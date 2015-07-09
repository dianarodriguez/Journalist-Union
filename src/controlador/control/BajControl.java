/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.BajaJpaController;
import java.util.List;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.Date;
import modelo.Baja;
import modelo.Periodista;
//import java.util.List;
/**
 *
 * @author asus
 */
public class BajControl {
public BajControl(){

    }

     BajaJpaController control = new BajaJpaController();
           Baja b= new Baja();
     Periodista p=new Periodista();

     public void adicionar(Baja obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Baja obj) throws Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Baja> listar(){
         return control.findBajaEntities();
     }


        public boolean existe(int idp){
    boolean existe=false;
    for (int i = 0; i < listar().size(); i++) {
        Baja object = listar().get(i);
        if(object.getPeriodista().getIdPeriodista()==idp){
            existe=true;break;
        }
    }
    return existe;
}
        public Baja buscar(String nombrep){
            for (int i = 0; i < listar().size(); i++) {
        Baja object = listar().get(i);
        if(object.getPeriodista().getNombrePeriodista().equals(nombrep)){
            return object;
        }

        }
            return null;
        }
/*public void actualizar(String causa,String obs,Date fecha,Periodista p,int id) throws NonexistentEntityException, Exception{

    for (int i = 0; i < listar().size(); i++) {
        Baja object = listar().get(i);
        if(object.getIdBaja()==id){
            object.setCausaBaja(causa);
            object.setFecha(fecha);
            object.setObservacionPeriod(obs);
            object.setPeriodista(p);
            modificar(object);break;
        }
    }
}*/
}
