/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "periodista_condecoracion")
@NamedQueries({
    @NamedQuery(name = "PeriodistaCondecoracion.findAll", query = "SELECT p FROM PeriodistaCondecoracion p"),
    @NamedQuery(name = "PeriodistaCondecoracion.findByYearCondec", query = "SELECT p FROM PeriodistaCondecoracion p WHERE p.yearCondec = :yearCondec"),
    @NamedQuery(name = "PeriodistaCondecoracion.findByIdPerCondec", query = "SELECT p FROM PeriodistaCondecoracion p WHERE p.idPerCondec = :idPerCondec"),
    @NamedQuery(name = "PeriodistaCondecoracion.findByJustificacion", query = "SELECT p FROM PeriodistaCondecoracion p WHERE p.justificacion = :justificacion")})
public class PeriodistaCondecoracion implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "year_condec")
    private String yearCondec;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_condec")
    private Integer idPerCondec;
    @Column(name = "justificacion")
    private String justificacion;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idcondecoracion", referencedColumnName = "id_condecoracion")
    @ManyToOne
    private Condecoracion condecoracion;

    public PeriodistaCondecoracion() {
    }

    public PeriodistaCondecoracion(Integer idPerCondec) {
        this.idPerCondec = idPerCondec;
    }

    public String getYearCondec() {
        return yearCondec;
    }

    public void setYearCondec(String yearCondec) {
        String oldYearCondec = this.yearCondec;
        this.yearCondec = yearCondec;
        changeSupport.firePropertyChange("yearCondec", oldYearCondec, yearCondec);
    }

    public Integer getIdPerCondec() {
        return idPerCondec;
    }

    public void setIdPerCondec(Integer idPerCondec) {
        Integer oldIdPerCondec = this.idPerCondec;
        this.idPerCondec = idPerCondec;
        changeSupport.firePropertyChange("idPerCondec", oldIdPerCondec, idPerCondec);
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        String oldJustificacion = this.justificacion;
        this.justificacion = justificacion;
        changeSupport.firePropertyChange("justificacion", oldJustificacion, justificacion);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    public Condecoracion getCondecoracion() {
        return condecoracion;
    }

    public void setCondecoracion(Condecoracion condecoracion) {
        Condecoracion oldCondecoracion = this.condecoracion;
        this.condecoracion = condecoracion;
        changeSupport.firePropertyChange("condecoracion", oldCondecoracion, condecoracion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerCondec != null ? idPerCondec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaCondecoracion)) {
            return false;
        }
        PeriodistaCondecoracion other = (PeriodistaCondecoracion) object;
        if ((this.idPerCondec == null && other.idPerCondec != null) || (this.idPerCondec != null && !this.idPerCondec.equals(other.idPerCondec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaCondecoracion[idPerCondec=" + idPerCondec + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
