
public class GRAPH
{
    // Attribute
    private KNOTEN[] knoten;
    private int knotenanzahl;
    private int[][] matrix;

    // Konstruktor
    public GRAPH ( int max_anzahl )
    {
        knoten = new KNOTEN[ max_anzahl ];
        matrix = new int[ max_anzahl ][ max_anzahl ];
        MatrixInitialisieren( max_anzahl );
    }

    // Methoden
    private void MatrixInitialisieren( int max_anzahl )
    {

        for( int i = 0; i < max_anzahl; i++ )
        {
            for( int j = 0; j < max_anzahl; j++ ) 
            {
                matrix[ i ][ j ] = -1;
            }
        }
    }

    public void KnotenHinzufuegen( String bezeichnung )
    {
        if( knotenanzahl < knoten.length )
        {
            knoten[ knotenanzahl ] = new KNOTEN( bezeichnung );
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

    public void GerichteteKanteHinzufuegen( String start_knoten, String ziel_knoten, int gewicht )
    {
        int nr = KnotennummerGeben(start_knoten);
        int ziel_nr = KnotennummerGeben(ziel_knoten);

        if( nr > -1 && ziel_nr > -1 )
        {
            matrix[ nr ][ ziel_nr ] = gewicht;
        }
    }

    public void KanteHinzufuegen( String start_knoten, String ziel_knoten, int gewicht )
    {
        GerichteteKanteHinzufuegen( start_knoten, ziel_knoten, gewicht );
        GerichteteKanteHinzufuegen( ziel_knoten, start_knoten, gewicht );
    }

    public void MatrixAusgeben()
    {
        int laenge = 5;
        System.out.println();
        System.out.print( " ".repeat( laenge ) );
        System.out.print( TextFormatieren( "|", laenge ) );
        for( int i = 0; i < knotenanzahl; i++ )
        {
            System.out.print( TextFormatieren( knoten[ i ].BezeichnungGeben(), laenge ) );
        }
        System.out.println();   
        System.out.println( "-".repeat( ( knotenanzahl + 2 ) * laenge ) );
        for( int i = 0; i < knotenanzahl; i++ )
        {
            System.out.print( TextFormatieren( knoten[ i ].BezeichnungGeben(), laenge ) );
            System.out.print( TextFormatieren( "|", laenge ) );
            for( int j = 0; j < knotenanzahl; j++ )
            {
                System.out.print( TextFormatieren( "" + matrix[ i ][ j ], laenge ) );
            }
            System.out.println();
        }
    }

    private String TextFormatieren( String text, int laenge )
    {   
        String erg = text;
        boolean hinten = true;
        while( erg.length() < laenge )
        {
            if ( hinten )
            {
                erg = erg + " ";
            }
            else
            {
                erg = " " +  erg;
            }
            hinten = !hinten;
        }
        return erg;
    }

    private void KnotenZuruecksetzen()
    {
        for( int i = 0; i < knotenanzahl; i++ )
        {
            knoten[ i ].ZurueckSetzen();
        }
    }

    public void Tiefensuche( String start_knoten )
    {
        KnotenZuruecksetzen();
        int nr = KnotennummerGeben( start_knoten );
        if(nr > -1 )
        {
            System.out.print( knoten[ nr ].BezeichnungGeben() );
            TSBesuchen( nr );
        }
    }

    private void TSBesuchen( int nr )
    {
        knoten[ nr ].Markieren();
        for( int i = 0; i < knotenanzahl; i++ )
        {
            if( matrix[ nr ][ i ] > 0 && !knoten[ i ].MarkierungGeben() )
            {
                System.out.print( " → " + knoten[ i ].BezeichnungGeben());
                TSBesuchen(i);
            }
        }
    }

    public void Breitensuche( String start_knoten )
    {
        INTQUEUE q = new INTQUEUE( knotenanzahl );
        KnotenZuruecksetzen();
        int nr = KnotennummerGeben( start_knoten );
        if(nr > -1)
        {
            q.Enqueue( nr );
            System.out.print( knoten[ nr ].BezeichnungGeben() );
            knoten[ nr ].Markieren();
            while( q.Peek() )
            {
                nr = q.Dequeue();
                for( int i = 0; i < knotenanzahl; i++)
                {
                    if( matrix[ nr ][ i ] > 0 && !knoten[ i ].MarkierungGeben() )
                    {
                        BSBesuchen( i , q );
                    }
                }
            }
        }
    }

    private void BSBesuchen( int nr, INTQUEUE q )
    {
        q.Enqueue( nr );
        System.out.print( " → " + knoten[ nr ].BezeichnungGeben() );
        knoten[ nr ].Markieren();
    }

    public void ModifizierteTiefensuche( String start_knoten, String ziel_knoten )
    {
        KnotenZuruecksetzen();
        int start_nr = KnotennummerGeben( start_knoten );
        int ziel_nr = KnotennummerGeben( ziel_knoten );
        if( start_nr > -1 && ziel_nr > -1 )
        {
            MTSBesuchen( start_nr, ziel_nr, knoten[ start_nr ].BezeichnungGeben(), 0 );
        }
    }

    private void MTSBesuchen( int nr, int ziel_nr, String weg, int laenge )
    {
        if(nr == ziel_nr)
        {
            System.out.println( weg + " | Länge: " + laenge );
        }
        knoten[ nr ].Markieren();
        for( int i = 0; i < knotenanzahl; i++ )
        {
            if( matrix[ nr ][ i ] > 0 && !knoten[ i ].MarkierungGeben() )
            {
                String w = weg + " → " + knoten[ i ].BezeichnungGeben();
                int l = laenge + matrix[ nr ][ i ];
                MTSBesuchen( i, ziel_nr, w, l );
            }
        }
        knoten[ nr ].MarkierungLoeschen();
    }

    public void Dijkstra( String start_knoten, String ziel_knoten )
    {
        int nr = KnotennummerGeben( start_knoten );
        int ziel_nr = KnotennummerGeben( ziel_knoten );
        if( nr > -1 && ziel_nr > -1 )
        {
            knoten[ nr ].distanz = 0;
            while( nr > -1 || nr == ziel_nr )
            {
                
                nr = MinimaldistanzKnotenGeben();
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

}