package veicoli;

public abstract class Veicolo {
    private String targa;

    
    public Veicolo(String sTarga){
        this.targa = sTarga;
    }
    
    public Veicolo(){
        this("");
    }

    /**
     * @return the targa
     */
    public String getTarga() {
        return targa;
    }
    
    public abstract void start();
    public abstract void stop();
    public abstract void move(String sWhere);
    
}
