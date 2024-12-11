/*|=============================================|ᴥ|
|x|      ________________________________       |x|
|x|      |LatoServer -  TCP   - UglyChat|       |x|
|x|      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       |x|
|ᴥ|=============================================|*/
/* Usa Xampp, Non Necessariamente Ma Perde Prestazioni Se Non Attivo*/

package juglychatserver;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class JFrameUglyChatServer extends javax.swing.JFrame {

    private JUglyChatServer mxA = null;

    
    public JFrameUglyChatServer(){          // Inizializzo Prima Schermata
        this.initComponents();
        this.setVisible(true);
        this.setSize(400,650);
        this.setContentPane(jPanel5);
        this.setTitle("[ᴥ] <[ All_Seign_Eye ]> [ᴥ]");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jPanel5.setBackground(Color.black);
        jPanel1.setBackground(Color.black);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Query:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Result:");

        jButton4.setText("EXE_QUERY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("GET_LOG_SERVER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Server Status:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("INSERIRE UNA QUERY");

        jButton6.setText("GET_MEX");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("GET_SCK_INFO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton7.setText("START");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MySQL AdminName:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Port Number MySQL Server:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hostname:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TCP Server Port (Default 4444):");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MySQL AdminPass:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(29, 29, 29))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField7)
                    .addComponent(jTextField4)
                    .addComponent(jTextField8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // On/Off Server
        String str = jToggleButton1.getText();
        if(str.equals("On")){                               
            jToggleButton1.setText("Off");
            mxA.stopServer();
        }
        else{
            jToggleButton1.setText("On");
            mxA.startServer();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Eseguo Una Query A Scelta
        jTextArea1.setText("");                                             
        jLabel9.setVisible(false);
        String strQuery = jTextField6.getText();
        if(strQuery.isEmpty())
            jLabel9.setVisible(true);
        else{
            try{
                ResultSet ris = mxA.exQuery(strQuery,true);         // Creo Result Set Sui Risultati Della Query
                ResultSetMetaData rsMD = ris.getMetaData();         // Creo ResultSetMetaData E Assegno Ai MetaData Del ResultSet Ottenuto              
                int countColumns = rsMD.getColumnCount();           // Estrapolo NumeroColonne Dai MetaData                   
                ris.beforeFirst();              // Puntatore ResultSet "Prima Del Primo"                                        
                for(int i=1;i<=countColumns;i++){           // Creo Prima Riga Che Identifica Le Varie Colonne
                    jTextArea1.append(rsMD.getColumnName(i) + "\t|\t");     // Dai MetaData Prendo Nome Colonna  
                }
                jTextArea1.append("\n================================================================\n");
                while(ris.next()){                  // Stampo I Dati Fino A Che Ho Un Valore Successivo Nel Result Set (While Sulle Righe)
                    String result ="";
                    for(int i=1; i<=countColumns;i++){  // For Sulle Colonne                    
                        if(rsMD.getColumnType(i)==4){       // Identifico I Tipi Usando I MetaData E Stampo (4=int)
                            result += String.valueOf(ris.getInt(i))+ "\t|  ";
                        }else{
                            if(rsMD.getColumnType(i)==12){  // (12=string)
                                if(ris.getString(i).length() <= 12){        // Creo Tabulazione In Funzione Della Lunghezza Della Stringa (Assolutamente Facoltativo)
                                    result += ris.getString(i)+ "\t\t|  ";
                                }else{
                                    if(ris.getString(i).length() > 20){
                                        result += ris.getString(i)+ "|  ";
                                    }else{
                                        result += ris.getString(i)+ "\t|  ";
                                    }
                                }
                            }else{
                                result += "TipoDatoNonAncoraGestito" + "\t|  ";
                            }
                        }
                    }
                    result+="\n";
                    jTextArea1.append(result);
                }
            }
            catch(SQLException exSql){
                exSql.getStackTrace();
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Stampo Tutti I Log
        jTextArea1.setText("");                                             
        try{
            ResultSet ris = mxA.exQuery("SELECT * FROM log_tb", true);      // Eseguo Query Sulla Tabella Dei Log
            ResultSetMetaData rsMD = ris.getMetaData();
            int countColumns = rsMD.getColumnCount();
            ris.beforeFirst();
            int i;
            for(i=1;i<=countColumns;i++){
                jTextArea1.append(rsMD.getColumnName(i) + "\t|\t");
            }
            jTextArea1.append("\n================================================================\n");
            String result ="";
            while(ris.next()){
                result += "IdLog: "+ris.getInt("id")+"||| \t Log: "+ris.getString("log")+" |||";
                result+="\n";
                jTextArea1.append(result);
            }
        }
        catch(SQLException exSQL){
            exSQL.getStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Stampo Tutti I Messaggi
        jTextArea1.setText("");                                                 
        try{
            ResultSet ris = mxA.exQuery("SELECT * FROM mex_tb", true);          // Eseguo Query Sulla Tabella Messaggi
            ris.beforeFirst();
            jTextArea1.append(" id\t| name_one\t->\t name_two \t| mex \t|\n\n");
            while(ris.next()){
                jTextArea1.append(ris.getInt("id")+"  |  "+ris.getString("name_one")+"\t|  "+ris.getString("name_two")+"\t|" + ris.getString("mex")+"\n");
            }
            ris.close();
        }
        catch(SQLException exSQL){
            exSQL.getStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Avvio Server, Seconda Schermata
        String str1 = jTextField4.getText();                                   
        String str2 = jTextField8.getText();
        String str3 = jTextField7.getText();
        String str4 = jTextField5.getText();
        String str5 = jTextField9.getText();
        if(str1.isEmpty() && str2.isEmpty() && !str3.isEmpty() && !str4.isEmpty() && !str5.isEmpty()){
            mxA = new JUglyChatServer(str3,str4);
        }else{
            if(!str1.isEmpty() && !str2.isEmpty() && !str3.isEmpty() && !str4.isEmpty() && !str5.isEmpty() ){
                mxA = new JUglyChatServer(str1,Integer.valueOf(str2),str3,str4,Integer.valueOf(str5));
            }else{
                mxA = new JUglyChatServer();
            }
        }
        if(mxA != null){
            mxA.startServer();                                                  
            setContentPane(jPanel1);                                            
            setSize(666,600);                                                   
            this.jToggleButton1.setText("On");                                  
            jLabel9.setVisible(false);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Stampo Tutti I Dati Sulle Sockets
        jTextArea1.setText("");                                             
        try{
            ResultSet ris = mxA.exQuery("SELECT * FROM sck_tb", true);      // Query Sulla Tabella Socket
            ResultSetMetaData rsMD = ris.getMetaData();
            int countColumns = rsMD.getColumnCount();
            ris.beforeFirst();
            int i;
            for(i=1;i<=countColumns;i++){
                jTextArea1.append(rsMD.getColumnName(i) + "\t|\t");
            }
            jTextArea1.append("\n================================================================\n");
            String result ="";
            while(ris.next()){
                result += "IdLogSck: "+ris.getInt("id")+"||| \t Sck_Info: "+ris.getString("sck_info")+" |||";
                result+="\n";
                jTextArea1.append(result);
            }
        }
        catch(SQLException exSQL){
            exSQL.getStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameUglyChatServer jfucs = new JFrameUglyChatServer();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
