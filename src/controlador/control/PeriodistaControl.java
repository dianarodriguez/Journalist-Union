/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

import controlador.jpa.PeriodistaJpaController;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import modelo.CargoUpec;
import modelo.Delegacion;
import modelo.Periodista;

/**
 *
 * @author asus
 */
public class PeriodistaControl {
public PeriodistaControl(){

    }

      PeriodistaJpaController control = new  PeriodistaJpaController();

     public void adicionar(Periodista obj) throws PreexistingEntityException, Exception{
        control.create(obj);
    }
     public void modificar(Periodista obj)throws PreexistingEntityException, Exception{
         control.edit(obj);
     }
     public void eliminar(Integer id)throws NonexistentEntityException{
         control.destroy(id);
     }
     public List<Periodista> listarPeriodista(){
         return control.findPeriodistaEntities();
     }
       public boolean periodistaAsignado(int idcargou){
        boolean asignado=false;
         for (int i = 0; i < listarPeriodista().size(); i++) {
          Periodista object = listarPeriodista().get(i);
             if(object.getCargoUpec().getIdCargou()==idcargou){
                 asignado=true;break;
             }
         }
        return asignado;
     }
        public boolean delegAsignado(int idDeleg){
        boolean asignado=false;
         for (int i = 0; i < listarPeriodista().size(); i++) {
          Periodista object = listarPeriodista().get(i);
             if(object.getDelegacion().getIdDelegacion()==idDeleg){
                 asignado=true;break;
             }
         }
        return asignado;
     }

         public boolean existe(String ci){
    boolean existe=false;
         for (int i = 0; i < listarPeriodista().size(); i++) {
            Periodista object = listarPeriodista().get(i);
          if(object.getCiPeriod().equalsIgnoreCase(ci))   {
              existe=true;break;
          }
         }
    return existe;
}

         public int buscarId(String ci){
         int id=0;
         for (int i = 0; i < listarPeriodista().size(); i++) {
          Periodista object = listarPeriodista().get(i);
          if(object.getCiPeriod().equalsIgnoreCase(ci))   {
              id=object.getIdPeriodista();break;
          }
         }
    return id;
     }
     public void actualizar(String nombre, int id,String ci,String direccion,String correo,
             String telefono,Double salario,String calidad,String municipio,String militancia,
             String nivelescolar,Delegacion d,CargoUpec cu) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPeriodista().size(); i++) {
       Periodista object = listarPeriodista().get(i);
          if(object.getIdPeriodista()==id)   {
              object.setCalidadPeriod(calidad);
              object.setCargoUpec(cu);
              object.setCiPeriod(ci);
              object.setCorreoElectronico(correo);
              object.setDelegacion(d);
              object.setDireccionPeriod(direccion);
              object.setMilitanciaPeriod(militancia);
              object.setMunicipioPeriod(municipio);
              object.setNivelEscolaridad(nivelescolar);
              object.setNombrePeriodista(nombre);
              object.setSelarioPeriod(salario);
              object.setTelefonoPeriod(telefono);
               modificar(object);break;
          }
     }
    }
      public boolean buscarNombre(String nombre){
         boolean existe=false;
         for (int i = 0; i < listarPeriodista().size(); i++) {
          Periodista object = listarPeriodista().get(i);
          if(object.getNombrePeriodista().equalsIgnoreCase(nombre))   {
              existe=true;break;
          }
         }
    return existe;
     }
 public boolean buscarIdNombreDoble(String nombre){
         boolean existe=false;
         String name="";
         for (int i = 0; i < listarPeriodista().size(); i++) {
          Periodista object = listarPeriodista().get(i);
          if(object.getNombrePeriodista().equalsIgnoreCase(nombre))   {

              existe=true;break;
          }
         }
    return existe;
     }
  public Periodista BuscarPeriod(int id){
    Periodista p=new Periodista();
         for (int i = 0; i < listarPeriodista().size(); i++) {
            Periodista object = listarPeriodista().get(i);
          if(object.getIdPeriodista()==id) {
              p=object;break;
          }
         }
    return p;
}

    public void actualizarP(String nombre, String correo, int id,String direccion,String ci,
            String miltancia,String munic,Double salario, String calidad, String telefono,Delegacion d,
            CargoUpec cu,String nivel) throws PreexistingEntityException, Exception{
           for (int i = 0; i < listarPeriodista().size(); i++) {
       Periodista object = listarPeriodista().get(i);
          if(object.getIdPeriodista()==id)   {
            object.setCalidadPeriod(calidad);
            object.setCargoUpec(cu);
            object.setCiPeriod(ci);
            object.setCorreoElectronico(correo);
            object.setDelegacion(d);
            object.setDireccionPeriod(direccion);
            object.setMilitanciaPeriod(miltancia);
            object.setMunicipioPeriod(munic);
            object.setNivelEscolaridad(nivel);
            object.setNombrePeriodista(nombre);
            object.setSelarioPeriod(salario);
            object.setTelefonoPeriod(telefono);


              modificar(object);break;
          }
     }
    }
     public Periodista buscarPerNombre(String nombre){
        Periodista p=new Periodista();
         for (int i = 0; i < listarPeriodista().size(); i++) {
          Periodista object = listarPeriodista().get(i);
          if(object.getNombrePeriodista().equalsIgnoreCase(nombre))   {
             p=object;break;
          }
         }
    return p;
     }
}
