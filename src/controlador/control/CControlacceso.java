/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

/**
 *
 * @author asus
 */
public class CControlacceso {
   // para controlar la entrada al software
    public int estado = 0;

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public CControlacceso() {
    }


    public int getEstado() {
        return estado;
    }

     // para controlar la salida de las tablas a traves del rol de los usuarios
    public String tipoUsuario;

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

}
