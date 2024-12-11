package gioco_personaggio;
import java.util.Scanner;

public class Gioco_Personaggio {
    static Scanner Read = new Scanner(System.in);
    
    public static void main(String[] args) { 
        String inputS = Gioco_Personaggio.Read.nextLine();
        System.out.println("\nInserire Posizione X Iniziale\n");
        int valx = Gioco_Personaggio.Read.nextInt();
        System.out.println("\nInserire Posizione Y Iniziale\n");
        int valy = Gioco_Personaggio.Read.nextInt();
        System.out.println("\nInserire Nome Personaggio\n");
        inputS = Gioco_Personaggio.Read.nextLine();
        Pg PGmv = new Pg(valx,valy,inputS);       
        PGmv.Presentazione();
        boolean exit=false;
        while(!exit){
            System.out.println("\nDigitare Operazione: 1] Avanti 2] Indietro 3] Su 4] Giu "
                + "5]Posizione 6]Esci / Aggiungere n alla fine della dicitura per eseguirla"
                + " con un valore di passi ad inserimento\n");
            switch(inputS){
                case "Avanti":
                    PGmv.Avanti(); 
                break;
                case "Indietro": 
                    PGmv.Indietro();
                break;
                case "Su": 
                    PGmv.Su();
                break;
                case "Giu": 
                    PGmv.Giu();
                break;
                case "Avantin": 
                    System.out.println("\nInserire Numero Passi Avanti\n");
                    valx = Gioco_Personaggio.Read.nextInt();
                    PGmv.Avanti2(valx);
                break;
                case "Indietron":
                    System.out.println("\nInserire Numero Passi Indietro\n");
                    valx = Gioco_Personaggio.Read.nextInt();
                    PGmv.Indietro2(valx);
                break;
                case "Sun":
                    System.out.println("\nInserire Numero Passi Su\n");
                    valx = Gioco_Personaggio.Read.nextInt();
                    PGmv.Su2(valx);
                break;
                case "Giun": 
                    System.out.println("\nInserire Numero Passi Giu\n");
                    valx = Gioco_Personaggio.Read.nextInt();
                    PGmv.Giu2(valx);
                break;
                    case "Posizione": 
                    PGmv.Mostra();
                break;
                case "Esci": 
                   exit=true;
                break;
                default : 
                    System.out.println("\nInserimento Non Valido, Ripetere.\n");
                break;                       
            }
        }
    }
