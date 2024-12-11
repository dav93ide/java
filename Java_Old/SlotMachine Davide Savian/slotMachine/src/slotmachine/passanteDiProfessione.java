package slotmachine;

public class passanteDiProfessione {
    
    int portafoglio;
    String nome;
    String cognome;
    int vincite;
    int contoInBanca;
    int totVinciteSemplici;
    int totVinciteJackpot;
    
    public passanteDiProfessione(int soldi,int conto, String name, String surname){
        portafoglio = soldi;
        contoInBanca = conto;
        nome = name;
        cognome = surname;
        vincite = 0;
        totVinciteSemplici=0;
        totVinciteJackpot=0;
    }
    
    public passanteDiProfessione(int soldi, int conto){
        this(soldi,conto,"Sconosciuto","Anonimo");
    }
    
    public void addVincitaSemplice(){
        totVinciteSemplici+=1;
    }
    public String checkConto(){
        return new String("Nel Tuo Conto Ci Sono:" + contoInBanca + " Euro");
    }
    public void addVincitaJackpot(){
        totVinciteJackpot+=1;
    }
    public passanteDiProfessione(){
        this(1000,10000,"Ricco","Spendaccione");
    }
    
    @Override
    public String toString(){
        return new String("Nome: "+ nome + "  Cognome: "+ cognome+ "  Portafoglio: "+ portafoglio + "  Ammontare Vincite: "+ vincite + " Euro,"+
                " Totale Di Vincite Semplici: " + totVinciteSemplici + " Totale Di Vincite Jackpot: " + totVinciteJackpot);
    }
        
    public void setPortafoglioVincita(int vincita){
        portafoglio+= ( vincita );
        vincite += (vincita );
    }
    
    public int getPortafoglio(){
        return portafoglio;
    }
    
    public void setContoInBanca(int prelievo, String Operazione){
        if(Operazione.equals("Prelievo")){
            if(contoInBanca<prelievo){
                System.out.println("Impossibile Ritirare Soldi, Ci Sono Solo: " + contoInBanca + " Euro Nel Conto.");
            }
            else{
                contoInBanca-=prelievo;
                portafoglio+=prelievo;
                System.out.println("Prelevati: " + prelievo + " Euro");
            }
        }
        else{
            if(portafoglio<prelievo){
                System.out.println("Non Hai Abbastanza Soldi Nel Portafoglio");
            }
            else{
                contoInBanca+=prelievo;
                portafoglio-=prelievo;
                System.out.println("Depositati: " + prelievo + " Euro");
                System.out.println("Saldo Attuale: "+ contoInBanca + " Euro");   
            }
        }
    }
}
