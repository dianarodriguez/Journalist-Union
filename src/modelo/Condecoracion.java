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
@Table(name = "condecoracion")
@NamedQueries({
    @NamedQuery(name = "Condecoracion.findAll", query = "SELECT c FROM Condecoracion c"),
    @NamedQuery(name = "Condecoracion.findByNombreCondec", query = "SELECT c FROM Condecoracion c WHERE c.nombreCondec = :nombreCondec"),
    @NamedQuery(name = "Condecoracion.findByDescripcionCondec", query = "SELECT c FROM Condecoracion c WHERE c.descripcionCondec = :descripcionCondec"),
    @NamedQuery(name = "Condecoracion.findByTipoCondec", query = "SELECT c FROM Condecoracion c WHERE c.tipoCondec = :tipoCondec"),
    @NamedQuery(name = "Condecoracion.findByIdCondecoracion", query = "SELECT c FROM Condecoracion c WHERE c.idCondecoracion = :idCondecoracion")})
public class Condecoracion implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_condec")
    private String nombreCondec;
    @Column(name = "descripcion_condec")
    private String descripcionCondec;
    @Column(name = "tipo_condec")
    private String tipoCondec;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_condecoracion")
    private Integer idCondecoracion;
    @OneToMany(mappedBy = "condecoracion")
    private List<PeriodistaCondecoracion> periodistaCondecoracionList;

    public Condecoracion() {
    }

    public Condecoracion(Integer idCondecoracion) {
        this.idCondecoracion = idCondecoracion;
    }

    public String getNombreCondec() {
        return nombreCondec;
    }

    public void setNombreCondec(String nombreCondec) {
        String oldNombreCondec = this.nombreCondec;
        this.nombreCondec = nombreCondec;
        changeSupport.firePropertyChange("nombreCondec", oldNombreCondec, nombreCondec);
    }

    public String getDescripcionCondec() {
        return descripcionCondec;
    }

    public void setDescripcionCondec(String descripcionCondec) {
        String oldDescripcionCondec = this.descripcionCondec;
        this.descripcionCondec = descripcionCondec;
        changeSupport.firePropertyChange("descripcionCondec", oldDescripcionCondec, descripcionCondec);
    }

    public String getTipoCondec() {
        return tipoCondec;
    }

    public void setTipoCondec(String tipoCondec) {
        String oldTipoCondec = this.tipoCondec;
        this.tipoCondec = tipoCondec;
        changeSupport.firePropertyChange("tipoCondec", oldTipoCondec, tipoCondec);
    }

    public Integer getIdCondecoracion() {
        return idCondecoracion;
    }

    public void setIdCondecoracion(Integer idCondecoracion) {
        Integer oldIdCondecoracion = this.idCondecoracion;
        this.idCondecoracion = idCondecoracion;
        changeSupport.firePropertyChange("idCondecoracion", oldIdCondecoracion, idCondecoracion);
    }

    public List<PeriodistaCondecoracion> getPeriodistaCondecoracionList() {
        return periodistaCondecoracionList;
    }

    public void setPeriodistaCondecoracionList(List<PeriodistaCondecoracion> periodistaCondecoracionList) {
        this.periodistaCondecoracionList = periodistaCondecoracionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCondecoracion != null ? idCondecoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condecoracion)) {
            return false;
        }
        Condecoracion other = (Condecoracion) object;
        if ((this.idCondecoracion == null && other.idCondecoracion != null) || (this.idCondecoracion != null && !this.idCondecoracion.equals(other.idCondecoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCondec;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
