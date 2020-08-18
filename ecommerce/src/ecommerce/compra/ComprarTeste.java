/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.compra;

import bancoDados.BD;
import ecommerce.usuario.session;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;


/**
 *
 * @author Ivan Farina
 */
public class ComprarTeste extends javax.swing.JFrame {

    /**
     * Creates new form ComprarTeste
     */
    BD bd = new BD();
    public ComprarTeste() {
        initComponents();
        bd.conecta();
        String sql = "select descricao from tipoProduto";
        ResultSet rs = bd.consulta(sql);
        
	try{
            while(rs.next()){
		tipo.addItem(rs.getString("descricao"));
            }   
            
        }
        catch(SQLException e){
            System.err.println("Excessão: " + e.toString());
        }
        
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null; String s;

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j","zuidrqukwykbwd","8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69");
            st = con.createStatement();
            s = "select produto.id,produto.descricao,tipoProduto.descricao,produto.preco_final from produto inner join tipoProduto on (produto.tipo = tipoProduto.id)";
            rs = st.executeQuery(s);
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);

            for(int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i));
            }

            Vector data = new Vector();
            Vector row = new Vector();

            while(rs.next()) {
                row = new Vector(c);

                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }

                data.add(row);
            }
            jTable2 = new javax.swing.JTable(data,column);
            jButton1 = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            id_prod = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            quant = new javax.swing.JTextField();
            Adicionar = new javax.swing.JButton();
            Limpar = new javax.swing.JButton();
            Voltar = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(jTable1);

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Comprar Itens");

            jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
            jLabel6.setText("Tipo");

            tipo.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
            tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));

            jTable2.getTableHeader().setFont(new Font("Felix Titling", 0, 18));
            jTable2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
            jScrollPane2.setViewportView(jTable2);
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "ERROR"); }
        finally{
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
        }

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adicionar item no carrinho");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel3.setText("ID do produto:");

        id_prod.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel4.setText("Quantidade:");

        quant.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        Adicionar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        Limpar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        Limpar.setText("Limpar");
        Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Adicionar)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adicionar)
                    .addComponent(Limpar))
                .addContainerGap())
        );

        Voltar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton2.setText("Ir para Carrinho");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Connection con = null;
    Statement st = null; 
    ResultSet rs = null; String s;
    try{ 
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j","zuidrqukwykbwd","8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69");
        st = con.createStatement();
        if(tipo.getSelectedItem() == "TODOS"){
            s = "select produto.id,produto.descricao,tipoProduto.descricao,produto.preco_final from produto inner join tipoProduto on (produto.tipo = tipoProduto.id)"; 
        }
        else{
            s = "select produto.id,produto.descricao,tipoProduto.descricao,produto.preco_final from produto inner join tipoProduto on (produto.tipo = tipoProduto.id) where tipoProduto.descricao = '" + tipo.getSelectedItem() + "'"; 
        }
        rs = st.executeQuery(s);
        ResultSetMetaData rsmt = rs.getMetaData(); 
        int c = rsmt.getColumnCount();
        Vector column = new Vector(c);

        for(int i = 1; i <= c; i++) {
            column.add(rsmt.getColumnName(i)); 
        } 

        Vector data = new Vector(); 
        Vector row = new Vector(); 

        while(rs.next()) { 
            row = new Vector(c); 

            for(int i = 1; i <= c; i++){
                row.add(rs.getString(i)); 
            } 

            data.add(row); 
        }
        jTable2 = new javax.swing.JTable(data,column);
        jTable2.getTableHeader().setFont(new Font("Felix Titling", 0, 18));
        jTable2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jScrollPane2.setViewportView(jTable2);
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "ERROR"); }
        finally{
            try{
                st.close(); 
                rs.close(); 
                con.close(); 
            }
            catch(Exception e){ 
                JOptionPane.showMessageDialog(null, "ERROR CLOSE"); 
            } 
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        id_prod.setText("");
        quant.setText("");
    }//GEN-LAST:event_LimparActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        String sql = "select preco_final from produto where id = '"+id_prod.getText()+"'";
        ResultSet rs = bd.consulta(sql);
        float preco_unit=0,preco_total = 0;
	try{
            while(rs.next()){
		preco_unit = Float.parseFloat(rs.getString("preco_final"));
            }   
        }
        catch(SQLException e){
            System.err.println("Excessão: " + e.toString());
        }
        preco_total = preco_unit*Integer.parseInt(quant.getText());
        bd.executa("INSERT INTO Carrinho (id_produto,cpf_cliente,quant,aberto,preco_total,preco_unit) VALUES('"+id_prod.getText()+"','"+session.getInstance().getCPF()+"','"+quant.getText()+"','s','"+preco_total+"','"+preco_unit+"')");
        id_prod.setText("");
        quant.setText("");
    }//GEN-LAST:event_AdicionarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Carrinho c = new Carrinho();
        c.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(ComprarTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprarTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprarTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprarTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprarTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton Limpar;
    private javax.swing.JButton Voltar;
    private javax.swing.JTextField id_prod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField quant;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
