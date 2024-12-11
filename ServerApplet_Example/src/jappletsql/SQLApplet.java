package jappletsql;

import java.sql.*;
import java.net.*;
import java.io.*;

public class SQLApplet {
    
    private String url;
    private String dbAdmin;
    private String adminPass;
    private Connection con;
    
    public SQLApplet{
        this.url = "jdbc:mysql://localhost:3306/";
        this.dbAdmin = "root";
        this.adminPass = "";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection(url,dbAdmin,adminPass);
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
        this.initDb();
    }
   
    public void initDb(){
        try{
            Statement st = con.createStatement();
            System.out.println("Creazione Database");
            st.execute("CREATE DATABASE IF NOT EXISTS dbjava");
            System.out.println("Creazione Tabella");
            st.execute("USE dbjava");
            st.execute("CREATE TABLE IF NOT EXISTS tbjava(id INT NOT NULL, name VARCHAR(20) NOT NULL, mex VARCHAR(100),PRIMARY KEY(id))");
            int value = this.getLastId();
            if(value==1){
                st.execute("INSERT INTO tbjava(id,name,mex) VALUES (1,'Admin','Benvenuto')");
                System.out.println("Valori Iniziali Inseriti");
            }
            st.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
    }
    
    public ResultSet exQuery(String sQuery) throws SQLException{
        Statement st = con.createStatement(); 
        st.execute("USE dbjava");
        System.out.println("Esecuzione Query :"+sQuery);
        ResultSet ris = st.executeQuery(sQuery);
        return ris;
    }
    
    public void insertData(String sData){
        try(
            Statement st = con.createStatement();
        ){
            st.execute("USE dbjava");
            int i=0;
            for(;sData.charAt(i) != '|';i++){}
            String sName = sData.substring(0,i);
            String sMex = sData.substring((i+1),sData.length());
            int iID = this.getLastId();
            System.out.println("Inserimento Dati");
            st.execute("INSERT INTO tbjava(id,name,mex) VALUES ("+iID+",'"+sName+"','"+sMex+"')");
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
    }
    
    private int getLastId(){
        System.out.println("Ricerca Ultimo ID");
        int value = 0;
        try{
            ResultSet result = exQuery("SELECT id FROM tbjava");
            result.beforeFirst();
            while(result.next()){
                value = result.getInt("id");
            }
            result.close();
        }
        catch(SQLException exSql){
            exSql.getStackTrace();
        }
        System.out.println("Valore LastID =" + value);
        return (value+1);
    }
}
