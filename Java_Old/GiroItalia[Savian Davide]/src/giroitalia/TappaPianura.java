package giroitalia;
import java.util.GregorianCalendar;

public class TappaPianura extends Tappa {
    
    private int lengthVolata;

    
    public TappaPianura(GregorianCalendar gcData, String sLP,String sLA,int iKM,int iLV){
        super(gcData,sLP,sLA,iKM);
        this.lengthVolata = iLV;
    }
    
    @Override
    public String toString(){
        return new String(super.toString() + " \n\t Tipo Di Tappa: "+ this.getClass().getSimpleName() + "\n\t Lunghezza Della Volata: " + this.lengthVolata);
    }
    
}
