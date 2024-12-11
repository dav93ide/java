package enumproject;
import java.util.Calendar;

public class Vets {
    
    private int[] iVet = {5,8,7,6,9,6,6,5,89,122};
    private String[] strVet = {"Ciao","Come","Va?","Tutto","Bene","?"};
    private Object[] obVet = {iVet,strVet,"Ciao",505.99,102};
    final private String[] mesi = {"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
    final double PiGreco = 3.1415926;
    
    public void printVets(){
       
        for(int i=0; i<iVet.length; i++){
            System.out.println("|"+iVet[i] + "|");
        }
        for( int valore : iVet){
            System.out.println(valore);
        }
        
        for(int i=0; i<strVet.length; i++){
            System.out.println("|"+strVet[i] + "|");
        }
        for( String str : strVet){
            System.out.println(str);
        }
        
        for(int i=0; i<obVet.length; i++){
            System.out.println("|"+obVet[i] + "|");
        }
        for( Object ob : obVet){
            System.out.println(ob);
        }
        
        for (String mese : mesi){
            System.out.println(mese);
        }
        
        System.out.println(PiGreco);
        /*int numGiorni=0;
        for(Enum valoreMese : Enum.values()){
            System.out.println(valoreMese.toString());
            if (valoreMese.equals(Enum.DICEMBRE)) System.out.println("In Un Anno Ci Sono: " + valoreMese.getGiorniAnno() + " Giorni");
        }*/
    }
}
