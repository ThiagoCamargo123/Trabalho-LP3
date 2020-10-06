
package InteligenciaArtificial;

import InteligenciaArtificial.model.Prateleira;
import InteligenciaArtificial.model.ProdutoBanco;
import ecommerce.prateleira.ListarPrateleira;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class OrganizarPrateleiraJFrame extends javax.swing.JFrame {
    OrganizarPrateleira organizarPrateleira = new OrganizarPrateleira();
    List<ProdutoBanco> produtos = null;
    List<Prateleira> prateleiraList = null;
    
    public OrganizarPrateleiraJFrame() {
        initComponents();
    }
    
    public void inicializarPrateleira() throws SQLException{
        prateleiraList = organizarPrateleira.consultaPrateleira();
        
        //Considere 12000000 = 100%
        for(Prateleira pra: prateleiraList){
            double divisor = 1200000;
            double volumeDisponivel = pra.getVolumeDisponivel();
            double divisao = volumeDisponivel / 1200000;
            double porcentagem = divisao * 100;
            String porcentagemString = String.valueOf(porcentagem);
            if(porcentagemString.length()>5){
                porcentagemString = porcentagemString.substring(0,5);
            }
            String res = porcentagemString+" %";
            pra.setPorcentagem(res);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        dataInicio = new com.toedter.calendar.JDateChooser();
        dataFim = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        categoriaLabel = new javax.swing.JLabel();
        totalEstocadoLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalNaoEstocado = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Categoria", "Total Estocado", "Total Não Estocado", "Lucro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Comprar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Inicio");

        jLabel3.setText("Fim");

        jButton2.setText("Filtrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Produto Selecionado");

        nomeLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        nomeLabel.setText("Nenhum Selecionado");

        categoriaLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        categoriaLabel.setText("Nenhum Selecionado");

        totalEstocadoLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        totalEstocadoLabel.setText("Nenhum Selecionado");

        jLabel10.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel10.setText("Estocado:");

        jLabel5.setText("Faça com que a I.A consulte os registros de vendas");

        jLabel6.setText("dutante as datas informadas, utilize datas atuais");

        jLabel7.setText("para ser mais preciso a consulta.");

        jLabel8.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        jLabel8.setText("Prioridade produtos com base nas datas inseridas");

        totalNaoEstocado.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        totalNaoEstocado.setText("Nenhum Selecionado");

        jLabel21.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel21.setText("Não Estocado:");

        jButton3.setText("Ver Estoque");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("____________________________________________");

        jLabel11.setText("___________________________________________________________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(dataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jButton2)))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoriaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(totalEstocadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalNaoEstocado, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(nomeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(categoriaLabel)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalEstocadoLabel)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalNaoEstocado)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(dataInicio == null || dataFim == null) {
            try {
                throw new Exception("Data inicio ou fim devem estar preenchidas");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
        }

        String inicioData = getDataInicio();
        String fimData = getDataFim();

        try {
            produtos = organizarPrateleira.calculaPrioridadeCategoriaPorMaisVendidaEMaiorLucroEMenorVolume(inicioData,fimData);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

        carregarTabela(produtos);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int indice = jTable1.getSelectedRow();
        Prateleira prateleiraAtualizada = null;
        try {
            prateleiraAtualizada = organizarPrateleira.armazenaOsProdutos(produtos.get(indice));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

//        for(Prateleira pra: prateleiraList){
//            if(pra.getId().equals(prateleiraAtualizada.getId())){
//                pra.setId(prateleiraAtualizada.getId());
//                pra.setPorcentagem(prateleiraAtualizada.getPorcentagem());
//                pra.setVolumeDisponivel(prateleiraAtualizada.getVolumeDisponivel());
//            }
//        }

        if(prateleiraAtualizada.getPorcentagem().equals("excedido")) JOptionPane.showMessageDialog(null,"Você não possui espaço no estoque para armazenar esse produto!");
        else JOptionPane.showMessageDialog(null,"Produto "+produtos.get(indice).getDescricao() +" inserido na Prateleira "+prateleiraAtualizada.getId());
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            nomeLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            categoriaLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            totalEstocadoLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            totalNaoEstocado.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ListarPrateleira listarPrateleira = new ListarPrateleira();
        listarPrateleira.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

   
        private void carregarTabela(List<ProdutoBanco> produtos) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            ProdutoBanco p;
            for (ProdutoBanco produto: produtos) {
                p = (ProdutoBanco) produto;
                modelo.addRow(new Object[]{
                    p.getDescricao(),p.getDescricaoCategoria(),p.getQuantidadeEstocado(),p.getQuantidadeNaoEstocado(),p.getLucro()
                });
            }
    }
    
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
    
    public String getDataFim(){
        int lenght1 = dataFim.getDate().toString().length();
        int lenght2 = lenght1 - 4;
        
        String diaFim = dataFim.getDate().toString().substring(8,10);
        String mesFim = String.valueOf(dataFim.getDate().getMonth() + 1);
        String anoFim = dataFim.getDate().toString().substring(lenght2,lenght1);
        
        String resultadoFim = null;
        
        if(mesFim.equals("11") || mesFim.equals("12")){
            resultadoFim = anoFim + "-" + mesFim + "-" + diaFim;
        } else {
            resultadoFim = anoFim + "-0" + mesFim + "-" + diaFim;
        }
        
        return resultadoFim;
    }
    
    public static void main(String args[]) throws SQLException {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrganizarPrateleiraJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoriaLabel;
    private com.toedter.calendar.JDateChooser dataFim;
    private com.toedter.calendar.JDateChooser dataInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel totalEstocadoLabel;
    private javax.swing.JLabel totalNaoEstocado;
    // End of variables declaration//GEN-END:variables
}
