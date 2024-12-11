/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoClient - TCP|IP - MexBoard|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/

package mexapplet;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.*;

public class OperationsRunnable extends ServerRunnable {
    
    Socket sSocket;
    
    public OperationsRunnable(Socket s){
        this.sSocket = s;
    }
    
    
    
    @Override
    public void run(){
        while(!sSocket.isClosed()){
            String fromClient;
            try{
                BufferedReader buffr = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));     // Creo Lettore Su Socket StreamInput
                fromClient = buffr.readLine();                                  // Leggo L'Input
                if(fromClient.length()==1){                                     //* Interpreto La Richiesta:
                    if(fromClient.charAt(0) == '1'){                            //* Se "1" Il Client Richiede L'Aggiornamento Della Casella Di Testo
                        this.sendMexBoard();                                    //* Altrimenti Il Client Ha Inviato Un Messaggio
                    }
                }
                else{
                    super.insertData(fromClient);                       
                }                
            }
            catch(Exception ex){
                ex.getStackTrace();
            }
        }
    }

    
    private void sendMexBoard(){
        ArrayList<String> mexBoard = new ArrayList();
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sSocket.getOutputStream())),true);   // Creo Scrittore Su Socket StreamOutput
            ResultSet ris = super.exQuery("SELECT name,mex FROM mex_tb",true);
            ris.beforeFirst();                                                  // Posiziono Il Cursore Del ResultSet All'Estremo Inizio (Sto Maledetto Non Si Resetta Mai Una Volta Chiuso)
            String result;
            while(ris.next()){
                result = ris.getString("name") + "|" + ris.getString("mex");
                mexBoard.add(result);
            }
            ris.close();
            for(String str : mexBoard)
                out.println(str);                                               // Scrivo Nell'OutputStream Tutta L'ArrayList
            out.println(0);                                                     // Invio Uno "0" Per Informare Che L'Operazione E' Finita
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
}
