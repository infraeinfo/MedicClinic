/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guias;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jhonatan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//         try {
//            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//         try {  
//            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");  
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {  
//            Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);  
//        } 
         
//                try {  
////            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");  
//                        UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {  
//            Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);  
//        } 
        //</editor-fold>
          new Autenticacao().setVisible(true);
    }
    
}
