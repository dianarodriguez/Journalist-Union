/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaCondecoracionJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Condecoracion;
import modelo.Periodista;
import modelo.PeriodistaCondecoracion;

/**
 *
 * @author asus
 */
public class PeriodistaCondecControl {
public PeriodistaCondecControl(){

    }

     PeriodistaCondecoracionJpaController  control = new PeriodistaCondecoracionJpaController() ;

     public void adicionar(PeriodistaCondecoracion obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaCondecoracion obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaCondecoracion> listarPerCondec(){
         return control.findPeriodistaCondecoracionEntities();
     }
      public boolean condecasigando(int idcateg){
        boolean asignado=false;
         for (int i = 0; i < listarPerCondec().size(); i++) {
          PeriodistaCondecoracion    object = listarPerCondec().get(i);
             if(object.getCondecoracion().getIdCondecoracion()==idcateg){
                 asignado=true;break;
             }
         }
        return asignado;
     }
       public boolean existe(int idper,int idc){
    boolean existe=false;
         for (int i = 0; i < listarPerCondec().size(); i++) {
             PeriodistaCondecoracion object = listarPerCondec().get(i);
          if(object.getCondecoracion().getIdCondecoracion()==idc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idc){
         int id=0;
         for (int i = 0; i < listarPerCondec().size(); i++) {
             PeriodistaCondecoracion object = listarPerCondec().get(i);
          if(object.getCondecoracion().getIdCondecoracion()==idc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerCondec();break;
          }
         }
    return id;
     }
     public void actualizarPerC(String year, Periodista p,Condecoracion c, int id,String just) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPerCondec().size(); i++) {
             PeriodistaCondecoracion object = listarPerCondec().get(i);
          if(object.getIdPerCondec()==id)   {
             object.setCondecoracion(c);
             object.setJustificacion(just);
             object.setPeriodista(p);
             object.setYearCondec(year);
                        object.setPeriodista(p);

              modificar(object);break;
          }
     }
    }
     public PeriodistaCondecoracion buscarId(int id){
          for (int i = 0; i < listarPerCondec().size(); i++) {
             PeriodistaCondecoracion object = listarPerCondec().get(i);
          if(object.getIdPerCondec()==id)   {
              return object;
          }

     }
           return null;
}
     public PeriodistaCondecoracion buscarNombre(String per,String cond){
          for (int i = 0; i < listarPerCondec().size(); i++) {
             PeriodistaCondecoracion object = listarPerCondec().get(i);
          if((object.getPeriodista().getNombrePeriodista().equals(per))
                     && (object.getCondecoracion().getNombreCondec().equals(cond)))   {
              return object;
          }
            
     }
           return null;
}

}
