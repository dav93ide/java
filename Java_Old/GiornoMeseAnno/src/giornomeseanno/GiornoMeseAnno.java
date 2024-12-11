
package giornomeseanno;
import java.util.Scanner;


public class GiornoMeseAnno {
    private static Scanner input = new Scanner(System.in);
    
    public static boolean controlloMeseGiorno(int month, int day){
        boolean ctr = false;
        if(day==0){
        if(month>12|month<=0){
           System.out.println("Inserimento Non Valido, Maggiore Di 12\n");
        }
        else{
           ctr = true;
        }
        }
        else{
        switch(month){
                case 3|6|9|11 : 
                    if(day>30|day<=0){
                        System.out.println("Inserimento non valido");
                        ctr=false;
                    }
                    else{
                        ctr=true;
                    }
                break;
                case 2:
                    if(day>28|day<=0){
                        System.out.println("Inserimento non valido");
                        ctr=false;
                    }
                    else{
                        ctr=true;
                    }
                break;
                default:
                    if(day>31|day<=0){
                        System.out.println("Inserimento non valido");
                        ctr=false;
                    }
                    else{
                        ctr=true;
                    }
                break;
            }
        }
        return ctr;
    }
    
    public static void main(String[] args) {
       boolean ctr = true;
       int month,day;
       do{
       System.out.println("Inserire Mese, In Cifre\n");
       month=input.nextInt();
       ctr = controlloMeseGiorno(month,0);
       } while(!ctr);
       do{
            System.out.println("Inserire Giorno, In Cifre\n");
            day = input.nextInt();
            ctr = controlloMeseGiorno(month,day);
       }while(!ctr);
       Calendario oggi = new Calendario();
       Calendario domani = new Calendario(oggi.getGiorno() + 1, oggi.getMese(), oggi.getAnno());
       Calendario nextWeek = new Calendario(oggi.getGiorno() + 7, oggi.getMese(), oggi.getAnno());
       String evento;
       System.out.println("Inserire Tipo Di Evento");
       evento = input.nextLine();
       int dd,mm,aaaa;
       System.out.println("Inserisci Giorno");
       dd = input.nextInt();
       System.out.println("Inserisci Mese");
       mm = input.nextInt();
       System.out.println("Inserisci Anno");
       aaaa=input.nextInt();
       Calendario giorno1 = new Calendario(dd,mm,aaaa);
       System.out.println("Il giorno del "+ evento + " cade il " + giorno1);
       System.out.println(oggi);
       System.out.println(domani);
       System.out.println(nextWeek);
    }
    
}