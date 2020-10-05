/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.cliente;

import bancoDados.BD;
import ecommerce.usuario.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ivan Farina
 */
public class PanelPerfil extends javax.swing.JPanel {

    /**
     * Creates new form Perfil
     */
    
    ClienteDAO dao = new ClienteDAO();
    public PanelPerfil() {
        initComponents();
        String cpf = Session.getInstance().getCPF();
        List<MCliente> listaClientes = dao.lerClientes();
        List<MCliente> resultado = listaClientes
                                                .stream()
                                                .filter(e -> e.getCpf().equals(cpf))
                                                .collect(Collectors.toList());
        
        MCliente mc = resultado.get(0);
        
        txtcpf.setText(mc.getCpf());
        txtnome.setText(mc.getNome());
        txtrua.setText(mc.getRua());
        txtbairro.setText(mc.getBairro());
        txtcidade.setText(mc.getCidade());
        txtemail.setText(mc.getEmail());
        txttelefone.setText(mc.getTelefone());
        txtcep.setText(mc.getCep());
        cbestado.setSelectedItem(mc.getEstado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcep1 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtrua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbestado = new javax.swing.JComboBox<>();
        txttelefone = new javax.swing.JFormattedTextField();
        atualizado = new javax.swing.JLabel();
        txtcep = new javax.swing.JFormattedTextField();
        txtcpf = new javax.swing.JFormattedTextField();

        try {
            txtcep1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcep1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel14.setText("Email");

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Perfil");

        txtnome.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAtualizarMouseClicked(evt);
            }
        });
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel7.setText("CPF");

        txtrua.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtrua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel8.setText("Nome");

        txtbairro.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbairroActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel9.setText("Telefone");

        txtcidade.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcidadeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel10.setText("Rua");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel11.setText("Bairro");

        txtemail.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel12.setText("Cidade");

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel13.setText("Cep");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel3.setText("Estado");

        cbestado.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ES", "MG", "RJ", "SP" }));
        cbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbestadoActionPerformed(evt);
            }
        });

        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txttelefone.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txttelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefoneActionPerformed(evt);
            }
        });

        atualizado.setFont(new java.awt.Font("Bookman Old Style", 3, 14)); // NOI18N
        atualizado.setForeground(new java.awt.Color(51, 51, 255));
        atualizado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcep.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcpf.setEnabled(false);
        txtcpf.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtrua))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcidade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atualizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(atualizado, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAtualizar)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtualizarMouseClicked
        
    }//GEN-LAST:event_btAtualizarMouseClicked

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        String cpf = txtcpf.getText().replace(".","").replace("-","");
        String cep = txtcpf.getText().replace(".","").replace("-","");
        String telefone = txttelefone.getText().replace("(","").replace(")","").replace(" ","").replace("-","");
        atualizar(cpf,cep,telefone);
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_txtnomeActionPerformed

    private void txttelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefoneActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_txttelefoneActionPerformed

    private void txtruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruaActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_txtruaActionPerformed

    private void txtbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbairroActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_txtbairroActionPerformed

    private void txtcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcidadeActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_txtcidadeActionPerformed

    private void cbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbestadoActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_cbestadoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        atualizado.setVisible(false);
    }//GEN-LAST:event_txtemailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atualizado;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JFormattedTextField txtcep1;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtrua;
    private javax.swing.JFormattedTextField txttelefone;
    // End of variables declaration//GEN-END:variables

    private void atualizar(String cpf, String cep, String telefone) {
        MCliente mc = new MCliente();
        mc.setCpf(cpf);
        mc.setNome(txtnome.getText());
        mc.setTelefone(telefone);
        mc.setRua(txtrua.getText());
        mc.setBairro(txtbairro.getText());
        mc.setCidade(txtcidade.getText());
        mc.setEstado((String) cbestado.getSelectedItem());
        mc.setCep(cep);
        mc.setEmail(txtemail.getText());
        
        ClienteDAO dao = new ClienteDAO();
        dao.alterarCliente(mc);
    }
}
