
public class PHYSIKER implements DATENELEMENT
{
    // Attribute
    private String vorname;
    private String nachname;
    private int geburtsjahr;   
    private int todesjahr;

    // Konstruktor
    public PHYSIKER ( String vorname, String nachname)
    {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public PHYSIKER ( String vorname, String nachname, int geburtsjahr, int todesjahr)
    {
        this(vorname, nachname);
        this.geburtsjahr = geburtsjahr;
        this.todesjahr = todesjahr;
    }

    @Override
    public void Ausgeben(){
        System.out.print(nachname + " " + vorname);
        if (todesjahr >= 0 || geburtsjahr >= 0){
            System.out.print(" (");
            if (geburtsjahr >= 0){
                System.out.print("*" + geburtsjahr);
                if(todesjahr >= 0){
                    System.out.print(", ");
                }
            }
            if(todesjahr >= 0){
                System.out.print("+" + geburtsjahr);
            }
            System.out.println(") ");
        }
    }
    
    @Override
    public boolean IstGleich(DATENELEMENT d){
        if(!(d instanceof PHYSIKER)){
            return false;
        }
        return nachname.equals( ((PHYSIKER) d).nachname) && vorname.equals( ((PHYSIKER) d).vorname );
    }
}