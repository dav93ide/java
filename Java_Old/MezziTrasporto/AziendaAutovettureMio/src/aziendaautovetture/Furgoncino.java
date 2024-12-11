package aziendaautovetture;

public class Furgoncino extends AMezzoTrasporto{
    
    private int altezza;
    private int larghezza;
    private int profondità;
    
    public Furgoncino(String house, String model, String targa, int h, int l, int d, int kmPercorsi){
        super(house,model,targa,kmPercorsi);
        this.altezza = h;
        this.larghezza = l;
        this.profondità = d;
    }
    
    public Furgoncino(String house, String model, String targa, int h, int l, int d){
        this(house,model,targa,h,l,d,0);
    }
    
    private boolean ctrlPatente(Dipendenti dip){
        if((dip.getPatente()=='C')||(dip.getPatente()=='D')) return true;
        else return false;
    }
    
    @Override
    public void noleggiaVeicolo(Dipendenti dip){
        if(this.ctrlPatente(dip)) super.noleggiaVeicolo(dip);
        else System.out.println("Per Noleggiare Tale Veicolo E' Necessaria Una Patente Di Grado Superiore");
    }
    
    @Override
    public void acquista(Dipendenti dip){
        if(this.ctrlPatente(dip)) super.acquista(dip);
        else System.out.println("Per Acquistare Tale Veicolo E' Necessaria Una Patente Di Grado Superiore");
    }
    
    
    
}
