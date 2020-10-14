/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Thiago
 */
public class ProdutosVendidos extends javax.swing.JFrame {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    List<MProduto> produtos = null;
    BD bd = new BD();
    public ProdutosVendidos() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void carregarTabelaPrimeiraPrateleira() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);

        String primeiraPrateleira = produtos.get(0).getIdPrateleira();

        for (MProduto produto : produtos) {
            if (produto.getIdPrateleira().equals(primeiraPrateleira)) {
                Object[] obj = new Object[]{
                    produto.getIdPrateleira(), produto.getDescricao(),produto.getData(),produto.getHora()
                };
                modelo.addRow(obj);
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
        dataInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Prateleira", "Produto", "Data Venda", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setText("Produtos Vendidos");

        prateleira.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        prateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prateleiraActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel8.setText("Prateleira");

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel9.setText("A Partir da data:");

        jButton1.setText("Buscar pela Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(prateleira, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1))))))
                            .addComponent(jLabel8))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prateleira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton3))
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                produto.getIdPrateleira(), produto.getDescricao(),produto.getData(),produto.getHora()
            });
        }
    }//GEN-LAST:event_prateleiraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(dataInicio == null) {
            try {
                throw new Exception("Data inicio deve estar preenchida");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
        }
        
        String inicioData = getDataInicio();
        
        produtos = produtoDAO.produtosVendidos(inicioData);
        if(produtos.size()>0)
            carregarTabelaPrimeiraPrateleira();
        inserirTiposNoSelect();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    public String getDataInicio(){
        int lenghtDataInicio = dataInicio.getDate().toString().length();
        int lenghtDataInicioFim = lenghtDataInicio - 4;
        
        String diaInicio = dataInicio.getDate().toString().substring(8,10);
        String mesInicio = String.valueOf(dataInicio.getDate().getMonth() + 1);
        String anoInicio = dataInicio.getDate().toString().substring(lenghtDataInicioFim,lenghtDataInicio);
        
        String resultadoInicio = null;
        
        if(mesInicio.equals("11") || mesInicio.equals("12")){
            resultadoInicio = anoInicio + "-" + mesInicio + "-" + diaInicio;
        } else {
            resultadoInicio = anoInicio + "-0" + mesInicio + "-" + diaInicio;
        }
        
        return resultadoInicio;
    }
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
            java.util.logging.Logger.getLogger(ProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutosVendidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> prateleira;
    // End of variables declaration//GEN-END:variables
}
