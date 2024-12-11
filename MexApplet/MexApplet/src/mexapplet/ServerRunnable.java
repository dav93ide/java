/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoClient - TCP|IP - MexBoard|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/

package mexapplet;

import java.net.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerRunnable extends MexApplet implements Runnable{
    
    protected int tcpPort;
    
    public ServerRunnable(){
        this.tcpPort = super.getTcpPort();
    }
    
    @Override
    protected ResultSet exQuery(String s, boolean b) throws SQLException{       // Rispedisco A Classe Superiore 
        return super.exQuery(s,b);
    }
    
    @Override                                                                   // Rispedisco A Classe Superiore
    protected void insertData(String s){
        super.insertData(s);
    }
    
    @Override
    public void run(){
        try{
            ServerSocket sServer = new ServerSocket(tcpPort);
            while(!super.getServerStatus()){
                Socket sSocket = sServer.accept();                              // Quando Si Instaura Una Nuova Connessione
                new Thread(                                                     // Avvio Un Nuovo Thread Per La Connessione
                    new OperationsRunnable(sSocket)
                ).start();
                super.logUpdate("|New Connection With: " + sSocket.getInetAddress().getHostAddress()+"|");
            }
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
}
