
public class FAKULTAET
{

    public FAKULTAET ()
    {
        
    }

    public int FakultaetIterativBerechnen(int n){
        int erg = 1;
        for(int i = 2; i <= n; i++){
            erg = erg * i;
        }
        return erg;
    }

    public int FakultaetRekursivBerechnen(int n){
        if(n <= 1){
            return 1;
        }
        return n * FakultaetRekursivBerechnen(n - 1);
    }
    
}