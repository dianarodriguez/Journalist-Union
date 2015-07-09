/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.UsuarioJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author asus
 */
public class UsuarioControl {
public UsuarioControl(){

    }

      UsuarioJpaController control = new  UsuarioJpaController();

     public void adicionar(Usuario obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Usuario obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Usuario> listarUsuario(){
         return control.findUsuarioEntities();
     }

     public boolean usuarioAsigando(int idrol){
        boolean asignado=false;
         for (int i = 0; i < listarUsuario().size(); i++) {
         Usuario   object = listarUsuario().get(i);
             if(object.getRol().getIdRol()==idrol){
                 asignado=true;break;
             }
         }
        return asignado;
     }

      public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarUsuario().size(); i++) {
             Usuario object = listarUsuario().get(i);
          if(object.getNombreUsuario().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdUsuario(String nombre){
         int id=0;
         for (int i = 0; i < listarUsuario().size(); i++) {
           Usuario object = listarUsuario().get(i);
          if(object.getNombreUsuario().equalsIgnoreCase(nombre))   {
              id=object.getIdUsuario();break;
          }
         }
    return id;
     }
     public void actualizarUsuario(String nombre, int id,String nombreu,String ci, String correo,Rol rol,String direcc) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarUsuario().size(); i++) {
       Usuario object = listarUsuario().get(i);
          if(object.getIdUsuario()==id)   {
              object.setNombre(nombre);
              object.setCiUsuario(ci);
              object.setCorreo(correo);
              object.setDireccion(direcc);
             object.setNombreUsuario(nombreu);
             object.setRol(rol);
               modificar(object);break;
          }
     }
    }
         public Usuario buscarUsuario(String nombre){
       Usuario u=new Usuario();
         for (int i = 0; i < listarUsuario().size(); i++) {
           Usuario object = listarUsuario().get(i);
          if(object.getNombreUsuario().equalsIgnoreCase(nombre))   {
              u=object;break;
          }
         }
    return u;
     }
         public boolean verificarUsuario(String nombreu,String pass){
             boolean existe=false;
             for (int i = 0; i < listarUsuario().size(); i++) {
                 Usuario object = listarUsuario().get(i);
                 if(object.getNombreUsuario().equals(nombreu)
                         && object.getLogueado().compareTo(pass)==0){
                      existe=true;break;
                 }

             }
             return existe;
         }



          public void modificarPass(String nombreu,String pass) throws PreexistingEntityException, Exception{

             for (int i = 0; i < listarUsuario().size(); i++) {
                 Usuario object = listarUsuario().get(i);
                 if(object.getNombreUsuario().equals(nombreu))
                        {
                     object.setLogueado(pass);
                    modificar(object);
                 }

             }

         }
           public Usuario buscarUsuario(int id){
       Usuario u=new Usuario();
         for (int i = 0; i < listarUsuario().size(); i++) {
           Usuario object = listarUsuario().get(i);
          if(object.getIdUsuario()==id)   {
              return object;
          }
         }
    return null;
     }
}
