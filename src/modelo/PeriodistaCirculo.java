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
@Table(name = "periodista_circulo")
@NamedQueries({
    @NamedQuery(name = "PeriodistaCirculo.findAll", query = "SELECT p FROM PeriodistaCirculo p"),
    @NamedQuery(name = "PeriodistaCirculo.findByIdPerCirculo", query = "SELECT p FROM PeriodistaCirculo p WHERE p.idPerCirculo = :idPerCirculo"),
    @NamedQuery(name = "PeriodistaCirculo.findByCargoPeriodista", query = "SELECT p FROM PeriodistaCirculo p WHERE p.cargoPeriodista = :cargoPeriodista"),
    @NamedQuery(name = "PeriodistaCirculo.findByFecha", query = "SELECT p FROM PeriodistaCirculo p WHERE p.fecha = :fecha")})
public class PeriodistaCirculo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_circulo")
    private Integer idPerCirculo;
    @Column(name = "cargo_periodista")
    private String cargoPeriodista;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idcirculo", referencedColumnName = "id_circuloe")
    @ManyToOne
    private CirculoEspecial circuloEspecial;

    public PeriodistaCirculo() {
    }

    public PeriodistaCirculo(Integer idPerCirculo) {
        this.idPerCirculo = idPerCirculo;
    }

    public Integer getIdPerCirculo() {
        return idPerCirculo;
    }

    public void setIdPerCirculo(Integer idPerCirculo) {
        Integer oldIdPerCirculo = this.idPerCirculo;
        this.idPerCirculo = idPerCirculo;
        changeSupport.firePropertyChange("idPerCirculo", oldIdPerCirculo, idPerCirculo);
    }

    public String getCargoPeriodista() {
        return cargoPeriodista;
    }

    public void setCargoPeriodista(String cargoPeriodista) {
        String oldCargoPeriodista = this.cargoPeriodista;
        this.cargoPeriodista = cargoPeriodista;
        changeSupport.firePropertyChange("cargoPeriodista", oldCargoPeriodista, cargoPeriodista);
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

    public CirculoEspecial getCirculoEspecial() {
        return circuloEspecial;
    }

    public void setCirculoEspecial(CirculoEspecial circuloEspecial) {
        CirculoEspecial oldCirculoEspecial = this.circuloEspecial;
        this.circuloEspecial = circuloEspecial;
        changeSupport.firePropertyChange("circuloEspecial", oldCirculoEspecial, circuloEspecial);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerCirculo != null ? idPerCirculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaCirculo)) {
            return false;
        }
        PeriodistaCirculo other = (PeriodistaCirculo) object;
        if ((this.idPerCirculo == null && other.idPerCirculo != null) || (this.idPerCirculo != null && !this.idPerCirculo.equals(other.idPerCirculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaCirculo[idPerCirculo=" + idPerCirculo + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
