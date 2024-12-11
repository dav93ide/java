
package inputdatastiera;
import java.util.Scanner;               // Input Con scanner
import java.io.IOException;             // Gestione Eccezioni
import java.io.BufferedReader;          
import java.io.InputStreamReader;       
public class InputDaTastiera {

    public static void main(String[] args) {
        int b,a;
        String str;
        boolean y;
        Scanner input1 = new Scanner(System.in);    // Costruisco Lo Scanner Su Stream Di Input
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in)); //Costruisco Un BufferedReader Su Un InputStreamReader Indirizzato Verso Stream di "System.in"
        try{  // Blocco Try Per Catturare Eventuali Eccezioni
            System.out.println("Inserire Valore Di A");
            do{
                //Inserire Iterazione Stringa Per Catturare Valori Int In Caso Di Inserimento Errato.             
            } while(!y);
            System.out.println("Inserire Valore Di B");
            b=input1.nextInt();
            System.out.println("Valore Di A: "+a+" Valore Di B: "+b);
        }
        catch(IOException ex){      // Catturo Eventuali Eccezioni
            ex.printStackTrace();   // Stampo Lo Stack Delle Eventuali Eccezioni Trovate
            System.out.println("Eccezione IO");
        }
        finally{
            System.out.println("Programma Finito");   
        }
    }
    
}
