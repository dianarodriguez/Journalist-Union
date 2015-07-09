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
@Table(name = "periodista_computadora")
@NamedQueries({
    @NamedQuery(name = "PeriodistaComputadora.findAll", query = "SELECT p FROM PeriodistaComputadora p"),
    @NamedQuery(name = "PeriodistaComputadora.findByIdPerComp", query = "SELECT p FROM PeriodistaComputadora p WHERE p.idPerComp = :idPerComp")})
public class PeriodistaComputadora implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_comp")
    private Integer idPerComp;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idpc", referencedColumnName = "id_pc")
    @ManyToOne
    private Computadoras computadoras;

    public PeriodistaComputadora() {
    }

    public PeriodistaComputadora(Integer idPerComp) {
        this.idPerComp = idPerComp;
    }

    public Integer getIdPerComp() {
        return idPerComp;
    }

    public void setIdPerComp(Integer idPerComp) {
        Integer oldIdPerComp = this.idPerComp;
        this.idPerComp = idPerComp;
        changeSupport.firePropertyChange("idPerComp", oldIdPerComp, idPerComp);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    public Computadoras getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(Computadoras computadoras) {
        Computadoras oldComputadoras = this.computadoras;
        this.computadoras = computadoras;
        changeSupport.firePropertyChange("computadoras", oldComputadoras, computadoras);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerComp != null ? idPerComp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaComputadora)) {
            return false;
        }
        PeriodistaComputadora other = (PeriodistaComputadora) object;
        if ((this.idPerComp == null && other.idPerComp != null) || (this.idPerComp != null && !this.idPerComp.equals(other.idPerComp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaComputadora[idPerComp=" + idPerComp + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
