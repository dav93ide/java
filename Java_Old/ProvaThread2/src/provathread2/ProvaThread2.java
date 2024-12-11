package provathread2;

public class ProvaThread2 {

    public static void main(String[] args) {
        Vaso v1 = new Vaso(10000);
        Vaso v2 = new Vaso(10000);
        ThreadOne thread1 = new ThreadOne(1,v1,"ThreadUno");
        ThreadOne thread2 = new ThreadOne(1,v2,"ThreadDue");
        thread1.setPriority(1);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();
        if(thread1.getStop() & thread2.getStop() == true){
            thread1.stop();
            thread2.stop();
        }
        System.out.println("\nOperazione Terminata\n");
    }
    
}
