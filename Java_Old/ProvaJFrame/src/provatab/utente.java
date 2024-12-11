package provatab;

public class utente {
    private int portafoglio;
    
    public utente(int soldi){
        this.portafoglio = soldi;
    }
    
    public void addToPortafoglio(int soldi){
        this.portafoglio+=soldi;
    }
    
    @Override
    public String toString(){
        return "Portafoglio: " + this.portafoglio;
    }
    
    public int getPortafoglio(){
        return portafoglio;
    }
}
