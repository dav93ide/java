package slotmachine;
import java.util.Scanner;

public class SlotMachine {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1,str2,str3;
        int int1,int2,int3;
        System.out.println("Inserire Tema Della SlotMachine");
        str1 = input.nextLine();
        System.out.println("Inserire Monete Inizialmente Contenute Nella Slot");
        int1 = input.nextInt();
        System.out.println("Inserisci Il Tuo Nome");
        str2=input.nextLine();
        System.out.println("Inserisci Il Tuo Cognome");
        str3=input.nextLine();
        System.out.println("Inserisci Il Tuo Budget Nel Portafoglio");
        int2=input.nextInt();
        System.out.println("Inserisci Il Tuo Budget Nel Conto Corrente");
        int3=input.nextInt();
        mangiaSchei slot = new mangiaSchei(str1,int1);
        passanteDiProfessione persona = new passanteDiProfessione(int2,int3,str2,str3);
        while(1==1){
            System.out.println("\nChe Vuoi Fare? \n\t1]Gioca \n\t2]Controlla Portafoglio"
                    + " \n\t3]Controlla SlotMachine \n\t4]Cambia Citta \n\t5]Imposta Vincite \n\t6]Preleva \n\t7]Deposita \n\t8]Controlla Conto \n\t 9]Sistema Slot \n\t10]Esci");
            str1=input.nextLine();
            switch(str1){
                case "Gioca":
                    if(slot.getSetPremi()==0){
                        System.out.println("E' Necessario Impostare Prima I Premi!");
                    }
                    else{
                        System.out.println("Quante Partite Consecutive Vuoi Fare? Costo Di Una Partita: 1 Euro");
                        int1 = input.nextInt();
                        for(int i=0; i < int1; i++){
                            persona.setPortafoglioVincita(slot.giocaSlot(persona));
                        }
                    }
                break;
                case "Controlla Portafoglio":
                    System.out.print(persona.toString());
                break;
                case "Controlla SlotMachine":
                    System.out.print(slot.toString());
                break;
                case "Cambia Citta":
                    System.out.println("Inserire Locale In Cui E' Situata La Slot");
                    str2 = input.nextLine();
                    System.out.println("Inserire Citta In Cui E' Situata La Slot");
                    str3 = input.nextLine();
                    slot.collocaSlot(str2, str3);
                break;
                case "Imposta Vincite":
                    System.out.println("Inserire Premio Vincita Semplice");
                    int1 = input.nextInt();
                    System.out.println("Inserire Premio Vincita Jackpot");
                    int2 = input.nextInt();
                    slot.setPremi(int1,int2);
                break;
                case "Preleva":
                    System.out.println("Inserire Soldi Da Prelevare");
                    int1=input.nextInt();
                    persona.setContoInBanca(int1,"Prelievo");
                break;
                case "Deposita":
                     System.out.println("Inserire Soldi Da Depositare");
                    int1=input.nextInt();
                    persona.setContoInBanca(int1,"Deposito");
                break;
                case "Controlla Conto":
                    System.out.print(persona.checkConto());
                break;
                case "Sistema Slot":
                    if(slot.sistemaSlotMachine()){
                        System.out.println("Slot Machine Sistemata");
                    }
                    else{
                        System.out.println("Impossibile Sistemare La Slot Machine");
                    }
                    
                break;
                case "Esci":
                break;
            }
            if(str1.equals("Esci")){
                break;
            }
        }
    }
    
}
