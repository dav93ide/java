package slotmachine;
import java.util.Random;

public class mangiaSchei {
    String tema;
    String nomeLocale;
    String nomeCitta;
    int vincitaSemplice;
    int vincitaJackpot;
    int nVinciteSemplici;
    int nVinciteJackpot;
    int haveMonete;
    int maxMonete;
    boolean luceRossa;
    boolean luceGialla;
    Random rand;
    int defaultMonete;
    
    public mangiaSchei(String tematica, int monete){
        tema= tematica;
        haveMonete=monete;
        defaultMonete=monete;
        maxMonete=1000;
        luceRossa=false;
        luceGialla=false;
        rand = new Random();
        nVinciteSemplici=0;
        nVinciteJackpot=0;
        nomeLocale="Random Casinò";
        nomeCitta="FarmVille";
    }
    
    public mangiaSchei(){
        this("Joker",300);
    }
    
    public void collocaSlot(String locale, String citta){
        nomeLocale=locale;
        nomeCitta=citta;
    }
    
    public void setPremi(int vincita, int jackpot){
        vincitaSemplice=vincita;
        vincitaJackpot=jackpot;
    }
    
    public int getSetPremi(){
        return (vincitaSemplice+vincitaJackpot);
    }
    
    public int giocaSlot(passanteDiProfessione persona){
        int rulloOne;
        int rulloTwo;
        if(luceRossa==true){
            System.out.println("SlotMachine Impossibilitata Ad Accettare Nuove Giocate");
            return 0;
        }
        else{
            if(luceGialla==true){
                System.out.println("SlotMachine Richiede Intervento Inserviente");
                return 0;
            }
            else{
                if((persona.getPortafoglio()>1)){
                    haveMonete+=1;
                    rulloOne= rand.nextInt(11);
                    rulloTwo= rand.nextInt(11);
                    if(rulloOne==rulloTwo){
                        if(rulloOne==10){
                            System.out.println("JACKPOT! Vinti: "+ (vincitaJackpot-1));
                            nVinciteJackpot+=1;
                            haveMonete-=vincitaJackpot;
                            persona.addVincitaJackpot();
                            this.checkMoney();
                            return (vincitaJackpot-1);
                        }
                        else{
                            System.out.println("Vincita Con: "+ rulloOne + "|"+ rulloTwo+" Totale: "+ (vincitaSemplice-1));
                            nVinciteSemplici+=1;
                            haveMonete-=vincitaSemplice;
                            persona.addVincitaSemplice();
                            this.checkMoney();
                            return (vincitaSemplice-1);
                        }
                    }
                    else{
                        System.out.println("Ottenuto: "+ rulloOne + "|" + rulloTwo + " - Nessuna Vincita");
                        return (-1);
                    }
                }
                else{
                    System.out.println("Poraccio, Non Hai Abbastanza Soldi");
                    return 0;
                }
            }
        }
    }
    
    public void checkMoney(){
        if(maxMonete-haveMonete==100){
            luceGialla=true;
        }
        else{
            if(haveMonete<vincitaJackpot){
                luceRossa=true;
            }
        }
    }
    
    @Override
    public String toString(){
        return new String("Monete Nella Slot Machine: "+ haveMonete + 
                " \n Numero Vincite Jackpot: "+ nVinciteJackpot + " \n Numero Vincite Semplici: " + nVinciteSemplici+
                " \n Vincita Jackpot: " + vincitaJackpot +" Euro, Vincita Semplice: "+ vincitaSemplice+ " Euro"+
                " \n La Slot Si Trova Nel Locale: "+ nomeLocale + " Nella Citta: " + nomeCitta +
                " \n Luce Rossa: "+ ((luceRossa)?"Accesa":"Spenta") + 
                " Luce Gialla: " + ((luceGialla)?"Accesa":"Spenta"));
    }
    
    public void resetSlot(){
        if(haveMonete<defaultMonete){
            System.out.println("Default Monete: " + defaultMonete + " Monete Mancanti: "+ (defaultMonete - haveMonete));
        }
        else{
            System.out.println("Default Monete: " + defaultMonete + " Monete In Surplus: "+ (haveMonete-defaultMonete));
        }
    }
    
    public boolean sistemaSlotMachine(){
        haveMonete=defaultMonete;
        return new Boolean((haveMonete==defaultMonete)?true:false);
    }
    
    
    
}
