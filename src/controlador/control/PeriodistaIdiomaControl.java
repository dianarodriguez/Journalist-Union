/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaIdiomaJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Idioma;
import modelo.Periodista;
import modelo.PeriodistaIdioma;

/**
 *
 * @author asus
 */
public class PeriodistaIdiomaControl {
public PeriodistaIdiomaControl(){

    }

      PeriodistaIdiomaJpaController control = new PeriodistaIdiomaJpaController()  ;

     public void adicionar(PeriodistaIdioma obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaIdioma obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaIdioma> listarPeriodistaIdioma(){
         return control.findPeriodistaIdiomaEntities();
     }
       public boolean idiomaAsigando(int ididioma){
        boolean asignado=false;
         for (int i = 0; i < listarPeriodistaIdioma().size(); i++) {
          PeriodistaIdioma    object = listarPeriodistaIdioma().get(i);
             if(object.getIdioma().getIdIdioma()==ididioma){
                 asignado=true;
             }
         }
        return asignado;
     }
             public boolean existe(int idper,int idi){
    boolean existe=false;
         for (int i = 0; i < listarPeriodistaIdioma().size(); i++) {
             PeriodistaIdioma object = listarPeriodistaIdioma().get(i);
          if(object.getIdioma().getIdIdioma()==idi
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idi){
         int id=0;
         for (int i = 0; i < listarPeriodistaIdioma().size(); i++) {
             PeriodistaIdioma object = listarPeriodistaIdioma().get(i);
          if(object.getIdioma().getIdIdioma()==idi
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPerIdioma();break;
          }
         }
    return id;
     }
     public void actualizarPerIdioma(String nivel, Periodista p,Idioma idi, int id,String habla,String lee,String escribe) throws PreexistingEntityException, Exception{
            for (int i = 0; i < listarPeriodistaIdioma().size(); i++) {
             PeriodistaIdioma object = listarPeriodistaIdioma().get(i);
             if(object.getIdPerIdioma()==id){
                 object.setEscribe(escribe);
                 object.setHabla(habla);
                 object.setLee(lee);
                 object.setNivel(nivel);
                 object.setPeriodista(p);
                 object.setIdioma(idi);
                 modificar(object);break;
             }

         }
    }
     public PeriodistaIdioma buscarIdiomaNombre(String per,String idi){
         int id=0;
         for (int i = 0; i < listarPeriodistaIdioma().size(); i++) {
             PeriodistaIdioma object = listarPeriodistaIdioma().get(i);
          if(object.getIdioma().getNombreIdioma().equals(idi)
                     && object.getPeriodista().getNombrePeriodista().equals(per))   {
            return object;
          }
         }
    return null;
     }

     public PeriodistaIdioma buscarIdiomaId(int idi){
         int id=0;
         for (int i = 0; i < listarPeriodistaIdioma().size(); i++) {
             PeriodistaIdioma object = listarPeriodistaIdioma().get(i);
          if(object.getIdPerIdioma()==idi)   {
            return object;
          }
         }
    return null;
     }
}
