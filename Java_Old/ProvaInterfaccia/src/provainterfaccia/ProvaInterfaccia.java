package provainterfaccia;
import java.util.Scanner;

public class ProvaInterfaccia {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        double dOne,dTwo;
        System.out.println("Inserire Primo Fattore Tipo Double");
        dOne = input.nextDouble();
        System.out.println("Inserire Secondo Fattore Tipo Double");
        dTwo = input.nextDouble();
        Somma addizione = new Somma();
        Differenza sottrazione = new Differenza();
        Prodotto moltiplicazione = new Prodotto();
        Quoziente divisione = new Quoziente();
        System.out.println("Fattori Utilizzati: " + dOne + " e " + dTwo);
        IOperazione op;     //Dichiaro Interfaccia op Alla Quale Passo Uno Degli Oggetti (Addizione,Sottrazione,Moltiplicazione o Divisione)
        op = addizione;     //Assegno Un Oggetto A op La Quale Può Eseguire Uno Dei Metodi Comuni, Ma Non Quelli Non Comuni.
        op.eseguiOp(dOne, dTwo);
        op = sottrazione;
        op.eseguiOp(dOne, dTwo);
        op = moltiplicazione;
        op.eseguiOp(dOne, dTwo);
        op = divisione;
        
        
    }
    
}
