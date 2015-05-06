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
public class DetalhesConsultaPaciente extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;

    /**
     * Creates new form cadVendas
     */
    public DetalhesConsultaPaciente() {
        initComponents();
    }
    public static String codConsulta;
    public static String nomePaciente;

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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaSintomasStatus = new javax.swing.JTextArea();
        txtNomePacienteStatus = new javax.swing.JLabel();
        lbTipoConsulta = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNomeMedicoConsulta = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        codMedicoConsulta = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTipoConuslta = new javax.swing.JComboBox();
        lbIdConsulta = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Detalhes de Triagem de Pacientes\n");
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
        jButton1.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Nome Paciente:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Tipo de Consulta:");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Sintomas:");

        AreaSintomasStatus.setEditable(false);
        AreaSintomasStatus.setBackground(new java.awt.Color(204, 255, 255));
        AreaSintomasStatus.setColumns(20);
        AreaSintomasStatus.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        AreaSintomasStatus.setForeground(new java.awt.Color(0, 0, 153));
        AreaSintomasStatus.setRows(5);
        jScrollPane1.setViewportView(AreaSintomasStatus);

        txtNomePacienteStatus.setBackground(new java.awt.Color(204, 255, 255));
        txtNomePacienteStatus.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtNomePacienteStatus.setForeground(new java.awt.Color(0, 0, 153));

        lbTipoConsulta.setBackground(new java.awt.Color(204, 255, 255));
        lbTipoConsulta.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lbTipoConsulta.setForeground(new java.awt.Color(0, 0, 153));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411839738_icon-compose-16.png"))); // NOI18N
        jButton2.setText("Alterar Consulta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Medico:");

        txtNomeMedicoConsulta.setBackground(new java.awt.Color(204, 255, 255));
        txtNomeMedicoConsulta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNomeMedicoConsulta.setForeground(new java.awt.Color(0, 0, 153));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1411783471_icon-ios7-search-strong-16.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        codMedicoConsulta.setBackground(new java.awt.Color(255, 255, 255));
        codMedicoConsulta.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        codMedicoConsulta.setForeground(new java.awt.Color(255, 255, 255));
        codMedicoConsulta.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de Consulta:");

        cbTipoConuslta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<selecione>", "4 - Grave", "5 - Padrão", "6 - Urgente" }));
        cbTipoConuslta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoConusltaActionPerformed(evt);
            }
        });

        lbIdConsulta.setBackground(new java.awt.Color(255, 255, 255));
        lbIdConsulta.setForeground(new java.awt.Color(255, 255, 255));
        lbIdConsulta.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNomePacienteStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtNomeMedicoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbTipoConuslta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(100, 100, 100)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbIdConsulta)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(codMedicoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbTipoConsulta, txtNomePacienteStatus});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomePacienteStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbTipoConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNomeMedicoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codMedicoConsulta))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbTipoConuslta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIdConsulta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbTipoConsulta, txtNomePacienteStatus});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

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

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        funcoes.funcao.busca_medicoAlteraConsulta();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbTipoConusltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoConusltaActionPerformed
        switch (cbTipoConuslta.getSelectedIndex()) {
            case 0:
                //                JOptionPane.showMessageDialog(null, "Case 0");
                break;
            case 1:
                //                JOptionPane.showMessageDialog(null, "Case 1");
                AreaSintomasStatus.setText("4 - Grave\nConstantes vômitos,\nDores no corpo,\nManchas vermelhas na parte inferior do braço e febre alta.\n" + "");
                break;
            case 2:
                //                JOptionPane.showMessageDialog(null, "Case 2");
                AreaSintomasStatus.setText("5 - Padrão\nDores na garganta,\nFebre alta,\nFraqueza quando caminha." + "");
                break;
            case 3:
                //                JOptionPane.showMessageDialog(null, "Case 3");
                AreaSintomasStatus.setText("6 - Urgente\nDores no coração,\nManchas avermelhadas no braço direito,\nFalta de ar e aparenta pressão alta." + "");
                break;
        }
    }//GEN-LAST:event_cbTipoConusltaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            con = ConectaBanco.conecta("bdclinica");

            String sql = "update consulta set medico_cod=?,tipo_consulta=?,sintomas=? where idconsulta=?";

            pst = con.prepareStatement(sql);
            pst.setString(1, codMedicoConsulta.getText());
            pst.setString(2, cbTipoConuslta.getSelectedItem().toString());
            pst.setString(3, AreaSintomasStatus.getText());
            pst.setString(4, lbIdConsulta.getText());
            
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sucesso na Alteração!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
//                return "Alterado com sucesso.";
//                return JOptionPane.showMessageDialog(null, "Sucesso na Alteração!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao Alterar!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
//                return "Erro ao alterar";
//                JOptionPane.showMessageDialog(null, "Falha ao Alterar!", "Alterar Pacientes", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalhesConsultaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea AreaSintomasStatus;
    public static javax.swing.JComboBox cbTipoConuslta;
    public static javax.swing.JLabel codMedicoConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbIdConsulta;
    public static javax.swing.JLabel lbTipoConsulta;
    public static javax.swing.JTextField txtNomeMedicoConsulta;
    public static javax.swing.JLabel txtNomePacienteStatus;
    // End of variables declaration//GEN-END:variables
}
