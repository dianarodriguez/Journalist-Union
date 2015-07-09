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
@Table(name = "cargo_upec")
@NamedQueries({
    @NamedQuery(name = "CargoUpec.findAll", query = "SELECT c FROM CargoUpec c"),
    @NamedQuery(name = "CargoUpec.findByNombreCargou", query = "SELECT c FROM CargoUpec c WHERE c.nombreCargou = :nombreCargou"),
    @NamedQuery(name = "CargoUpec.findByTipoCargou", query = "SELECT c FROM CargoUpec c WHERE c.tipoCargou = :tipoCargou"),
    @NamedQuery(name = "CargoUpec.findByDescripcionCargou", query = "SELECT c FROM CargoUpec c WHERE c.descripcionCargou = :descripcionCargou"),
    @NamedQuery(name = "CargoUpec.findByIdCargou", query = "SELECT c FROM CargoUpec c WHERE c.idCargou = :idCargou")})
public class CargoUpec implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_cargou")
    private String nombreCargou;
    @Column(name = "tipo_cargou")
    private String tipoCargou;
    @Column(name = "descripcion_cargou")
    private String descripcionCargou;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_cargou")
    private Integer idCargou;
    @OneToMany(mappedBy = "cargoUpec")
    private List<Periodista> periodistaList;

    public CargoUpec() {
    }

    public CargoUpec(Integer idCargou) {
        this.idCargou = idCargou;
    }

    public String getNombreCargou() {
        return nombreCargou;
    }

    public void setNombreCargou(String nombreCargou) {
        String oldNombreCargou = this.nombreCargou;
        this.nombreCargou = nombreCargou;
        changeSupport.firePropertyChange("nombreCargou", oldNombreCargou, nombreCargou);
    }

    public String getTipoCargou() {
        return tipoCargou;
    }

    public void setTipoCargou(String tipoCargou) {
        String oldTipoCargou = this.tipoCargou;
        this.tipoCargou = tipoCargou;
        changeSupport.firePropertyChange("tipoCargou", oldTipoCargou, tipoCargou);
    }

    public String getDescripcionCargou() {
        return descripcionCargou;
    }

    public void setDescripcionCargou(String descripcionCargou) {
        String oldDescripcionCargou = this.descripcionCargou;
        this.descripcionCargou = descripcionCargou;
        changeSupport.firePropertyChange("descripcionCargou", oldDescripcionCargou, descripcionCargou);
    }

    public Integer getIdCargou() {
        return idCargou;
    }

    public void setIdCargou(Integer idCargou) {
        Integer oldIdCargou = this.idCargou;
        this.idCargou = idCargou;
        changeSupport.firePropertyChange("idCargou", oldIdCargou, idCargou);
    }

    public List<Periodista> getPeriodistaList() {
        return periodistaList;
    }

    public void setPeriodistaList(List<Periodista> periodistaList) {
        this.periodistaList = periodistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargou != null ? idCargou.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoUpec)) {
            return false;
        }
        CargoUpec other = (CargoUpec) object;
        if ((this.idCargou == null && other.idCargou != null) || (this.idCargou != null && !this.idCargou.equals(other.idCargou))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCargou;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
