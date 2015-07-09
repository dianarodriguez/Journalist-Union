/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author asus
 */
public class EncriptarClave {
 public static String encriptarMD5(String password) throws NoSuchAlgorithmException
        {
           char[] HEXADECIMAL = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                                  '9', 'a', 'b', 'c', 'd', 'e', 'f' };
           MessageDigest md = MessageDigest.getInstance("MD5");
           byte[] bytes = md.digest(password.getBytes());
           StringBuilder sb = new StringBuilder(2 * bytes.length);
           for (int i = 0; i < bytes.length; i++)
           {
              int low = (int)(bytes[i] & 0x0f);
              int high = (int)((bytes[i] & 0xf0) >> 4);
              sb.append(HEXADECIMAL[high]);
              sb.append(HEXADECIMAL[low]);
           }
           password=sb.toString();
           return password;
        }
}
