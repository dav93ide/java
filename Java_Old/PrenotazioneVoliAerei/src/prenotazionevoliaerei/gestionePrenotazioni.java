
package prenotazionevoliaerei;
import java.util.Calendar; 


public class gestionePrenotazioni {
    private int[] postiTotaliEconomy = new int[100];
    private int[] postiLiberiEconomy = new int [100];
    private int[] postiTotaliBusiness = new int [100];
    private int[] postiLiberiBusiness = new int [100];
    private double[] costoEconomy = new double [100];
    private double[] costoBusiness = new double [100];
    private Calendar dataAttuale;
    private Calendar[] dateVoliEc = new Calendar[100];
    private Calendar[] dateVoliBu = new Calendar[100];
    private int totVoliEc;
    private int totVoliBu;
    
    
    public gestionePrenotazioni(){
        costoEconomy[0] = 20.0;
        costoBusiness[0] = 30.0;
        postiTotaliEconomy[0] = 100;
        postiLiberiEconomy[0] = 100;
        postiTotaliBusiness[0] = 20;
        postiLiberiBusiness[0] = 20;
        dateVoliEc =new Calendar[10];
        dataAttuale = Calendar.getInstance();
    }
    public gestionePrenotazioni(int numVoliEc,int numVoliBu){
        dataAttuale = Calendar.getInstance();
        totVoliEc = numVoliEc;
        totVoliBu = numVoliBu;
    }
    public void getDataAttuale(){
        System.out.println("Data Attuale:" + dataAttuale.getTime() + " \n");
    }
    public void setDataVolo(int arrayPos,int tipo){
        int date;
        int year = 2015;
        int month = 3;
        if(tipo==1){
            System.out.println("Inserire Giorno Partenza Volo Economy Numero: " + (arrayPos+1) + " \n");
            date=PrenotazioneVoliAerei.input.nextInt();
            dateVoliEc[arrayPos]= dataAttuale;
            dateVoliEc[arrayPos].set(year,month,date);
        }
        else{
            System.out.println("Inserire Giorno Partenza Volo Business Numero: " + (arrayPos+1) + " \n");
            date=PrenotazioneVoliAerei.input.nextInt();
            dateVoliBu[arrayPos] = dataAttuale;
            dateVoliBu[arrayPos].set(year,month,date);
        }
    }
    public void setPosti(int arrayPos,int tipo){
        int postiEc, postiBu;
        if(tipo==1){
            System.out.println("Inserire Posti Economy Volo Numero: " + (arrayPos+1) + " \n");
            postiEc=PrenotazioneVoliAerei.input.nextInt();
            postiTotaliEconomy[arrayPos]=postiEc;
            postiLiberiEconomy[arrayPos]=postiEc;
        }
        else{
            System.out.println("Inserire Posti Business Volo Numero: " + (arrayPos+1) + " \n");
            postiBu = PrenotazioneVoliAerei.input.nextInt();
            postiTotaliBusiness[arrayPos]=postiBu;
            postiLiberiBusiness[arrayPos]=postiBu;
        }
    }
    public void setCosti(int arrayPos,int tipo){
        double costoEc,costoBu;
        if(tipo==1){
            System.out.println("Inserire Costo Economy Volo Numero: " + (arrayPos+1) + " \n");
            costoEc = PrenotazioneVoliAerei.input.nextDouble();
            costoEconomy[arrayPos] = costoEc;
        }
        else{
            System.out.println("Inserire Costo Business Volo Numero: " + (arrayPos+1) + " \n");
            costoBu = PrenotazioneVoliAerei.input.nextDouble();
            costoBusiness[arrayPos] = costoBu;
        }
    }

    public void getDateEconomy(){
        int i;
        for (i=0; i< totVoliEc;i++){
            System.out.println("Data Volo Numero " + (i+1) + ": " + dateVoliEc[i].getTime());
        }
    }
    
    public void getDateBusiness(){
        int i;
        for (i=0; i< totVoliBu;i++){
            System.out.println("Data Volo Numero " + (i+1) + ": " + dateVoliBu[i].getTime());
        }
    }
    
    public int getGiornoVolo(){
        int volo;
        System.out.println("Inserire Numero Volo (Vedi Lista Sopra)");
        volo = PrenotazioneVoliAerei.input.nextInt();
        return (volo-1);
    }
   
    
    public void getLiberi(int classe,int arrayPos){
        if(classe==1){
            System.out.println("Totale Posti Liberi Classe Economy: "+ postiLiberiEconomy[arrayPos] + " \n");        
        }
        else{
            System.out.println("Totale Posti Liberi Classe Business: "+ postiLiberiBusiness[arrayPos] + " \n");
        }
    }
    public void totaleIncasso(){
        double totEc,totBu,postiEc,postiBu;
        int postiOccupatiEc,postiOccupatiBu,i;
        totEc=0;
        totBu=0;
        for(i=0;i<totVoliEc;i++){
            postiOccupatiEc = postiTotaliEconomy[i] - postiLiberiEconomy[i];
            postiEc=(double) postiOccupatiEc;
            totEc+= postiEc*costoEconomy[i];
        }
        for(i=0;i<totVoliBu;i++){
            postiOccupatiBu = postiTotaliBusiness[i]-postiLiberiBusiness[i];
            postiBu = (double) postiOccupatiBu;
            totBu+= postiOccupatiBu * costoBusiness[i];
        }
        System.out.println("Incasso Totale Classe Economy: " + totEc + " Euro \n");
        System.out.println("Incasso Totale Classe Business: " + totBu + " Euro \n");
        System.out.println("Incasso Totale Due Classi: "+ (totEc+totBu)+ " Euro \n");
    }

    public void prenotaPosti(int posti, int classe,int i){
        if(classe==1){
            if((postiLiberiEconomy[i]-posti)>=0){
                System.out.println("Sono Stati Prenotati " + posti + " Posti In Classe Economy. \n");
                System.out.println("Il Costo Della Prenotazione Ammonta A: " + (posti*costoEconomy[i])+ " Euro.\n");
                postiLiberiEconomy[i] -= posti;
            }
            else{
                System.out.println("Numero Di Posti Disponibili Insufficiente Per La Prenotazione In Classe Economy In Data"
                        + dateVoliEc[i].getTime() + ". \n");
                this.getLiberi(1,i);
            }
        }
        else{
            if((postiTotaliBusiness[i]-postiLiberiBusiness[i])<=posti){
                System.out.println("Sono Stati Prenotati " + posti + " Posti In Classe Business. \n");
                System.out.println("Il Costo Della Prenotazione Ammonta A: " + (posti*costoBusiness[i])+ " Euro.\n");
                postiLiberiBusiness[i] -= posti;
            }
            else{
               System.out.println("Numero Di Posti Disponibili Insufficienti Per La Prenotazione In Classe Business In Data"
                       + dateVoliBu[i].getTime() + ". \n");
               this.getLiberi(2,i);
            }
        }
    }
    
}
