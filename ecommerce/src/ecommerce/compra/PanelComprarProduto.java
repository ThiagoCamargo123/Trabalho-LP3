/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.compra;

import ecommerce.compra.Carrinho.MCarrinho;
import ecommerce.compra.Carrinho.CarrinhoDAO;
import bancoDados.BD;
import ecommerce.cliente.AreaCliente;
import ecommerce.produto.MProduto;
import ecommerce.produto.MTipoProduto;
import ecommerce.produto.ProdutoDAO;
import ecommerce.usuario.Session;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan Farina
 */
public class PanelComprarProduto extends javax.swing.JPanel {

    /**
     * Creates new form PanelComprarProduto
     */
    BD bd = new BD();
    AreaCliente ac = new AreaCliente();
    ProdutoDAO pdao = new ProdutoDAO();
    int estocadoGlobal;
    public PanelComprarProduto() {
        initComponents();
        initComponents();
        bd.conecta();
        
        List<MTipoProduto> atipo = pdao.lerTipo();
        for(MTipoProduto tp : atipo){
            cbtipo.addItem(tp.getDescricao());
        }
        
        carregarTabela();
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
        jTextArea1 = new javax.swing.JTextArea();
        cbtipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btpesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txid_prod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btadicionar = new javax.swing.JButton();
        btlimpar = new javax.swing.JButton();
        txquant = new javax.swing.JSpinner();
        lbErroID = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CompraSucesso = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        CompraRealizada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Bookman Old Style", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Escolha os produtos que deseja, com o  preço mais \nacessível do mercado!\nAbra a guia Compras > Escolha a opção Comprar");
        jTextArea1.setBorder(null);
        jTextArea1.setCaretColor(new java.awt.Color(240, 240, 240));
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        setMinimumSize(new java.awt.Dimension(823, 562));
        setPreferredSize(new java.awt.Dimension(823, 562));

        cbtipo.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        cbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição","Categoria","Preço","Em estoque"
            }
        )
    );
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });
    jTable1.getTableHeader().setFont(new Font("Felix Titling", 0, 18));
    jTable1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    jScrollPane2.setViewportView(jTable1);

    btpesquisar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    btpesquisar.setText("Pesquisar");
    btpesquisar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btpesquisarActionPerformed(evt);
        }
    });

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADICIONAR ITENS AO CARRINHO!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 0, 18))); // NOI18N

    jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    jLabel3.setText("ID do produto:");

    txid_prod.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    txid_prod.setEnabled(false);
    txid_prod.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            txid_prodMouseClicked(evt);
        }
    });
    txid_prod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txid_prodActionPerformed(evt);
        }
    });

    jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    jLabel4.setText("Quantidade:");

    btadicionar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    btadicionar.setText("Adicionar item ao Carrinho");
    btadicionar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btadicionarActionPerformed(evt);
        }
    });

    btlimpar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    btlimpar.setText("Limpar");
    btlimpar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btlimparActionPerformed(evt);
        }
    });

    txquant.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    txquant.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
    txquant.setEnabled(false);

    lbErroID.setFont(new java.awt.Font("Bookman Old Style", 3, 14)); // NOI18N
    lbErroID.setForeground(new java.awt.Color(255, 51, 51));

    jScrollPane3.setBorder(null);
    jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    CompraSucesso.setEditable(false);
    CompraSucesso.setBackground(new java.awt.Color(240, 240, 240));
    CompraSucesso.setColumns(20);
    CompraSucesso.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    CompraSucesso.setRows(1);
    CompraSucesso.setText("Passo 1: Selecione o produto que deseja\nPasso 2: Escolha a quantidade que deseja comprar desse produto\nPasso 3: Clique no botão: Adicionar Item ao carrinho\nPasso 4: Para finalizar a compra, abra o menu Comprar e selecione a opção Carrinho.");
    CompraSucesso.setToolTipText("");
    CompraSucesso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Passo a passo para comprar um produto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 18))); // NOI18N
    CompraSucesso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jScrollPane3.setViewportView(CompraSucesso);

    jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane4.setEnabled(false);

    CompraRealizada.setEditable(false);
    CompraRealizada.setBackground(new java.awt.Color(240, 240, 240));
    CompraRealizada.setColumns(20);
    CompraRealizada.setFont(new java.awt.Font("Bookman Old Style", 0, 13)); // NOI18N
    CompraRealizada.setForeground(new java.awt.Color(255, 0, 0));
    CompraRealizada.setRows(3);
    CompraRealizada.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    CompraRealizada.setCaretColor(new java.awt.Color(240, 240, 240));
    CompraRealizada.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    CompraRealizada.setEnabled(false);
    jScrollPane4.setViewportView(CompraRealizada);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btlimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(20, 20, 20)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txquant)
                                .addComponent(txid_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbErroID, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addComponent(btadicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbErroID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txid_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txquant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btlimpar)
                .addComponent(btadicionar))
            .addContainerGap())
    );

    jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Comprar Itens");

    jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
    jLabel6.setText("Tipo");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(btpesquisar)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(cbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btpesquisar))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents

    private void btpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpesquisarActionPerformed
        carregarTabela();
    }//GEN-LAST:event_btpesquisarActionPerformed

    private void btadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btadicionarActionPerformed
        adicionarCarrinho();
    }//GEN-LAST:event_btadicionarActionPerformed

    private void btlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlimparActionPerformed
        txid_prod.setText("");
        txquant.setValue(1);
        CompraRealizada.setText("");
    }//GEN-LAST:event_btlimparActionPerformed

    private void txid_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txid_prodActionPerformed
        lbErroID.setText("");
        CompraRealizada.setText("");
    }//GEN-LAST:event_txid_prodActionPerformed

    private void txid_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txid_prodMouseClicked
        lbErroID.setText("");
        CompraRealizada.setText("");
    }//GEN-LAST:event_txid_prodMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            txid_prod.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            int estocado = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            if(estocado!=0){
                txquant.enable(true);
                txquant.setModel(new SpinnerNumberModel(1,1,estocado,1));
                this.estocadoGlobal=estocado;
            }
            else{
                FrameSolicitaCompraGer sg = new FrameSolicitaCompraGer();
                sg.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CompraRealizada;
    private javax.swing.JTextArea CompraSucesso;
    private javax.swing.JButton btadicionar;
    private javax.swing.JButton btlimpar;
    private javax.swing.JButton btpesquisar;
    private javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbErroID;
    private javax.swing.JTextField txid_prod;
    private javax.swing.JSpinner txquant;
    // End of variables declaration//GEN-END:variables

    private void adicionarCarrinho() {
        int id = Integer.parseInt(txid_prod.getText());
        double preco_unit=0,preco_total = 0;
        
        preco_unit = pdao.lerPreco_unitario(id);
        int quant = Integer.parseInt(txquant.getValue().toString());
        preco_total = preco_unit*quant;
        
        CarrinhoDAO dao = new CarrinhoDAO();
        MCarrinho c = new MCarrinho();
        
        c.setCpf_Cliente(Session.getInstance().getCPF());
        c.setId_produto(Integer.parseInt(txid_prod.getText()));
        c.setPreco_total(preco_total);
        c.setPreco_unit(preco_unit);
        c.setQuant(quant);
        
        
        if(dao.addCarrinho(c)){
            txid_prod.setText("");
            txquant.setValue(1);
            CompraRealizada.setText("Compra realizada com sucesso!\nPara visualizar seu item:\nAbra a guia Compras>Opção Carrinho");
            CompraRealizada.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, "Adicionado ao carrinho!!");
            txquant.enable(false);
        }
        
    }
    
    private void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        List<MProduto> listaProdutos = pdao.lerProduto();
        MProduto p;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if(cbtipo.getSelectedItem().equals("TODOS")){
                p = listaProdutos.get(i);
                modelo.addRow(new Object[]{
                    p.getId(),p.getDescricao(),p.getTipo(),p.getPreco_final(),p.getEstocado()
                });
            }
            else{
                if(listaProdutos.get(i).getTipo().equals(cbtipo.getSelectedItem())){
                    p = listaProdutos.get(i);
                    modelo.addRow(new Object[]{
                        p.getId(),p.getDescricao(),p.getTipo(),p.getPreco_final(),p.getEstocado()
                    });
                }
            }
        }
    }
}
