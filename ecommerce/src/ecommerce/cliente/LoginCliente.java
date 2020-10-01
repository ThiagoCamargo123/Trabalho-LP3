/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.cliente;

import ecommerce.usuario.session;

/**
 *
 * 
 */
public class LoginCliente extends javax.swing.JFrame {

    /**
     * Creates new form LoginCliente
     */
    
    
    public LoginCliente() {
        initComponents();
        setLocationRelativeTo(null);
        
        txtsenha.setEchoChar('*');
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btEntrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        txtsenha = new javax.swing.JPasswordField();
        LabelLoginErrado = new javax.swing.JLabel();
        txtcpf = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ficamos felizes por ter escolhido nossa loja!");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel3.setText("Não possui cadastro?");

        btCadastrar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCadastrarMouseClicked(evt);
            }
        });
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel4.setText("CPF");

        btEntrar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEntrarMouseClicked(evt);
            }
        });
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel5.setText("SENHA");

        btVoltar.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        txtsenha.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtsenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsenhaMouseClicked(evt);
            }
        });

        LabelLoginErrado.setFont(new java.awt.Font("Bookman Old Style", 3, 12)); // NOI18N
        LabelLoginErrado.setForeground(new java.awt.Color(255, 0, 0));
        LabelLoginErrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcpf.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtcpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcpfMouseClicked(evt);
            }
        });
        txtcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcpfActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton1.setText("Alterar senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Esqueceu sua senha?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelLoginErrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsenha, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addComponent(txtcpf)))
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelLoginErrado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEntrar)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(38, 38, 38)
                        .addComponent(btVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCadastrar)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCadastrarMouseClicked
        CadastroCliente cadastro = new CadastroCliente();
        cadastro.setVisible(true);
    }//GEN-LAST:event_btCadastrarMouseClicked

    private void btEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEntrarMouseClicked
        String cpf = txtcpf.getText().replace(".","").replace("-","");
        login(cpf);
    }//GEN-LAST:event_btEntrarMouseClicked

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEntrarActionPerformed

    private void txtsenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsenhaMouseClicked
        LabelLoginErrado.setText("");
    }//GEN-LAST:event_txtsenhaMouseClicked

    private void txtcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcpfActionPerformed
        LabelLoginErrado.setText("");
    }//GEN-LAST:event_txtcpfActionPerformed

    private void txtcpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcpfMouseClicked
        LabelLoginErrado.setText("");
    }//GEN-LAST:event_txtcpfMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFAlterarSenha as = new JFAlterarSenha();
        as.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    private void login(String cpf){
        ClienteDAO dao = new ClienteDAO();
        String senha = new String (txtsenha.getPassword());
        if (senha.equals(dao.ClienteSenha(cpf))) {
            session sessao = session.getInstance();
            sessao.setCPF(cpf);
            sessao.settipo("Cliente");
            AreaCliente ac = new AreaCliente();
            ac.setVisible(true);
            dispose();
        } else {
            LabelLoginErrado.setText("CPF OU SENHA INCORRETOS");
        }
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
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLoginErrado;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
