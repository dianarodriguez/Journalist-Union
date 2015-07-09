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
@Table(name = "circulo_especial")
@NamedQueries({
    @NamedQuery(name = "CirculoEspecial.findAll", query = "SELECT c FROM CirculoEspecial c"),
    @NamedQuery(name = "CirculoEspecial.findByNombreCirculo", query = "SELECT c FROM CirculoEspecial c WHERE c.nombreCirculo = :nombreCirculo"),
    @NamedQuery(name = "CirculoEspecial.findByDescripcionCirculo", query = "SELECT c FROM CirculoEspecial c WHERE c.descripcionCirculo = :descripcionCirculo"),
    @NamedQuery(name = "CirculoEspecial.findByIdCirculoe", query = "SELECT c FROM CirculoEspecial c WHERE c.idCirculoe = :idCirculoe"),
    @NamedQuery(name = "CirculoEspecial.findByEspecialidad", query = "SELECT c FROM CirculoEspecial c WHERE c.especialidad = :especialidad")})
public class CirculoEspecial implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_circulo")
    private String nombreCirculo;
    @Column(name = "descripcion_circulo")
    private String descripcionCirculo;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_circuloe")
    private Integer idCirculoe;
    @Column(name = "especialidad")
    private String especialidad;
    @OneToMany(mappedBy = "circuloEspecial")
    private List<PeriodistaCirculo> periodistaCirculoList;

    public CirculoEspecial() {
    }

    public CirculoEspecial(Integer idCirculoe) {
        this.idCirculoe = idCirculoe;
    }

    public String getNombreCirculo() {
        return nombreCirculo;
    }

    public void setNombreCirculo(String nombreCirculo) {
        String oldNombreCirculo = this.nombreCirculo;
        this.nombreCirculo = nombreCirculo;
        changeSupport.firePropertyChange("nombreCirculo", oldNombreCirculo, nombreCirculo);
    }

    public String getDescripcionCirculo() {
        return descripcionCirculo;
    }

    public void setDescripcionCirculo(String descripcionCirculo) {
        String oldDescripcionCirculo = this.descripcionCirculo;
        this.descripcionCirculo = descripcionCirculo;
        changeSupport.firePropertyChange("descripcionCirculo", oldDescripcionCirculo, descripcionCirculo);
    }

    public Integer getIdCirculoe() {
        return idCirculoe;
    }

    public void setIdCirculoe(Integer idCirculoe) {
        Integer oldIdCirculoe = this.idCirculoe;
        this.idCirculoe = idCirculoe;
        changeSupport.firePropertyChange("idCirculoe", oldIdCirculoe, idCirculoe);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        String oldEspecialidad = this.especialidad;
        this.especialidad = especialidad;
        changeSupport.firePropertyChange("especialidad", oldEspecialidad, especialidad);
    }

    public List<PeriodistaCirculo> getPeriodistaCirculoList() {
        return periodistaCirculoList;
    }

    public void setPeriodistaCirculoList(List<PeriodistaCirculo> periodistaCirculoList) {
        this.periodistaCirculoList = periodistaCirculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCirculoe != null ? idCirculoe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CirculoEspecial)) {
            return false;
        }
        CirculoEspecial other = (CirculoEspecial) object;
        if ((this.idCirculoe == null && other.idCirculoe != null) || (this.idCirculoe != null && !this.idCirculoe.equals(other.idCirculoe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCirculo;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
