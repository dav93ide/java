
package aereoporto;

import java.util.Scanner;

public class Aereoporto {

    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        String dir,name,surname,pass,choose;
        voli volo = new voli();
        utente user = new utente();
        System.out.println("Digitare La Directory");
        dir = input.nextLine();
        airportFileHandler handler = new airportFileHandler(dir);
        while(!handler.checkDir()){
            System.out.println("Ridigitare La Directory");
            dir = input.nextLine();
            handler.setDir(dir);
        }
        while(user.getStatus().equals("Guest")){
            System.out.println("1] LogIn 2] Registrazione");
            choose = input.nextLine();
            if(choose.equals("LogIn")){
                System.out.println("Inserire Nome Utente");
                name=input.nextLine();
                System.out.println("Inserire Cognome Utente");
                surname=input.nextLine();
                System.out.println("Inserire Password Utente");
                pass=input.nextLine();
                user.setNomeCognome(name, surname);
                System.out.println("setNomeCognome");
                user.setPass(pass);
                System.out.println("setPass");
            }
            else{
                if(choose.equals("Registrazione")){
                    System.out.println("Inserire Nome Utente");
                    name=input.nextLine();
                    System.out.println("Inserire Cognome Utente");
                    surname=input.nextLine();
                    System.out.println("Inserire Password Utente");
                    pass=input.nextLine();
                    System.out.println("Nome:"+name);
                    System.out.println("Cognome:"+surname);
                    System.out.println("Password:"+pass);
                    user.setNomeCognome(name,surname);
                    user.setPass(pass);
                    user.userRegistration(handler);
                }
            }
            user.LogUser(handler);
        }
        System.out.println("LogIn Effettuato. Benvenuto "+ user.getNome() +" | "+ user.getCognome());
        do{
            System.out.println("Digitare Un Operazione:"
                    + "\n\t1]Cerca Volo "
                    + "\n\t2]Vedi Prenotazioni"
                    + "\n\t3]Informazioni Account"
                    + "\n\t4]Cambia Nome"
                    + "\n\t5]Cambia Cognome"
                    + "\n\t6]Cambia Password"
                    + "\n\t7]LogOut");
            choose=input.nextLine();
            switch(choose){
                case "Cerca Volo":
                    String partenza,destinazione;
                    int nVolo,nPosti;
                    System.out.println("Inserire Citta` Di Partenza");
                    partenza = input.nextLine();
                    System.out.println("Inserire Citta` Di Destinazione");
                    destinazione = input.nextLine();
                    handler.getLineFromIdVoli(partenza, destinazione, volo);
                    volo.printInfo();
                    System.out.println("Inserire Numero Volo Da Prenotare (Non idVolo)");
                    nVolo=input.nextInt()-1;
                    System.out.println("Inserire Numero Posti Da Prenotare");
                    nPosti=input.nextInt();
                    volo.makePrenotation(nVolo,nPosti, handler, user);
                break;
                case "Vedi Prenotazioni":
                break;
                case "Informazioni Account":
                break;
                case "Cambia Nome":
                break;
                case "Cambia Cognome":
                break;
                case "Cambia Password":
                break;
                case "LogOut":
                break;
                default:
                    System.out.println("Inserimento Non Valido");
                break;
            }
        } while(!choose.equals("Exit"));
    }
    
    public static boolean systemError(){
        return false;
    }
    
}
