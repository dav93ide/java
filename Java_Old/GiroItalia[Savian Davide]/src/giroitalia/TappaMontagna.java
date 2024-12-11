package giroitalia;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TappaMontagna extends Tappa {
    
    private ArrayList<Salita> listSalite;
    
    public TappaMontagna(GregorianCalendar gcData, String sLP,String sLA,int iKM,ArrayList<Salita> sList){
        super(gcData,sLP,sLA,iKM);
        this.listSalite = sList;
    }
    
    public void addSalita(Salita sNew){
        this.listSalite.add(sNew);
    }
    
    public double mediaPendenza(){
        double totPendenza = 0.0;
        for(Salita s : listSalite){
            totPendenza += s.getPendenza();
        }
        return totPendenza;
    }
    
    public String listSalite(){
        String sReturn = "\n";
        for(Salita s : listSalite){
            sReturn+= "\t\t" + s.toString() + "\n";
        }
        return sReturn;
    }
    
    @Override
    public String toString(){
        return new String(super.toString() + "\n\tTipo Di Tappa: "+this.getClass().getSimpleName()+"\n\tLista salite: " + this.listSalite() + "\t\tDislivello Totale: " + this.mediaPendenza());
    }
}
