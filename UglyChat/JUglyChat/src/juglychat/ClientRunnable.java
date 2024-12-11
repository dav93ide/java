/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoClient -   TCP  - UglyChat|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/


package juglychat;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ClientRunnable implements Runnable{
    
    private javax.swing.JTextArea jTA;
    private javax.swing.JTextArea jTA2;
    private javax.swing.JButton jB5;
    private javax.swing.JLabel jL16;
    private JUglyChat mAC;
    private int count;
    
    public ClientRunnable(javax.swing.JTextArea jta, JUglyChat mac,javax.swing.JTextArea jta2,javax.swing.JButton jButton5,javax.swing.JLabel jLabel16){        // Istanzio ClientRunnable Passando I JFrame Da Modificare
        this.jTA = jta;                                                                                                             // E Oggetto JUglyChat Per Attributi Utente E Socket
        this.mAC = mac;
        this.jTA2 = jta2;
        this.jB5 = jButton5;
        this.jL16=jLabel16;
        count = 0;
    }

    @Override
    public void run(){
        while(!Thread.interrupted()){
            try{
                BufferedReader bffr = new BufferedReader(new InputStreamReader(mAC.getSocket().getInputStream()));                  // Collego Buffer Di Lettura A Socket.InputStream Per Ricezione
                String line;
                while(true){
                    line = bffr.readLine();                              // Leggo Dal Buffer
                    switch(line.charAt(0)){                             // Controllo Primo Carattere Per Tipo Operazione
                        case '2':                                       // Caso 2: Accetto Chat Da Utente Remoto
                            mAC.setOtherUser(mAC.getWaitingUser()); mAC.setWaitingUser(""); mAC.sendMex("8"+mAC.getOtherUser()); jTA.append("\n--Chat Accettata--\n");      // Setto Attributi E Ritorno Conferma Per Settare Socket HostRemoto Nel Server
                            break;
                        case '3':                       // Caso 3: Rifiuto La Chat Da Utente Remoto O Ricevo Un Messaggio
                            if(line.equals("3Chat Rifiutata")){ 
                                jTA.append("\n--"+line.substring(1,line.length())+"--\n");
                                mAC.setWaitingUser("");             // Azzero Attributi Utente Remoto
                                mAC.setOtherUser("");
                                jL16.setText("");
                                this.jB5.setVisible(true);          // "Accetta Chat" Visibile
                            }
                            else{
                               jTA.append(mAC.getOtherUser()+":  "+line.substring(1,line.length())+"\n");   // Visualizzo Il Messaggio Nel Formato -> UtenteRemoto : Messaggio
                            }
                            break;
                        case '4':               // Caso 4: Stampo Lista Utenti Online
                            count+=1;
                            jTA2.append(count+"] "+line.substring(1,line.length())+"\n");  
                            break;
                        case '5':               // Caso 5: Richiesta Chat Da Utente
                            jTA.append(line.substring(1,line.length())+"-> Vuole Chattare Con Te.\n");
                            mAC.setWaitingUser(line.substring(1,line.length()));
                            jB5.setVisible(true);
                            break;
                        case '6':               // Caso 6: Nome Utente Inserito Non Accettato
                            jTA.append("\n--Nome Utente Già In Uso--\n\tDisconnettersi\n\tE Riloggare...\n");
                            Thread.interrupted();
                            break;
                        case '7':               // Caso 7: L'Utente Remoto Si E' Disconnesso
                            jTA.append(mAC.getOtherUser()+":  Utente Disconnesso \n");
                            mAC.setWaitingUser("");
                            mAC.setOtherUser("");
                            break;
                        case '0':               // Caso 0: Fine Lista, Azzero Count
                            count = 0;
                            continue;
                        default:
                            System.out.println("Non Processato");
                            break;
                    }
                    Thread.sleep(20);
                }
            }
            catch(Exception exIO){
                exIO.getStackTrace();
            }
        }
        mAC.disconnect();
    }
}

