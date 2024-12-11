package provainterfaccia;

public abstract class OpStampa {
        
    public void opStampa(double Risultato){
        System.out.printf("|%s Risultato: %.2f | \n",this.getClass().getSimpleName(), Risultato); //Come Per Il C, Con %.2f Imposto Un Double Con Arrotondamento A 2 Cifre Dopo La Virgola 
    }
}
