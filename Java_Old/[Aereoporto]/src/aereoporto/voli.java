
package aereoporto;

import java.util.Calendar;


public class voli {
    String[] idVolo;
    String[] classe;
    int[] postiTotali;
    int[] postiLiberi;
    double[] costo;
    Calendar[] dataVolo;
    Calendar dataOdierna;
    
    public voli(){
        dataOdierna= Calendar.getInstance();
        dataVolo = new Calendar[50];
        costo = new double[50];
        postiLiberi= new int[50];
        postiTotali= new int[50];
        classe = new String[50];
        idVolo = new String[50];

    }
    
    public void setVetEnd(){
        int i=0;
        if(idVolo[i]==null){
            idVolo[i]="/";
        }
        else{
            for(;idVolo[i].equals(null);i++){
                System.out.println("SETVETEND IDVOLO IN"+i+" =");
            }
        }
        idVolo[i]="/";
    }
    
    private int getVetEnd(){
        int i=0;
        if(idVolo[i]=="/"){
            return i;
        }
        else{
            for(;idVolo[i].equals("/");i++){
                System.out.println("SETVETEND IDVOLO IN"+i+" =");
            }
            return i;
        }
    }
   
    public void setPostiTotali(int n, int posti){
        System.out.println("STR setPOSTITOTALI="+posti);
        postiTotali[n]= posti;
    }
    
    public void setPostiLiberi(int n, int posti){
        postiLiberi[n]=posti;
    }
    
    public void setClasse(int n,String str){
        classe[n]=str;
    }
    
    public void setCosto(int n, double price){
        costo[n]= price;
    }
    
    public void setIdVolo(int n, String str){
        System.out.println("IDVOLO in SETIDVOLO="+str);
        idVolo[n]=str;
    }
    
    public void setDataVolo(int n,String str){
        dataVolo[n]=dataOdierna;
        int minuti,ora,giorno,mese,anno;
        String strPart="";
        minuti = Integer.valueOf(str.substring(0,2));
        ora = Integer.valueOf(str.substring(3,5));
        giorno = Integer.valueOf(str.substring(6,8));
        mese = Integer.valueOf(str.substring(9,11));
        anno = Integer.valueOf(str.substring(12,16));
        dataVolo[n].set(minuti, ora, giorno, mese, anno);
    }
    
    public void printInfo(){
        int n = this.getVetEnd();
        for(int i=0; i<(n+1);i++){
            System.out.println(
                    (i+1) +"] "+
                    "ID Volo: "+idVolo[i]+
                    ", Classe: "+ classe[i]+
                    ", Posti Totali: "+postiTotali[i]+
                    ", Posti Liberi: "+postiLiberi[i]+
                    ", Data Volo: "+ dataVolo[i].getTime()+
                    ", Costo: "+ costo[i] +" Euro."
            );
        }
    }
    
    public String toString(int n){
        return new String(
                idVolo[n]+"~"+
                classe[n]+"~"+
                String.valueOf(postiTotali[n])+
                String.valueOf(postiLiberi[n])+
                String.valueOf(costo[n])+
                String.valueOf(dataVolo[n].MINUTE)+
                String.valueOf(dataVolo[n].HOUR)+
                String.valueOf(dataVolo[n].DAY_OF_MONTH)+
                String.valueOf(dataVolo[n].MONTH)+
                String.valueOf(dataVolo[n].YEAR));
    }
    
    public void makePrenotation(int n, int nPosti, airportFileHandler handler, utente user){
        if(nPosti<postiLiberi[n]){
            System.out.println("Richiesta In Elaborazione");
            postiLiberi[n]-= nPosti;
            handler.setDatiVolo(this.toString(n), idVolo[n]);
            user.makePrenotation(nPosti,idVolo[n], handler);
        }
        else{
            System.out.println("Posti Disponibili Nel Volo: " + idVolo[n] + " Non Sufficienti Per Effettuare La Prenotazione.");
        }
    }
 
}
