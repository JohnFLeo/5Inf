
public class PHYSIKER implements DATENELEMENT
{
    // Attribute
    private String vorname;
    private String nachname;
    private int geburtsjahr;   
    private int todesjahr;

    private DATENELEMENT naechster;
    // Konstruktor
    public PHYSIKER ( String vorname, String nachname)
    {
        naechster = null;
        this.vorname = vorname;
        this.nachname = nachname;

    }

    public PHYSIKER ( String vorname, String nachname, int geburtsjahr, int todesjahr)
    {
        this(vorname, nachname);
        this.geburtsjahr = geburtsjahr;
        this.todesjahr = todesjahr;
    }

    //Methoden
    public void NaechsterSetzen(DATENELEMENT naechster){
        this.naechster = naechster;
    }

    @Override
    public int Suchen(DATENELEMENT d){
        if(this == d){
            return 0;
        }
        if(naechster == null){
            return -1;
        }
        int erg = naechster.Suchen(d);
        if(erg < 0){
            return -1;
        }
        return erg + 1;
    }
    @Override
    public int AnzahlGeben(){
        if(naechster == null){
            return 0;
        }
        return naechster.AnzahlGeben()+1;
    }
    @Override
    public DATENELEMENT Entfernen(int nr){
        if(nr == 0){
            return naechster;
        }
        if(naechster != null){
            naechster = naechster.Entfernen( nr -1 );
        }
        return this;
    }

    @Override
    public void Hinzufuegen(DATENELEMENT d){
        if(naechster == null){
            NaechsterSetzen(d);
        }else{
            naechster.Hinzufuegen(d);
        }
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
        if(naechster!=null){
            naechster.Ausgeben();
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