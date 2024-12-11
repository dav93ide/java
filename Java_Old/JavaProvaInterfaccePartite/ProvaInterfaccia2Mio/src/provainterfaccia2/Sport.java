package provainterfaccia2;

public abstract class Sport {
    private int finalRis1;
    private int finalRis2;
    protected String nome1;
    protected String nome2;
    
    public void setFinalRis(int iFR1, int iFR2){
        this.finalRis1 = iFR1;
        this.finalRis2 = iFR2;
    }
    
    public void getWinner(){
        System.out.println("Vincitore: " + ((this.finalRis1>this.finalRis2)?this.nome1:this.nome2));
    }
    
    public int getFinal1(){
        return this.finalRis1;
    }
    
    public int getFinal2(){
        return this.finalRis2;
    }
}
