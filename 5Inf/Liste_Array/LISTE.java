
public class LISTE
{

    // Attribute
    private DATENELEMENT[] elemente;
    private int anzahl;

    // Konstruktor
    public LISTE(){
        elemente = new DATENELEMENT[100];
        anzahl = 0;
    }

    public LISTE(int kapazitaet){
        elemente = new DATENELEMENT[kapazitaet];
        anzahl = 0;
    }

    // Methoden
    public void Hinzufuegen(DATENELEMENT d){
        if(anzahl <= elemente.length){  
            elemente[anzahl] = d;
            anzahl = anzahl + 1;   
        }
    }

    public int Suchen(DATENELEMENT d){
        for(int i = 0; i < anzahl; i = i + 1){
            if(elemente[i].IstGleich(d)){
                return i;
            }
        }
        return -404;
    }

    public void Entfernen(int nr){
        if(nr >= 0 && nr < anzahl){
            anzahl = anzahl - 1;
            for(int i = nr; i < anzahl; i = i + 1){
                elemente[i] = elemente[i + 1];
            }
            elemente[anzahl] = null;
        }

    }

    public void Entfernen(DATENELEMENT d){
        Entfernen(Suchen(d));
    }

    public void Ausgeben(){
        System.out.println();
        System.out.println("- - - - - - - - - - Liste (" + anzahl + "/" + elemente.length + " Elemente) - - - - - - - - - -");
        System.out.println();
        for(int i = 0; i < anzahl; i = i + 1){
            System.out.print(i + " | ");
            elemente[i].Ausgeben();
        }
        System.out.println();
        System.out.println("- - - - - - - - - - Liste (" + anzahl + "/" + elemente.length + " Elemente) - - - - - - - - - -");
        System.out.println();
    }

}