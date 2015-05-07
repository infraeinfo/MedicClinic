package guias;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import conexão.ConectaBanco;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonatan
 */
public class CadUsuarioMedico extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;
    
    /**
     * Creates new form CadUsuario
     */
    public CadUsuarioMedico() {
        initComponents();
    }
    public static String nomeMedico;
    public static String CRM;
    public static String celular;

    public void CadastrarUsuarioMedico() {
        if (txtSenha.getText().equals(txtSenha2.getText())) {
            Connection con;
            try {
//        con=null;    
                con = ConectaBanco.conecta("bdclinica");
                String query = "INSERT INTO login (nome,telefone,cpf,usuario,senha,tipo) values (?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, txtNome.getText());
                pst.setString(2, txtTelefone.getText().trim());
                pst.setString(3, txtCrm.getText());
                pst.setString(4, txtUsuario.getText().trim());
                pst.setString(5, txtSenha.getText());
                pst.setString(6, cbSetor.getSelectedItem().toString());
//        pst.setString(6,grupo.getSelection().getActionCommand());  

                pst.execute();
                //Metodo para recuperar o id de AutoIncremento de PK_PKF
                ResultSet rs = pst.getGeneratedKeys();
                rs.next();
                //Metodo para Setar o campo recuperado em algum lugar da aplicação
                String cod = rs.getString(1);
                txtCodigoUsuario.setText(cod);
                CadMedicos.codLogin = txtCodigoUsuario.getText();
                CadMedicos.CodLogin.setText(txtCodigoUsuario.getText());

                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                limpar();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
        } else {
            lbAlerta.setText("Senha inválida! Confirme a senha corretamente!");
            txtSenha.setText("");
            txtSenha2.setText("");
            txtSenha.requestFocus();
        }
    }

    public void limpar() {
        txtCrm.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtSenha2.setText("");
        txtUsuario.setText("");
        txtTelefone.setText("");
        lbAlerta.setText("");
        txtNome.requestFocus();
        cbSetor.setSelectedIndex(0);
    }

    public void log() throws SQLException {
        String CadtroPaciente;
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into log (acao,data,login_cod)"
                + "values ('Cadastrou usuario Medico',current_timestamp,?)";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cbSetor = new javax.swing.JComboBox();
        txtSenha = new javax.swing.JPasswordField();
        txtSenha2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JLabel();
        txtCrm = new javax.swing.JLabel();
        txtCodigoUsuario = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuarios Medicos ao sistema\n");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411838523_icon-close-round-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome Completo:");

        jLabel2.setText("Celular:");

        jLabel3.setText("CRM:");

        jLabel4.setText("Setor:");

        jLabel5.setText("Usuario:");

        jLabel6.setText("Senha:");

        jLabel7.setText("Repita Senha:");

        txtUsuario.setBackground(new java.awt.Color(204, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 204));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        cbSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Medico" }));
        cbSetor.setEnabled(false);

        txtSenha.setBackground(new java.awt.Color(204, 255, 255));
        txtSenha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 0, 204));

        txtSenha2.setBackground(new java.awt.Color(204, 255, 255));
        txtSenha2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtSenha2.setForeground(new java.awt.Color(0, 0, 204));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411783486_icon-loop-16.png"))); // NOI18N
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411839738_icon-compose-16.png"))); // NOI18N
        jButton3.setEnabled(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411837995_icon-checkmark-16.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtNome.setBackground(new java.awt.Color(204, 255, 255));
        txtNome.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 153));

        txtTelefone.setBackground(new java.awt.Color(204, 255, 255));
        txtTelefone.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTelefone.setForeground(new java.awt.Color(0, 0, 153));

        txtCrm.setBackground(new java.awt.Color(204, 255, 255));
        txtCrm.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtCrm.setForeground(new java.awt.Color(0, 0, 153));

        txtCodigoUsuario.setBackground(new java.awt.Color(204, 255, 255));
        txtCodigoUsuario.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha)
                            .addComponent(txtUsuario)
                            .addComponent(txtSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 130, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtSenha, txtSenha2, txtUsuario});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCrm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 22)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 22)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 18)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 18)
                        .addComponent(txtSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCrm, txtNome, txtTelefone});

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

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        verificaUsurio();
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        try {
            CadastrarUsuarioMedico();
            log();
        } catch (SQLException ex) {
            Logger.getLogger(CadUsuarioMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
//        Connection con;
//        try {
//            con = ConectaBanco.conecta("bdclinica");
////            String sql = "SELECT *from consulta where nome LIKE ?";
//            String sql = "select p.nome, c.horario,c.tipo_consulta,c.sintomas,c.data_consulta from paciente p , consulta c where c.paciente_cod=p.cod and p.nome LIKE ? ";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, DetalhesConsultaPaciente.txtNomePacienteStatus.getText());
//
//            ResultSet rs = pst.executeQuery();
//           while ( rs.next()){
//            DetalhesConsultaPaciente.AreaSintomasStatus.setText(rs.getString("sintomas"));
//            DetalhesConsultaPaciente.txtHoraAtendimentoStatus.setText(rs.getString("horario"));
//        }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
//        }

    }//GEN-LAST:event_formInternalFrameOpened

    public void verificaUsurio() throws HeadlessException {
        Connection con;
        try {
//            con=null;
            con = ConectaBanco.conecta("bdclinica");
            String query = "SELECT * FROM login WHERE usuario = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, txtUsuario.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lbAlerta.setText("Login indisponível! Escolha outro.");
                lbAlerta.setForeground(Color.red);
                txtUsuario.requestFocus();
                txtUsuario.selectAll();
            } else if (rs.next() == false && !txtUsuario.getText().trim().equals("")) {
                lbAlerta.setText("Login disponível!");
                lbAlerta.setForeground(Color.blue);
            } else {
                lbAlerta.setText("Login não pode ficar em branco!");
                lbAlerta.setForeground(Color.red);
                txtUsuario.requestFocus();
                txtUsuario.selectAll();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbSetor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlerta;
    public static javax.swing.JLabel txtCodigoUsuario;
    public static javax.swing.JLabel txtCrm;
    public static javax.swing.JLabel txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenha2;
    public static javax.swing.JLabel txtTelefone;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
