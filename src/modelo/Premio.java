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
@Table(name = "premio")
@NamedQueries({
    @NamedQuery(name = "Premio.findAll", query = "SELECT p FROM Premio p"),
    @NamedQuery(name = "Premio.findByDescripcionPremio", query = "SELECT p FROM Premio p WHERE p.descripcionPremio = :descripcionPremio"),
    @NamedQuery(name = "Premio.findByIdPremio", query = "SELECT p FROM Premio p WHERE p.idPremio = :idPremio"),
    @NamedQuery(name = "Premio.findByNombrePremio", query = "SELECT p FROM Premio p WHERE p.nombrePremio = :nombrePremio")})
public class Premio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "descripcion_premio")
    private String descripcionPremio;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_premio")
    private Integer idPremio;
    @Column(name = "nombre_premio")
    private String nombrePremio;
    @OneToMany(mappedBy = "premio")
    private List<PeriodistaPremio> periodistaPremioList;

    public Premio() {
    }

    public Premio(Integer idPremio) {
        this.idPremio = idPremio;
    }

    public String getDescripcionPremio() {
        return descripcionPremio;
    }

    public void setDescripcionPremio(String descripcionPremio) {
        String oldDescripcionPremio = this.descripcionPremio;
        this.descripcionPremio = descripcionPremio;
        changeSupport.firePropertyChange("descripcionPremio", oldDescripcionPremio, descripcionPremio);
    }

    public Integer getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(Integer idPremio) {
        Integer oldIdPremio = this.idPremio;
        this.idPremio = idPremio;
        changeSupport.firePropertyChange("idPremio", oldIdPremio, idPremio);
    }

    public String getNombrePremio() {
        return nombrePremio;
    }

    public void setNombrePremio(String nombrePremio) {
        String oldNombrePremio = this.nombrePremio;
        this.nombrePremio = nombrePremio;
        changeSupport.firePropertyChange("nombrePremio", oldNombrePremio, nombrePremio);
    }

    public List<PeriodistaPremio> getPeriodistaPremioList() {
        return periodistaPremioList;
    }

    public void setPeriodistaPremioList(List<PeriodistaPremio> periodistaPremioList) {
        this.periodistaPremioList = periodistaPremioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPremio != null ? idPremio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Premio)) {
            return false;
        }
        Premio other = (Premio) object;
        if ((this.idPremio == null && other.idPremio != null) || (this.idPremio != null && !this.idPremio.equals(other.idPremio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePremio;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
