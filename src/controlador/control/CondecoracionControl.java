/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.CondecoracionJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Condecoracion;

/**
 *
 * @author asus
 */
public class CondecoracionControl {
public CondecoracionControl(){

    }

    CondecoracionJpaController   control = new CondecoracionJpaController();

     public void adicionar(Condecoracion obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Condecoracion obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Condecoracion> listar(){
         return control.findCondecoracionEntities();
     }

         public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listar().size(); i++) {
             Condecoracion object = listar().get(i);
          if(object.getNombreCondec().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdCondec(String nombre){
         int id=0;
         for (int i = 0; i < listar().size(); i++) {
             Condecoracion object = listar().get(i);
          if(object.getNombreCondec().equalsIgnoreCase(nombre))   {
              id=object.getIdCondecoracion();break;
          }
         }
    return id;
     }
     public void actualizarConde(String nombre, String descripcion, int id,String tipo) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listar().size(); i++) {
          Condecoracion object = listar().get(i);
          if(object.getIdCondecoracion()==id)   {
              object.setNombreCondec(nombre);
              object.setDescripcionCondec(descripcion);
              object.setTipoCondec(tipo);

              modificar(object);
          }
     }
    }

       public Condecoracion buscarCondec(String nombre){
         Condecoracion c=new Condecoracion();
         for (int i = 0; i < listar().size(); i++) {
             Condecoracion object = listar().get(i);
          if(object.getNombreCondec().equalsIgnoreCase(nombre))   {
              c=object;break;
          }
         }
    return c;
     }
        public Condecoracion buscarCondec(int id){
         Condecoracion c=new Condecoracion();
         for (int i = 0; i < listar().size(); i++) {
             Condecoracion object = listar().get(i);
          if(object.getIdCondecoracion()==id)   {
             return object;
          }
         }
    return null;
     }
}
