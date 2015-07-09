/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaCategoriaJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CategoriaDocente;
import modelo.Periodista;
import modelo.PeriodistaCategoria;

/**
 *
 * @author asus
 */
public class PeriodistaCategControl {
public PeriodistaCategControl(){

    }

    PeriodistaCategoriaJpaController   control = new  PeriodistaCategoriaJpaController();

     public void adicionar(PeriodistaCategoria obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(PeriodistaCategoria obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<PeriodistaCategoria> listar(){
         return control.findPeriodistaCategoriaEntities();
     }

      public boolean categasigando(int idcateg){
        boolean asignado=false;
         for (int i = 0; i < listar().size(); i++) {
          PeriodistaCategoria    object = listar().get(i);
             if(object.getCategoriaDocente().getIdCategoria()==idcateg){
                 asignado=true;break;
             }
         }
        return asignado;
     }

       public boolean existe(int idper,int idcateg){
    boolean existe=false;
         for (int i = 0; i < listar().size(); i++) {
             PeriodistaCategoria object = listar().get(i);
          if(object.getCategoriaDocente().getIdCategoria()==idcateg
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(int idper,int idcateg){
         int id=0;
         for (int i = 0; i < listar().size(); i++) {
             PeriodistaCategoria object = listar().get(i);
          if(object.getCategoriaDocente().getIdCategoria()==idcateg
                     && object.getPeriodista().getIdPeriodista()==idper)   {
              id=object.getIdPeriodsitaCateg();break;
          }
         }
    return id;
     }
     public void actualizarPerC(String year, Periodista p,CategoriaDocente cd, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listar().size(); i++) {
             PeriodistaCategoria object = listar().get(i);
          if(object.getIdPeriodsitaCateg()==id)   {
              object.setCategoriaDocente(cd);
              object.setPeriodista(p);
              object.setYearCategoria(year);


              modificar(object);break;
          }
     }
    }
public PeriodistaCategoria buscarporId(int id){
          for (int i = 0; i < listar().size(); i++) {
             PeriodistaCategoria object = listar().get(i);
             if(object.getIdPeriodsitaCateg()==id)
                 return object;
         }
          return null;
     }

public PeriodistaCategoria buscarporNombre(String per,String cat){
     for (int i = 0; i < listar().size(); i++) {
             PeriodistaCategoria object = listar().get(i);
             if(object.getCategoriaDocente().getNombreCategoria().equals(cat)&&object.getPeriodista().getNombrePeriodista().equals(per))
                 return object;
                 }
     return null;
}
}
