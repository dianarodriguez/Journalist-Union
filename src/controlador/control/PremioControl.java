/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PremioJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Premio;

/**
 *
 * @author asus
 */
public class PremioControl {
public PremioControl(){

    }

    PremioJpaController   control = new  PremioJpaController();

     public void adicionar(Premio obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Premio obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Premio> listarPremio(){
         return control.findPremioEntities();
     }
          public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarPremio().size(); i++) {
             Premio object = listarPremio().get(i);
          if(object.getNombrePremio().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdPremio(String nombre){
         int id=0;
         for (int i = 0; i < listarPremio().size(); i++) {
           Premio object = listarPremio().get(i);
          if(object.getNombrePremio().equalsIgnoreCase(nombre))   {
              id=object.getIdPremio();break;
          }
         }
    return id;
     }
     public void actualizarPremio(String nombre, String descripcion, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPremio().size(); i++) {
         Premio object = listarPremio().get(i);
          if(object.getIdPremio()==id)   {
              object.setNombrePremio(nombre);
              object.setDescripcionPremio(descripcion);


              modificar(object);break;
          }
     }
    }
           public Premio buscarPremio(String nombre){
       Premio p=new Premio();
         for (int i = 0; i < listarPremio().size(); i++) {
           Premio object = listarPremio().get(i);
          if(object.getNombrePremio().equalsIgnoreCase(nombre))   {
              p=object;break;
          }
         }
    return p;
     }
            public Premio buscarPremiId(int id){
       Premio p=new Premio();
         for (int i = 0; i < listarPremio().size(); i++) {
           Premio object = listarPremio().get(i);
          if(object.getIdPremio()==id)   {
             return object;
          }
         }
    return null;
     }
}
