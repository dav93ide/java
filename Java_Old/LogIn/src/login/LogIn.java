package login;
import java.util.Scanner;
import java.util.Random;
public class LogIn {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String str1,str2;
        user utente = new user();
        System.out.println("Inserire Nome Della Directory");
        str1 = input.nextLine();
        System.out.println("Inserire Nome Del File");
        str2 = input.nextLine();
        fileHandler handler = new fileHandler(str1, str2);
        while(!handler.setDir(str1)){
            System.out.println("Directory Inesistente, Inserire Nome Della Directory.");
            str1=input.nextLine();
        }
        System.out.println("Directory Esistente.");
        while(!handler.setFileInfoNome(str2)){
            System.out.println("File Inesistente, Inserire Nome Del File.");
            str2=input.nextLine();
        }
        System.out.println("File Esistente.");
        while(true){
            String str3;
            System.out.println("LogIn o Registrazione?");
            str3=input.nextLine();
            System.out.println("Inserire Nome Utente");
            str1=input.nextLine();
            System.out.println("Inserire Password Utente");
            str2=input.nextLine();
            if(str3.equals("Registrazione")){
                if(utente.registraUser(str1, str2, handler) & utente.changeUser(str1, str2, handler)){
                    break;
                }
            }
            else{
                if(utente.changeUser(str1, str2, handler)){
                    break;
                }
            }
        }
        System.out.println("Benvenuto, " + utente.toString());
        while(true){
            String choose;
            System.out.println("Selezionare Un Operazione: \n\t1]Modifica File Utente\n\t2]Scrivi In File Utente\n\t3]Modifica Password Utente\n\t4]Cambia Utente\n\t5]Info Utente\n\t6]Registra Nuovo Utente\n\t7]Leggi File Utente \n\t8]Cambia Password Questo Utente \n\t9]Esci");
            if(utente.getUserStatus().equals("AdminOnline")){
                System.out.println("\nPrivilegi Admin: \n\t1]Lista Di Tutti I File \n\t2]Leggi File\n\t3]Sovrascrivi File\n\t4]Cancella File\n\t5]Crea File\n\t6]Scrivi In File\n\t7]Cambia Password Di Un Utente\n\t");
            }
            choose = input.nextLine();
            if(utente.getUserStatus().equals("AdminOnline")){
                switch(choose){
                    case "Lista Di Tutti I File":
                        handler.fileList();
                    break;
                    case "Leggi File":
                        System.out.println("Inserire Nome Del File");
                        str1=input.nextLine();
                        handler.readUserFile(str1);
                    break;
                    case "Sovrascrivi File":
                        String str3;
                        boolean lineaParola;
                        System.out.println("Inserire Nome Del File");
                        str1=input.nextLine();
                        System.out.println("Inserire Stringa Da Sovrascrivere");
                        str2=input.nextLine();
                        System.out.println("Inserire Stringa Da Scrivere");
                        str3=input.nextLine();
                        System.out.println("Sovrascrivere Tutta La Linea? (Si|No)");
                        lineaParola= (input.nextLine().equals("No")) ? true : false;
                        handler.replaceInFile(str2, str3, str1, lineaParola);
                    break;
                    case "Cancella File":
                        System.out.println("Inserire Nome Del File");
                        str1=input.nextLine();
                        handler.deleteFile(str1);
                    break;
                    case "Crea File":
                        System.out.println("Inserire Nome Del File");
                        str1=input.nextLine();
                        handler.createFileTxt(str1);
                    break;
                    case "Scrivi In File":
                        boolean nuovaLinea;
                        System.out.println("Inserire Nome Del File");
                        str1=input.nextLine();
                        System.out.println("Inserire Stringa Da Scrivere");
                        str2=input.nextLine();
                        System.out.println("Scrivere Su Nuova Linea? (Si|No)");
                        nuovaLinea= (input.nextLine().equals("Si") ? true : false);
                        handler.writeInFile(str1, str2, nuovaLinea);
                    break;
                    case "Cerca In File":
                        System.out.println("Inserire Nome Del File");
                        str1=input.nextLine();
                        System.out.println("Inserire Stringa Da Cercare");
                        str2=input.nextLine();
                        System.out.print("Linea Con Stringa Cercata: " + handler.searchInfoInFile(str2, str1));
                    break;
                    case "Cambia Password Di Un Utente":
                        System.out.println("Inserire Nome Utente");
                        str1=input.nextLine();
                        System.out.println("Info Utente: "+ handler.searchInfoInFile(str1,handler.getFileInfoNome()));
                        System.out.println("Attuale Password Utente: " + utente.getPassDe(handler.searchUserInfoInLine(handler.searchInfoInFile(str1, handler.getFileInfoNome()), "userPass")));
                        System.out.println("Inserire Nuova Password Utente");
                        str2=input.nextLine();
                        utente.changePass(str2,str1, handler);
                    break;
                }
            }
            switch(choose){
                case "Modifica File Utente":
                    System.out.println("File Utente Attuale: " + utente.getUserFile());
                    System.out.println("Inserire Nuovo Nome File");
                    str1=input.nextLine();
                    utente.createFileUtente(str1, handler);
                break;
                case "Scrivi In File Utente":
                    System.out.println("Inserire Testo Da Aggiungere In: "+utente.getUserFile());
                    str1=input.nextLine();
                    handler.writeInFile(utente.getUserFile(), str1, false);
                break;
                case "Modifica Password Utente":
                    System.out.println("Metodo Non Ancora Creato");
                break;
                case "Cambia Utente":
                    System.out.println("Inserire Nome Utente");
                    str1=input.nextLine();
                    System.out.println("Inserire Password Utente");
                    str2=input.nextLine();
                    if(utente.changeUser(str1, str2, handler)){
                        System.out.println("Benvenuto, " + utente.toString());
                    }                    
                break;
                case "Info Utente":
                    System.out.println(utente.toString());
                break;
                case "Registra Nuovo Utente":
                    System.out.println("Inserire Nome Utente");
                    str1=input.nextLine();
                    System.out.println("Inserire Password Utente");
                    str2=input.nextLine();
                    if(utente.registraUser(str1, str2, handler) & utente.changeUser(str1, str2, handler)){
                        System.out.println("Benvenuto, " + utente.toString());
                    }      
                break;
                case "Leggi File Utente":
                    utente.readFile(utente.getUserFile(), handler);
                break;
                case "Cambia Password Questo Utente":
                    System.out.println("Inserire Nuova Password");
                    str1=input.nextLine();
                    utente.changePass(str1, utente.getUserName(), handler);
                break;
                case "Esci":
                    System.out.println("System.Exit");
                break;
            }
            if(choose.equals("Esci")){
                break;
            }
        }
    }
}
