/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guias;

import conexão.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jhonatan
 */
public class CadEndereco extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;
    Statement stmt;

    /**
     * Creates new form CadEndereco
     *
     */
    public CadEndereco() {
        initComponents();

    }

    public static String codEnd;
    public static String nomePaciente;

    public void cadastrarLogradouro() throws SQLException {
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into logradouro (cep,numero,bairro,cidade,uf,endereco)"
                + "values (?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, txtBuscaCep.getText());
            pst.setString(2, txtNumero.getText());
            pst.setString(3, txtBairro.getText());
            pst.setString(4, txtCidade.getText());
            pst.setString(5, cbUf.getSelectedItem().toString());
            pst.setString(6, txtEndereco.getText());

            pst.execute();
            //Metodo para recuperar o id de AutoIncremento de PK_PKF
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            //Metodo para Setar o campo recuperado em algum lugar da aplicação
            String cod = rs.getString(1);
            txtCodEnde.setText(cod);
            //Metodo criado para trbalhar com troca de dados entre forms
            CadPacientes.codEndereco = txtCodEnde.getText();
            CadPacientes.txtCodEndereco.setText(txtCodEnde.getText());

            pst.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!", "Cadastrar Logradouro de Pacientes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Descrição do Erro! " + error.getMessage());
        }
    }

    public void LimparCampos() {
        txtBuscaCep.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEndereco.setText("");
        cbUf.setSelectedIndex(0);
        txtBuscaCep.requestFocus();

    }

    public void LimparCampos2() {
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEndereco.setText("");
        cbUf.setSelectedIndex(0);
        txtNumero.requestFocus();
    }

    public void BuscaCep() throws SQLException {
        Connection con;
        try {
            con = ConectaBanco.conecta("bdclinica");
//        String sql = "select * from logradouro Where cep='" +txtBuscaCep+ "'";
            String sql = "select * from logradouro Where cep LIKE ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, txtBuscaCep.getText());
                ResultSet rs = pst.executeQuery();

                if (rs.next())//Se encontrou algun registro prossegue
                {
                    txtBuscaCep.setText(rs.getString("cep"));
                    txtEndereco.setText(rs.getString("endereco"));
                    txtNumero.requestFocus();
                    txtBairro.setText(rs.getString("bairro"));
                    txtCidade.setText(rs.getString("cidade"));
                    cbUf.setSelectedItem(rs.getString("uf"));
                } else {
                    int op = JOptionPane.showConfirmDialog(null, "CEP Não Cadastrado! Deseja cadastrar um novo CEP?");
                    if (op == JOptionPane.YES_OPTION) {
                        txtNumero.requestFocus();                        
                        LimparCampos2();
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }

    }
    
        public void log() throws SQLException {
//        String CadtroPaciente;
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into log (acao,data,login_cod)"
                + "values ('Cadastrou Novo Endereco',current_timestamp,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Principal.lbCod.getText());
            pst.execute();
            pst.close();
//            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!", "Cadastrar Pacientes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Descrição do Erro! " + error.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bntSalvarLogradouro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscaCep = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        cbUf = new javax.swing.JComboBox();
        txtNomePaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodEnde = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Endereços Para Clientes");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411838523_icon-close-round-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411783486_icon-loop-16.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bntSalvarLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411837995_icon-checkmark-16.png"))); // NOI18N
        bntSalvarLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarLogradouroActionPerformed(evt);
            }
        });

        jLabel1.setText("CEP:");

        jLabel2.setText("Nº:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("UF:");

        txtBuscaCep.setBackground(new java.awt.Color(204, 255, 255));
        txtBuscaCep.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtBuscaCep.setForeground(new java.awt.Color(0, 51, 153));
        txtBuscaCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaCepFocusLost(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411783471_icon-ios7-search-strong-16.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtNumero.setBackground(new java.awt.Color(204, 255, 255));
        txtNumero.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 153));

        txtEndereco.setBackground(new java.awt.Color(204, 255, 255));
        txtEndereco.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(0, 51, 153));

        txtBairro.setBackground(new java.awt.Color(204, 255, 255));
        txtBairro.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtBairro.setForeground(new java.awt.Color(0, 51, 153));

        txtCidade.setBackground(new java.awt.Color(204, 255, 255));
        txtCidade.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(0, 51, 153));

        cbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione>", "MT", "SP" }));

        txtNomePaciente.setEditable(false);
        txtNomePaciente.setBackground(new java.awt.Color(204, 255, 255));
        txtNomePaciente.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        txtNomePaciente.setForeground(new java.awt.Color(0, 0, 153));

        jLabel7.setText("Cod. Ende:");

        txtCodEnde.setEditable(false);
        txtCodEnde.setBackground(new java.awt.Color(204, 255, 255));
        txtCodEnde.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodEnde.setForeground(new java.awt.Color(0, 0, 153));
        txtCodEnde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEndeActionPerformed(evt);
            }
        });

        jLabel8.setText("Paciente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBairro)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodEnde, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(bntSalvarLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomePaciente)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bntSalvarLogradouro, jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodEnde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscaCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(bntSalvarLogradouro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntSalvarLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarLogradouroActionPerformed
        try {
            cadastrarLogradouro();
            log();
            LimparCampos();

        } catch (SQLException ex) {
            Logger.getLogger(CadEndereco.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();

    }//GEN-LAST:event_bntSalvarLogradouroActionPerformed

    private void txtCodEndeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEndeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodEndeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimparCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            BuscaCep();
        } catch (SQLException ex) {
            Logger.getLogger(CadEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtBuscaCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaCepFocusLost
//        try {
//            BuscaCep();
//        } catch (SQLException ex) {
//            Logger.getLogger(CadEndereco.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_txtBuscaCepFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSalvarLogradouro;
    private javax.swing.JComboBox cbUf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBairro;
    public static javax.swing.JTextField txtBuscaCep;
    private javax.swing.JTextField txtCidade;
    public static javax.swing.JTextField txtCodEnde;
    private javax.swing.JTextField txtEndereco;
    public static javax.swing.JTextField txtNomePaciente;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        // TODO code application logic here
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
////                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Autenticacao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

//                try {  
////            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");  
//                        UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {  
//            Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);  
//        } 
        //</editor-fold>
        new CadEndereco().setVisible(true);

    }
}
