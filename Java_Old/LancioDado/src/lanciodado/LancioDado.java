package lanciodado;

import java.util.Scanner;

public class LancioDado {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInserire Numero Facce");
        int num = input.nextInt();
        Dado Star = new Dado(num);
        do{
        System.out.println("\nInserire un opzione \n\t 1]Lanciare il dado \n\t 2]Serie di lanci \n\t 3]Cambio facce \n\t 4]Scommessa\n\t 5]Attuale numero facce \n\t 6]Esci");
        String scelta;
        scelta = input.nextLine();
        switch(scelta){
            case "Lanciare il dado": 
                    num = Star.lancio();
                    System.out.println("\n Hai Ottenuto Un: " + num);                    
            break;
            case "Serie di lanci": 
                    System.out.println("\nInserisci Lunghezza Della Serie"); 
                    num = input.nextInt();
                    Star.serieLanci(num,"Serie");
                    System.out.println("\n Fine Della Serie Di Lanci.");
                    Star.maxMinSerie(num);
                    Star.resetMaxMin();
            break;
            case "Cambio facce": 
                    int num2;
                    System.out.println("\nInserire Nuovo Numero Di Facce");
                    num = input.nextInt();
                    Star.changeFaces(num);
                    num2 = Star.numFacce();
                    if(num==num2){
                        System.out.println("\nModifica Effettuata Con Successo, Nuovo Numero Di Facce: " + num2);
                    }
                    else{
                        System.out.println("\nNon E' Stato Possibile Effettuare La Modifica.");
                    }
            break;
            case "Scommessa":
                    System.out.println("\nInserisci Lunghezza Della Serie");
                    num = input.nextInt();
                    Star.serieLanci(num,"Sfida");
                                      
            break;
            case "Attuale numero facce":
                    num = Star.numFacce();
                    System.out.println("\nNumero Facce Dado Attuale: " + num);
            break;
            case "Esci": 
                    System.out.println("\nRun.Exit");
                    num = 9818;
            break;
            default: System.out.println("\nYoYoYo Impara A Leggere!"); 
            break;
        }
        } while (num!=9818);        //Non riuscendo ad inserire comparazione Stringa uso escape su num.
    }     
}
