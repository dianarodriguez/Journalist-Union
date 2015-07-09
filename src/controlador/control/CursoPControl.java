/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.CursoPostgradoJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CursoPostgrado;

/**
 *
 * @author asus
 */
public class CursoPControl {
public CursoPControl(){

    }

    CursoPostgradoJpaController   control = new CursoPostgradoJpaController() ;

     public void adicionar(CursoPostgrado obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(CursoPostgrado obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<CursoPostgrado> listar(){
         return control.findCursoPostgradoEntities();
     }

       public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listar().size(); i++) {
             CursoPostgrado object = listar().get(i);
          if(object.getTipoPostgrado().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdCursoP(String nombre){
         int id=0;
         for (int i = 0; i < listar().size(); i++) {
             CursoPostgrado object = listar().get(i);
          if(object.getTipoPostgrado().equalsIgnoreCase(nombre))   {
              id=object.getIdPostgrado();break;
          }
         }
    return id;
     }
     public void actualizarCursoP(String nombre, String descripcion, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listar().size(); i++) {
             CursoPostgrado object = listar().get(i);
          if(object.getIdPostgrado()==id)   {
              object.setTipoPostgrado(nombre);
              object.setDescripcionPostgrado(descripcion);
              modificar(object);
          }
     }
    }


   public CursoPostgrado buscarCursoP(String nombre){
        CursoPostgrado cp=new CursoPostgrado();
         for (int i = 0; i < listar().size(); i++) {
             CursoPostgrado object = listar().get(i);
          if(object.getTipoPostgrado().equalsIgnoreCase(nombre))   {
             cp=object;break;
          }
         }
    return cp;
     }

    public CursoPostgrado buscarCursoPId(int id){
        CursoPostgrado cp=new CursoPostgrado();
         for (int i = 0; i < listar().size(); i++) {
             CursoPostgrado object = listar().get(i);
          if(object.getIdPostgrado()==id)   {
            return object;
          }
         }
    return cp;
     }
}
