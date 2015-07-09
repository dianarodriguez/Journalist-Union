/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.IdiomaJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Idioma;

/**
 *
 * @author asus
 */
public class IdiomaControl {
public IdiomaControl(){

    }

   IdiomaJpaController    control = new  IdiomaJpaController();

     public void adicionar(Idioma obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Idioma obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Idioma> listarIdioma(){
         return control.findIdiomaEntities();
     }
      public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarIdioma().size(); i++) {
             Idioma object = listarIdioma().get(i);
          if(object.getNombreIdioma().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdIdioma(String nombre){
         int id=0;
         for (int i = 0; i < listarIdioma().size(); i++) {
           Idioma object = listarIdioma().get(i);
          if(object.getNombreIdioma().equalsIgnoreCase(nombre))   {
              id=object.getIdIdioma();break;
          }
         }
    return id;
     }
     public void actualizarIdioma(String nombre, String dificultad, int id,String habla, String escribe,String lee) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarIdioma().size(); i++) {
        Idioma object = listarIdioma().get(i);
          if(object.getIdIdioma()==id)   {
              object.setNombreIdioma(nombre);
              object.setDificultadIdioma(dificultad);
              object.setDificultadEscritura(escribe);
              object.setDificultadExpresion(habla);
              object.setDificultadLectura(lee);



              modificar(object);break;
          }
     }
    }
         public Idioma buscarIdioma(String nombre){
         Idioma id=new Idioma();
         for (int i = 0; i < listarIdioma().size(); i++) {
           Idioma object = listarIdioma().get(i);
          if(object.getNombreIdioma().equalsIgnoreCase(nombre))   {
              id=object;break;
          }
         }
    return id;
     }
          public Idioma buscarIdiomaId(int id){
         Idioma idi=new Idioma();
         for (int i = 0; i < listarIdioma().size(); i++) {
           Idioma object = listarIdioma().get(i);
          if(object.getIdIdioma()==id)   {
             return object;
          }
         }
    return null;
     }
}
