/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByPaisEvento", query = "SELECT e FROM Evento e WHERE e.paisEvento = :paisEvento"),
    @NamedQuery(name = "Evento.findByNombreEvento", query = "SELECT e FROM Evento e WHERE e.nombreEvento = :nombreEvento"),
    @NamedQuery(name = "Evento.findByLugarEvento", query = "SELECT e FROM Evento e WHERE e.lugarEvento = :lugarEvento"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByFechaEvento", query = "SELECT e FROM Evento e WHERE e.fechaEvento = :fechaEvento")})
public class Evento implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "pais_evento")
    private String paisEvento;
    @Column(name = "nombre_evento")
    private String nombreEvento;
    @Column(name = "lugar_evento")
    private String lugarEvento;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Column(name = "fecha_evento")
    @Temporal(TemporalType.DATE)
    private Date fechaEvento;
    @OneToMany(mappedBy = "evento")
    private List<PeriodistaEvento> periodistaEventoList;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getPaisEvento() {
        return paisEvento;
    }

    public void setPaisEvento(String paisEvento) {
        String oldPaisEvento = this.paisEvento;
        this.paisEvento = paisEvento;
        changeSupport.firePropertyChange("paisEvento", oldPaisEvento, paisEvento);
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        String oldNombreEvento = this.nombreEvento;
        this.nombreEvento = nombreEvento;
        changeSupport.firePropertyChange("nombreEvento", oldNombreEvento, nombreEvento);
    }

    public String getLugarEvento() {
        return lugarEvento;
    }

    public void setLugarEvento(String lugarEvento) {
        String oldLugarEvento = this.lugarEvento;
        this.lugarEvento = lugarEvento;
        changeSupport.firePropertyChange("lugarEvento", oldLugarEvento, lugarEvento);
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        Integer oldIdEvento = this.idEvento;
        this.idEvento = idEvento;
        changeSupport.firePropertyChange("idEvento", oldIdEvento, idEvento);
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        Date oldFechaEvento = this.fechaEvento;
        this.fechaEvento = fechaEvento;
        changeSupport.firePropertyChange("fechaEvento", oldFechaEvento, fechaEvento);
    }

    public List<PeriodistaEvento> getPeriodistaEventoList() {
        return periodistaEventoList;
    }

    public void setPeriodistaEventoList(List<PeriodistaEvento> periodistaEventoList) {
        this.periodistaEventoList = periodistaEventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreEvento;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
