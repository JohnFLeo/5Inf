
public class FIBONACCI
{
    
    private int rekursionen;
    
    public FIBONACCI ()
    {
    }
    
    public int FibonacciZahlIterativBerechnen(int n){
        int fvv = 1;
        int fv = 1;
        int erg = 0;
        for(int i = 2; i <= n; i++){
            erg = fv + fvv;
            fvv = fv;
            fv = erg;
        }
        return erg;
    }
    
    public int FibonacciZahlRekursivBerechnenStarten(int n){
        rekursionen = 0;
        int erg = FibonacciZahlRekursivBerechnen(n);
        System.out.println("Rekursionen: " + rekursionen);
        return erg;
    }
    
    private int FibonacciZahlRekursivBerechnen(int n){
        rekursionen = rekursionen + 1;
        if(n <= 1){
            return 1;
        }
        return FibonacciZahlRekursivBerechnen(n - 1) + FibonacciZahlRekursivBerechnen(n - 2);
    }
}