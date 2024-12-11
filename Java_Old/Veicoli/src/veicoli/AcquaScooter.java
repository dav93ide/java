package veicoli;

public class AcquaScooter extends Veicolo {
    
    
    public AcquaScooter(String sMatricola){
        super(sMatricola);
    }
    
    public AcquaScooter(){
        this("");
    }
    
    @Override
    public void start(){
        System.out.print("\nAccensione Del Motore");
    }
    
    @Override
    public void stop(){
        System.out.print("\nSpegnimento Del Motore");
    }
    
    /** 
     * @param sWhere : Destra, Sinistra, Sulle Onde E Sott'Acqua. 
     */
    @Override
    public void move(String sWhere){
        System.out.print("Muoviamo Verso: "+ sWhere);
    }
    
}
