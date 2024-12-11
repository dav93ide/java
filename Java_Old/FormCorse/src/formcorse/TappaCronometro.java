package formcorse;
import java.util.GregorianCalendar;

public class TappaCronometro extends Tappa {
    
    private int mtDislivello;
    
    public TappaCronometro(GregorianCalendar gcData, String sLP,String sLA,int iKM,int iMT){
        super(gcData,sLP,sLA,iKM);
        this.mtDislivello = iMT;
    }
    
    @Override
    public String toString(){
        return new String(super.toString() + "\n\t Tipo Tappa: " + this.getClass().getSimpleName() + "\n\t Metri Di Dislivello: " + this.mtDislivello);
    }
}
