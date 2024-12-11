package convegnomedicina;
import java.util.ArrayList;

public abstract class ARelatori {
    
    private String codeRel;
    private String nameRel;
    private String surnameRel;
    private String natRel;
    private ArrayList<Intervento> listInterventi;
    
    public ARelatori(String sCode, String sName, String sSurname, String sNat){
        this.codeRel = sCode;
        this.nameRel = sName;
        this.surnameRel = sSurname;
        this.natRel = sNat;
        this.listInterventi = new ArrayList();
    }

    /**
     * @return the codeRel
     */
    public String getCodeRel() {
        return codeRel;
    }

    /**
     * @param codeRel the codeRel to set
     */
    public void setCodeRel(String codeRel) {
        this.codeRel = codeRel;
    }

    /**
     * @return the nameRel
     */
    public String getNameRel() {
        return nameRel;
    }

    /**
     * @param nameRel the nameRel to set
     */
    public void setNameRel(String nameRel) {
        this.nameRel = nameRel;
    }

    /**
     * @return the surnameRel
     */
    public String getSurnameRel() {
        return surnameRel;
    }

    /**
     * @param surnameRel the surnameRel to set
     */
    public void setSurnameRel(String surnameRel) {
        this.surnameRel = surnameRel;
    }

    /**
     * @return the natRel
     */
    public String getNatRel() {
        return natRel;
    }

    /**
     * @param natRel the natRel to set
     */
    public void setNatRel(String natRel) {
        this.natRel = natRel;
    }
    /**
     * @param iInt Oggetto Di Tipo Intervento
     */
    public void addInterventi(Intervento iInt){
        this.listInterventi.add(iInt);
    }
    
    public void printInterventi(){
        System.out.println(this.toString());
        for (Intervento i : listInterventi){    // Itero listInterventi E Stampo Informazioni Per Ogni Intervento
            System.out.println("\tIntervento: " + i.getTitle() + "\t Voto: " +  i.getVoto() +" Data Intervento: " + i.getData().getTime());
        }
    }
    
    /**
     * @return Double Media Voti
     */
    public double mediaVotiInt(){
        double media=0.0;
        for (Intervento i : listInterventi){    //Itero listInterventi
            media += (double)i.getVoto();   // Cast A Double Su getVoto, Aumento Media Per Ogni Voto
        }
        return (media / listInterventi.size()); // Divido Media Per Numero Interventi E Ritorno
    }
    
    /*
    * @return ArrayList Di Interventi
    */
    public ArrayList getInterventi(){   
        return this.listInterventi;
    }
    
    @Override
    public String toString(){
        return new String("Nome Relatore: " + this.nameRel + " Cognome Relatore: "+this.surnameRel+" Codice Relatore: " + this.codeRel + " Nazionalita` Relatore: " + this.natRel);
    }    
}
