/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoClient - TCP|IP - MexBoard|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/

package mexapplet;

import java.sql.*;
import java.util.Calendar;

public class MexApplet {

    private String url;
    private String adminName;
    private String adminPass;
    private int tcpPort;
    private Connection con;
    private boolean serverOn = false;
    private Calendar date;
    
    public MexApplet(String url, int sqlP, String aN, String aP, int tcpP){
        this.url = "jdbc:mysql://"+url+":"+sqlP+"/";
        this.adminName = aN;
        this.adminPass = aP;
        this.tcpPort = tcpP;
        date = Calendar.getInstance();
    }
    
    public MexApplet(String aN, String aP, int tcpP){
        this.url = "jdbc:mysql://localhost:3306/";                  //* 3306 E' La Porta Di Default Di Xaamp 
        this.adminName = aN;                                        //* jdbc:mysql: Specifica I Driver Da Usare Per 
        this.adminPass = aP;                                        //* Gestire La Connessione Con Il DBMS
        this.tcpPort = tcpP;
        date = Calendar.getInstance();                              // Uso Un Calendar Per Stampare I Log Del Server
    }
    
    public MexApplet(){
        this.url= "jdbc:mysql://localhost:3306/";
        this.adminName = "root";
        this.adminPass = "";
        this.tcpPort = 4444;
        date = Calendar.getInstance();
    }
    
    private void initDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();                           // Setto I Driver Da Utilizzare
            this.con = DriverManager.getConnection(url,adminName,adminPass);
            Statement st = con.createStatement(); 
            st.execute("CREATE DATABASE IF NOT EXISTS mex_db"); 
            st.execute("USE mex_db");
            st.execute("CREATE TABLE IF NOT EXISTS mex_tb(id INT NOT NULL, name VARCHAR(20) NOT NULL, mex VARCHAR(100),PRIMARY KEY(id))");
            st.execute("CREATE TABLE IF NOT EXISTS log_tb(id INT NOT NULL, log VARCHAR(200),PRIMARY KEY(id))");
            int value = this.getLastId("mex_tb");
            if(value==1)                                                                   // Se mex_tb E' Vuota Inserisco
                st.execute("INSERT INTO mex_tb(id,name,mex) VALUES (1,'Admin','Benvenuto!')");
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
    }
    
    protected synchronized void logUpdate(String op){                                       // Salvo I Log In log_tb
        try{
            if(con==null || con.isClosed()){                                                // Se Connessione Disattiva La Rieffettuo
                this.con = DriverManager.getConnection(url,adminName,adminPass);
            }
            Statement st = con.createStatement();
            st.execute("USE mex_db");
            int idV=this.getLastId("log_tb");
            this.setCalendar();
            st.execute("INSERT INTO log_tb(id,log) VALUES ("+idV+",'Date:"+date.getTime()+"/op:"+op+"')");
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
    }
    
    protected synchronized int getLastId(String tbName){
        int value = 0;
        try{
            ResultSet result = exQuery("SELECT id FROM "+tbName,false);
            result.beforeFirst();
            while(result.next()){
                value = result.getInt("id");
            }
            result.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
        return (value+1);
    }
    
    protected synchronized ResultSet exQuery(String sQuery,boolean v) throws SQLException{      //* Il Parametro Boolean "v"
        if(con==null || con.isClosed()){                                                        //* Mi Permette Di Non Entrare In Un Loop Infinito
            this.con = DriverManager.getConnection(url,adminName,adminPass);                    //* Nel Momento Dell'Inizializzazione Del Db
        }                                                                                       //* (getLastId -> exQuery -> getLastId -> exQuery...)
        Statement st = con.createStatement(); 
        st.execute("USE mex_db");
        if(v)this.logUpdate("Ex Query -"+sQuery+"-");
        ResultSet ris = st.executeQuery(sQuery);
        return ris;
    }
    
    protected synchronized void insertData(String sData){
        try{
            if(con==null || con.isClosed()){
                this.con = DriverManager.getConnection(url,adminName,adminPass);
            }
            Statement st = con.createStatement();
            st.execute("USE mex_db");
            int i=0;
            for(;sData.charAt(i) != '|';i++){}
            String sName = sData.substring(0,i);
            String sMex = sData.substring((i+1),sData.length());
            int iID = this.getLastId("mex_tb");
            st.execute("INSERT INTO mex_tb(id,name,mex) VALUES ("+iID+",'"+sName+"','"+sMex+"')");
            this.logUpdate("Insert Data mex_tb -"+iID+"|"+sName+"|"+sMex);
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
    }
    
    protected int getTcpPort(){
        return tcpPort;
    }
    
    protected boolean getServerStatus(){
        return serverOn;
    }
    
    protected void setCalendar(){                                               // Recupero Data/Ora Attuale                                        
        this.date = Calendar.getInstance();
    }
    
    public void startServer(){
        this.initDB();
        this.serverOn = true;
        this.logUpdate("Start Server adminName:" + adminName + "|tcpPort:"+tcpPort);
        new Thread(new ServerRunnable()).start();                               // Avvio Il Thread Che Gestisce Le Connessioni In Entrata
    }
    
    public void stopServer(){
        this.serverOn = false;
        this.logUpdate("Stop Server tcpPort:"+tcpPort);
    }
}
