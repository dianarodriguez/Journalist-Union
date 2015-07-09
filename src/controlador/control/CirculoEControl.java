/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.CirculoEspecialJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CirculoEspecial;

/**
 *
 * @author asus
 */
public class CirculoEControl {
public CirculoEControl(){

    }

     CirculoEspecialJpaController  control = new CirculoEspecialJpaController();

     public void adicionar(CirculoEspecial obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(CirculoEspecial obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<CirculoEspecial> listarCirculo(){
         return control.findCirculoEspecialEntities();
     }
         public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarCirculo().size(); i++) {
             CirculoEspecial object = listarCirculo().get(i);
          if(object.getNombreCirculo().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdCirculo(String nombre){
         int id=0;
         for (int i = 0; i < listarCirculo().size(); i++) {
             CirculoEspecial object = listarCirculo().get(i);
          if(object.getNombreCirculo().equalsIgnoreCase(nombre))   {
              id=object.getIdCirculoe();break;
          }
         }
    return id;
     }
     public void actualizarCirculo(String nombre, String descripcion, int id,String espec) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarCirculo().size(); i++) {
          CirculoEspecial object = listarCirculo().get(i);
          if(object.getIdCirculoe()==id)   {
              object.setNombreCirculo(nombre);
              object.setDescripcionCirculo(descripcion);
              object.setEspecialidad(espec);

              modificar(object);
          }
     }
    }
        public CirculoEspecial buscarCirculo(int id){
         CirculoEspecial ce=new CirculoEspecial();
         for (int i = 0; i < listarCirculo().size(); i++) {
             CirculoEspecial object = listarCirculo().get(i);
          if(object.getIdCirculoe()==id)   {
             ce=object;break;
          }
         }
    return ce;
     }
          public CirculoEspecial buscarCirculoNombre(String nombre){

         for (int i = 0; i < listarCirculo().size(); i++) {
             CirculoEspecial object = listarCirculo().get(i);
          if(object.getNombreCirculo().equalsIgnoreCase(nombre))   {
              return object;
          }
         }
    return null;
     }
}
