/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.ComputadorasJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Computadoras;
import modelo.Delegacion;

/**
 *
 * @author asus
 */
public class ComputadoraControl {
public ComputadoraControl(){

    }

     ComputadorasJpaController control = new ComputadorasJpaController();

     public void adicionar(Computadoras obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Computadoras obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Computadoras> listarComp(){
         return control.findComputadorasEntities();
     }

      public boolean existe(String codigo){
    boolean existe=false;
         for (int i = 0; i < listarComp().size(); i++) {
            Computadoras object = listarComp().get(i);
          if(object.getCodigoPc().equalsIgnoreCase(codigo))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdComp(String codigo){
         int id=0;
         for (int i = 0; i < listarComp().size(); i++) {
            Computadoras object = listarComp().get(i);
          if(object.getCodigoPc().equalsIgnoreCase(codigo))   {
              id=object.getIdPc();break;
          }
         }
    return id;
     }
     public void actualizarComp(String codigo, String tipo, int id,String marca,String year,String capacidad,Delegacion deleg) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarComp().size(); i++) {
         Computadoras object = listarComp().get(i);
          if(object.getIdPc()==id)   {
              object.setCapacidad(capacidad);
              object.setCodigoPc(codigo);
         object.setDelegacion(deleg);
              object.setYearFabricacion(year);
              object.setMarcaPc(marca);
              object.setTipoPc(tipo);

              modificar(object);
          }
     }
    }
         public Computadoras buscarComp(String codigo){
   Computadoras c = new Computadoras();
         for (int i = 0; i < listarComp().size(); i++) {
            Computadoras object = listarComp().get(i);
          if(object.getCodigoPc().equalsIgnoreCase(codigo))   {
             c=object;break;
          }
         }
    return c;
}
          public Computadoras buscarCompId(int id){
   Computadoras c = new Computadoras();
         for (int i = 0; i < listarComp().size(); i++) {
            Computadoras object = listarComp().get(i);
          if(object.getIdPc()==id)   {
            return object;
          }
         }
    return null;
}
}
