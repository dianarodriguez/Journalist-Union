/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaEventoJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Evento;
import modelo.Periodista;
import modelo.PeriodistaEvento;

/**
 *
 * @author asus
 */
public class PeriodistaEventoControl {
public PeriodistaEventoControl(){

    }

      PeriodistaEventoJpaController control = new PeriodistaEventoJpaController() ;

     public void adicionar(PeriodistaEvento obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaEvento obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaEvento> listarPeriodistaEvento(){
         return control.findPeriodistaEventoEntities();
     }
        public boolean eventoAsigando(int idevento){
        boolean asignado=false;
         for (int i = 0; i < listarPeriodistaEvento().size(); i++) {
          PeriodistaEvento   object = listarPeriodistaEvento().get(i);
             if(object.getEvento().getIdEvento()==idevento){
                 asignado=true;break;
             }
         }
        return asignado;
     }
         public boolean existe(int idper,int ide){
    boolean existe=false;
         for (int i = 0; i < listarPeriodistaEvento().size(); i++) {
             PeriodistaEvento object = listarPeriodistaEvento().get(i);
          if(object.getEvento().getIdEvento()==ide
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int ide){
         int id=0;
         for (int i = 0; i < listarPeriodistaEvento().size(); i++) {
             PeriodistaEvento object = listarPeriodistaEvento().get(i);
          if(object.getEvento().getIdEvento()==ide
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerEvento();break;
          }
         }
    return id;
     }
     public void actualizarEvento(String part, Periodista p,Evento e, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPeriodistaEvento().size(); i++) {
             PeriodistaEvento object = listarPeriodistaEvento().get(i);
          if(object.getIdPerEvento()==id)   {
           object.setEvento(e);
           object.setPeriodista(p);
           object.setTipoParticipacion(part);
                        object.setPeriodista(p);

              modificar(object);break;
          }
     }
    }

      public PeriodistaEvento buscarNombre(String per,String e){

         for (int i = 0; i < listarPeriodistaEvento().size(); i++) {
             PeriodistaEvento object = listarPeriodistaEvento().get(i);
          if(object.getEvento().getNombreEvento().equals(e)
                     && object.getPeriodista().getNombrePeriodista().equals(per) )  {
             return object;
          }
         }
    return null;
     }

       public PeriodistaEvento buscarPEId(int id){

         for (int i = 0; i < listarPeriodistaEvento().size(); i++) {
             PeriodistaEvento object = listarPeriodistaEvento().get(i);
          if(object.getIdPerEvento()==id )  {
             return object;
          }
         }
    return null;
     }
}
