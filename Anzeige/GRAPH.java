
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
            knoten[ knotenanzahl ] = new KNOTEN( bezeichnung ,x,y);
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
    }

    public void KanteHinzufuegen(String startknoten, String zielknoten, int gewicht)
    {
        GerichteteKanteHinzufuegen(startknoten, zielknoten, gewicht);
        GerichteteKanteHinzufuegen(zielknoten, startknoten, gewicht);
    }
    //Suchen
    private void MarkierungLoeschen(){
        for(int i = 0; i < knotenanzahl; i = i + 1)
        {
            knoten[i].MarkierenLoeschen();
        }
    }

    public void Breitensuche(String startknoten){
        INTQUEUE q = new INTQUEUE(knotenanzahl);
        MarkierungLoeschen();
        int nr = KnotennummerGeben(startknoten);
        q.Enqueue(nr);
        System.out.print(knoten[nr].BezeichnungGeben());
        knoten[nr].Markieren();
        
        while(q.Peek()){
            int i = 0;
            while(i < knotenanzahl){
                if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                    q.Enqueue(i);
                    System.out.print(" -> "+knoten[i].BezeichnungGeben());
                    knoten[i].Markieren();
                }
                i = i + 1; 
            }
            nr = q.Dequeue();
        }        
        System.out.println();
    }

    public void Tiefensuche(String startknoten){
        MarkierungLoeschen();
        int startnr = KnotennummerGeben(startknoten);
        if(startnr > -1 ){
            System.out.print(knoten[startnr].BezeichnungGeben());
            TSBesuchen(startnr);
        }
        System.out.println();
    }

    private void TSBesuchen(int nr){
        knoten[nr].Markieren();

        for(int i = 0; i < knotenanzahl; i = i + 1)
        {
            if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                System.out.print(" -> "+knoten[i].BezeichnungGeben());
                TSBesuchen(i);
            }
        } 

    }
    public void ModifzierteTiefensuche(String startknoten,String zielknoten){
        MarkierungLoeschen();
        int startnr = KnotennummerGeben(startknoten);
        int zielnr = KnotennummerGeben(zielknoten);
        if(startnr > -1 && zielnr > -1 ){ 
            String weg = knoten[startnr].BezeichnungGeben();
            int laenge = 0;
            MTSBesuchen(startnr, zielnr, weg, laenge);
        }
        System.out.println();
    }
    private void MTSBesuchen(int nr, int zielnr, String weg, int laenge){
        if(nr  == zielnr){
            System.out.println(weg + "; Länge: " + laenge);
        }
        knoten[nr].Markieren();
        for(int i = 0; i < knotenanzahl; i = i + 1)
        {
            if(matrix[nr][i] > 0 && !knoten[i].MarkierungGeben()){
                MTSBesuchen(i, zielnr, weg+", "+ knoten[i].BezeichnungGeben(), laenge + matrix[nr][i]);
            }
        } 
        knoten[nr].MarkierenLoeschen();
    }
    //Weitere Funktionalität
    public void GraphAnzeigen(){
        if(ga == null){
            ga = new GraphenAnzeige(knoten,matrix);
        }
        
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