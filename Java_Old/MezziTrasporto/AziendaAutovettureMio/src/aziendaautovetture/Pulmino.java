package aziendaautovetture;

public class Pulmino extends AMezzoTrasporto{
    
    private int nPosti;
    
    public Pulmino(String house, String model, String targa, int posti, int kmPercorsi){
        super(house,model,targa,kmPercorsi);
        this.nPosti = posti;
    }
    
    public Pulmino(String house, String model, String targa, int posti){
        this(house,model,targa,posti,0);
    }
    
    public boolean ctrlPatente(Dipendenti dip){
        if ( this.nPosti > 9 ) {
            if(dip.getPatente() == 'D'){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(dip.getPatente() == 'C' || dip.getPatente() == 'D'){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    @Override
    public void noleggiaVeicolo(Dipendenti dip){
        if(this.ctrlPatente(dip)) super.noleggiaVeicolo(dip);
        else System.out.println("La Patente Del Dipendente Non E' DI Grado Sufficiente Per Effettuare Il Noleggio Del Mezzo");
    }
    
    @Override
    public void acquista(Dipendenti dip){
        if(this.ctrlPatente(dip)) super.acquista(dip);
        else System.out.println("La Patente Del Dipendente Non E' DI Grado Sufficiente Per Effettuare Il Noleggio Del Mezzo");
    }
    
}
