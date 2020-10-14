package ecommerce.produto;

import bancoDados.BD;
import ecommerce.produto.dao.MProduto;
import ecommerce.produto.dao.ProdutoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutosPorPrateleira extends javax.swing.JFrame {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    List<MProduto> produtos = null;
    BD bd = new BD();

    public ProdutosPorPrateleira() {
        initComponents();
        setLocationRelativeTo(null);
        produtos = produtoDAO.produtosPorPrateleira();
        if(produtos.size()>0)
            carregarTabelaPrimeiraPrateleira();
        inserirTiposNoSelect();
        
    }

    private void carregarTabelaPrimeiraPrateleira() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);

        String primeiraPrateleira = produtos.get(0).getIdPrateleira();

        for (MProduto produto : produtos) {
            if (produto.getIdPrateleira().equals(primeiraPrateleira)) {
                modelo.addRow(new Object[]{
                    produto.getIdPrateleira(), produto.getDescricaoTipo(), produto.getDescricao()
                });
            }
        }
    }

    private void inserirTiposNoSelect() {
        bd.conecta();
        String sql = "select id_prateleira from produto_prateleira group by id_prateleira order by id_prateleira";
        ResultSet rs = bd.consulta(sql);

        try {
            while (rs.next()) {
                prateleira.addItem(rs.getString("id_prateleira"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        prateleira = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Prateleira", "Produto", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        jLabel1.setText("Produtos Estocados");

        prateleira.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        prateleira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prateleiraMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prateleiraMouseExited(evt);
            }
        });
        prateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prateleiraActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel8.setText("Prateleira");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addGap(20, 20, 20)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(prateleira, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(prateleira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prateleiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prateleiraMouseClicked
        
    }//GEN-LAST:event_prateleiraMouseClicked

    private void prateleiraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prateleiraMouseExited
       
    }//GEN-LAST:event_prateleiraMouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void prateleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prateleiraActionPerformed
        String prateleiraString = prateleira.getSelectedItem().toString();

        List<MProduto> filtroPorTipo = produtos.stream().filter(p -> p.getIdPrateleira().equals(prateleiraString)).collect(Collectors.toList());
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        for (MProduto produto : filtroPorTipo) {
            modelo.addRow(new Object[]{
                produto.getIdPrateleira(), produto.getDescricaoTipo(), produto.getDescricao()
            });
        }
    }//GEN-LAST:event_prateleiraActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutosPorPrateleira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosPorPrateleira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosPorPrateleira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosPorPrateleira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutosPorPrateleira().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> prateleira;
    // End of variables declaration//GEN-END:variables

}
