/*
 * Programma per gestire prenotazione prosit dei voli aerei, ogni oggetto volo caratterizzato 
 * da tratta, data, ora del volo, numero di posti in tariffa business e numero posti in tariffa 
 * economy con relativo prezzo e numero di posti liberi per ogni tariffa.
 * Poter costruire oggetto volo specificando tratta data e ora (20 posti default 
 * per business e 100 per economy) oppure aggiungendo anche il numero di posti per le 2 tariffe.
 * Richiesti: metodo setCosto per specificare costo 2 tariffe, metodo Prenota per prenotare posti 
 * in una tariffa ( 2 parametri, tariffa prenotazione e numero di posti da prenotare) se non esistono 
 * posti liberi il metodo deve tornare un messaggio di avviso e non prenotare i posti altrimenti darà
 * il messaggio di posti prenotati comunicando il costo totale per quei posti, un metodo postiLiberi
 * per sapere quanti posti sono liberi, un metodo totale per sapere il totale incassato dal volo.
 */
package prenotazionevoliaerei;
import java.util.Scanner;


public class PrenotazioneVoliAerei{
    public static Scanner input = new Scanner(System.in);
    

    public static void main(String[] args) {
        double prezzoEc,prezzoBu;
        int postiEc,postiBu,numEc,numBu,i;
        System.out.println("Inserire Numero Di Voli Economy In Questo Mese. \n");
        numEc = input.nextInt();
        System.out.println("Inserire Numero Di Voli Business In Questo Mese. \n");
        numBu = input.nextInt();
        gestionePrenotazioni volo = new gestionePrenotazioni(numEc,numBu);
        for(i=0;i<numEc;i++){        
            volo.setDataVolo(i,1);
            volo.setPosti(i,1);
            volo.setCosti(i,1);
        }
        for(i=0;i<numBu;i++){         
            volo.setDataVolo(i,2);
            volo.setPosti(i,2);
            volo.setCosti(i,2);
        }  
        int choose;
        boolean ctr = true;
        do{
            int day;
            volo.getDataAttuale();
            System.out.println("\nSelezionare Operazione Immettendo Valore Numerico Corrispondente:"
                    + "\n\t1]Prenotazione Economy \n\t2]Prenotazione Business \n\t3]Posti Liberi Economy \n\t"
                    + "4]Posti Liberi Business \n\t5]Totale Incasso Voli \n\t6]Esci \n");
            choose = input.nextInt();
            switch(choose){
                case 1:
                    volo.getDateEconomy();
                    day=volo.getGiornoVolo();
                    System.out.println("Inserire Numero Di Posti Da Prenotare Per La Classe Economy. \n");
                    volo.getLiberi(1,day);
                    postiEc = input.nextInt();
                    volo.prenotaPosti(postiEc,1,day);
                break;
                case 2:
                    volo.getDateBusiness();
                    day=volo.getGiornoVolo();
                    System.out.println("Inserire Numero Posti Da Prenotare Per La Classe Business. \n");
                    volo.getLiberi(2,day);
                    postiBu= input.nextInt();
                    volo.prenotaPosti(postiBu,2,day);
                break;
                case 3:
                    volo.getDateEconomy();
                    day=volo.getGiornoVolo();
                    volo.getLiberi(1,day);
                break;
                case 4:
                    volo.getDateBusiness();
                    day=volo.getGiornoVolo();
                    volo.getLiberi(2,day);
                break;
                case 5:
                    volo.totaleIncasso();
                break;
                case 6:
                    System.out.println("System.Exit \n");
                    ctr = false;
                break;
                default:
                    System.out.println("Inserimento Non Valido, Si Prega Di Ridigitare. \n");
                break;
            }
        } while (ctr);
    }
}
