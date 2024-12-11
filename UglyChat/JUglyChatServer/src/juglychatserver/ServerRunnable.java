/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoServer -  TCP   - UglyChat|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/

package juglychatserver;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class ServerRunnable extends JUglyChatServer implements Runnable{
    
    protected int tcpPort;
    private ArrayList<String> usersList;
    private ArrayList<Socket> socketsList;
    
    public ServerRunnable(){
        this.tcpPort = super.getTcpPort();
        usersList = new ArrayList();
        socketsList = new ArrayList();
    }
    
    @Override
    protected ResultSet exQuery(String s, boolean b) throws SQLException{        
        return super.exQuery(s,b);
    }
    
    @Override                                                                   
    protected void insertData(String s){
        super.insertData(s);
    }
    
    @Override
    public void run(){
        try{
            ServerSocket sServer = new ServerSocket(tcpPort);       // Creo Socket Per Il Server
            while(!super.getServerStatus()){
                Socket sSocket = sServer.accept();    // Accetto Connessione
                sSocket.setSoTimeout(20000);
                new Thread(                                 // Avvio Nuovo Thread Che Gestisce La Socket                    
                    new OperationsRunnable(sSocket,this)
                ).start();
                this.logUpdate("|New Connection With: " + sSocket.getInetAddress().getHostAddress()+"|");
            }
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
    public void addSocketUser(String us, Socket sc){        // Aggiungo Utente-Socket
        this.socketsList.add(sc);
        this.usersList.add(us);
    }
    
    public void rwSocketUser(String us, Socket sc){         // Rimuovo Utente-Socket
        this.socketsList.remove(sc);
        this.usersList.remove(us);
    }
    
    public synchronized ArrayList<String> getListUser(){        // Restituisco Lista Utenti
        return usersList;
    }
    
    public Socket getUserSocket(String us){                 // Restituisco Socket Di Uno Specifico Utente
        return this.socketsList.get(usersList.indexOf(us));
    }
    
    public boolean isUserList(String s){        // NomeUtente Presente In Lista
        return usersList.contains(s);
    }
    


}

