/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.CargoUpecJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CargoUpec;

/**
 *
 * @author asus
 */
public class CargoUControl {
public CargoUControl(){

    }

      CargoUpecJpaController control = new CargoUpecJpaController();

     public void adicionar(CargoUpec obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(CargoUpec obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<CargoUpec> listarCargoU(){
         return control.findCargoUpecEntities();
     }
        public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarCargoU().size(); i++) {
             CargoUpec object = listarCargoU().get(i);
          if(object.getNombreCargou().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarIdCargoU(String nombre){
         int id=0;
         for (int i = 0; i < listarCargoU().size(); i++) {
             CargoUpec object = listarCargoU().get(i);
          if(object.getNombreCargou().equalsIgnoreCase(nombre))   {
              id=object.getIdCargou();break;
          }
         }
    return id;
     }
     public void actualizarCursoP(String nombre, String descripcion, int id, String tipo) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarCargoU().size(); i++) {
            CargoUpec object = listarCargoU().get(i);
          if(object.getIdCargou()==id)   {
              object.setNombreCargou(nombre);
              object.setDescripcionCargou(descripcion);
              object.setTipoCargou(tipo);
              modificar(object);
          }
     }
    }
     public CargoUpec buscarCU(String nombre){
         CargoUpec cu= new CargoUpec();
         for (int i = 0; i < listarCargoU().size(); i++) {
             CargoUpec object = listarCargoU().get(i);
          if(object.getNombreCargou().equalsIgnoreCase(nombre))   {
             cu=object;break;
          }
         }
    return cu;
     }
       public CargoUpec buscarCUId(int id){
         CargoUpec cu= new CargoUpec();
         for (int i = 0; i < listarCargoU().size(); i++) {
             CargoUpec object = listarCargoU().get(i);
          if(object.getIdCargou()==id)   {
             cu=object;break;
          }
         }
    return cu;
     }
}
