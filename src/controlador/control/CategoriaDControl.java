/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.CategoriaDocenteJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CategoriaDocente;

/**
 *
 * @author asus
 */
public class CategoriaDControl {
public CategoriaDControl(){

    }

     CategoriaDocenteJpaController  control = new CategoriaDocenteJpaController();

     public void adicionar(CategoriaDocente obj) throws PreexistingEntityException, Exception{
       control.create(obj);
    }
     public void modificar(CategoriaDocente obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<CategoriaDocente> listarCategoria(){
         return control.findCategoriaDocenteEntities();
     }

       public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarCategoria().size(); i++) {
             CategoriaDocente object = listarCategoria().get(i);
          if(object.getNombreCategoria().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdCateg(String nombre){
         int id=0;
         for (int i = 0; i < listarCategoria().size(); i++) {
             CategoriaDocente object = listarCategoria().get(i);
          if(object.getNombreCategoria().equalsIgnoreCase(nombre))   {
              id=object.getIdCategoria();break;
          }
         }
    return id;
     }
     public void actualizarCateg(String nombre, String descripcion, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarCategoria().size(); i++) {
             CategoriaDocente object = listarCategoria().get(i);
          if(object.getIdCategoria()==id)   {
              object.setNombreCategoria(nombre);
              object.setDescripcionCategoria(descripcion);
              modificar(object);
          }
     }
    }
        public CategoriaDocente buscarCategoria(int id){
        CategoriaDocente cd=new CategoriaDocente();
         for (int i = 0; i < listarCategoria().size(); i++) {
             CategoriaDocente object = listarCategoria().get(i);
          if(object.getIdCategoria()==id)   {
              cd=object;break;
          }
         }
    return cd;
     }

         public CategoriaDocente buscarCategNombre(String nombre){

         for (int i = 0; i < listarCategoria().size(); i++) {
             CategoriaDocente object = listarCategoria().get(i);
          if(object.getNombreCategoria().equalsIgnoreCase(nombre))   {
              return object;
          }
         }
    return null;
     }


}
