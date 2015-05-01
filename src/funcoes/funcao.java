/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import guias.BuscaMedico;
import guias.BuscaPaciente;
import guias.CadEndereco;
import guias.InfoLaudos;
import guias.LaudosMedicos;
import guias.LogsSistema;
import guias.Sobre;
import guias.Status;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import guias.CadPacientes.*;
import static guias.CadPacientes.txtNome;
import guias.CadUsuarioMedico;
import guias.DetalhesConsultaPaciente;

/**
 *
 * @author jhonatan
 */
public class funcao {
    
    public static JFrame sistenaPrincipal;
    public static JInternalFrame cad_consulta;
    public static JInternalFrame cad_pacientes;
    public static JInternalFrame cad_medicos;
    public static JInternalFrame cad_usuarios;
    public static JInternalFrame busca_paciente;
    public static JInternalFrame busca_medico;
    public static JInternalFrame cad_endereco;
    public static JInternalFrame laudo_medico;
    public static JInternalFrame log_sistema;
    public static JInternalFrame status;
    public static JInternalFrame sobre;
    public static JInternalFrame cad_usario_medico;
    public static JInternalFrame detalhesBuscaPaciente;
    public static JFrame pre_laudos;

    //Abre o sistema na Tela Principal depois de Clicado no botão acessar
    public static void telaPrincipal() {
        if (sistenaPrincipal == null || sistenaPrincipal.isVisible() == false) {
            sistenaPrincipal = new guias.Principal();
            sistenaPrincipal.setVisible(true);
        } else {
            sistenaPrincipal.toFront();
        }
    }//telaPrincipal

    //cadastra consulta
    public static void cad_consulta() {
        if (cad_consulta == null || cad_consulta.isVisible() == false) {
            cad_consulta = new guias.CadConsulta();
            guias.Principal.centro.add(cad_consulta);
            cad_consulta.setVisible(true);
        } else {
            cad_consulta.toFront();
        }
    }//cadastra consulta

    //cadastra paciente
    public static void cad_paciente() {
        if (cad_pacientes == null || cad_pacientes.isVisible() == false) {
            cad_pacientes = new guias.CadPacientes();
            guias.Principal.centro.add(cad_pacientes);
            cad_pacientes.setVisible(true);
        } else {
            cad_pacientes.toFront();
        }
    }//cadastra paciente

    //cadastra medicos
    public static void cad_medico() {
        if (cad_medicos == null || cad_medicos.isVisible() == false) {
            cad_medicos = new guias.CadMedicos();
            guias.Principal.centro.add(cad_medicos);
            cad_medicos.setVisible(true);
        } else {
            cad_medicos.toFront();
        }
    }//cadastra medicos

    //Cadastra Usuarios ao sistema
    public static void cad_usuario() {
        if (cad_usuarios == null || cad_usuarios.isVisible() == false) {
            cad_usuarios = new guias.CadUsuario();
            guias.Principal.centro.add(cad_usuarios);
            cad_usuarios.setVisible(true);
        } else {
            cad_usuarios.toFront();
        }
    }//cadatrar usuarios ao sistema

    //Funccao para buscar paciente para ser consultados por medicos na janela (Consulta).
    public static void busca_paciente() {
        if (busca_paciente == null || busca_paciente.isVisible() == false) {
            busca_paciente = new BuscaPaciente();
            guias.Principal.centro.add(busca_paciente);
            centraliza(busca_paciente);
            busca_paciente.setVisible(true);
        } else {
            busca_paciente.toFront();
        }
    }//busca_paciente

    //Funcção para buscar Medicos para Consultar pacientes na janela (Consulta)
    public static void busca_medico() {
        if (busca_medico == null || busca_medico.isVisible() == false) {
            busca_medico = new BuscaMedico();
            guias.Principal.centro.add(busca_medico);
            centraliza(busca_medico);
            busca_medico.setVisible(true);
        } else {
            busca_medico.toFront();
        }
    }//busca_medico

    //Funcao de Cadas de Endereços para Paciente (Cadastro Pacientes)
    public static void cad_endereco() {
        if (cad_endereco == null || cad_endereco.isVisible() == false) {
            cad_endereco = new CadEndereco();//(txtNome.getText());
            guias.Principal.centro.add(cad_endereco);
            centraliza(cad_endereco);
            cad_endereco.setVisible(true);
        } else {
            cad_endereco.toFront();
        }
    }//cad endereco

    //Funcao que abre paraos medicos laudarem
    public static void laudo_medico() {
        if (laudo_medico == null || laudo_medico.isVisible() == false) {
            laudo_medico = new LaudosMedicos();
            guias.Principal.centro.add(laudo_medico);
            centraliza(laudo_medico);
            laudo_medico.setVisible(true);
        } else {
            laudo_medico.toFront();
        }
    }// LAUDO medicos

    public static void status() {
        if (status == null || status.isVisible() == false) {
            status = new Status();
            guias.Principal.centro.add(status);
            status.setVisible(true);
        } else {
            status.toFront();
        }
    }// status

    //Abre a tela Informaçoes do sistema contendo detalhes
    public static void sobre() {
        if (sobre == null || sobre.isVisible() == false) {
            sobre = new Sobre();
            guias.Principal.centro.add(sobre);
            centraliza(sobre);
            sobre.setVisible(true);
        } else {
            sobre.toFront();
        }
    }// sobre

    //Abre a tela de logs do sistema de açoes do usuarios
    public static void logsistema() {
        if (log_sistema == null || log_sistema.isVisible() == false) {
            log_sistema = new LogsSistema();
            guias.Principal.centro.add(log_sistema);
            log_sistema.setVisible(true);
        } else {
            log_sistema.toFront();
        }
    }// sobre

    //Funcão para Exibir PréLaudos de medicos tambem pode ser cadastrados aqui
    public static void preLaudos() {
        if (pre_laudos == null || pre_laudos.isVisible() == false) {
            pre_laudos = new InfoLaudos();
//            guias.Principal.centro.add(pre_laudos);
            pre_laudos.setVisible(true);
        } else {
            pre_laudos.toFront();
        }
    }
    
    public static void cad_usario_medico() {
        if (cad_usario_medico == null || cad_usario_medico.isVisible() == false) {
            cad_usario_medico = new CadUsuarioMedico();
            guias.Principal.centro.add(cad_usario_medico);
            centraliza(cad_usario_medico);
            cad_usario_medico.setVisible(true);
        } else {
            cad_usario_medico.toFront();
        }
    }
    
    public static void detalhes_paciente_Status() {
        if (detalhesBuscaPaciente == null || detalhesBuscaPaciente.isVisible() == false) {
            detalhesBuscaPaciente = new DetalhesConsultaPaciente();
            guias.Principal.centro.add(detalhesBuscaPaciente);
            centraliza(detalhesBuscaPaciente);
            detalhesBuscaPaciente.setVisible(true);
        } else {
            detalhesBuscaPaciente.toFront();
        }
    }

    //metodo para centralizar o JinternalFrame
    public static void centraliza(JInternalFrame janela) {
        // centraliza no JDesktopPane  
//        int lDesk = JFprincipal.area.getWidth();     
        int lDesk = guias.Principal.centro.getWidth();
        int aDesk = guias.Principal.centro.getHeight();
        int lIFrame = janela.getWidth();
        int aIFrame = janela.getHeight();
        
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
    }
    
}//Fecha Funcão
