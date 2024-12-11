package provathread3;
import java.util.Scanner;

public class ProvaThread3 {
    ThreadSistema thread1;      //Dichiaro oggetto thread1 di ThreadSistema
    ThreadSistema thread2;      //Dichiaro oggetto thread2 di ThreadSistema
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxX,maxY;
        System.out.println("Inserire Valori Di MAX X e MAX Y");
        maxX=input.nextInt();
        maxY=input.nextInt();
        Matrice m1 = new Matrice(maxX,maxY);
        Matrice m2 = new Matrice(maxX,maxY);
        ProvaThread3 tt = new ProvaThread3(m1,m2);
        System.out.println("Inserire Valori Di Priorita` Per Thread1 e Thread2");
        maxX=input.nextInt();
        maxY=input.nextInt();
        tt.thread1.setPriority(maxX);
        tt.thread2.setPriority(maxY);
        System.out.println("Priorita` Thread1: "+ tt.thread1.getPriority() + " Priorita` Thread2: "+ tt.thread2.getPriority());
        System.out.println("\n\n\nMatrice Iniziale Di Thread1: \n\n\n");
        m1.visualPresentation();
        System.out.println("\n\n\nMatrice Iniziale Di Thread2: \n\n\n");
        m2.visualPresentation();
        tt.thread1.start();
        tt.thread2.start();
        try{
            tt.thread1.join();
            tt.thread2.join();
        } catch(InterruptedException ex){ ex.getStackTrace();}
        System.out.println("\nNumero Di Commutazioni Dei Thread: "+ tt.thread1.getNCommutazioni()+"\n");
        System.out.println("\n\n\nMatrice Finale Di Thread1: \n\n\n");
        tt.thread1.getStampMatrix();
        System.out.println("\n\n\nMatrice Finale Di Thread2: \n\n\n");
        tt.thread2.getStampMatrix();
        System.out.println("FINE");
    }
    
    public ProvaThread3(Matrice m1, Matrice m2){
        thread1 = new ThreadSistema(m1,"ThreadUNO");
        thread2 = new ThreadSistema(m2,"ThreadDUE");
    }

}
