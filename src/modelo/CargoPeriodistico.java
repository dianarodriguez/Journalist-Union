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
@Table(name = "cargo_periodistico")
@NamedQueries({
    @NamedQuery(name = "CargoPeriodistico.findAll", query = "SELECT c FROM CargoPeriodistico c"),
    @NamedQuery(name = "CargoPeriodistico.findByNombreCargop", query = "SELECT c FROM CargoPeriodistico c WHERE c.nombreCargop = :nombreCargop"),
    @NamedQuery(name = "CargoPeriodistico.findByDescripcionCargop", query = "SELECT c FROM CargoPeriodistico c WHERE c.descripcionCargop = :descripcionCargop"),
    @NamedQuery(name = "CargoPeriodistico.findByIdCargop", query = "SELECT c FROM CargoPeriodistico c WHERE c.idCargop = :idCargop")})
public class CargoPeriodistico implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_cargop")
    private String nombreCargop;
    @Column(name = "descripcion_cargop")
    private String descripcionCargop;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_cargop")
    private Integer idCargop;
    @OneToMany(mappedBy = "cargoPeriodistico")
    private List<PeriodistaCargop> periodistaCargopList;

    public CargoPeriodistico() {
    }

    public CargoPeriodistico(Integer idCargop) {
        this.idCargop = idCargop;
    }

    public String getNombreCargop() {
        return nombreCargop;
    }

    public void setNombreCargop(String nombreCargop) {
        String oldNombreCargop = this.nombreCargop;
        this.nombreCargop = nombreCargop;
        changeSupport.firePropertyChange("nombreCargop", oldNombreCargop, nombreCargop);
    }

    public String getDescripcionCargop() {
        return descripcionCargop;
    }

    public void setDescripcionCargop(String descripcionCargop) {
        String oldDescripcionCargop = this.descripcionCargop;
        this.descripcionCargop = descripcionCargop;
        changeSupport.firePropertyChange("descripcionCargop", oldDescripcionCargop, descripcionCargop);
    }

    public Integer getIdCargop() {
        return idCargop;
    }

    public void setIdCargop(Integer idCargop) {
        Integer oldIdCargop = this.idCargop;
        this.idCargop = idCargop;
        changeSupport.firePropertyChange("idCargop", oldIdCargop, idCargop);
    }

    public List<PeriodistaCargop> getPeriodistaCargopList() {
        return periodistaCargopList;
    }

    public void setPeriodistaCargopList(List<PeriodistaCargop> periodistaCargopList) {
        this.periodistaCargopList = periodistaCargopList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargop != null ? idCargop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoPeriodistico)) {
            return false;
        }
        CargoPeriodistico other = (CargoPeriodistico) object;
        if ((this.idCargop == null && other.idCargop != null) || (this.idCargop != null && !this.idCargop.equals(other.idCargop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCargop;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
