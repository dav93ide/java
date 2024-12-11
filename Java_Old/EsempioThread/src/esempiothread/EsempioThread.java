package esempiothread;


public class EsempioThread {

    private int bilancia = 0;
    
    public static void main(String[] args){
        EsempioThread thread = new EsempioThread();
        thread.vita();
    }
    
    public EsempioThread(){}
    
    public void vita(){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<100000; i++){
                    aumenta();
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<100000;i++){
                    diminuisci();
                }
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException ex){
            ex.getStackTrace();
        }
        System.out.println(bilancia);
    }
    synchronized public void aumenta(){
        this.bilancia++;
    }
    synchronized public void diminuisci(){
        this.bilancia--;
    }

}
