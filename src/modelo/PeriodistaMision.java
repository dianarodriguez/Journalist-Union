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
@Table(name = "periodista_mision")
@NamedQueries({
    @NamedQuery(name = "PeriodistaMision.findAll", query = "SELECT p FROM PeriodistaMision p"),
    @NamedQuery(name = "PeriodistaMision.findByIdPerMision", query = "SELECT p FROM PeriodistaMision p WHERE p.idPerMision = :idPerMision"),
    @NamedQuery(name = "PeriodistaMision.findByCantidadMeses", query = "SELECT p FROM PeriodistaMision p WHERE p.cantidadMeses = :cantidadMeses"),
    @NamedQuery(name = "PeriodistaMision.findByObservaciones", query = "SELECT p FROM PeriodistaMision p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PeriodistaMision.findByFecha", query = "SELECT p FROM PeriodistaMision p WHERE p.fecha = :fecha")})
public class PeriodistaMision implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_mision")
    private Integer idPerMision;
    @Column(name = "cantidad_meses")
    private Integer cantidadMeses;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idmision", referencedColumnName = "id_mision")
    @ManyToOne
    private Mision mision;

    public PeriodistaMision() {
    }

    public PeriodistaMision(Integer idPerMision) {
        this.idPerMision = idPerMision;
    }

    public Integer getIdPerMision() {
        return idPerMision;
    }

    public void setIdPerMision(Integer idPerMision) {
        Integer oldIdPerMision = this.idPerMision;
        this.idPerMision = idPerMision;
        changeSupport.firePropertyChange("idPerMision", oldIdPerMision, idPerMision);
    }

    public Integer getCantidadMeses() {
        return cantidadMeses;
    }

    public void setCantidadMeses(Integer cantidadMeses) {
        Integer oldCantidadMeses = this.cantidadMeses;
        this.cantidadMeses = cantidadMeses;
        changeSupport.firePropertyChange("cantidadMeses", oldCantidadMeses, cantidadMeses);
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        String oldObservaciones = this.observaciones;
        this.observaciones = observaciones;
        changeSupport.firePropertyChange("observaciones", oldObservaciones, observaciones);
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

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        Mision oldMision = this.mision;
        this.mision = mision;
        changeSupport.firePropertyChange("mision", oldMision, mision);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerMision != null ? idPerMision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaMision)) {
            return false;
        }
        PeriodistaMision other = (PeriodistaMision) object;
        if ((this.idPerMision == null && other.idPerMision != null) || (this.idPerMision != null && !this.idPerMision.equals(other.idPerMision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaMision[idPerMision=" + idPerMision + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
