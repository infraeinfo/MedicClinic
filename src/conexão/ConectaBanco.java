/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jhonatan
 */
public class ConectaBanco {
        public static Connection conecta(String nomeBD)throws
    SQLException
    {
       try{
         Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection("jdbc:mysql://localhost/"+nomeBD,"tads","tads123");
       }catch(ClassNotFoundException e){
         throw new SQLException(e.getMessage()); 
       }
    }//conecta

   
}