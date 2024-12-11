package provathread2;

public class ThreadOne extends Thread {
    private Vaso vase;
    private int speed;
    private String threadName;
    private boolean statoStop;
    
    public ThreadOne(int iSpeed, Vaso oV, String sName){
        this.speed=iSpeed;
        this.vase=oV;
        this.threadName = sName;
        this.statoStop=false;
    }
    
    public boolean getStop(){
        return this.statoStop;
    }
    
    @Override
    public void run(){
        int i = vase.getValAttuale();
        while(!statoStop){
            vase.setValAttuale(i);
            System.out.println("\nRiempimento Attuale "+this.threadName+" : " + vase.getValAttuale() + " Riempiti: "+ i);
            i +=this.speed;
            if(vase.getValAttuale()>=vase.getFull()){
                System.out.print("\n/////////////////////////Vaso Riempito Da" + this.threadName +"///////////////////////////////");
                this.statoStop=true;
            }
        }
    }
}
