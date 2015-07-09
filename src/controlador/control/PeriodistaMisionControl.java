/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaMisionJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.List;
import modelo.Mision;
import modelo.Periodista;
import modelo.PeriodistaMision;

/**
 *
 * @author asus
 */
public class PeriodistaMisionControl {
public PeriodistaMisionControl(){

    }

     PeriodistaMisionJpaController  control = new  PeriodistaMisionJpaController();

     public void adicionar(PeriodistaMision obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaMision obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaMision> listarPerMision(){
         return control.findPeriodistaMisionEntities();
     }
      public boolean misionAsigando(int ididioma){
        boolean asignado=false;
         for (int i = 0; i < listarPerMision().size(); i++) {
          PeriodistaMision   object = listarPerMision().get(i);
             if(object.getMision().getIdMision()==ididioma){
                 asignado=true;
             }
         }
        return asignado;
     }

        public boolean existe(int idper,int idm,Date fecha){
    boolean existe=false;
            for (int i = 0; i < listarPerMision().size(); i++) {
             PeriodistaMision object = listarPerMision().get(i);
          if(object.getMision().getIdMision()==idm
                     && object.getPeriodista().getIdPeriodista()==idper
                   /*  && object.getFecha().equals(fecha)*/
                                        )  {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idm){
         int id=0;
         for (int i = 0; i < listarPerMision().size(); i++) {
             PeriodistaMision object = listarPerMision().get(i);
          if(object.getMision().getIdMision()==idm
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerMision();break;
          }
         }
    return id;
     }
     public void actualizarMision(Date fecha, Periodista p,Mision m, int id,int cantmeses,String obs) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPerMision().size(); i++) {
             PeriodistaMision object = listarPerMision().get(i);
          if(object.getIdPerMision()==id)   {
           object.setCantidadMeses(cantmeses);
           object.setMision(m);
           object.setPeriodista(p);
           object.setObservaciones(obs);
              object.setFecha(fecha);
                        object.setPeriodista(p);

              modificar(object);break;
          }
     }
    }

       public PeriodistaMision buscarMisionNombre(String per,String m){
         int id=0;
         for (int i = 0; i < listarPerMision().size(); i++) {
             PeriodistaMision object = listarPerMision().get(i);
          if(object.getMision().getCodigoMision().equals(m)
                     && object.getPeriodista().getNombrePeriodista().equals(per))   {
             return object;
          }
         }
    return null;
     }

         public PeriodistaMision buscarMisionId(int id){

         for (int i = 0; i < listarPerMision().size(); i++) {
             PeriodistaMision object = listarPerMision().get(i);
          if(object.getIdPerMision()==id)   {
              return object;
          }
         }
    return null;
     }
}
