package listaanimali;

public class Animale {
    private String nome;
    
    public Animale(String sNome){
        this.nome = sNome;
    }
    
    public void verso(){}
    
    public void nome(){
        System.out.println(this.nome);
    }
}
