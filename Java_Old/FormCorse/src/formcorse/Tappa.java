package formcorse;
import java.util.GregorianCalendar;

public abstract class Tappa {
    
    private GregorianCalendar data;
    private String luogoPartenza;
    private String luogoArrivo;
    private int kmTot;
    private String primo;
    private String secondo;
    private String terzo;

    
    public Tappa(GregorianCalendar gcData, String sLP,String sLA,int iKM){
        this.data = gcData;
        this.luogoPartenza = sLP;
        this.luogoArrivo = sLA;
        this.kmTot = iKM;
    }
    
    public void setClassificaPrimo(String name){
        this.primo = name;
    }
    
    public void setClassificaSecondo(String name){
        this.secondo = name;
    }
    public void setClassificaTerzo(String name){
        this.terzo = name;
    }
    
    public String getClassifica(){
       return new String("Primo: " + this.primo +" Secondo: " + this.secondo +" Terzo: " + this.terzo);
    }
    
    public GregorianCalendar getData(){
        return this.data;
    }
    
    public String getPartenza(){
        return this.luogoPartenza;
    }
    
    public String getArrivo(){
        return this.luogoArrivo;
    }
    
    public int getKmTot(){
        return this.kmTot;
    }  
    
    @Override
    public String toString(){
        return new String("Data Della Tappa: " + data.getTime() + "\tLuogo Di Partenza: " + this.luogoPartenza + "\tLuogo Di Arrivo: "+ this.luogoArrivo + "\tKilometri Totali: "+this.kmTot);
    }
}

