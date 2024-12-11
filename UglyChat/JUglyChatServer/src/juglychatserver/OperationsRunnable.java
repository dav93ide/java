/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoServer -  TCP   - UglyChat|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/


package juglychatserver;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class OperationsRunnable implements Runnable{
    
    private Socket sSocket;
    private String thisUser;
    private String otherUser; 
    private ServerRunnable sr;
    private Socket oSocket;
    private boolean on;
    
    public OperationsRunnable(Socket s, ServerRunnable sr){
        this.sr = sr;
        this.sSocket = s;
        this.on=true;
    }

    @Override
    public void run(){
        while(on){
            this.getMex();
            try{
                Thread.sleep(20);
            }
            catch(InterruptedException exIn){
                exIn.getStackTrace();
            }
        }
    }
    
    private void getMex(){
        String fromClient;
            try{
                BufferedReader buffr = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));     // Creo Lettore Su Socket StreamInput
                fromClient = buffr.readLine();
                switch(fromClient.charAt(0)){
                    case '0':           // Richiesta Inserimento Nuovo Utente
                        if(sr.isUserList(fromClient.substring(1,fromClient.length()))){    // Nome Già In Uso 
                            this.sendMex("6", sSocket);
                            sSocket.close();
                            this.on=false;
                        }
                        else{
                            thisUser = fromClient.substring(1,fromClient.length());         // Identifico User Di Questo Thread Sulla Socket
                            sr.sckUpdate(sSocket.toString()+"->BindToUser:"+thisUser);
                            sr.addSocketUser(thisUser, sSocket);            // Aggiungo User E Socket Ad ArrayList
                        }
                        break;
                    case '1':           // Richiesta Avvio Chat
                        this.sendMex("5"+thisUser, sr.getUserSocket(fromClient.substring(1,fromClient.length())));
                        break;
                    case '2':           // Richiesta Lista Utenti
                        ArrayList<String> listUsers = sr.getListUser();
                        for(String s : listUsers){
                            this.sendMex("4"+s, sSocket);
                        }
                        this.sendMex("0",sSocket);  // Fine Lista
                        break;
                    case '3':       // Inoltro Messaggio
                        sr.insertData(thisUser+"|"+otherUser+"|"+fromClient.substring(1,fromClient.length()));
                        String str = "3"+fromClient.substring(1, fromClient.length());
                        this.sendMex(str,oSocket);
                        break;
                    case '4':       // Disconnessione Utente
                        on=false;
                        sr.rwSocketUser(thisUser, sSocket);
                        sr.sckUpdate(sSocket.toString()+"// Closed Connection //User:"+thisUser);
                        sSocket.close();
                        this.sendMex("7", oSocket);
                        break;
                    case '9':           // Chat Accettata Dall'Utente
                        otherUser = fromClient.substring(1,fromClient.length());
                        oSocket = sr.getUserSocket(otherUser);
                        this.sendMex("2"+otherUser,oSocket);
                        sr.logUpdate(thisUser+"|"+otherUser+"|"+thisUser+"->Connect->"+otherUser);
                        break;
                    case '8':           // Chat Accettata Dall'Altro Utente
                        otherUser = fromClient.substring(1,fromClient.length());
                        oSocket = sr.getUserSocket(otherUser);
                        break;
                    case '7':   // Chat Rifiutata
                        if(fromClient.substring(1,fromClient.length()).equals(this.otherUser)){
                            this.oSocket = null;
                        }
                        this.sendMex("3Chat Rifiutata", sr.getUserSocket(fromClient.substring(1,fromClient.length())));
                        break;
                    default:
                        break;
                }
            }
            catch(Exception ex){
                ex.getStackTrace();
            }
    }

    
    private void sendMex(String s,Socket sck){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sck.getOutputStream())),true);   
            out.println(s);
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
}

