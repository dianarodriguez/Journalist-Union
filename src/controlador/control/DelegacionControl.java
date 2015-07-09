/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.DelegacionJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Delegacion;

/**
 *
 * @author asus
 */
public class DelegacionControl {
public DelegacionControl(){

    }

    DelegacionJpaController   control = new DelegacionJpaController() ;

     public void adicionar(Delegacion obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Delegacion obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Delegacion> listarDelegacion(){
         return control.findDelegacionEntities();
     }
      public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarDelegacion().size(); i++) {
            Delegacion object = listarDelegacion().get(i);
          if(object.getNombreDeleg().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdDeleg(String nombre){
         int id=0;
         for (int i = 0; i < listarDelegacion().size(); i++) {
            Delegacion object = listarDelegacion().get(i);
          if(object.getNombreDeleg().equalsIgnoreCase(nombre))   {
              id=object.getIdDelegacion();break;
          }
         }
    return id;
     }
     public void actualizarDeleg(String nombre, String descripcion, int id,String direcc,String year) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarDelegacion().size(); i++) {
         Delegacion object = listarDelegacion().get(i);
          if(object.getIdDelegacion()==id)   {
              object.setNombreDeleg(nombre);
              object.setDescripcionDeleg(descripcion);
              object.setDireccionDeleg(direcc);
              object.setYearFundada(year);
              modificar(object);
          }
     }
    }

       public Delegacion buscaDeleg(String nombre){

         Delegacion d=new Delegacion();
         for (int i = 0; i < listarDelegacion().size(); i++) {
            Delegacion object = listarDelegacion().get(i);
          if(object.getNombreDeleg().equalsIgnoreCase(nombre))   {
              d=object;break;
          }
         }
    return d;
     }

         public Delegacion buscaDelegId(int id){

         Delegacion d=new Delegacion();
         for (int i = 0; i < listarDelegacion().size(); i++) {
            Delegacion object = listarDelegacion().get(i);
          if(object.getIdDelegacion()==id)   {
              return object;
          }
         }
    return null;
     }
}
