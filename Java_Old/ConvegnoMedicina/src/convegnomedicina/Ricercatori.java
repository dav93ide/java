package convegnomedicina;

public class Ricercatori extends ARelatori{
    
    private int numPublic;
    
    public Ricercatori(int iNP,String sCode, String sName, String sSurname, String sNat){
        super(sCode,sName,sSurname,sNat);
        this.numPublic = iNP;
    }

    /**
     * @return the numPublic
     */
    public int getNumPublic() {
        return numPublic;
    }

    /**
     * @param numPublic the numPublic to set
     */
    public void setNumPublic(int numPublic) {
        this.numPublic = numPublic;
    }
    
    
    
}
