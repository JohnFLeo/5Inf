public class LISTENTEST
{
    // Attribute
    private LISTE liste;

    // Methoden
    public void Testen(){
        // Liste Anlegen
        liste = new LISTE(8);
        // Leere Liste ausgeben
        liste.Ausgeben();
        // Liste befüllen
        liste.Hinzufuegen(new PHYSIKER("Albert", "Einstein", 1879, 1955));
        liste.Hinzufuegen(new PHYSIKER("Alessandro", "Voltar", 1745, 1827));
        liste.Hinzufuegen(new PHYSIKER("James", "Watt", 1736, 1819));
        liste.Hinzufuegen(new PHYSIKER("Isaac", "Newton", 1643, 1727));
        liste.Hinzufuegen(new PHYSIKER("Marie", "Curie", 1867, 1934 ));
        liste.Hinzufuegen(new PHYSIKER("Max", "Planck", 1858, 1947));
        liste.Hinzufuegen(new PHYSIKER("Stephen", "Hawking", 1942, 2018));
        liste.Ausgeben();
    }
}