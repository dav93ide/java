package provathread;

public class ProvaThread implements Runnable {
    CounterThread thread1 = new CounterThread('a');        //Creo oggetto thread1 da CounterThread1
    CounterThread thread2 = new CounterThread('b');        //Creo oggetto thread2 da CounterThread2
    Thread thisThread = new Thread(this);               //Creo oggetto thisThread da Thread
    int duration;
    

    
    public ProvaThread(int priority1, int priority2, int duration){         //Costruttore per classe ProvaThread
        this.duration = duration;
        thisThread.setPriority(Thread.MAX_PRIORITY);                    //Setto a massima priorita`oggetto thisThread(Thread Principale)
        thread1.setPriority(priority1);                 //Setto priorita` thread1
        thread2.setPriority(priority2);                 //Setto priorita` thread2
        thread1.start();                                //Avvio thread1
        thread2.start();                                //Avvio thread2
        thisThread.start();                             //Avvio thisThread
    }
    
    @Override
    public void run(){                  //Sovrascrivo Metodo Run
        try{
            for(int i=0; i<duration;i++){
                System.out.println("\nThread1: priority:"+thread1.getPriority()+" count: " + thread1.count);      //Stampo priorita` e valore di count dell'oggetto thread1
		System.out.println("\nThread2: priority:"+thread2.getPriority()+" count: " + thread2.count);      //Stampo priorita` e valroe di count dell'oggetto thread2
                System.out.println("\ni = "+ i);      //Stampo valore di i
                thisThread.sleep(1000);         //Metto in pausa thisThread per 1000 millisec.
            }
            thread1.stop();     //Chiudo thread1
            thread2.stop();     //Chiudo thread2
            thisThread.stop();  //Chiudo thisThread
        }catch(InterruptedException e){}
    }
    
    public static void main(String[] args) {
        new ProvaThread(3,8,10);      //Creo oggetto ProvaThread
    }
    
    
    
}