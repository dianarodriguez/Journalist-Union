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
@Table(name = "periodista_evento")
@NamedQueries({
    @NamedQuery(name = "PeriodistaEvento.findAll", query = "SELECT p FROM PeriodistaEvento p"),
    @NamedQuery(name = "PeriodistaEvento.findByIdPerEvento", query = "SELECT p FROM PeriodistaEvento p WHERE p.idPerEvento = :idPerEvento"),
    @NamedQuery(name = "PeriodistaEvento.findByTipoParticipacion", query = "SELECT p FROM PeriodistaEvento p WHERE p.tipoParticipacion = :tipoParticipacion")})
public class PeriodistaEvento implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_evento")
    private Integer idPerEvento;
    @Column(name = "tipo_participacion")
    private String tipoParticipacion;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idevento", referencedColumnName = "id_evento")
    @ManyToOne
    private Evento evento;

    public PeriodistaEvento() {
    }

    public PeriodistaEvento(Integer idPerEvento) {
        this.idPerEvento = idPerEvento;
    }

    public Integer getIdPerEvento() {
        return idPerEvento;
    }

    public void setIdPerEvento(Integer idPerEvento) {
        Integer oldIdPerEvento = this.idPerEvento;
        this.idPerEvento = idPerEvento;
        changeSupport.firePropertyChange("idPerEvento", oldIdPerEvento, idPerEvento);
    }

    public String getTipoParticipacion() {
        return tipoParticipacion;
    }

    public void setTipoParticipacion(String tipoParticipacion) {
        String oldTipoParticipacion = this.tipoParticipacion;
        this.tipoParticipacion = tipoParticipacion;
        changeSupport.firePropertyChange("tipoParticipacion", oldTipoParticipacion, tipoParticipacion);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        Evento oldEvento = this.evento;
        this.evento = evento;
        changeSupport.firePropertyChange("evento", oldEvento, evento);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerEvento != null ? idPerEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaEvento)) {
            return false;
        }
        PeriodistaEvento other = (PeriodistaEvento) object;
        if ((this.idPerEvento == null && other.idPerEvento != null) || (this.idPerEvento != null && !this.idPerEvento.equals(other.idPerEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaEvento[idPerEvento=" + idPerEvento + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
