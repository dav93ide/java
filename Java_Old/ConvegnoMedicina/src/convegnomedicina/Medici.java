package convegnomedicina;

public class Medici extends ARelatori {
    
    private String hospitalName;
    private String hospitalLocation;
    
    public Medici(String sHN, String sHL, String sCode, String sName, String sSurname, String sNat){
        super(sCode,sName,sSurname,sNat);
        this.hospitalName = sHN;
        this.hospitalLocation = sHL;
    }

    /**
     * @return the hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName the hospitalName to set
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return the hospitalLocation
     */
    public String getHospitalLocation() {
        return hospitalLocation;
    }

    /**
     * @param hospitalLocation the hospitalLocation to set
     */
    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }
    
    
    
}
