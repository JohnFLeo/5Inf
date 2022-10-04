
public class HANOI
{
    
    // Innere Klasse
    private class SPIESS{
        private int[] scheiben;
        private int anzahl;
        
        public SPIESS(int scheibenzahl){
             scheiben = new int[scheibenzahl];
             anzahl = 0;
        }
        
        public int ScheibeNehmen(){
            anzahl--;
            int erg = scheiben[anzahl];
            scheiben[anzahl] = 0;
            return erg;
        }
        
        public void scheibeAuflegen(int s){
            if(anzahl > 0 && scheiben[anzahl - 1] > s){
                System.out.println("Es darf keine größere auf eine kleinere Scheibe gelegt werden!");
                System.exit(418);
            }
            scheiben[anzahl] = s;
            anzahl++;
        }
    }
    
    private int[][] spiesse;

    public HANOI (int scheibenzahl)
    {
        spiesse[0] = new int[scheibenzahl];
        spiesse[1] = new int[scheibenzahl];
        spiesse[2] = new int[scheibenzahl];
        
        for(int i = 1; i <= scheibenzahl; i++){
            spiesse[0][i] = scheibenzahl - i + 1;
        }
    }

    public void Umsetzen(int vonSpiess, int zuSpiess){
        
    }
    
    public void HanoiLoesen(){

    }
}