package formcorse;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JPanelAddTappa extends javax.swing.JPanel {

    GregorianCalendar gcData;
    private String sPartenza,sArrivo;
    private int iKm;
    private ArrayList<Salita> sList;
    private ArrayList<Object> tList;
    
    public JPanelAddTappa(ArrayList<Object> objList) {
        initComponents();
        tList = objList;
        sList = new ArrayList();
        jTextChooseCPM.setVisible(false);
        jTextChooseM1.setVisible(false);
        jTextChooseM2.setVisible(false);
        addSalita.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        checkCronometro = new javax.swing.JCheckBox();
        checkMontagna = new javax.swing.JCheckBox();
        checkPianura = new javax.swing.JCheckBox();
        jTextField4 = new javax.swing.JTextField();
        jTextChooseCPM = new javax.swing.JTextField();
        jTextChooseM1 = new javax.swing.JTextField();
        addSalita = new javax.swing.JButton();
        addTappa = new javax.swing.JButton();
        jTextChooseM2 = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jTextPane1);

        jTextField1.setText("Inserire Data Della Tappa (AAAA/MM/GG/hh/mm)");

        jTextField2.setText("Luogo Di Partenza Della Tappa");

        jTextField3.setText("Luogo Di Arrivo Della Tappa");

        checkCronometro.setText("Cronometro");
        checkCronometro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkCronometroMouseClicked(evt);
            }
        });

        checkMontagna.setText("Montagna");
        checkMontagna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMontagnaMouseClicked(evt);
            }
        });

        checkPianura.setText("Pianura");
        checkPianura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkPianuraMouseClicked(evt);
            }
        });

        jTextField4.setText("Totale Kilometri Della Tappa");

        addSalita.setText("Aggiungi Salita");
        addSalita.setActionCommand("AddSalita");
        addSalita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSalitaMouseClicked(evt);
            }
        });

        addTappa.setText("Aggiungi Tappa");
        addTappa.setActionCommand("AddTappa");
        addTappa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTappaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addSalita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addTappa))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkCronometro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkMontagna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkPianura))
                            .addComponent(jTextChooseCPM)
                            .addComponent(jTextChooseM1)
                            .addComponent(jTextChooseM2))
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCronometro)
                    .addComponent(checkMontagna)
                    .addComponent(checkPianura))
                .addGap(18, 18, 18)
                .addComponent(jTextChooseCPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextChooseM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextChooseM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSalita)
                    .addComponent(addTappa))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkCronometroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCronometroMouseClicked
        checkMontagna.setVisible(!checkMontagna.isVisible());
        checkPianura.setVisible(!checkPianura.isVisible());
        jTextChooseCPM.setVisible(true);
        int iMDis;
        jTextChooseCPM.setText("Metri Dislivello Della Tappa");
    }//GEN-LAST:event_checkCronometroMouseClicked

    private void checkMontagnaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMontagnaMouseClicked
        checkPianura.setVisible(!checkPianura.isVisible());
        checkCronometro.setVisible(!checkCronometro.isVisible());
        jTextChooseCPM.setVisible(true);
        jTextChooseM1.setVisible(true);
        jTextChooseM2.setVisible(true);
        addSalita.setVisible(false);
        jTextChooseCPM.setText("Nome Della Salita");
        jTextChooseM1.setText("Lunghezza Della Salita");
        jTextChooseM2.setText("Pendenza Della Salita");
    }//GEN-LAST:event_checkMontagnaMouseClicked

    private void checkPianuraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkPianuraMouseClicked
        checkMontagna.setVisible(!checkMontagna.isVisible());
        checkCronometro.setVisible(!checkCronometro.isVisible());
        jTextChooseCPM.setVisible(true);
        int iLen;
        jTextChooseCPM.setText("Lunghezza Della Volata");
    }//GEN-LAST:event_checkPianuraMouseClicked

    private void addSalitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSalitaMouseClicked
        String sName;
        int iLen;
        double dP;
        if(jTextChooseCPM.getText().equals("Nome Della Salita")){
            System.err.println("Inserire Nome Della Salita");
        }
        else{
            sName = jTextChooseCPM.getText();
            if(jTextChooseM1.getText().equals("Lunghezza Della Salita")){
                System.err.println("Inserire Lunghezza Della Salita");
            }
            else{
                iLen = Integer.parseInt(jTextChooseM1.getText());
                if(jTextChooseM2.getText().equals("Pendenza Della Salita")){
                    System.err.println("Inserire Pendenza Della Salita");
                }
                else{
                    dP = Double.parseDouble(jTextChooseM2.getText());
                    sList.add(new Salita(sName,iLen,dP));
                }
            }     
        }
        System.out.println("Salita Aggiunta");
    }//GEN-LAST:event_addSalitaMouseClicked
    
    private void addTappaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTappaMouseClicked
        String sData = jTextField1.getText();
        System.out.println("sb1: " + sData.substring(0, 4));
        System.out.println("sb2: " + sData.substring(5, 7));
        System.out.println("sb3: " + sData.substring(8, 10));
        System.out.println("sb4: " + sData.substring(11, 13));
        System.out.println("sb5: " + sData.substring(14));
        this.gcData = new GregorianCalendar(Integer.parseInt(sData.substring(0, 4)), (Integer.parseInt(sData.substring(5, 7)) - 1), Integer.parseInt(sData.substring(8, 10)), Integer.parseInt(sData.substring(11, 13)), Integer.parseInt(sData.substring(14)));
        this.sPartenza = jTextField2.getText();
        this.sArrivo = jTextField3.getText();
        this.iKm = Integer.parseInt(jTextField4.getText());
        if (checkCronometro.isVisible()) {
            int iLen;
            iLen = Integer.parseInt(jTextChooseCPM.getText());
            tList.add(new TappaCronometro(this.gcData, this.sPartenza, this.sArrivo, this.iKm, iLen));
        } else {
            if (checkPianura.isVisible()) {
                int iLen;
                iLen = Integer.parseInt(jTextChooseCPM.getText());
                tList.add(new TappaPianura(this.gcData, this.sPartenza, this.sArrivo, this.iKm, iLen));
            } else {
                tList.add(new TappaMontagna(this.gcData, this.sPartenza, this.sArrivo, this.iKm, sList));
            }
        }
        for (Object o : tList) {
            o.toString();
        }
        System.out.println("Tappa Aggiunta");
        synchronized (this){this.notify();}
    }//GEN-LAST:event_addTappaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSalita;
    private javax.swing.JButton addTappa;
    private javax.swing.JCheckBox checkCronometro;
    private javax.swing.JCheckBox checkMontagna;
    private javax.swing.JCheckBox checkPianura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextChooseCPM;
    private javax.swing.JTextField jTextChooseM1;
    private javax.swing.JTextField jTextChooseM2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
