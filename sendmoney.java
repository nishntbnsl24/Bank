
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nishant
 */
public class sendmoney extends javax.swing.JFrame {

    /**
     * Creates new form sendmoney
     */
    long senderaccountnumber;
    double senderoldbalance,sendernewbalance;
    public sendmoney() {
        initComponents();
    }
    public sendmoney(ResultSet result)
    {
        try{senderaccountnumber=Long.parseLong(result.getString("account_number"));
        senderoldbalance=Double.parseDouble(result.getString("balance"));}catch(Exception e){JOptionPane.showMessageDialog(this, e);}
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(400, 50));

        jLabel1.setText("Send Money");

        jLabel2.setText("Account Number");

        jLabel3.setText("Amount");

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addGap(114, 114, 114))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*try {
            long a = Long.parseLong(jTextField1.getText());
            double s = Double.parseDouble(jTextField2.getText());
            if (s <= 2000) {
                if (true) {
                    JOptionPane.showMessageDialog(this, s + " Sent Successfully to " + "Holder");
                } else {
                    JOptionPane.showMessageDialog(this, "Account holder doesn't exist");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Balance");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Account Number and Amount must be numbers");
        }*/
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankdatabase", "root", "");
            Statement stmt = con.createStatement();
            double a=0,receivernewbalance=0;
            long receiveraccountnumber=0;
            String debit="DEBIT",credit="CREDIT";
            Date date=new Date();
            try{a = Double.parseDouble(jTextField2.getText());
            sendernewbalance=signinyes.updatedbalance-a;}catch(Exception e){JOptionPane.showMessageDialog(this, "Amount must be in numbers");}
            try{receiveraccountnumber=Long.parseLong(jTextField1.getText());}catch(Exception e){JOptionPane.showMessageDialog(this, "AccountNumber must be in numbers");}
            String query3="select * from customers where account_number="+receiveraccountnumber+"";
            ResultSet receiver=stmt.executeQuery(query3);
            if(receiver.next()){
            try{double receiveroldbalance=Double.parseDouble(receiver.getString("balance"));
            receivernewbalance=receiveroldbalance+a;}catch(Exception e){JOptionPane.showMessageDialog(this, "Error");}
            String query1 = "update customers set balance=" + sendernewbalance + " where account_number=" + senderaccountnumber + ";";
            String query2="update customers set balance=" + receivernewbalance + " where account_number=" + receiveraccountnumber + ";";
            String transaction1="insert into transactions values(" + senderaccountnumber + ",'" + debit + "'," + a + ",'" + date + "',null);";
            String transaction2="insert into transactions values(" + receiveraccountnumber + ",'" + credit + "'," + a + ",'" + date + "',null);";
            if (sendernewbalance >= 0/*balance*/) {
                stmt.execute(query1);
                stmt.execute(query2);
                signinyes.updatedbalance = sendernewbalance;
                JOptionPane.showMessageDialog(this, "Money sent Successfully to "+receiveraccountnumber);
                stmt.execute(transaction1);
                stmt.execute(transaction2);
                con.close();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Amount");
            }
        } 
            else JOptionPane.showMessageDialog(this, "Account Not found");}catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sendmoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sendmoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sendmoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sendmoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sendmoney().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
