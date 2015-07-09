/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaPremioJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.List;
import modelo.Periodista;
import modelo.PeriodistaPremio;
import modelo.Premio;

/**
 *
 * @author asus
 */
public class PeriodistaPremioControl {
public PeriodistaPremioControl(){

    }

      PeriodistaPremioJpaController control = new PeriodistaPremioJpaController() ;

     public void adicionar(PeriodistaPremio obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaPremio obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaPremio> listarPerPremio(){
         return control.findPeriodistaPremioEntities();
     }
      public boolean premioAsigando(int idpremio){
        boolean asignado=false;
         for (int i = 0; i < listarPerPremio().size(); i++) {
          PeriodistaPremio    object = listarPerPremio().get(i);
             if(object.getPremio().getIdPremio()==idpremio){
                 asignado=true;break;
             }
         }
        return asignado;
     }
       public boolean existe(int idper,int idp,String proypremiado,String posicion){
    boolean existe=false;
         for (int i = 0; i < listarPerPremio().size(); i++) {
             PeriodistaPremio object = listarPerPremio().get(i);
          if(object.getPremio().getIdPremio()==idp
                     && object.getPeriodista().getIdPeriodista()==idper
                     && object.getProyectoPremiado().equals(proypremiado)
                     && object.getPosicionPremio().equals(posicion))   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idp){
         int id=0;
         for (int i = 0; i < listarPerPremio().size(); i++) {
             PeriodistaPremio object = listarPerPremio().get(i);
          if(object.getPremio().getIdPremio()==idp
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerPremio();break;
          }
         }
    return id;
     }
     public void actualizarPerCargo(Date fecha, Periodista p,Premio pre, int id,String opinion,String estimulo,String proyectopremiado,String posicion) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPerPremio().size(); i++) {
             PeriodistaPremio object = listarPerPremio().get(i);
          if(object.getIdPerPremio()==id)   {
             object.setEstimulo(estimulo);
             object.setOpinion(opinion);
             object.setPeriodista(p);
             object.setPosicionPremio(posicion);
             object.setPremio(pre);
             object.setProyectoPremiado(proyectopremiado);
              object.setFecha(fecha);
                        object.setPeriodista(p);

              modificar(object);break;
          }
     }
    }

      public PeriodistaPremio buscarPNombre(String per,String p){

         for (int i = 0; i < listarPerPremio().size(); i++) {
             PeriodistaPremio object = listarPerPremio().get(i);
          if(object.getPremio().getNombrePremio().equals(p)
                     && object.getPeriodista().getNombrePeriodista().equals(per))   {
             return object;
          }
         }
    return null;
     }
 public PeriodistaPremio buscarPId(int id){

         for (int i = 0; i < listarPerPremio().size(); i++) {
             PeriodistaPremio object = listarPerPremio().get(i);
          if(object.getIdPerPremio()==id)   {
             return object;
          }
         }
    return null;
     }
}
