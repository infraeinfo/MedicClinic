/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guias;

import com.toedter.calendar.JDateChooser;
import conexão.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonatan
 */
public class CadPacientes extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;

    /**
     * Creates new form CadPaciente
     */
    public CadPacientes() {
        initComponents();
    }

    public static String codEndereco;

    public String AlteraPaciente() throws SQLException {
//        Connection con;

        con = ConectaBanco.conecta("bdclinica");
//        String sql = "select * from logradouro Where cep='" +txtBuscaCep+ "'";
        String sql = "update paciente set nome=?,rg=?,cpf=?,telefone=?,celular=?,data_nasc=?,estado_civil=?,tipo_sangue=?,altura=?,peso=?,logradouro_cod=? where cod=?";
//        try (PreparedStatement pst = con.prepareStatement(sql)) {
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtRg.getText());
            pst.setString(3, txtCpf.getText());
            pst.setString(4, txtTelefone.getText());
            pst.setString(5, txtCelular.getText());
            pst.setString(6, dataNasci.getDate().toString());
            pst.setString(7, cbEstadoCivil.getSelectedItem().toString());
            pst.setString(8, cbTipoSangue.getSelectedItem().toString());
            pst.setString(9, txtAltura.getText());
            pst.setString(10, txtPeso.getText());
            pst.setString(11, txtCodEndereco.getText());
            pst.setString(12, lbCodigoPaciente.getText());

            //pst.executeUpdate();
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sucesso na Alteração!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
                return "Alterado com sucesso.";
//                return JOptionPane.showMessageDialog(null, "Sucesso na Alteração!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao Alterar!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
                return "Erro ao alterar";
//                JOptionPane.showMessageDialog(null, "Falha ao Alterar!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
            }
//            pst.close();
//            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!", "Cadastrar Pacientes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Descrição do Erro! " + error.getMessage());
        }
        return null;
    }

    public void buscaCPF() throws SQLException {
        Connection con;

        try {
            con = ConectaBanco.conecta("bdclinica");
            String sql = "select * from paciente Where cpf LIKE ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, txtCpf.getText());
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    txtNome.setText(rs.getString("Nome"));
                    txtRg.setText(rs.getString("rg"));
                    txtCpf.requestFocus();
                    txtTelefone.setText(rs.getString("telefone"));
                    txtCelular.setText(rs.getString("celular"));
                    dataNasci.setDateFormatString(rs.getString("data_nasc"));
                    cbEstadoCivil.setSelectedItem(rs.getString("estado_civil"));
                    cbTipoSangue.setSelectedItem(rs.getString("tipo_sangue"));
                    txtAltura.setText(rs.getString("altura"));
                    txtPeso.setText(rs.getString("peso"));
                    txtCodEndereco.setText(rs.getString("logradouro_cod"));
                    lbCodigoPaciente.setText(rs.getString("cod"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }

    }

    //Insert no banco
    public void cadastrarPacientes() throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = simpleDateFormat.format(this.dataNasci.getDate());
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into paciente (nome,rg,cpf,telefone,celular,data_nasc,estado_civil,tipo_sangue,altura,peso,logradouro_cod)"
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtRg.getText());
            pst.setString(3, txtCpf.getText());
            pst.setString(4, txtTelefone.getText());
            pst.setString(5, txtCelular.getText());
            pst.setString(6, dataFormatada);
            pst.setString(7, cbEstadoCivil.getSelectedItem().toString());
            pst.setString(8, cbTipoSangue.getSelectedItem().toString());
            pst.setString(9, txtAltura.getText());
            pst.setString(10, txtPeso.getText());
            pst.setString(11, txtCodEndereco.getText());

            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!", "Cadastrar Pacientes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Descrição do Erro! " + error.getMessage());
        }
    }

    public void log() throws SQLException {
        String CadtroPaciente;
        con = ConectaBanco.conecta("bdclinica");
        String sql = "Insert into log (acao,data,login_cod)"
                + "values ('cadastro de Pacientes',current_timestamp,?)";
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

    public void LimparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtAltura.setText("");
        txtCelular.setText("");
        txtRg.setText("");
        dataNasci.setDate(null);
        txtCodEndereco.setText("");
        txtPeso.setText("");
        txtTelefone.setText("");
        cbEstadoCivil.setSelectedIndex(0);
        cbTipoSangue.setSelectedIndex(0);
        txtNome.requestFocus();
    }

    //Fim inserts no banco
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        cbTipoSangue = new javax.swing.JComboBox();
        cbEstadoCivil = new javax.swing.JComboBox();
        dataNasci = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSalvarCadPacientes = new javax.swing.JButton();
        btnAbreLogradouro = new javax.swing.JButton();
        txtCodEndereco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lbCodigoPaciente = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Pacientes\n");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411838523_icon-close-round-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome Completo:");

        jLabel2.setText("RG:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Celular");

        jLabel6.setText("Data Nasc.:");

        jLabel7.setText("Estado Civil:");

        jLabel8.setText("Tipo de Sangue:");

        jLabel9.setText("Altura:");

        jLabel10.setText("Peso KG:");

        txtPeso.setBackground(new java.awt.Color(204, 255, 255));
        txtPeso.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPeso.setForeground(new java.awt.Color(0, 0, 204));

        txtAltura.setBackground(new java.awt.Color(204, 255, 255));
        txtAltura.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtAltura.setForeground(new java.awt.Color(0, 0, 204));

        txtCelular.setBackground(new java.awt.Color(204, 255, 255));
        txtCelular.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCelular.setForeground(new java.awt.Color(0, 0, 204));

        txtTelefone.setBackground(new java.awt.Color(204, 255, 255));
        txtTelefone.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTelefone.setForeground(new java.awt.Color(0, 0, 204));

        txtCpf.setBackground(new java.awt.Color(204, 255, 255));
        txtCpf.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCpf.setForeground(new java.awt.Color(0, 0, 204));

        txtRg.setBackground(new java.awt.Color(204, 255, 255));
        txtRg.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtRg.setForeground(new java.awt.Color(0, 0, 204));

        txtNome.setBackground(new java.awt.Color(204, 255, 255));
        txtNome.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 204));

        cbTipoSangue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<selecione>", "A+", "A-", "B+", "B-", "O-", "O+", "AB" }));

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<selecione>", "Casado(A)", "Solteiro(A)", "Divorciado(A)", "Viuvo(A)", "União Estavél" }));

        dataNasci.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411783486_icon-loop-16.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411839738_icon-compose-16.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSalvarCadPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411837995_icon-checkmark-16.png"))); // NOI18N
        btnSalvarCadPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadPacientesActionPerformed(evt);
            }
        });

        btnAbreLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411763221_map.png"))); // NOI18N
        btnAbreLogradouro.setText("Cadastrar End.");
        btnAbreLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbreLogradouroActionPerformed(evt);
            }
        });

        txtCodEndereco.setEditable(false);
        txtCodEndereco.setBackground(new java.awt.Color(204, 255, 255));
        txtCodEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodEndereco.setForeground(new java.awt.Color(0, 0, 204));
        txtCodEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEnderecoActionPerformed(evt);
            }
        });

        jLabel11.setText("Cod. Endereco");

        jButton4.setText("B");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lbCodigoPaciente.setBackground(new java.awt.Color(255, 255, 255));
        lbCodigoPaciente.setForeground(new java.awt.Color(102, 204, 255));
        lbCodigoPaciente.setText("codigo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                            .addComponent(txtRg, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCodigoPaciente))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCodEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAbreLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel6)
                                    .addGap(0, 0, 0)
                                    .addComponent(dataNasci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbTipoSangue, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAltura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvarCadPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(12, 12, 12))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSalvarCadPacientes, jButton1, jButton2, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(lbCodigoPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAbreLogradouro))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dataNasci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbTipoSangue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnSalvarCadPacientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSalvarCadPacientes, jButton1, jButton2, jButton3});

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAbreLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbreLogradouroActionPerformed
        funcoes.funcao.cad_endereco();
        CadEndereco.txtBuscaCep.requestFocus();
        //metodos que enviam e recebe informaçoes de outra form.
        CadEndereco.nomePaciente = txtNome.getText();
        CadEndereco.txtNomePaciente.setText(txtNome.getText());
        CadEndereco.codEnd = txtCodEndereco.getText();
        CadEndereco.txtCodEnde.setText(txtCodEndereco.getText());

    }//GEN-LAST:event_btnAbreLogradouroActionPerformed

    private void btnSalvarCadPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadPacientesActionPerformed
        if (!"".equals(txtCodEndereco.getText())) {
            //digite aqui a instrução se o campo for NÃO vazio e NÃO nulo. 
            try {
                cadastrarPacientes();
                log();
                LimparCampos();
            } catch (SQLException ex) {
                Logger.getLogger(CadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //digite aqui a intrução para quando o campo FOR vazio ou FOR nulo  
            JOptionPane.showMessageDialog(null, "Campo Codigo endereco Vazio! Favor Cadastrar END.");
        }
    }//GEN-LAST:event_btnSalvarCadPacientesActionPerformed

    private void txtCodEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodEnderecoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimparCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            buscaCPF();
        } catch (SQLException ex) {
            Logger.getLogger(CadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            AlteraPaciente();
        } catch (SQLException ex) {
            Logger.getLogger(CadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbreLogradouro;
    private javax.swing.JButton btnSalvarCadPacientes;
    private javax.swing.JComboBox cbEstadoCivil;
    private javax.swing.JComboBox cbTipoSangue;
    private com.toedter.calendar.JDateChooser dataNasci;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodigoPaciente;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCodEndereco;
    private javax.swing.JTextField txtCpf;
    public static javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
