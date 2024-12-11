/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dipendenti;

public class Dipendenti {

    public static void main(String[] args) {
        System.out.println("\nPurtroppo Sei Il Nostro Capo (ID: 1) Dunque Dovremo Inizializzarti Come Dipendente '0'.");
        System.out.println("\nInserisci Il Tuo Nome");
        String scelta = Employee.stringPut();
        System.out.println("\nInserisci Il Tuo Cognome");
        String surname = Employee.stringPut();
        Employee lavoratori = new Employee(scelta,surname,0);
        System.out.println("\nInserisci Il Tuo Stipendio, Scommetto Che Esagererai...");
        Double schei = lavoratori.doublePut();
        lavoratori.cambiaSalario(surname,schei);
        boolean ctr = true;
        do{
            System.out.println("\nDigitare Opzione: \n\t1]inserimento \n\t2]info \n\t3]Info_all \n\t4]cambia_salario\n\t5]set_id\n\t6]esci");
            scelta = lavoratori.stringPut();
            switch(scelta){
                case "inserimento":
                    int num;
                    System.out.println("\n Inserire Numero Di Dipendenti Da Registrare");   
                    num = lavoratori.intPut();
                    lavoratori.registraDipendenti(num);               
                break;
                case "info":
                    int num1;
                    int num2;
                    System.out.println("\nInserire ID dipendente di \"partenza\"");
                    num1 = lavoratori.intPut();
                    System.out.println("\nInserire ID dipendente di \"arrivo\", Se Si Vogliono Info Solo Sul Primo ID Ridigitarlo");
                    num2 = lavoratori.intPut();
                    lavoratori.infoDipendenti(num1, num2, 1);
                break;
                case "info_all":
                    lavoratori.infoDipendenti(0, 0, 2);
                break;
                case "cambia_salario":
                    System.out.println("\nInserire Cognome Dipendente");
                    surname = lavoratori.stringPut();
                    System.out.println("\nInserire Salario Dipendente");
                    schei = lavoratori.doublePut();
                    lavoratori.cambiaSalario(surname,schei);
                break;
                case "set_id":
                    lavoratori.setIDipendente();
                break;
                case "esci":
                    System.out.println("\nProcess.Exit");
                    ctr = false;
                break;
                default:
                    System.out.println("\nInserimento Non Valido, Reinserire Prego.");
                break;
            }
        } while(ctr);
    }
    
}
