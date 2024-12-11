package provainterfaccia;

public class Somma extends OpStampa implements IOperazione {
    
    @Override
    public void eseguiOp(double dOne, double dTwo){
        super.opStampa(dOne + dTwo);
    }
}
