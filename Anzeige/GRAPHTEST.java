

public class GRAPHTEST
{
    // Attribute
    private GRAPH graph;
    // Methoden
    public void Testen()
    {
        graph = new GRAPH(20);
        graph.KnotenHinzufuegen("A");
        graph.KnotenHinzufuegen("F");
        graph.KnotenHinzufuegen("FD");
        graph.KnotenHinzufuegen("HO");
        graph.KnotenHinzufuegen("KA");
        graph.KnotenHinzufuegen("LI");
        graph.KnotenHinzufuegen("M");
        graph.KnotenHinzufuegen("N");
        graph.KnotenHinzufuegen("PA");
        graph.KnotenHinzufuegen("R");
        graph.KnotenHinzufuegen("RO");
        graph.KnotenHinzufuegen("S");
        graph.KnotenHinzufuegen("UL");
        graph.KnotenHinzufuegen("WÜ");
        
        graph.KanteHinzufuegen( "A", "M", 79 );
        graph.KanteHinzufuegen( "A", "UL", 88 );
        graph.KanteHinzufuegen( "M", "RO", 69 );
        graph.KanteHinzufuegen( "M", "R", 127 );
        graph.KanteHinzufuegen( "M", "N", 170);
        graph.KanteHinzufuegen( "UL", "LI", 117 );
        graph.KanteHinzufuegen( "UL", "S", 92 );
        graph.KanteHinzufuegen( "UL", "WÜ", 198 );
        graph.KanteHinzufuegen( "N", "R", 112 );
        graph.KanteHinzufuegen( "N", "HO", 140 );
        graph.KanteHinzufuegen( "N", "WÜ", 109 );
        graph.KanteHinzufuegen( "S", "WÜ", 147 );
        graph.KanteHinzufuegen( "S", "KA", 74 );
        graph.KanteHinzufuegen( "KA", "F", 139 );
        graph.KanteHinzufuegen( "F", "WÜ", 118);
        graph.KanteHinzufuegen( "WÜ", "FD", 108);
        graph.KanteHinzufuegen( "WÜ", "HO", 192);
        graph.KanteHinzufuegen( "R", "PA", 121);
        graph.KanteHinzufuegen( "R", "HO", 176);
        
        graph.MatrixAusgeben();
        //System.out.println("Tiefensuche ab KA");
        //graph.Tiefensuche("KA");
        //System.out.println("Breitensuche ab KA");
        //graph.Breitensuche("KA");
        graph.ModifzierteTiefensuche("WÜ", "N");
        graph.GraphAnzeigen();
    }
}