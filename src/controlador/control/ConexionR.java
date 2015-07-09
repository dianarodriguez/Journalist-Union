/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class ConexionR {
   Statement stmt;
    Connection con;

public ConexionR(){
    super();
}

 public boolean hacer_conexion(){
 String url = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"bd_upec";
 try{Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","root+123/*-");
         return true;
      }catch(Exception se){
	   JOptionPane.showMessageDialog(null, se.getMessage());
               return false;
	   }
    }
public Connection getCon() {
      return con;
    }
}
