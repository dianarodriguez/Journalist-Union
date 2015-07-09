/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.RolJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Rol;

/**
 *
 * @author asus
 */
public class RolControl {
public RolControl(){

    }

    RolJpaController   control = new RolJpaController() ;

     public void adicionar(Rol obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Rol obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Rol> listarRol(){
         return control.findRolEntities();
     }

      public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarRol().size(); i++) {
             Rol object = listarRol().get(i);
          if(object.getNombreRol().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdRol(String nombre){
         int id=0;
         for (int i = 0; i < listarRol().size(); i++) {
           Rol object = listarRol().get(i);
          if(object.getNombreRol().equalsIgnoreCase(nombre))   {
              id=object.getIdRol();break;
          }
         }
    return id;
     }
     public void actualizarRol(String nombre, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarRol().size(); i++) {
        Rol object = listarRol().get(i);
          if(object.getIdRol()==id)   {
              object.setNombreRol(nombre);
               modificar(object);break;
          }
     }
    }
     public Rol buscarRol(String nombre){
         Rol r = new Rol();
           for (int i = 0; i < listarRol().size(); i++) {
           Rol object = listarRol().get(i);
          if(object.getNombreRol().equalsIgnoreCase(nombre))   {
             r=object;break;
          }
         }
         return r;
     }
       public Rol buscarRolId(int id){
         Rol r = new Rol();
           for (int i = 0; i < listarRol().size(); i++) {
           Rol object = listarRol().get(i);
          if(object.getIdRol()==id)   {
             return object;
          }
         }
         return null;
     }
}
