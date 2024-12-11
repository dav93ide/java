package convegnomedicina;
import java.util.Calendar;

public class Intervento {
    
    private Calendar data;
    private String title;
    private int voto=0;
    private ARelatori relatore;
    
    public Intervento(Calendar cData,String sTitle, ARelatori sRel, int iVote){
        this.data = cData;
        this.title = sTitle;
        this.relatore = sRel;
        this.voto = iVote;
        sRel.addInterventi(this);       // Aggiungo Intervento A listInterventi Del Relatore
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the relatore
     */
    public ARelatori getRelatore() {
        return this.relatore;
    }

    /**
     * @param relatore the relatore to set
     */
    public void setRelatore(ARelatori relatore) {
        this.relatore = relatore;
    }
    
    public void setVoto(int iVoto){
        this.voto = iVoto;
    }
    
    public int getVoto(){
        return this.voto;
    }
    
    @Override
    public String toString(){
        return new String("Titolo Intervento: "+this.title+" Data Intervento: "+this.data.getTime()+ " Voto Intervento: " + this.voto + " \n Relatore: \n\t"+this.relatore.toString());
    }
    
    
}
