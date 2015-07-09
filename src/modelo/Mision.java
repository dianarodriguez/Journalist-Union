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
@Table(name = "mision")
@NamedQueries({
    @NamedQuery(name = "Mision.findAll", query = "SELECT m FROM Mision m"),
    @NamedQuery(name = "Mision.findByPaisMision", query = "SELECT m FROM Mision m WHERE m.paisMision = :paisMision"),
    @NamedQuery(name = "Mision.findByTipoMision", query = "SELECT m FROM Mision m WHERE m.tipoMision = :tipoMision"),
    @NamedQuery(name = "Mision.findByIdMision", query = "SELECT m FROM Mision m WHERE m.idMision = :idMision"),
    @NamedQuery(name = "Mision.findByCodigoMision", query = "SELECT m FROM Mision m WHERE m.codigoMision = :codigoMision")})
public class Mision implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "pais_mision")
    private String paisMision;
    @Column(name = "tipo_mision")
    private String tipoMision;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_mision")
    private Integer idMision;
    @Column(name = "codigo_mision")
    private String codigoMision;
    @OneToMany(mappedBy = "mision")
    private List<PeriodistaMision> periodistaMisionList;

    public Mision() {
    }

    public Mision(Integer idMision) {
        this.idMision = idMision;
    }

    public String getPaisMision() {
        return paisMision;
    }

    public void setPaisMision(String paisMision) {
        String oldPaisMision = this.paisMision;
        this.paisMision = paisMision;
        changeSupport.firePropertyChange("paisMision", oldPaisMision, paisMision);
    }

    public String getTipoMision() {
        return tipoMision;
    }

    public void setTipoMision(String tipoMision) {
        String oldTipoMision = this.tipoMision;
        this.tipoMision = tipoMision;
        changeSupport.firePropertyChange("tipoMision", oldTipoMision, tipoMision);
    }

    public Integer getIdMision() {
        return idMision;
    }

    public void setIdMision(Integer idMision) {
        Integer oldIdMision = this.idMision;
        this.idMision = idMision;
        changeSupport.firePropertyChange("idMision", oldIdMision, idMision);
    }

    public String getCodigoMision() {
        return codigoMision;
    }

    public void setCodigoMision(String codigoMision) {
        String oldCodigoMision = this.codigoMision;
        this.codigoMision = codigoMision;
        changeSupport.firePropertyChange("codigoMision", oldCodigoMision, codigoMision);
    }

    public List<PeriodistaMision> getPeriodistaMisionList() {
        return periodistaMisionList;
    }

    public void setPeriodistaMisionList(List<PeriodistaMision> periodistaMisionList) {
        this.periodistaMisionList = periodistaMisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMision != null ? idMision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mision)) {
            return false;
        }
        Mision other = (Mision) object;
        if ((this.idMision == null && other.idMision != null) || (this.idMision != null && !this.idMision.equals(other.idMision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoMision;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
