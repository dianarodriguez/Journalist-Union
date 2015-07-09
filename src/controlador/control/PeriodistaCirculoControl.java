/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaCirculoJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.List;
import modelo.CirculoEspecial;
import modelo.Periodista;
import modelo.PeriodistaCirculo;

/**
 *
 * @author asus
 */
public class PeriodistaCirculoControl {
public PeriodistaCirculoControl(){

    }

     PeriodistaCirculoJpaController  control = new  PeriodistaCirculoJpaController();

     public void adicionar(PeriodistaCirculo obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaCirculo obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaCirculo> listarPerCirculo(){
         return control.findPeriodistaCirculoEntities();
     }
       public boolean circuloAsigando(int idcirculo){
        boolean asignado=false;
         for (int i = 0; i < listarPerCirculo().size(); i++) {
          PeriodistaCirculo    object = listarPerCirculo().get(i);
             if(object.getCirculoEspecial().getIdCirculoe()==idcirculo){
                 asignado=true;break;
             }
         }
        return asignado;
     }
        public boolean existe(int idper,int idc){
    boolean existe=false;
         for (int i = 0; i < listarPerCirculo().size(); i++) {
             PeriodistaCirculo object = listarPerCirculo().get(i);
          if(object.getCirculoEspecial().getIdCirculoe()==idc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
          public int buscarId(int idper,int idc){
         int id=0;
         for (int i = 0; i < listarPerCirculo().size(); i++) {
             PeriodistaCirculo object = listarPerCirculo().get(i);
          if(object.getCirculoEspecial().getIdCirculoe()==idc
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerCirculo();break;
          }
         }
    return id;
     }
     public void actualizarPC(Date fecha, Periodista p,CirculoEspecial ce, int id,String cp) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPerCirculo().size(); i++) {
             PeriodistaCirculo object = listarPerCirculo().get(i);
          if(object.getIdPerCirculo()==id)   {
              object.setCargoPeriodista(cp);
              object.setFecha(fecha);
              object.setCirculoEspecial(ce);
              object.setPeriodista(p);


              modificar(object);break;
          }
     }
    }
     public PeriodistaCirculo buscarNombre(String per,String c){
           for (int i = 0; i < listarPerCirculo().size(); i++) {
             PeriodistaCirculo object = listarPerCirculo().get(i);
          if(object.getCirculoEspecial().getNombreCirculo().equals(c)&&
                     object.getPeriodista().getNombrePeriodista().equals(per))   {
              return object;
          }
     }
            return null;
    }
 public PeriodistaCirculo buscarId(int id){
           for (int i = 0; i < listarPerCirculo().size(); i++) {
             PeriodistaCirculo object = listarPerCirculo().get(i);
          if(object.getIdPerCirculo()==id)   {
              return object;
          }
     }
            return null;
    }
}
