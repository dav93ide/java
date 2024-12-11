package veicoli;

public class Jet extends Veicolo {
    
    public Jet(String sMatricola){
        super(sMatricola);
    }
    
    public Jet(){
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
    
    @Override
    public void move(String sWhere){
        System.out.print("Muoviamo Verso: "+ sWhere);
    }
}
