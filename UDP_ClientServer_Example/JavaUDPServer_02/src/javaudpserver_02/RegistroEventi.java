/*********************************************
 *    ESERCIZIO NUMERO 4 PAGINA 113-114      *
 *********************************************/

package javaudpserver_02;

import java.util.ArrayList;
import java.util.Calendar;

public class RegistroEventi extends Thread{
    
    ArrayList<Integer> iOp;
    ArrayList<Calendar> iTime;
    ArrayList<String> iIP;
    ArrayList<Calendar> iRic;
    Calendar c;
    boolean status;
    
    public RegistroEventi(){
        this.iOp = new ArrayList();
        this.iTime = new ArrayList();
        this.iIP = new ArrayList();
        this.iRic = new ArrayList();
        status = true;
        c = Calendar.getInstance();
    }
    
    @Override
    public synchronized void run(){
        System.out.println("\t\t/////ServerOperations Avviato/////");
        while(true){    
            try{
              if(!iOp.isEmpty()){
                if(c.getTimeInMillis()>=iTime.get(0).getTimeInMillis()){        // Se OrarioAttualeInMillisecondi=>OrarioProssimaOperazioneInMillisecondi Eseguo L'operazione
                    this.exOp();                                                // ">=" Per I 10Millisec Attesi
                }
            }
                this.wait(10);                      // Aspetto 10Millisec Per Non Occupare Eccessivamente CPU
                c = Calendar.getInstance();         // Ottengo Orario Attuale
            }
            catch(InterruptedException inEx){
                inEx.getStackTrace();
            }
        }
    }
    
    public void exOp() throws InterruptedException{
        switch(iOp.get(0)){                 // Eseguo L'operazione Allocata In Pos 0
            case 0:
                this.status=false;
                System.out.println("\n\nServerOperations\\\\ \t...Spegnimento... \t \\\\");
                break;
            case 1:
                this.status=true;
                System.out.println("\n\nServerOperations\\\\ \t...Accensione... \t \\\\");
                break;
            default:
                System.err.println("Errore Operazionale");
                break;
        }
        iOp.remove(0);                  // Elimino Dati Dalle ArrayList
        iTime.remove(0);       
        iRic.remove(0);
        iIP.remove(0);
        this.printLists();
    }
    
    public synchronized boolean addOp(int iO, Calendar cT, String sIP, Calendar cR){        // Aggiungo Dati A Tutte ArrayList
        iOp.add(iO);
        iTime.add(cT);
        iIP.add(sIP);
        iRic.add(cR);
        boolean ritorno = ((iTime.get(iTime.size() - 1) == cT ) ? true : false);
        if(iTime.size() > 1){                       // Riordino ArrayLists In Base A DataEsecuzione
            for(int i=0;i<(iTime.size()-1);i++){
                Calendar cTemp = iTime.get(i);      // Valore DataEsecuzione Pos i
                int Value = i;                      // Valore Posizione
                for(int j=i;j<iTime.size();j++){
                    if(cTemp.getTimeInMillis() > iTime.get(j).getTimeInMillis()){       //Controllo Se >
                        cTemp=iTime.get(j);                                             // Sostituisco cTemp Con Valore Inferiore A cTemp Precedente
                        Value = j;                                                      // Salvo Anche La Nuova Posizione
                    }
                }
                this.iTime.set(Value, iTime.get(i));                                // Per Ogni ArrayList Sostituisco Il Valore In Posizione "Value" Con Il Valore In Posizione "i"
                this.iTime.set(i, cTemp);                                           // Successivamente Sostituisco Il Valore In Posizione "i" Con Il Valore In Posizione "Value" Precedentemente Salvato In Una Variabile "temp" Dedicata
                int opTemp = iOp.get(Value);
                String sIPTemp = iIP.get(Value);
                this.iOp.set(Value,iOp.get(i));
                this.iOp.set(i,opTemp);
                this.iIP.set(Value,iIP.get(i));
                this.iIP.set(i,sIPTemp);
                cTemp = iRic.get(Value);
                this.iRic.set(Value,iRic.get(i));
                this.iRic.set(Value,cTemp);
            }           
        }
        this.printLists();
        return ritorno;
    }
    
    public boolean arrList(){
        return iOp.isEmpty();
    }

    public void printLists(){                                   // Stampo Lista
        System.out.println("\n\n----------------------------------------------------------------------------------------------------------\n"
                + "\t\tLista Operazioni: \n");
        for(int i=0; i<iOp.size(); i++){
            System.out.println("\t"+(i+1)+"]\n\t\tOperazione: " + ((iOp.get(i)==0)?"Spegnimento":"Accensione") + " \n\t\tDataOraOperazione: " + iTime.get(i).getTime() + "\n\t\tIP: " + iIP.get(i) + "\n\t\tDataRicezione: " + iRic.get(i).getTime() + 
                    "\n----------------------------------------------------------------------------------------------------------\n\n");
        }
    }
    
}
