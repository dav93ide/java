/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoServer -  TCP   - UglyChat|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/

// Necessaria Libreria "MySql JDBC Driver"

package juglychatserver;

import java.sql.*;
import java.util.Calendar;


public class JUglyChatServer {
    
    private String url;
    private String adminName;
    private String adminPass;
    private int tcpPort;
    private Connection con;
    private boolean serverOn = false;
    private Calendar date;
    

    public JUglyChatServer(String url, int sqlP, String aN, String aP, int tcpP){
        this.url = "jdbc:mysql://"+url+":"+sqlP+"/";
        this.adminName = aN;
        this.adminPass = aP;
        this.tcpPort = tcpP;
        date = Calendar.getInstance();
    }
    
    public JUglyChatServer(String aN, String aP){
        this.url = "jdbc:mysql://localhost:3306/";               
        this.adminName = aN;                                        
        this.adminPass = aP;                                        
        date = Calendar.getInstance();                              
    }
    
    public JUglyChatServer(){
        this.url= "jdbc:mysql://localhost:3306/";       // Url Con Driver Java Per Connessione Al Servizio MySql Sulla Porta Di Default 3306
        this.adminName = "root";            // Nome Adming E Password Di Default
        this.adminPass = "";
        this.tcpPort = 4444;
        date = Calendar.getInstance();
    }
    
    private void initDB(){          // Creo Database E Tabelle Se Non Esistono
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();               // Creo Una Nuova Istanza Per Caricare I Driver                       
            this.con = DriverManager.getConnection(url,adminName,adminPass);    // Connessione Con Il Servizio MySql
            Statement st = con.createStatement();                       // Creo Lo Statement Su Cui Eseguire Le Query
            st.execute("CREATE DATABASE IF NOT EXISTS chat_db"); 
            st.execute("USE chat_db");
            st.execute("CREATE TABLE IF NOT EXISTS mex_tb(id INT NOT NULL, name_one VARCHAR(20) NOT NULL,name_two VARCHAR(20) NOT NULL, mex VARCHAR(100),PRIMARY KEY(id))");
            st.execute("CREATE TABLE IF NOT EXISTS log_tb(id INT NOT NULL, log VARCHAR(200),PRIMARY KEY(id))");
            st.execute("CREATE TABLE IF NOT EXISTS sck_tb(id INT NOT NULL, sck_info VARCHAR(200), PRIMARY KEY (id))");
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
    }
    
    protected synchronized void sckUpdate(String op){       // Aggiorno Tabella Socket
        try{
            if(con==null || con.isClosed()){                  // Ricreo Connessione O Riattivo Se Chiusa                              
                this.con = DriverManager.getConnection(url,adminName,adminPass);
            }
            Statement st = con.createStatement();
            st.execute("USE chat_db");
            int idV=this.getLastId("sck_tb");
            this.setCalendar();
            st.execute("INSERT INTO sck_tb(id,sck_info) VALUES ("+idV+",'Date:"+date.getTime()+"//sckInfo:"+op+"|||')");
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
    }
    
    protected synchronized void logUpdate(String op){     // Aggiorno Tabella Dei Log                                  
        try{
            if(con==null || con.isClosed()){                                                
                this.con = DriverManager.getConnection(url,adminName,adminPass);
            }
            Statement st = con.createStatement();
            st.execute("USE chat_db");
            int idV=this.getLastId("log_tb");
            this.setCalendar();
            st.execute("INSERT INTO log_tb(id,log) VALUES ("+idV+",'Date:"+date.getTime()+"//op:"+op+"|||')");
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
    }
    
    protected synchronized int getLastId(String tbName){        // Estrapolo Ultimo ID Da Una Tabella
        int value = 0;
        try{
            if(con==null || con.isClosed()){                                                
                this.con = DriverManager.getConnection(url,adminName,adminPass);
            }
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
    
    protected synchronized ResultSet exQuery(String sQuery,boolean v) throws SQLException{     // Eseguo Una Query
        if(con==null || con.isClosed()){                                                        
            this.con = DriverManager.getConnection(url,adminName,adminPass);                    
        }                                                                                       
        Statement st = con.createStatement(); 
        st.execute("USE chat_db");
        if(v){
            this.logUpdate("Ex Query -"+sQuery+"-");
        }
        ResultSet ris = st.executeQuery(sQuery);
        return ris;
    }
    
    protected synchronized void insertData(String sData){       // Aggiorno Tabella Messaggi
        try{
            if(con==null || con.isClosed()){
                this.con = DriverManager.getConnection(url,adminName,adminPass);
            }
            Statement st = con.createStatement();
            st.execute("USE chat_db");
            int i=0;
            for(;sData.charAt(i) != '|';i++){}
            int j=(i+1);
            for(;sData.charAt(j) != '|';j++){}
            String sName1 = sData.substring(0,i);
            String sName2 = sData.substring((i+1),j);
            String sMex = sData.substring((j+1),sData.length());
            int iID = this.getLastId("mex_tb");
            st.execute("INSERT INTO mex_tb(id,name_one,name_two,mex) VALUES ("+iID+",'"+sName1+"','"+sName2+"','"+sMex+"')");
            this.logUpdate("Insert "+iID+"id mex|");
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
    
    protected void setCalendar(){                                                                                      
        this.date = Calendar.getInstance();
    }
    
    public void startServer(){              // Avvio Thread-Server
        this.initDB();
        this.serverOn = true;
        this.logUpdate("Start Server adminName:" + adminName + "|tcpPort:"+tcpPort);
        new Thread(new ServerRunnable()).start();                               
    }
    
    public void stopServer(){
        this.serverOn = false;
        this.logUpdate("Stop Server tcpPort:"+tcpPort);
    }
}

    
