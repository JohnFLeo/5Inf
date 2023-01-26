

public class GRAPHTEST
{
    // Attribute
    private GRAPH graph;
    // Methoden
    public void Testen()
    {
        graph = new GRAPH(20);
        graph.KnotenHinzufuegen("A",12,14);
        graph.KnotenHinzufuegen("F",4,4);
        graph.KnotenHinzufuegen("FD",8,1);
        graph.KnotenHinzufuegen("HO",16, 2);
        graph.KnotenHinzufuegen("KA",3,10);
        graph.KnotenHinzufuegen("LI",8,18);
        graph.KnotenHinzufuegen("M", 15,15);
        graph.KnotenHinzufuegen("N",13, 8);
        graph.KnotenHinzufuegen("PA", 22, 13);
        graph.KnotenHinzufuegen("R", 17, 10);
        graph.KnotenHinzufuegen("RO",17, 17);
        graph.KnotenHinzufuegen("S",6, 11);
        graph.KnotenHinzufuegen("UL", 9, 14);
        graph.KnotenHinzufuegen("WÜ", 9, 5);
        
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
        
        graph.GraphAnzeigen();
        graph.KnotenHinzufuegen("LA", 24, 24);
        graph.GraphAnzeigen();
    }
}