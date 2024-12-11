package abstractclassanimale;

public abstract class Animale {
    protected int numZampe;
    protected String alimentazione;
    protected String specie;
    
    public Animale(int iZampe, String sAli, String sSpecie){
        this.numZampe = iZampe;
        this.alimentazione = sAli;
        this.specie = sSpecie;
    }

    public abstract int getNumZampe();

    public abstract String getAlimentazione();

    public abstract String getSpecie();
       
}
