/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guias;

import conexão.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonatan
 */
public class CadMedicos extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;

    /**
     * Creates new form CadMedicos
     */
    public CadMedicos() {

        initComponents();
    }
    public static String codLogin;

    public void cadastrarMedico() throws SQLException {
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into medico (crm,nome,telefone,celular,email,especialidade,atendimento,login_cod)"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtCRM.getText());
            pst.setString(2, txtNomeMedico.getText());
            pst.setString(3, txtTelefoneMedico.getText());
            pst.setString(4, txtCelularMedico.getText());
            pst.setString(5, txtEmailMedico.getText());
            pst.setString(6, txtEspecialidadeMedico.getText());//getDate().toString());
            pst.setString(7, cbAtendimentoMedico.getSelectedItem().toString());
            pst.setString(8, CodLogin.getText());

            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!", "Cadastrar Médicos", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Descrição do Erro! " + error.getMessage());
        }
    }

    public void LimparCampos(){
        txtCRM.setText("");
        txtCelularMedico.setText("");
        txtEmailMedico.setText("");
        txtNomeMedico.setText("");
        txtEspecialidadeMedico.setText("");
        txtTelefoneMedico.setText("");
        CodLogin.setText("cod..Login");
        cbAtendimentoMedico.setSelectedIndex(0);
        txtCRM.requestFocus();
    }
    
        public void log() throws SQLException {
        String CadtroPaciente;
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into log (acao,data,login_cod)"
                + "values ('Cadastrou Novo Medico',current_timestamp,?)";
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        btnFecharCadMedico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEspecialidadeMedico = new javax.swing.JTextField();
        txtEmailMedico = new javax.swing.JTextField();
        txtCelularMedico = new javax.swing.JTextField();
        txtTelefoneMedico = new javax.swing.JTextField();
        txtNomeMedico = new javax.swing.JTextField();
        txtCRM = new javax.swing.JTextField();
        cbAtendimentoMedico = new javax.swing.JComboBox();
        btnLimparCadMedico = new javax.swing.JButton();
        btnSalvarCadMedico = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        CodLogin = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Medicos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        btnFecharCadMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411838523_icon-close-round-16.png"))); // NOI18N
        btnFecharCadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharCadMedicoActionPerformed(evt);
            }
        });

        jLabel1.setText("CRM:");

        jLabel2.setText("Nome Completo:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Celular:");

        jLabel5.setText("Email:");

        jLabel6.setText("Especialidades:");

        jLabel7.setText("Atendimentos:");

        txtEspecialidadeMedico.setBackground(new java.awt.Color(204, 255, 255));
        txtEspecialidadeMedico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEspecialidadeMedico.setForeground(new java.awt.Color(0, 0, 204));

        txtEmailMedico.setBackground(new java.awt.Color(204, 255, 255));
        txtEmailMedico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEmailMedico.setForeground(new java.awt.Color(0, 0, 204));

        txtCelularMedico.setBackground(new java.awt.Color(204, 255, 255));
        txtCelularMedico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCelularMedico.setForeground(new java.awt.Color(0, 0, 204));

        txtTelefoneMedico.setBackground(new java.awt.Color(204, 255, 255));
        txtTelefoneMedico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTelefoneMedico.setForeground(new java.awt.Color(0, 0, 204));

        txtNomeMedico.setBackground(new java.awt.Color(204, 255, 255));
        txtNomeMedico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNomeMedico.setForeground(new java.awt.Color(0, 0, 204));

        txtCRM.setBackground(new java.awt.Color(204, 255, 255));
        txtCRM.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCRM.setForeground(new java.awt.Color(0, 0, 204));

        cbAtendimentoMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<selecione>", "Matutino", "Vespertino", "Noturno", "Matutino/vespertino", "Matutino/noturno", "Vespertino/Notuno", "Vespertino/Matutino", "Noturno/matutino", "Noturno/vespertino" }));

        btnLimparCadMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411783486_icon-loop-16.png"))); // NOI18N
        btnLimparCadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadMedicoActionPerformed(evt);
            }
        });

        btnSalvarCadMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411837995_icon-checkmark-16.png"))); // NOI18N
        btnSalvarCadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadMedicoActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar Usuario e Senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CodLogin.setBackground(new java.awt.Color(204, 255, 255));
        CodLogin.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        CodLogin.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(jLabel5))
                                        .addComponent(jLabel4)))))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAtendimentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnSalvarCadMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimparCadMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFecharCadMedico))
                            .addComponent(txtCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCelularMedico)
                                .addComponent(txtTelefoneMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEspecialidadeMedico)
                            .addComponent(txtEmailMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(CodLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFecharCadMedico, btnLimparCadMedico, btnSalvarCadMedico});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(txtCelularMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(CodLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEspecialidadeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAtendimentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFecharCadMedico)
                        .addComponent(btnLimparCadMedico))
                    .addComponent(btnSalvarCadMedico))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharCadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharCadMedicoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharCadMedicoActionPerformed

    private void btnSalvarCadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadMedicoActionPerformed
        try {
            cadastrarMedico();
            LimparCampos();
            log();
        } catch (SQLException ex) {
            Logger.getLogger(CadMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSalvarCadMedicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        funcoes.funcao.cad_usario_medico();
        CadUsuarioMedico.txtUsuario.requestFocus();
        CadUsuarioMedico.nomeMedico = txtNomeMedico.getText();
        CadUsuarioMedico.txtNome.setText(txtNomeMedico.getText());
        CadUsuarioMedico.CRM=txtCRM.getText();
        CadUsuarioMedico.txtCrm.setText(txtCRM.getText());
        CadUsuarioMedico.celular = txtCelularMedico.getText();
        CadUsuarioMedico.txtTelefone.setText(txtCelularMedico.getText());
                

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimparCadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadMedicoActionPerformed
       LimparCampos();
    }//GEN-LAST:event_btnLimparCadMedicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel CodLogin;
    private javax.swing.JButton btnFecharCadMedico;
    private javax.swing.JButton btnLimparCadMedico;
    private javax.swing.JButton btnSalvarCadMedico;
    private javax.swing.JComboBox cbAtendimentoMedico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtCRM;
    public static javax.swing.JTextField txtCelularMedico;
    private javax.swing.JTextField txtEmailMedico;
    private javax.swing.JTextField txtEspecialidadeMedico;
    public static javax.swing.JTextField txtNomeMedico;
    private javax.swing.JTextField txtTelefoneMedico;
    // End of variables declaration//GEN-END:variables
}
