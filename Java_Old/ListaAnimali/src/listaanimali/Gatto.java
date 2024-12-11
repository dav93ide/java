package listaanimali;

public class Gatto extends Animale{
    
    public Gatto(String sNome){
        super(sNome);
    }
    
    @Override
    public void verso(){
        System.out.println("Miao Miao");
    }
}
