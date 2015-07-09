/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.GraphicsEnvironment;
import tesisupec.*;

/**
 *
 * @author asus
 */
public class Main {
  private static GraphicsEnvironment CentroPantalla() {

        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return gEnv;
    }

   public static void main(String[] args) {
        // TODO code application logic here

 AutentificarUsuario princ= new AutentificarUsuario(null, true);
        princ.setLocation(CentroPantalla().getCenterPoint().x - 250,
                CentroPantalla().getCenterPoint().y - 250);
    princ.setVisible(true);
    }
}
