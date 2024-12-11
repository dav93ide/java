package provainterfaccia;

public class Quoziente extends OpStampa implements IOperazione {
    
    @Override
    public void eseguiOp(double dOne, double dTwo){
        super.opStampa(dOne / dTwo);
    }
    
}
