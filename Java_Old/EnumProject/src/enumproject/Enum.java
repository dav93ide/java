package enumproject;


public enum Enum {
    GENNAIO,
    FEBBRAIO(28),
    MARZO,
    APRILE(30),
    MAGGIO,
    GIUGNO(30),
    LUGLIO,
    AGOSTO,
    SETTEMBRE(30),
    OTTOBRE,
    NOVEMBRE(30),
    DICEMBRE;
    
    private int nGiorni;
    
    private Enum(int nGiorni){
        this.nGiorni = nGiorni;
    }
    
    private Enum(){
        this(31);
    }
    
    public int getNGiorni(){
        return nGiorni;
    }

    public int getGiorniAnno(){
        int num=0;
        for(Enum MonthElem : Enum.values()){
            num += MonthElem.getNGiorni();
        }
        return num;
    }
    
    @Override
    public String toString(){
        return new String ("Mese: "+ super.toString() + " Giorni Nel Mese: "+ this.nGiorni + " Classe: " + this.getClass());
    }
}
