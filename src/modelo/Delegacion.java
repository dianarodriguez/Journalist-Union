/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "delegacion")
@NamedQueries({
    @NamedQuery(name = "Delegacion.findAll", query = "SELECT d FROM Delegacion d"),
    @NamedQuery(name = "Delegacion.findByNombreDeleg", query = "SELECT d FROM Delegacion d WHERE d.nombreDeleg = :nombreDeleg"),
    @NamedQuery(name = "Delegacion.findByDescripcionDeleg", query = "SELECT d FROM Delegacion d WHERE d.descripcionDeleg = :descripcionDeleg"),
    @NamedQuery(name = "Delegacion.findByDireccionDeleg", query = "SELECT d FROM Delegacion d WHERE d.direccionDeleg = :direccionDeleg"),
    @NamedQuery(name = "Delegacion.findByIdDelegacion", query = "SELECT d FROM Delegacion d WHERE d.idDelegacion = :idDelegacion"),
    @NamedQuery(name = "Delegacion.findByYearFundada", query = "SELECT d FROM Delegacion d WHERE d.yearFundada = :yearFundada")})
public class Delegacion implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_deleg")
    private String nombreDeleg;
    @Column(name = "descripcion_deleg")
    private String descripcionDeleg;
    @Column(name = "direccion_deleg")
    private String direccionDeleg;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_delegacion")
    private Integer idDelegacion;
    @Column(name = "year_fundada")
    private String yearFundada;
    @OneToMany(mappedBy = "delegacion")
    private List<Periodista> periodistaList;
    @OneToMany(mappedBy = "delegacion")
    private List<Computadoras> computadorasList;

    public Delegacion() {
    }

    public Delegacion(Integer idDelegacion) {
        this.idDelegacion = idDelegacion;
    }

    public String getNombreDeleg() {
        return nombreDeleg;
    }

    public void setNombreDeleg(String nombreDeleg) {
        String oldNombreDeleg = this.nombreDeleg;
        this.nombreDeleg = nombreDeleg;
        changeSupport.firePropertyChange("nombreDeleg", oldNombreDeleg, nombreDeleg);
    }

    public String getDescripcionDeleg() {
        return descripcionDeleg;
    }

    public void setDescripcionDeleg(String descripcionDeleg) {
        String oldDescripcionDeleg = this.descripcionDeleg;
        this.descripcionDeleg = descripcionDeleg;
        changeSupport.firePropertyChange("descripcionDeleg", oldDescripcionDeleg, descripcionDeleg);
    }

    public String getDireccionDeleg() {
        return direccionDeleg;
    }

    public void setDireccionDeleg(String direccionDeleg) {
        String oldDireccionDeleg = this.direccionDeleg;
        this.direccionDeleg = direccionDeleg;
        changeSupport.firePropertyChange("direccionDeleg", oldDireccionDeleg, direccionDeleg);
    }

    public Integer getIdDelegacion() {
        return idDelegacion;
    }

    public void setIdDelegacion(Integer idDelegacion) {
        Integer oldIdDelegacion = this.idDelegacion;
        this.idDelegacion = idDelegacion;
        changeSupport.firePropertyChange("idDelegacion", oldIdDelegacion, idDelegacion);
    }

    public String getYearFundada() {
        return yearFundada;
    }

    public void setYearFundada(String yearFundada) {
        String oldYearFundada = this.yearFundada;
        this.yearFundada = yearFundada;
        changeSupport.firePropertyChange("yearFundada", oldYearFundada, yearFundada);
    }

    public List<Periodista> getPeriodistaList() {
        return periodistaList;
    }

    public void setPeriodistaList(List<Periodista> periodistaList) {
        this.periodistaList = periodistaList;
    }

    public List<Computadoras> getComputadorasList() {
        return computadorasList;
    }

    public void setComputadorasList(List<Computadoras> computadorasList) {
        this.computadorasList = computadorasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelegacion != null ? idDelegacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delegacion)) {
            return false;
        }
        Delegacion other = (Delegacion) object;
        if ((this.idDelegacion == null && other.idDelegacion != null) || (this.idDelegacion != null && !this.idDelegacion.equals(other.idDelegacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreDeleg;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
