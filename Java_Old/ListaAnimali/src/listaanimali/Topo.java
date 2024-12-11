package listaanimali;

public class Topo extends Animale{
    
    public Topo(String sNome){
        super(sNome);
    }
    
    @Override
    public void verso(){
        System.out.println("Squit Squit");
    }
}
