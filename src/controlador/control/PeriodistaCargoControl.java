/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaCargopJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.List;
import modelo.CargoPeriodistico;
import modelo.Periodista;
import modelo.PeriodistaCargop;

/**
 *
 * @author asus
 */
public class PeriodistaCargoControl {
public PeriodistaCargoControl(){

    }

      PeriodistaCargopJpaController control = new  PeriodistaCargopJpaController();

     public void adicionar(PeriodistaCargop obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaCargop obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaCargop> listarPerCargoP(){
         return control.findPeriodistaCargopEntities();
     }

     public boolean cargoasigando(int idcargo){
        boolean asignado=false;
         for (int i = 0; i < listarPerCargoP().size(); i++) {
          PeriodistaCargop    object = listarPerCargoP().get(i);
             if(object.getCargoPeriodistico().getIdCargop()==idcargo){
                 asignado=true;break;
             }
         }
        return asignado;
     }
        public boolean existe(int idper,int idcargo){
    boolean existe=false;
         for (int i = 0; i < listarPerCargoP().size(); i++) {
             PeriodistaCargop object = listarPerCargoP().get(i);
          if(object.getCargoPeriodistico().getIdCargop()==idcargo
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idcargo){
         int id=0;
         for (int i = 0; i < listarPerCargoP().size(); i++) {
             PeriodistaCargop object = listarPerCargoP().get(i);
          if(object.getCargoPeriodistico().getIdCargop()==idcargo
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerCargo();break;
          }
         }
    return id;
     }
     public void actualizarPerCargo(Date fecha, Periodista p,CargoPeriodistico cp, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPerCargoP().size(); i++) {
             PeriodistaCargop object = listarPerCargoP().get(i);
          if(object.getIdPerCargo()==id)   {
              object.setCargoPeriodistico(cp);
              object.setFecha(fecha);
                        object.setPeriodista(p);

              modificar(object);break;
          }
     }
    }
     public PeriodistaCargop buscarporId(int id){
          for (int i = 0; i < listarPerCargoP().size(); i++) {
             PeriodistaCargop object = listarPerCargoP().get(i);
             if(object.getIdPerCargo()==id)
                 return object;
         }
          return null;
     }
public PeriodistaCargop buscarNombre(String nombrep,String nombrec){
     for (int i = 0; i < listarPerCargoP().size(); i++) {
             PeriodistaCargop object = listarPerCargoP().get(i);
             if(object.getPeriodista().getNombrePeriodista().equals(nombrep)
                     &&object.getCargoPeriodistico().getNombreCargop().equals(nombrec))
                 return object;
}
     return null;
}
}
