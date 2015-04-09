/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import guias.BuscaMedico;
import guias.BuscaPaciente;
import guias.CadEndereco;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

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
            cad_pacientes = new guias.CadPaciente();
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
    public static void cad_usuario(){
        if(cad_usuarios == null || cad_usuarios.isVisible()==false){
            cad_usuarios = new guias.CadUsuario();
            guias.Principal.centro.add(cad_usuarios);
            cad_usuarios.setVisible(true);
        }else{
            cad_usuarios.toFront();
        }
    }//cadatrar usuarios ao sistema
    
    //Funccao para buscar paciente para ser consultados por medicos na janela (Consulta).
    public static void busca_paciente(){
        if(busca_paciente == null || busca_paciente.isVisible()==false){
            busca_paciente=new BuscaPaciente();
            guias.Principal.centro.add(busca_paciente);
            busca_paciente.setVisible(true);
        }else{
            busca_paciente.toFront();
        }
    }//busca_paciente
    
    //Funcção para buscar Medicos para Consultar pacientes na janela (Consulta)
    public static void busca_medico(){
        if(busca_medico == null ||busca_medico.isVisible()==false){
            busca_medico=new BuscaMedico();
            guias.Principal.centro.add(busca_medico);
            busca_medico.setVisible(true);
        }else{
            busca_medico.toFront();
        }
    }//busca_medico
    
    //Funcao de Cadas de Endereços para Paciente (Cadastro Pacientes)
    public static void cad_endereco(){
        if(cad_endereco == null || cad_endereco.isVisible()==false){
            cad_endereco=new CadEndereco();
            guias.Principal.centro.add(cad_endereco);
            cad_endereco.setVisible(true);
        }else{
            cad_endereco.toFront();
        }
    }//cad endereco
    
    

}//Fecha Funcão
