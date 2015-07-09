/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaPostgradoJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CursoPostgrado;
import modelo.Periodista;
import modelo.PeriodistaPostgrado;

/**
 *
 * @author asus
 */
public class PeriodistaPostgradoControl {
  public PeriodistaPostgradoControl(){

    }

    PeriodistaPostgradoJpaController   control = new  PeriodistaPostgradoJpaController();

     public void adicionar(PeriodistaPostgrado obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaPostgrado obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaPostgrado> listarPerPostgrado(){
         return control.findPeriodistaPostgradoEntities();
     }

       public boolean postgasignado(int idpostg){
        boolean asignado=false;
         for (int i = 0; i < listarPerPostgrado().size(); i++) {
          PeriodistaPostgrado  object = listarPerPostgrado().get(i);
             if(object.getCursoPostgrado().getIdPostgrado()==idpostg){
                 asignado=true;break;
             }
         }
        return asignado;
     }

           public boolean existe(int idper,int idc){
    boolean existe=false;
         for (int i = 0; i < listarPerPostgrado().size(); i++) {
             PeriodistaPostgrado object = listarPerPostgrado().get(i);
          if(object.getCursoPostgrado().getIdPostgrado()==idc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idc){
         int id=0;
         for (int i = 0; i < listarPerPostgrado().size(); i++) {
             PeriodistaPostgrado object = listarPerPostgrado().get(i);
          if(object.getCursoPostgrado().getIdPostgrado()==idc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerPostg();break;
          }
         }
    return id;
     }
     public void actualizarPerCargo(String year, Periodista p,CursoPostgrado cp, int id, String aporte,String tema,String e) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPerPostgrado().size(); i++) {
             PeriodistaPostgrado object = listarPerPostgrado().get(i);
          if(object.getIdPerPostg()==id)   {
              object.setCursoPostgrado(cp);
              object.setAportesPer(aporte);
              object.setEvaluacionPeriodista(e);
              object.setTituloPostgr(tema);
              object.setYearPostg(year);
               object.setPeriodista(p);

              modificar(object);break;
          }
     }
    }
     public PeriodistaPostgrado buscarNombre(String per,String post){
          for (int i = 0; i < listarPerPostgrado().size(); i++) {
             PeriodistaPostgrado object = listarPerPostgrado().get(i);
          if((object.getPeriodista().getNombrePeriodista().equals(per))
                     && (object.getCursoPostgrado().getTipoPostgrado().equals(post)))

          {
              return object;
          }

     }
           return null;

}

      public PeriodistaPostgrado buscarId(int id){
          for (int i = 0; i < listarPerPostgrado().size(); i++) {
             PeriodistaPostgrado object = listarPerPostgrado().get(i);
          if(object.getIdPerPostg()==id)

          {
              return object;
          }

     }
           return null;

}

}
