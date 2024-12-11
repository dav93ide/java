package provathread;
import java.lang.Thread;

public class CounterThread extends Thread{
    boolean terminated = false;
    long count=0;
    char valueChar;
    
    public CounterThread(char value){
        this.valueChar = value;
    }
    
    @Override
    public void run(){              //Sovrascrivo metodo run
        while(!terminated){
            count++;            //Aumento count di 1
            for(int i=0;i<1000;i++){        // Ciclo "vuoto" di 1000 interazioni
                //System.out.print("["+i+this.valueChar+"]"); //Stampo i+charIdentificatoreOggetto ad ogni iterazione
            }
            //System.out.print("\n"); //Inserisco un a-capo dopo ogni ciclo for
        }
    }
    
    public void terminate(){        //Setta "terminate()" a true.
        terminated=true;
    }
    
    public double getCount(){       // Ritorna il valore di count
        return count;
    }
}