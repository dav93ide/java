package abstractclassanimale;

public class Uccelli extends Animale{
    
    public Uccelli(int iZampe, String sAli, String sSpecie){
        super(iZampe,sAli,sSpecie);
    }
    @Override
    public int getNumZampe() {
        return numZampe;
    }
    @Override
    public String getAlimentazione() {
        return alimentazione;
    }
    @Override
    public String getSpecie() {
        return specie;
    }
}
