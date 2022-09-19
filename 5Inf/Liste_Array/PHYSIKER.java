public class PHYSIKER implements DATENELEMENT
{
    // Attribute
    private String vorname;
    private String nachname;
    private int geburtsjahr;
    private int todesjahr;
    // Konstruktor
    public PHYSIKER (String vorname, String nachname ){
        // Instanzvariable initialisieren
		this.vorname = vorname;
		this.nachname = nachname;
    }
    public PHYSIKER (String vorname, String nachname, int geburtsjahr, int todesjahr ){
        // Instanzvariable initialisieren
        this(vorname, nachname);
		this.geburtsjahr = geburtsjahr;
		this.todesjahr = todesjahr;
    }

    // Methoden
	@Override
	public void Ausgeben(){
		if(geburtsjahr >= 0 && todesjahr >= 0){
			System.out.println("Name: " +nachname+", "+vorname+", "+ "* "+ geburtsjahr +", Alter: " +(todesjahr - geburtsjahr));
		}
	}
}