package provathread2;

public class Vaso {
    private int full;
    private int valAttuale;
    
    public Vaso(int iFull){
        this.full = iFull;
        this.valAttuale = 0;
    }
    
    public int getFull(){
        return this.full;
    }
    
    public int getValAttuale(){
        return this.valAttuale;
    }
    
    public void setValAttuale(int iIncremento){
        this.valAttuale+=iIncremento;
    }
    
}
