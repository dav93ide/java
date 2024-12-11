/*|=============================================|*|
|x|      ________________________________       |x|
|x|      |LatoClient - TCP|IP - MexBoard|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|x|=============================================|*/

package mexappletclient;


import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class MexAppletClient {
    
    private static final int TIME_MILLIS = 5000;
    
    private String host;
    private String username;
    private int port;
    private Socket clientSocket;
    
    public MexAppletClient(String h, String u,int p){
        this.host = h;
        this.username=u;
        this.port=p;
        this.getSocket();
        new Thread(
        ).start();
    }
    
    public void getSocket(){
        try{
           clientSocket = new Socket(host,port);
           clientSocket.setSoTimeout(TIME_MILLIS);
           clientSocket.setKeepAlive(true);                                     // No All'Eutanasia Sulle Socket.
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
    }
    
    public void sendMex(String s){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
            String ss = this.username+"|"+s;
            out.println(ss);
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
    public void askMexBoard(){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
            out.println(1);                                                     // Invio "1" Per Richiedere Aggiornamento Messaggi
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
    public ArrayList<String> getMexBoard(){
        ArrayList<String> mexBoard = new ArrayList();
        try{
            BufferedReader bffr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while(true){
                line = bffr.readLine();
                if(line.length()==1)
                    if(line.charAt(0)=='0'){                                    // Quando Ricevo "0" Finisco Di Leggere
                        break;
                    }
                mexBoard.add(line);
            }
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
        return mexBoard;
    }
    
    public boolean getStatusCon(){
        return !clientSocket.isClosed();
    }
    
    public void disconnect(){
        try{
            clientSocket.close();
        }
        catch(IOException exIO){
            exIO.getStackTrace();
        }
    }
    
    public String getUsername(){
        return username;
    }
    
    
    
}
