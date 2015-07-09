/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.MisionJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.Mision;

/**
 *
 * @author asus
 */
public class MisionControl {
public MisionControl(){

    }

      MisionJpaController control = new MisionJpaController() ;

     public void adicionar(Mision obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Mision obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Mision> listarMision(){
         return control.findMisionEntities();
     }
       public boolean existe(String codidgo){
    boolean existe=false;
         for (int i = 0; i < listarMision().size(); i++) {
             Mision object = listarMision().get(i);
          if(object.getCodigoMision().equalsIgnoreCase(codidgo))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarId(String cod){
         int id=0;
         for (int i = 0; i < listarMision().size(); i++) {
           Mision object = listarMision().get(i);
          if(object.getCodigoMision().equalsIgnoreCase(cod))   {
              id=object.getIdMision();break;
          }
         }
    return id;
     }
     public void actualizarMision(String codigo, String pais, int id,String tipo) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarMision().size(); i++) {
        Mision object = listarMision().get(i);
          if(object.getIdMision()==id)   {
            object.setCodigoMision(codigo);
            object.setPaisMision(pais);
            object.setTipoMision(tipo);


              modificar(object);break;
          }
     }
    }
         public Mision buscarMision(String cod){
         Mision m=new Mision();
         for (int i = 0; i < listarMision().size(); i++) {
           Mision object = listarMision().get(i);
          if(object.getCodigoMision().equalsIgnoreCase(cod))   {
            m=object;break;
          }
         }
    return m;
     }

          public Mision buscarMisionId(int id){
         Mision m=new Mision();
         for (int i = 0; i < listarMision().size(); i++) {
           Mision object = listarMision().get(i);
          if(object.getIdMision()==id)   {
            return object;
          }
         }
    return null;
     }
}
