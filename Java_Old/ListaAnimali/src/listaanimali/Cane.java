package listaanimali;

public class Cane extends Animale{
    
    public Cane(String sNome){
        super(sNome);
    }
    
    @Override
    public void verso(){
        System.out.println("Bau Bau");
    }
}
