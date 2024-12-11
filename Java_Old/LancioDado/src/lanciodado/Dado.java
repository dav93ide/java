package lanciodado;


import java.util.Random;

public class Dado {    
    Random caso = new Random();
    private int nFacce;   
    private int max=0;
    private int min=999;

    public int lancio(){
        int ritorno;
        ritorno = caso.nextInt(nFacce);
        if (ritorno > max ){
            max = ritorno;
        }
        if (ritorno < min){
            min = ritorno;
        }
        return ritorno;
    }
    public void serieLanci(int lenght, String Tipo){
        int lancio;
        if(Tipo=="Serie"){
                for(int i=0; i<lenght;i++){
                lancio = this.lancio();
                    System.out.println("\nLancio Numero:" + (i+1) + "\t Risultato: " + lancio);
                }
        }
        else{
            int somma1=0;
            int somma2=0;
            for(int i=0; i<(lenght*2);i++){
                lancio = this.lancio();
                if(i%2==0){
                    System.out.println("\nLancio Numero:" + (i+1) + "\t Giocatore: 1 Risultato: " + lancio);
                    somma1+=lancio;
                }
                else{
                    System.out.println("\nLancio Numero:" + (i+1) + "\t Giocatore: 2 Risultato: " + lancio);
                    somma2+=lancio;
                }
            }   
            if(somma1>somma2){
                System.out.println("\nIl Giocatore Numero 1 Ha Vinto Con Punti: " + somma1 + " Differenza Di Punteggio: "+(somma1-somma2));
            }
            else{
                System.out.println("\nIl Giocatore Numero 2 Ha Vinto Con Punti: " + somma2 + " Differenza Di Punteggio: "+(somma2-somma1));
            }
        }
    }
    public void maxMinSerie(int lenght){
        System.out.println("\nSerie Da " + lenght + " lanci, valore max = " + max + " valore min = " + min + " con dado a " + nFacce + " facce."); 
    }
    public void changeFaces(int facce){
        nFacce = facce;
    }
    public int numFacce(){
        return nFacce;
    }
    public void resetMaxMin(){
        max=0;
        min=999;
    }
    public Dado(){
        nFacce=6;    
    } 
    public Dado(int facce){
        nFacce=facce;
    }
}
