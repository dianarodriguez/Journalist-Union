/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "baja")
@NamedQueries({
    @NamedQuery(name = "Baja.findAll", query = "SELECT b FROM Baja b"),
    @NamedQuery(name = "Baja.findByCausaBaja", query = "SELECT b FROM Baja b WHERE b.causaBaja = :causaBaja"),
    @NamedQuery(name = "Baja.findByObservacionPeriod", query = "SELECT b FROM Baja b WHERE b.observacionPeriod = :observacionPeriod"),
    @NamedQuery(name = "Baja.findByIdBaja", query = "SELECT b FROM Baja b WHERE b.idBaja = :idBaja"),
    @NamedQuery(name = "Baja.findByFecha", query = "SELECT b FROM Baja b WHERE b.fecha = :fecha")})
public class Baja implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "causa_baja")
    private String causaBaja;
    @Column(name = "observacion_period")
    private String observacionPeriod;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_baja")
    private Integer idBaja;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;

    public Baja() {
    }

    public Baja(Integer idBaja) {
        this.idBaja = idBaja;
    }

    public String getCausaBaja() {
        return causaBaja;
    }

    public void setCausaBaja(String causaBaja) {
        String oldCausaBaja = this.causaBaja;
        this.causaBaja = causaBaja;
        changeSupport.firePropertyChange("causaBaja", oldCausaBaja, causaBaja);
    }

    public String getObservacionPeriod() {
        return observacionPeriod;
    }

    public void setObservacionPeriod(String observacionPeriod) {
        String oldObservacionPeriod = this.observacionPeriod;
        this.observacionPeriod = observacionPeriod;
        changeSupport.firePropertyChange("observacionPeriod", oldObservacionPeriod, observacionPeriod);
    }

    public Integer getIdBaja() {
        return idBaja;
    }

    public void setIdBaja(Integer idBaja) {
        Integer oldIdBaja = this.idBaja;
        this.idBaja = idBaja;
        changeSupport.firePropertyChange("idBaja", oldIdBaja, idBaja);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBaja != null ? idBaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baja)) {
            return false;
        }
        Baja other = (Baja) object;
        if ((this.idBaja == null && other.idBaja != null) || (this.idBaja != null && !this.idBaja.equals(other.idBaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Baja[idBaja=" + idBaja + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
