
public class LISTE
{

    // Attribute
    private DATENELEMENT erster;


    // Konstruktor
    public LISTE(){
        erster = null;
    }
    // Methoden
    private boolean IstGueltig(DATENELEMENT d){
        //doppelte Einträge vermeiden
        if(d == null){
            return false;
        }
        if(Suchen(d) > -1){
            return false;
        }
        return true;
    }
    public void Hinzufuegen(DATENELEMENT d){
        if(IstGueltig(d)){
            if(erster == null){
                erster = d;
            }else{
                erster.Hinzufuegen(d);
            }  
        }
    }

    public int Suchen(DATENELEMENT d){
        if(erster == null){
            return -1;
        }
        return erster.Suchen(d); 
    }

    public void Entfernen(int nr){
        if(nr >= 0){
            if(erster!= null){
                erster = erster.Entfernen( nr );
            }         
        }

    }

    public void Entfernen(DATENELEMENT d){
        Entfernen(Suchen(d));
    }
    public int AnzahlGeben(){
        if(erster == null){
            return 0;
        }
        return erster.AnzahlGeben()+1;
    }
    public void Ausgeben(){
        System.out.println();
        System.out.println("- - - - - - - - - - Liste (" + AnzahlGeben() + " Elemente) - - - - - - - - - -");
        System.out.println();
        if(erster!=null){
            erster.Ausgeben();
        }
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

}