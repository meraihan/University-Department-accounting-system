
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Sayed Mahmud Raihan
 */
public class delete extends javax.swing.JFrame {

   
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public delete() {
        super("Drop dept");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        initComponents();
        conn = javaconnect.rw();
        fillcombo();
        
    }
    private void fillcombo(){
        try{
            String sql = "select * from account";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("dept_name");
                del_combo.addItem(name);
            }
            
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
       }
            finally{
            try{
            rs.close();
            pst.close();
                
           }catch(SQLException e){
          
          }
        }
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        del_combo = new javax.swing.JComboBox();
        del_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Select Department:");

        del_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        del_button.setText("Delete");
        del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(del_button, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(del_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(del_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_buttonActionPerformed
         int p = JOptionPane.showConfirmDialog(null, "Do you want to really delete?", "Delete", JOptionPane.YES_NO_OPTION);
         if (p == 0) {
            String sql = "DELETE FROM account WHERE dept_name = '"+del_combo.getSelectedItem()+"'";
            try {

                pst = conn.prepareStatement(sql);
                
                
                

                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(null, e);
            }
         }
    }//GEN-LAST:event_del_buttonActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton del_button;
    private javax.swing.JComboBox del_combo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
