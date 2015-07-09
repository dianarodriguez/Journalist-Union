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
@Table(name = "periodista_cargop")
@NamedQueries({
    @NamedQuery(name = "PeriodistaCargop.findAll", query = "SELECT p FROM PeriodistaCargop p"),
    @NamedQuery(name = "PeriodistaCargop.findByIdPerCargo", query = "SELECT p FROM PeriodistaCargop p WHERE p.idPerCargo = :idPerCargo"),
    @NamedQuery(name = "PeriodistaCargop.findByFecha", query = "SELECT p FROM PeriodistaCargop p WHERE p.fecha = :fecha")})
public class PeriodistaCargop implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_cargo")
    private Integer idPerCargo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idcargop", referencedColumnName = "id_cargop")
    @ManyToOne
    private CargoPeriodistico cargoPeriodistico;

    public PeriodistaCargop() {
    }

    public PeriodistaCargop(Integer idPerCargo) {
        this.idPerCargo = idPerCargo;
    }

    public Integer getIdPerCargo() {
        return idPerCargo;
    }

    public void setIdPerCargo(Integer idPerCargo) {
        Integer oldIdPerCargo = this.idPerCargo;
        this.idPerCargo = idPerCargo;
        changeSupport.firePropertyChange("idPerCargo", oldIdPerCargo, idPerCargo);
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

    public CargoPeriodistico getCargoPeriodistico() {
        return cargoPeriodistico;
    }

    public void setCargoPeriodistico(CargoPeriodistico cargoPeriodistico) {
        CargoPeriodistico oldCargoPeriodistico = this.cargoPeriodistico;
        this.cargoPeriodistico = cargoPeriodistico;
        changeSupport.firePropertyChange("cargoPeriodistico", oldCargoPeriodistico, cargoPeriodistico);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerCargo != null ? idPerCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaCargop)) {
            return false;
        }
        PeriodistaCargop other = (PeriodistaCargop) object;
        if ((this.idPerCargo == null && other.idPerCargo != null) || (this.idPerCargo != null && !this.idPerCargo.equals(other.idPerCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaCargop[idPerCargo=" + idPerCargo + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
