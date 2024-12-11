package vettoreanimali;

public class Animali {
    private String[] nomeAnimali;
    private String[] versiAnimali;
    
    
    public Animali(int len){
        nomeAnimali = new String[len];
        versiAnimali = new String[len];
    }
    
    public int getLenVet(){
        return this.nomeAnimali.length;
    }
    
    public void setNomeEVerso(int n, String nome, String verso){
        nomeAnimali[n] = nome;
        versiAnimali[n] = verso;
    }
    
    public String getNomeEVerso(int n){
        return "Nome: " + this.nomeAnimali[n] + " Verso: " + this.versiAnimali[n];
    }
}
