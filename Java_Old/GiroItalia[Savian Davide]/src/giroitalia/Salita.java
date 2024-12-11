package giroitalia;

public class Salita {
    
    private String nome;
    private int length;
    private double mediaPendenza;
    
    public Salita(String sName, int iLen, double dMP){
        this.nome = sName;
        this.length = iLen;
        this.mediaPendenza = dMP;
    }
    
    public double getPendenza(){
        return this.mediaPendenza;
    }
    
    public String getName(){
        return this.nome;
    }
    
    public int getLength(){
        return this.length;
    }
    
    @Override
    public String toString(){
        return new String("Nome Salita: " + this.nome + "\tLunghezza Salita: " + this.length + "\tPendenza Media: " + this.mediaPendenza);
    }
}
