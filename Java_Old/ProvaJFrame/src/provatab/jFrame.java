package provatab;
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
public class jFrame extends javax.swing.JFrame {
    private Random rand = new Random();
    private Scanner input = new Scanner(System.in);
    private utente user = new utente(input.nextInt());
    
    public jFrame() {
        initComponents();
        label5.setText(user.toString());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pannello = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jButton1.setText("SPIN");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        label1.setText("0000");

        label2.setText("0000");

        label3.setText("0000");

        label4.setText("Win:");

        label5.setText("Portafoglio:");

        javax.swing.GroupLayout PannelloLayout = new javax.swing.GroupLayout(Pannello);
        Pannello.setLayout(PannelloLayout);
        PannelloLayout.setHorizontalGroup(
            PannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelloLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PannelloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(155, 155, 155))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PannelloLayout.setVerticalGroup(
            PannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelloLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(Pannello, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.out.println("EVENTO CATTURATO");
        if(user.getPortafoglio()<1){
            label4.setText("Saldo Portafoglio Insufficiente");
            label5.setText("Saldo Portafoglio Insufficiente");
        }
        else{
            try{
                synchronized(this.label1){
                    synchronized(this.label2){
                        synchronized(this.label3){
                            int n1,n2,n3;
                            Color c1,c2,c3;
                            n1 = rand.nextInt(10);
                            n2 = rand.nextInt(10);
                            n3 = rand.nextInt(10);
                            String s1,s2,s3;
                            s1 = this.getValText(n1);
                            s2 = this.getValText(n2);
                            s3 = this.getValText(n3);
                            c1 = this.getColor(n1);
                            c2 = this.getColor(n2);
                            c3 = this.getColor(n3);
                            if(!s1.equals("Error")&!s2.equals("Error")&!s3.equals("Error")){
                                label1.setBackground(Color.BLACK);
                                label2.setBackground(Color.BLACK);
                                label3.setBackground(Color.BLACK);
                                label1.setForeground(c1);
                                label2.setForeground(c2);
                                label3.setForeground(c3);
                                label1.setText(s1);
                                label2.setText(s2);
                                label3.setText(s3);
                                this.checkWin(n1, n2, n3);
                            }
                            else{
                                label1.setBackground(Color.RED);
                                label2.setBackground(Color.RED);
                                label3.setBackground(Color.RED);
                                label1.setText("  ERROR!  ");
                                label2.setText("  ERROR!  ");
                                label3.setText("  ERROR!  ");
                            }
                        }
                    }
                }
            } catch (Exception e){
                e.getStackTrace();
            }
        } 
    }//GEN-LAST:event_jButton1MouseClicked

    private void checkWin(int n1,int n2,int n3){
        if(n1==n2 & n3==n1){
            if(n3==9){
                label1.setText("JACKPOT!");
                label2.setText("JACKPOT!");
                label3.setText("JACKPOT!");
                label4.setText("Win: JACKPOT!!  100 Euro");
                user.addToPortafoglio(100);
                label5.setText(user.toString());
            }
            else{
                label4.setText("Win 3 Uguali: 5 Euro");
                user.addToPortafoglio(5);
                label5.setText(user.toString());
            }
        }
        else{
            if(n1==n2 | n2==n3 | n3==n1 ){
                if(n1==9 | n2==9){
                    label4.setText("Win 2 Uguali 9: 2 Euro");
                    user.addToPortafoglio(2);
                    label5.setText(user.toString());
                }
                else{
                    label4.setText("Win 2 Uguali: 1 Euro");
                    user.addToPortafoglio(1);
                    label5.setText(user.toString());
                }
            }
            else{
                label4.setText("No Win");
                user.addToPortafoglio(-1);
                label5.setText(user.toString());
            }
        }
    }
    
    private String getValText(int n){
        switch(n){
            case 0:
                return "  0000  ";
            case 1:
                return "  1111  ";
            case 2:
                return "  2222  ";
            case 3:
                return "  3333  ";
            case 4:
                return "  4444  ";
            case 5:
                return "  5555  ";
            case 6:
                return "  6666  ";
            case 7:
                return "  7777  ";
            case 8:
                return "  8888  ";
            case 9:
                return "  9999  ";
            default:
                System.out.print("Error");
                return "Error";
        }
    }
    
    private Color getColor(int n){
        switch(n){
            case 0:
                return Color.BLUE;
            case 1:
                return Color.RED;
            case 2:
                return Color.CYAN;
            case 3:
                return Color.MAGENTA;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.GREEN;
            case 6:
                return Color.WHITE;
            case 7:
                return Color.PINK;
            case 8:
                return Color.YELLOW;
            case 9:
                return Color.LIGHT_GRAY;
            default:
                System.out.print("Error");
                return Color.BLACK;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.print("Inserire Valore Iniziale Di Portafoglio\n");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrame().setVisible(true);     
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pannello;
    private javax.swing.JButton jButton1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    // End of variables declaration//GEN-END:variables
}
