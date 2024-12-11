/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoClient -   TCP  - UglyChat|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/

package juglychat;

import java.net.*;
import java.io.*;

public class JUglyChat {

    private static final int TIME_MILLIS = 5000;
    
    private String host;
    private String username;
    private int port;
    private Socket clientSocket;
    private String otherUser="";
    private String waitingUser="";
  
    
    public JUglyChat(String h, String u,int p){
        this.host = h;
        this.username=u;
        this.port=p;
        this.startSocket();
    }
    
 
    public Socket getSocket(){
        return clientSocket;
    }

    public void startSocket(){
        try{
           clientSocket = new Socket(host,port);
           clientSocket.setSoTimeout(TIME_MILLIS);
           clientSocket.setKeepAlive(true); 
           this.sendMex("0"+this.username);     // Registro Utente Nel Server
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
    }
    
    public synchronized void sendMex(String s){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);     // Streaming Di Output
            out.println(s);
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
    public boolean getStatusCon(){
        return !clientSocket.isClosed();
    }
    
    public void disconnect(){
        try{
            if(this.clientSocket != null){
                this.sendMex("4");
                clientSocket.close();
                this.otherUser="";
            }
            else{
                System.out.println("Non Ancora Connesso");
            }
           
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
    public String getUsername(){
        return username;
    }
    
    public synchronized void setOtherUser(String s){
        this.otherUser = s;
        this.waitingUser="";
    }
    
    public synchronized String getOtherUser(){
        return otherUser;
    }
    
    public void setWaitingUser(String s){
        this.waitingUser=s;
    }
    
    public String getWaitingUser(){
        return waitingUser;
    }
    
}

    

