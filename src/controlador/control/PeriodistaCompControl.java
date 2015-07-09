/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaComputadoraJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Computadoras;
import modelo.Periodista;
import modelo.PeriodistaComputadora;

/**
 *
 * @author asus
 */
public class PeriodistaCompControl {
public PeriodistaCompControl(){

    }

     PeriodistaComputadoraJpaController  control = new  PeriodistaComputadoraJpaController();

     public void adicionar(PeriodistaComputadora obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaComputadora obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaComputadora> listarperComp(){
         return control.findPeriodistaComputadoraEntities();
     }
       public boolean compAsignado(int idComp){
        boolean asignado=false;
         for (int i = 0; i < listarperComp().size(); i++) {
          PeriodistaComputadora object = listarperComp().get(i);
             if(object.getComputadoras().getIdPc()==idComp){
                 asignado=true;break;
             }
         }
        return asignado;
     }
  public boolean existe(int idper,int idpc){
    boolean existe=false;
         for (int i = 0; i < listarperComp().size(); i++) {
             PeriodistaComputadora object = listarperComp().get(i);
          if(object.getComputadoras().getIdPc()==idpc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
  public void actualizar(int id,Computadoras c,Periodista p) throws PreexistingEntityException, Exception{
       for (int i = 0; i < listarperComp().size(); i++) {
             PeriodistaComputadora object = listarperComp().get(i);
      if(object.getIdPerComp()==id){
          object.setComputadoras(c);
          object.setPeriodista(p);
          modificar(object);break;
      }
       }
  }
  public PeriodistaComputadora buscar(String per,String pc){
      for (int i = 0; i < listarperComp().size(); i++) {
             PeriodistaComputadora object = listarperComp().get(i);
          if(object.getComputadoras().getCodigoPc().equals(pc)
                     && object.getPeriodista().getNombrePeriodista().equals(per))
              return object;
  }
      return null;
}
  public PeriodistaComputadora buscarPCId(int id){
      for (int i = 0; i < listarperComp().size(); i++) {
             PeriodistaComputadora object = listarperComp().get(i);
          if(object.getIdPerComp()==id)
              return object;
  }
      return null;
}
}
