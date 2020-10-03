
package InteligenciaArtificial;

import InteligenciaArtificial.model.Prateleira;
import InteligenciaArtificial.model.ProdutoBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            double divisor = 12000000;
            double volumeDisponivel = pra.getVolumeDisponivel();
            double divisao = volumeDisponivel / 12000000;
            double porcentagem = divisao * 100;
            String porcentagemString = String.valueOf(porcentagem);
            if(porcentagemString.length()>5){
                porcentagemString = porcentagemString.substring(0,5);
            }
            String res = porcentagemString+" %";
            pra.setPorcentagem(res);
        }
        
        a1.setText(String.valueOf(prateleiraList.get(0).getPorcentagem()));
        a2.setText(String.valueOf(prateleiraList.get(2).getPorcentagem()));
        a3.setText(String.valueOf(prateleiraList.get(4).getPorcentagem()));
        a4.setText(String.valueOf(prateleiraList.get(6).getPorcentagem()));
        a5.setText(String.valueOf(prateleiraList.get(8).getPorcentagem()));
        b1.setText(String.valueOf(prateleiraList.get(1).getPorcentagem()));
        b2.setText(String.valueOf(prateleiraList.get(3).getPorcentagem()));
        b3.setText(String.valueOf(prateleiraList.get(5).getPorcentagem()));
        b4.setText(String.valueOf(prateleiraList.get(7).getPorcentagem()));
        b5.setText(String.valueOf(prateleiraList.get(9).getPorcentagem()));
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
        jLabel1 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        b1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        b3 = new javax.swing.JLabel();
        b2 = new javax.swing.JLabel();
        b4 = new javax.swing.JLabel();
        b5 = new javax.swing.JLabel();

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Categoria", "Total Estocado", "Lucro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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

        jLabel1.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        jLabel1.setText("Estoque Atual");

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

        jLabel9.setText("____________________________________________________________________________");

        jLabel11.setText("_______________________________________________________________________");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel12.setText("A");

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel13.setText("B");

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel14.setText("1");

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setText("2");

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("3");

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel17.setText("4");

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setText("5");

        jLabel19.setText("Volume (%)");

        jLabel20.setText("Volume (%)");

        b1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        b1.setText("0 %");

        a2.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        a2.setText("0 %");

        a3.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        a3.setText("0 %");

        a4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        a4.setText("0 %");

        a5.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        a5.setText("0 %");

        a1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        a1.setText("0%");

        b3.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        b3.setText("0 %");

        b2.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        b2.setText("0 %");

        b4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        b4.setText("0 %");

        b5.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        b5.setText("0 %");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoriaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalEstocadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(a4))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(78, 78, 78)
                                                        .addComponent(b1)
                                                        .addGap(137, 137, 137))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(a1)
                                                        .addGap(139, 139, 139)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(b2)
                                                    .addComponent(a2))
                                                .addGap(117, 117, 117)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(b3)
                                                    .addComponent(a3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b4)))
                                        .addGap(136, 136, 136)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(a5)
                                            .addComponent(b5)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(198, 198, 198)
                                        .addComponent(jLabel14)
                                        .addGap(147, 147, 147)
                                        .addComponent(jLabel15)
                                        .addGap(131, 131, 131)
                                        .addComponent(jLabel16)
                                        .addGap(151, 151, 151)
                                        .addComponent(jLabel17)
                                        .addGap(152, 152, 152)
                                        .addComponent(jLabel18)))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addGap(290, 290, 290)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
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
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(a2)
                    .addComponent(a3)
                    .addComponent(a4)
                    .addComponent(a5)
                    .addComponent(a1)
                    .addComponent(jLabel19))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(b1)
                    .addComponent(b3)
                    .addComponent(b2)
                    .addComponent(b4)
                    .addComponent(b5)
                    .addComponent(jLabel20))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                Logger.getLogger(OrganizarPrateleiraJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String inicioData = getDataInicio();
        String fimData = getDataFim();
        
        try {
            produtos = organizarPrateleira.calculaPrioridadeCategoriaPorMaisVendidaEMaiorLucroEMenorVolume(inicioData,fimData);
        } catch (Exception ex) {
            Logger.getLogger(OrganizarPrateleiraJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregarTabela(produtos);
        try {
            inicializarPrateleira();
        } catch (SQLException ex) {
            Logger.getLogger(OrganizarPrateleiraJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            nomeLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            categoriaLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            totalEstocadoLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    
    public void atualizarPrateleiras(){
        a1.setText(String.valueOf(prateleiraList.get(0).getPorcentagem()));
        a2.setText(String.valueOf(prateleiraList.get(2).getPorcentagem()));
        a3.setText(String.valueOf(prateleiraList.get(4).getPorcentagem()));
        a4.setText(String.valueOf(prateleiraList.get(6).getPorcentagem()));
        a5.setText(String.valueOf(prateleiraList.get(8).getPorcentagem()));
        b1.setText(String.valueOf(prateleiraList.get(1).getPorcentagem()));
        b2.setText(String.valueOf(prateleiraList.get(3).getPorcentagem()));
        b3.setText(String.valueOf(prateleiraList.get(5).getPorcentagem()));
        b4.setText(String.valueOf(prateleiraList.get(7).getPorcentagem()));
        b5.setText(String.valueOf(prateleiraList.get(9).getPorcentagem()));
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int indice = jTable1.getSelectedRow();
        Prateleira prateleiraAtualizada = null; 
        try {
             prateleiraAtualizada = organizarPrateleira.armazenaOsProdutos(produtos.get(indice));
        } catch (Exception ex) {
            Logger.getLogger(OrganizarPrateleiraJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Prateleira pra: prateleiraList){
            if(pra.getId().equals(prateleiraAtualizada.getId())){
                pra.setId(prateleiraAtualizada.getId());
                pra.setPorcentagem(prateleiraAtualizada.getPorcentagem());
                pra.setVolumeDisponivel(prateleiraAtualizada.getVolumeDisponivel());
            }
        }
        
        atualizarPrateleiras();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    private void carregarTabela(List<ProdutoBanco> produtos) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            ProdutoBanco p;
            for (ProdutoBanco produto: produtos) {
                p = (ProdutoBanco) produto;
                modelo.addRow(new Object[]{
                    p.getDescricao(),p.getDescricaoCategoria(),p.getQuantidadeEstocado(),p.getLucro()
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
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b4;
    private javax.swing.JLabel b5;
    private javax.swing.JLabel categoriaLabel;
    private com.toedter.calendar.JDateChooser dataFim;
    private com.toedter.calendar.JDateChooser dataInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel totalEstocadoLabel;
    // End of variables declaration//GEN-END:variables
}
