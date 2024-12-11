package giroitalia;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GiroItalia {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Tappa> listTappe = new ArrayList();
        while(true){
            System.out.println("Inserire Valore Corrispettivo: \n\t1]Aggiungi Tappa\n\t2]Stampa Tutte Le Tappe\n\t3]Stampa Tutte Le Tappe Di Un Tipo\n\t4]Inserire Classifica Tappa\n\t5]Stampa Classifica Di Una Tappa\n\t6]Esci\n\t\t[int Value 1to6]");
            int choose = input.nextInt();
            input.nextLine();
            switch(choose){
                case 1:
                    System.out.println("Inserire Rispettivamente Anno, Mese, Giorno, Ora, Minuti Della Tappa [int x 5]");
                    GregorianCalendar data = new GregorianCalendar(input.nextInt(),(input.nextInt()-1),input.nextInt(),input.nextInt(),input.nextInt());
                    input.nextLine();
                    System.out.println("Inserire Luogo Di Partenza Della Tappa [String]");
                    String sPartenza = input.nextLine();
                    System.out.println("Inserire Luogo Di Arrivo Della Tappa [String]");
                    String sArrivo = input.nextLine();
                    System.out.println("Inserire Lunghezza Totale (Km) Della Tappa [int]");
                    int totKm = input.nextInt();
                    input.nextLine();
                    System.out.println("Specificare Il Tipo Di Tappa [String]");
                    String tipo = input.nextLine();
                    if(tipo.contains("ianura")){
                        System.out.println("Inserire Lunghezza Della Volata Della Tappa [int]");
                        int iVolata = input.nextInt();
                        listTappe.add(new TappaPianura(data,sPartenza,sArrivo,totKm,iVolata));
                    }else{
                        if(tipo.contains("ronometro")){
                           System.out.println("Inserire Metri Di Dislivello Della Tappa [int]");
                           int iDislivello = input.nextInt();
                           listTappe.add(new TappaCronometro(data,sPartenza,sArrivo,totKm,iDislivello));
                        }
                        else{
                           ArrayList<Salita> listSalite = new ArrayList();
                           while(true){
                               System.out.println("Inserire Nome Della Salita [End To Finish]");
                                   break;
                               }
                               System.out.println("Inserire Lunghezza Della Salita [int]");
                               int iLenS = input.nextInt();
                               System.out.println("Inserire Pendenza Della Salita [double]");
                               double dPS = input.nextDouble();
                               String sSName = input.nextLine();
                               if(sSName.equals("End")){
                               listSalite.add(new Salita(sSName,iLenS,dPS));
                               input.nextLine();
                           }
                           listTappe.add(new TappaMontagna(data,sPartenza,sArrivo,totKm,listSalite));
                        }
                    }
                    break;   
                case 2:
                    for(Tappa tp : listTappe){
                        System.out.println(tp.toString() + "\n");
                    }
                    break;
                case 3:
                    System.out.println("Inserire Tipo Di Tappa [String -> Tappa | TappaPianura | TappaCronometro | TappaMontagna]");
                    String sType = input.nextLine();
                    for(Tappa tp : listTappe){
                        if(tp.getClass().getSimpleName().contains(sType)){
                            System.out.println(tp.toString() + "\n");
                        }
                    }
                    break;
                case 4:
                    for(int i=0; i<listTappe.size();i++){
                        System.out.println((i+1) + "]" + listTappe.get(i).toString() + "\n");
                    }
                    System.out.println("Inserire Numero Della Tappa [int]");
                    int nTappa = input.nextInt() - 1;
                    input.nextLine();
                    System.out.println("Inserire Rispettivamente I Nome Del Primo,Secondo E Terzo Classificato [String x 3]");
                    listTappe.get(nTappa).setClassificaPrimo(input.nextLine());
                    listTappe.get(nTappa).setClassificaSecondo(input.nextLine());
                    listTappe.get(nTappa).setClassificaTerzo(input.nextLine());
                    break;
                case 5:
                    for(int i=0; i<listTappe.size();i++){
                        System.out.println((i+1) + "]" + listTappe.get(i).toString() + "\n");
                    }
                    System.out.println("Inserire Numero Della Tappa [int]");
                    nTappa = input.nextInt();
                    System.out.println(listTappe.get((nTappa-1)).getClassifica());
                    break;
                case 6:
                    System.out.println("Fine Programma.");
                    System.exit(0);
                    break;
                    
            }
        }
    }
    
}
