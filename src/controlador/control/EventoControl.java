/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.EventoJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.List;
import modelo.Evento;

/**
 *
 * @author asus
 */
public class EventoControl {
public EventoControl(){

    }

      EventoJpaController control = new  EventoJpaController();

     public void adicionar(Evento obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Evento obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Evento> listarE(){
         return control.findEventoEntities();
     }
       public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarE().size(); i++) {
            Evento object = listarE().get(i);
          if(object.getNombreEvento().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarId(String nombre){
         int id=0;
         for (int i = 0; i < listarE().size(); i++) {
           Evento object = listarE().get(i);
          if(object.getNombreEvento().equalsIgnoreCase(nombre))   {
              id=object.getIdEvento();break;
          }
         }
    return id;
     }
     public void actualizarUsuario(String nombre, int id,Date d,String pais,String lugar) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarE().size(); i++) {
       Evento object = listarE().get(i);
          if(object.getIdEvento()==id)   {

              object.setLugarEvento(lugar);

              object.setNombreEvento(nombre);
              object.setPaisEvento(pais);
             object.setFechaEvento(d);
               modificar(object);break;
          }
     }
    }
         public Evento buscarEvento(String nombre){
         Evento e= new  Evento();
         for (int i = 0; i < listarE().size(); i++) {
           Evento object = listarE().get(i);
          if(object.getNombreEvento().equalsIgnoreCase(nombre))   {
              e= object;break;
          }
         }
    return e;
     }
          public Evento buscarEventoId(int id){
         Evento e= new  Evento();
         for (int i = 0; i < listarE().size(); i++) {
           Evento object = listarE().get(i);
          if(object.getIdEvento()==id)   {
              return object;
          }
         }
    return e;
     }
}
