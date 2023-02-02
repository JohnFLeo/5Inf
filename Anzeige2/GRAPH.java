
public class GRAPH
{
    // Attribute
    private KNOTEN[] knoten;

    private int knotenanzahl;
    private int[][] matrix;
    GraphenAnzeige ga;
    // Konstruktor
    public GRAPH ( int max_anzahl )
    {
        knoten = new KNOTEN[ max_anzahl ];
        matrix = new int[ max_anzahl ][ max_anzahl ];
        MatrixInitialisieren( max_anzahl );
        ga = new GraphenAnzeige(max_anzahl);
    }

    // Methoden
    //Grundfunktionalität Speichermedium
    private void MatrixInitialisieren(int max_anzahl )
    {
        for(int i = 0; i < max_anzahl; i = i + 1)
        {
            for(int j = 0; j < max_anzahl; j = j + 1)
            {
                matrix[i][j] = -1;
            }
        }
    }

    public void KnotenHinzufuegen( String bezeichnung, int x, int y)
    {
        if( knotenanzahl < knoten.length )
        {
            knoten[ knotenanzahl ] = new KNOTEN( bezeichnung ,x,y, ga);
            knotenanzahl = knotenanzahl + 1;
        }
    }

    public int KnotennummerGeben( String bezeichnung )
    {
        int i = 0;
        while( i < knotenanzahl )
        {
            if( knoten[ i ].IstGleich( bezeichnung ) )
            {
                return i;
            }
            i = i + 1;
        }
        return -1;
    }

    public void GerichteteKanteHinzufuegen(String startknoten, String zielknoten, int gewicht)
    {
        int startnr = KnotennummerGeben(startknoten);
        int zielnr = KnotennummerGeben(zielknoten);
        if(startnr > -1 && zielnr > -1){
            matrix[startnr][zielnr] = gewicht;
        }
        ga.updateKanten(matrix, knoten[startnr], knoten[zielnr]);
    }

    public void KanteHinzufuegen(String startknoten, String zielknoten, int gewicht)
    {
        GerichteteKanteHinzufuegen(startknoten, zielknoten, gewicht);
        GerichteteKanteHinzufuegen(zielknoten, startknoten, gewicht);
    }
    //Suchen
    private void MarkierungLoeschen(int delay){
        for(int i = 0; i < knotenanzahl; i = i + 1)
        {
            knoten[i].MarkierenLoeschen(delay);
        }
    }

    public void Breitensuche(String startknoten, int delay){
        INTQUEUE q = new INTQUEUE(knotenanzahl);
        MarkierungLoeschen(delay);
        int nr = KnotennummerGeben(startknoten);
        q.Enqueue(nr);
        System.out.print(knoten[nr].BezeichnungGeben());
        knoten[nr].Markieren(delay);
        
        while(q.Peek()){
            int i = 0;
            while(i < knotenanzahl){
                if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                    q.Enqueue(i);
                    System.out.print(" -> "+knoten[i].BezeichnungGeben());
                    knoten[i].Markieren(delay);
                    //kante markieren
                }
                i = i + 1; 
            }
            nr = q.Dequeue();
        }        
        System.out.println();
    }

    public void Tiefensuche(String startknoten, int delay){
        MarkierungLoeschen(0);
        int startnr = KnotennummerGeben(startknoten);
        if(startnr > -1 ){
            System.out.print(knoten[startnr].BezeichnungGeben());
            TSBesuchen(startnr, delay);
        }
        System.out.println();
    }

    private void TSBesuchen(int nr, int delay){
        knoten[nr].Markieren(delay);
        //kante markieren
        for(int i = 0; i < knotenanzahl; i = i + 1)
        {
            if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                System.out.print(" -> "+knoten[i].BezeichnungGeben());
                TSBesuchen(i, delay);
            }
        } 

    }

    public void ModifzierteTiefensuche(String startknoten,String zielknoten, int delay){
        MarkierungLoeschen(0);
        int startnr = KnotennummerGeben(startknoten);
        int zielnr = KnotennummerGeben(zielknoten);
        if(startnr > -1 && zielnr > -1 ){ 
            String weg = knoten[startnr].BezeichnungGeben();
            int laenge = 0;
            MTSBesuchen(startnr, zielnr, weg, laenge, delay);
        }
        System.out.println();
    }

    private void MTSBesuchen(int nr, int zielnr, String weg, int laenge, int delay){
        if(nr  == zielnr){
            System.out.println(weg + "; Länge: " + laenge);
        }
        knoten[nr].Markieren(delay);
        //kante markieren
        for(int i = 0; i < knotenanzahl; i = i + 1)
        {
            if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                MTSBesuchen(i, zielnr, weg+", "+ knoten[i].BezeichnungGeben(), laenge + matrix[nr][i], delay);
            }
        } 
        knoten[nr].MarkierenLoeschen(delay);
        //kante demarkieren
    }
    private void KnotenZuruecksetzen()
    {
        for( int i = 0; i < knotenanzahl; i++ )
        {
            knoten[ i ].ZurueckSetzen();
        }
    }
    public void Dijkstra( String start_knoten, String ziel_knoten , int delay)
    {
        KnotenZuruecksetzen();
        int nr = KnotennummerGeben( start_knoten );
        int ziel_nr = KnotennummerGeben( ziel_knoten );
        if( nr > -1 && ziel_nr > -1 )
        {
            knoten[ nr ].distanz = 0;
            while( nr > -1 && nr != ziel_nr )
            {
                System.out.print(knoten[nr].BezeichnungGeben() + ":");
                knoten[nr].Markieren(delay);
                int i = 0;
                while(i < knotenanzahl){
                    if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                        System.out.print(" "+knoten[i].BezeichnungGeben() );
                        if(knoten[nr].distanz+matrix[nr][i] < knoten[i].distanz){
                            knoten[i].distanz = knoten[nr].distanz+matrix[nr][i];
                            knoten[i].vorgaenger = knoten[nr];
                            System.out.print("("+ knoten[i].distanz +")");
                        }
                    }
                    i= i + 1;
                }
                System.out.println();
                nr = MinimaldistanzKnotenGeben();
            }
            if( nr > -1 )
            {
                String weg = "";
                System.out.println( knoten[ nr ].BezeichnungGeben() + "( " + knoten[ nr ].distanz +  " ):" );
                KNOTEN k = knoten[ nr ];
                while( k != null )
                {
                    weg = k.BezeichnungGeben() + "  " + weg;
                    k = k.vorgaenger;
                }
                System.out.println();
                System.out.println( weg );
                System.out.println( "Länge: " + knoten[ nr ].distanz );
                knoten[ziel_nr].WegAnzeigen(start_knoten, 100);
            }
            else
            {
                System.out.println("F E H L E R ! ! !");
                System.out.println("F E H L E R ! ! !");
                System.out.println("F E H L E R ! ! !");
                System.out.println("ZIELKNOTEN NICHT GEFUNDEN!!!");
                System.out.println("F E H L E R ! ! !");
                System.out.println("F E H L E R ! ! !");
                System.out.println("F E H L E R ! ! !");
                System.exit(404);
            }
        }
    }

    private int MinimaldistanzKnotenGeben()
    {
        int min_dist = Integer.MAX_VALUE;
        int knoten_nr = -1;
        for( int i = 0; i < knotenanzahl; i++ )
        {
            if( knoten[ i ].distanz < min_dist && !knoten[ i ].MarkierungGeben() )
            {
                min_dist = knoten[ i ].distanz;
                knoten_nr = i;
            }
        }
        return knoten_nr;
    }
    //Weitere Funktionalität
    public void GraphAnzeigen(){
        ga.Anzeigen();
    }

    public void MatrixAusgeben(){
        int laenge = 5;
        System.out.println();
        System.out.print(" ".repeat(laenge));
        System.out.print(TextFormatieren("|",laenge));
        for(int i = 0; i < knotenanzahl; i = i + 1){
            System.out.print(TextFormatieren(knoten[i].BezeichnungGeben(), laenge));
        }
        System.out.println();
        System.out.println("-".repeat((knotenanzahl + 2) * laenge));
        for(int i = 0; i < knotenanzahl; i = i + 1){
            System.out.print(TextFormatieren(knoten[i].BezeichnungGeben(), laenge));
            System.out.print(TextFormatieren("|",laenge));
            for(int j = 0; j < knotenanzahl; j = j + 1){
                System.out.print(TextFormatieren(""+matrix[i][j], laenge));
            }System.out.println();
        }
    }

    private String TextFormatieren(String text, int laenge){
        String erg = text;
        boolean hinten = true;
        while(erg.length() < laenge){
            if(hinten){
                erg = erg + " ";
            }else{
                erg = " " + erg;
            }
            hinten = !hinten;
        }
        return erg;
    }
}