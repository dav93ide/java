package aziendaautovetture;

public abstract class AMezzoTrasporto implements Noleggio {
    
    private String casaProduttrice;
    private String modello;
    private String numeroTarga;
    private int kmPercorsi;
    private boolean noleggiato;
    private boolean acquisito;
    private Dipendenti noleggiatore;
    private Dipendenti acquisitore;
    
    public AMezzoTrasporto(String house, String model, String targa, int kmPercorsi){
        this.casaProduttrice = house;
        this.modello = model;
        this.numeroTarga = targa;
        this.kmPercorsi = kmPercorsi;
        this.noleggiato = false;
        this.acquisito = false;
    }
    
    public void noleggiaVeicolo(Dipendenti dip){
        System.out.println("Veicolo Noleggiato");
        this.getNoleggiato();
        this.noleggiato = true;
        this.noleggiatore = dip;
        noleggiatore.setKm(this.kmPercorsi);
    }
    
    public boolean ctrNA(){
        return noleggiato | acquisito;
    }
    
    @Override
    public void getNoleggiato(){
        if(this.noleggiato) System.out.println("Il Veicolo Con Targa " + this.numeroTarga + " Di Modello: " + this.modello + " E' Stato Noleggiato"
                + "Da: "+ noleggiatore.getName() + " " + noleggiatore.getSurname());
        else System.out.println(" Il Veicolo Non E' Ancora Stato Noleggiato");
    }
    
    public void acquista(Dipendenti dip){
        System.out.println("Veicolo Acquistato");
        this.acquisito = true;
        this.acquisitore = dip;
        acquisitore.setKm(kmPercorsi);
    }
    
    @Override
    public void getAcquistato(){
        if(this.acquisito) System.out.println("Il Veicolo Con Targa " + this.numeroTarga + " Di Modello: " + this.modello + " E' Stato Acquistato"
                + "Da: "+ acquisitore.getName() + " " + acquisitore.getSurname());
        else System.out.println(" Il Veicolo Non E' Ancora Stato Acquistato");
    }
    
    @Override
    public void restituisci(){
        if(this.noleggiato){
            this.kmPercorsi += noleggiatore.getKm();
            this.noleggiato = false;
            this.noleggiatore = null;
        }
        else{
            System.out.println("Nessuno Ha Noleggiato Questo Veicolo");
        }
    }
    
}
