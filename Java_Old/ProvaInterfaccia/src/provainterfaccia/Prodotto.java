package provainterfaccia;

public class Prodotto extends OpStampa implements IOperazione {
    
    @Override
    public void eseguiOp(double dOne, double dTwo){
        super.opStampa(dOne * dTwo);
    }
    
}
