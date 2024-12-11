/*
Progettare una classi di nome DistributoreBenzina, poer rappresentare un distributore di carburante 
per autmobili. Tale classe prevede due variabili d'istanza. La prima variabile d'istanza è chiamata
deposito, è di tipo double e contiene il quantitativo di benzina disponibile nel distributore.
La seconda variabile d'istanza è chiamata euroPerLitro è di tipo double e rappresenta il prezzo
della benzina espresso in euro per litro. La classe deve implementare un costruttore public
DistributoreBenzina(double unPrezzoPerLitro) che prende come parametro esplicito il prezzo in euro
per un litro di benzina. Quantità iniziale disponibile : 0. Implementare metodi per rifornire
distributore di benzina, nmetodo che vende un quantità di benzina corrispondente all'ammontare
di euro pagato, un metodo che aggiorna il prezzo della benzina.
*/

package distributorebenzina;
import java.util.Scanner;

public class DistributoreBenzina {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInserire Attuale Valore In Euro Per Litro Della Benzina");
        double n = input.nextDouble();
        Distributore Benza = new Distributore(n);
        Macchina car = new Macchina("XM967VV");
        boolean controllo = true;
        while(controllo){
            System.out.println("\nDigitare Un Opzione: \n\t 1]Compra\n\t 2]Informazioni \n\t 3]Rifornimento \n\t 4]Cambio Prezzo \n\t 5]Info Macchina \n\t 6]Cambia Targa \n\t 7]Esci");
            String str=input.nextLine();
            System.out.println("\nSelezionato: "+ str);
            switch(str){
                case "Compra": 
                    System.out.println("\nInserire Importo In Euro");
                    n = input.nextDouble();
                    car.rifornimento(Benza,n);
                break;
                case "Informazioni":
                    Benza.infoDistributore();
                break;
                case "Rifornimento":
                    System.out.println("\nInserire Numero Di Litri");
                    n = input.nextDouble();
                    Benza.rifornimento(n);
                break;
                case "Cambio Prezzo": 
                    System.out.println("\nInserire Attuale Prezzo Benzina In Euro/Litri");
                    n = input.nextDouble();
                    Benza.cambioPrezzo(n);
                break;
                case "Info Macchina":
                    car.getInfo();
                break;
                case "Cambia Targa":
                    String targa;
                    System.out.println("Inserire Nuova Targa Del Veicolo");
                    targa = input.nextLine();
                    car.setTarga(targa);
                break;
                case "Esci": 
                    controllo=false;
                break;
                default: 
                    System.out.println("\nInserire Un Comando Corretto, Grazie");
                break;
            }
        }
    }
}
