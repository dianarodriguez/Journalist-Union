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
@Table(name = "periodista_premio")
@NamedQueries({
    @NamedQuery(name = "PeriodistaPremio.findAll", query = "SELECT p FROM PeriodistaPremio p"),
    @NamedQuery(name = "PeriodistaPremio.findByIdPerPremio", query = "SELECT p FROM PeriodistaPremio p WHERE p.idPerPremio = :idPerPremio"),
    @NamedQuery(name = "PeriodistaPremio.findByOpinion", query = "SELECT p FROM PeriodistaPremio p WHERE p.opinion = :opinion"),
    @NamedQuery(name = "PeriodistaPremio.findByProyectoPremiado", query = "SELECT p FROM PeriodistaPremio p WHERE p.proyectoPremiado = :proyectoPremiado"),
    @NamedQuery(name = "PeriodistaPremio.findByPosicionPremio", query = "SELECT p FROM PeriodistaPremio p WHERE p.posicionPremio = :posicionPremio"),
    @NamedQuery(name = "PeriodistaPremio.findByEstimulo", query = "SELECT p FROM PeriodistaPremio p WHERE p.estimulo = :estimulo"),
    @NamedQuery(name = "PeriodistaPremio.findByFecha", query = "SELECT p FROM PeriodistaPremio p WHERE p.fecha = :fecha")})
public class PeriodistaPremio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_premio")
    private Integer idPerPremio;
    @Column(name = "opinion")
    private String opinion;
    @Column(name = "proyecto_premiado")
    private String proyectoPremiado;
    @Column(name = "posicion_premio")
    private String posicionPremio;
    @Column(name = "estimulo")
    private String estimulo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idpremio", referencedColumnName = "id_premio")
    @ManyToOne
    private Premio premio;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;

    public PeriodistaPremio() {
    }

    public PeriodistaPremio(Integer idPerPremio) {
        this.idPerPremio = idPerPremio;
    }

    public Integer getIdPerPremio() {
        return idPerPremio;
    }

    public void setIdPerPremio(Integer idPerPremio) {
        Integer oldIdPerPremio = this.idPerPremio;
        this.idPerPremio = idPerPremio;
        changeSupport.firePropertyChange("idPerPremio", oldIdPerPremio, idPerPremio);
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        String oldOpinion = this.opinion;
        this.opinion = opinion;
        changeSupport.firePropertyChange("opinion", oldOpinion, opinion);
    }

    public String getProyectoPremiado() {
        return proyectoPremiado;
    }

    public void setProyectoPremiado(String proyectoPremiado) {
        String oldProyectoPremiado = this.proyectoPremiado;
        this.proyectoPremiado = proyectoPremiado;
        changeSupport.firePropertyChange("proyectoPremiado", oldProyectoPremiado, proyectoPremiado);
    }

    public String getPosicionPremio() {
        return posicionPremio;
    }

    public void setPosicionPremio(String posicionPremio) {
        String oldPosicionPremio = this.posicionPremio;
        this.posicionPremio = posicionPremio;
        changeSupport.firePropertyChange("posicionPremio", oldPosicionPremio, posicionPremio);
    }

    public String getEstimulo() {
        return estimulo;
    }

    public void setEstimulo(String estimulo) {
        String oldEstimulo = this.estimulo;
        this.estimulo = estimulo;
        changeSupport.firePropertyChange("estimulo", oldEstimulo, estimulo);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        Premio oldPremio = this.premio;
        this.premio = premio;
        changeSupport.firePropertyChange("premio", oldPremio, premio);
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
        hash += (idPerPremio != null ? idPerPremio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaPremio)) {
            return false;
        }
        PeriodistaPremio other = (PeriodistaPremio) object;
        if ((this.idPerPremio == null && other.idPerPremio != null) || (this.idPerPremio != null && !this.idPerPremio.equals(other.idPerPremio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaPremio[idPerPremio=" + idPerPremio + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
