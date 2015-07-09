/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.CargoPeriodisticoJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.CargoPeriodistico;
import vista.Trabajoem;

/**
 *
 * @author asus
 */
public class CargoPerControl {
    EntityManager em = Trabajoem.GetEntityManager();
public CargoPerControl(){

    }

    CargoPeriodisticoJpaController control = new CargoPeriodisticoJpaController();

     public void adicionar(CargoPeriodistico obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(CargoPeriodistico obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<CargoPeriodistico> listarCergoP(){
         return control.findCargoPeriodisticoEntities();
     }
     public boolean existe(String nombre){
    boolean existe=false;
         for (int i = 0; i < listarCergoP().size(); i++) {
             CargoPeriodistico object = listarCergoP().get(i);
          if(object.getNombreCargop().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
}
     public int buscarIdCargop(String nombre){
         int id=0;
         for (int i = 0; i < listarCergoP().size(); i++) {
             CargoPeriodistico object = listarCergoP().get(i);
          if(object.getNombreCargop().equalsIgnoreCase(nombre))   {
              id=object.getIdCargop();break;
          }
         }
    return id;
     }
     public void actualizarCargoP(String nombre, String descripcion, int id) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarCergoP().size(); i++) {
             CargoPeriodistico object = listarCergoP().get(i);
          if(object.getIdCargop()==id)   {
              object.setNombreCargop(nombre);
              object.setDescripcionCargop(descripcion);
              modificar(object);
          }
     }
    }

     public CargoPeriodistico insert(CargoPeriodistico cp, List listcargo){
         listcargo.add(cp);
         return cp;
     }
     public CargoPeriodistico buscarCargoP(int id){
         CargoPeriodistico cp=new CargoPeriodistico();
           for (int i = 0; i < listarCergoP().size(); i++) {
             CargoPeriodistico object = listarCergoP().get(i);
          if(object.getIdCargop()==id)   {
              cp=object;break;
          }
         }
         return cp;
     }
      public CargoPeriodistico buscarCargop(String nombre){

         for (int i = 0; i < listarCergoP().size(); i++) {
             CargoPeriodistico object = listarCergoP().get(i);
          if(object.getNombreCargop().equalsIgnoreCase(nombre))   {
              return object;
          }
         }
    return null;
     }

      public CargoPeriodistico modificarCargoP(CargoPeriodistico cp,List listcargo,String nombre,
              String descripcion, javax.persistence.Query muniquery){

          Integer validar = 1;
         try {
            em.getTransaction().begin();
            cp.setNombreCargop(nombre);
           cp.setDescripcionCargop(descripcion);


            em.getTransaction().commit();
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error de transacción al modificar el cargo.");
            validar = 0;
            em.getTransaction().rollback();
          }
        if (validar == 1) {
            listcargo.clear();
            Query query = em.createQuery("SELECT c FROM CargoPeriodistico c");
            listcargo.addAll(query.getResultList());
        }

        return cp;

      }
}
