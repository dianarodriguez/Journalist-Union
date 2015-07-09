/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.control;

import java.sql.Connection;

/**
 *
 * @author Administrador
 */
public class Herramientas {

    static public boolean vocalTilde(char aChar) {
        switch (aChar) {
            case 'á':
            case 'é':
            case 'í':
            case 'ó':
            case 'ú':
            case 'ñ':
            case 'Ñ':
                return true;
        }
        return false;
    }

    static public String FormaCadenaParaJFormatter(String cadena, int CantCarAntesPunto) {

        int indice = cadena.indexOf('.');
        String cadenaAntesPunto = cadena.substring(0, indice);
        String cadenaDespuesPunto = cadena.substring(indice, cadena.length());
        int cantCeros = CantCarAntesPunto - cadenaAntesPunto.length();
        for (int i = 0; i < cantCeros; i++) {
            cadenaAntesPunto = "0".concat(cadenaAntesPunto);
        }

        return cadenaAntesPunto.concat(cadenaDespuesPunto);
    }

  /*  static public  Connection NuevaConexion(String nombrehost, String usuario, String clave) throws java.sql.SQLException {
        ConexionManejoBD cmBD = new ConexionManejoBD(nombrehost, usuario, clave);
        Connection con = cmBD.Conexion();
        return con;
    }*/
}
