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
@Table(name = "periodista_idioma")
@NamedQueries({
    @NamedQuery(name = "PeriodistaIdioma.findAll", query = "SELECT p FROM PeriodistaIdioma p"),
    @NamedQuery(name = "PeriodistaIdioma.findByIdPerIdioma", query = "SELECT p FROM PeriodistaIdioma p WHERE p.idPerIdioma = :idPerIdioma"),
    @NamedQuery(name = "PeriodistaIdioma.findByHabla", query = "SELECT p FROM PeriodistaIdioma p WHERE p.habla = :habla"),
    @NamedQuery(name = "PeriodistaIdioma.findByLee", query = "SELECT p FROM PeriodistaIdioma p WHERE p.lee = :lee"),
    @NamedQuery(name = "PeriodistaIdioma.findByEscribe", query = "SELECT p FROM PeriodistaIdioma p WHERE p.escribe = :escribe"),
    @NamedQuery(name = "PeriodistaIdioma.findByNivel", query = "SELECT p FROM PeriodistaIdioma p WHERE p.nivel = :nivel")})
public class PeriodistaIdioma implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_idioma")
    private Integer idPerIdioma;
    @Column(name = "habla")
    private String habla;
    @Column(name = "lee")
    private String lee;
    @Column(name = "escribe")
    private String escribe;
    @Column(name = "nivel")
    private String nivel;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "ididioma", referencedColumnName = "id_idioma")
    @ManyToOne
    private Idioma idioma;

    public PeriodistaIdioma() {
    }

    public PeriodistaIdioma(Integer idPerIdioma) {
        this.idPerIdioma = idPerIdioma;
    }

    public Integer getIdPerIdioma() {
        return idPerIdioma;
    }

    public void setIdPerIdioma(Integer idPerIdioma) {
        Integer oldIdPerIdioma = this.idPerIdioma;
        this.idPerIdioma = idPerIdioma;
        changeSupport.firePropertyChange("idPerIdioma", oldIdPerIdioma, idPerIdioma);
    }

    public String getHabla() {
        return habla;
    }

    public void setHabla(String habla) {
        String oldHabla = this.habla;
        this.habla = habla;
        changeSupport.firePropertyChange("habla", oldHabla, habla);
    }

    public String getLee() {
        return lee;
    }

    public void setLee(String lee) {
        String oldLee = this.lee;
        this.lee = lee;
        changeSupport.firePropertyChange("lee", oldLee, lee);
    }

    public String getEscribe() {
        return escribe;
    }

    public void setEscribe(String escribe) {
        String oldEscribe = this.escribe;
        this.escribe = escribe;
        changeSupport.firePropertyChange("escribe", oldEscribe, escribe);
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        String oldNivel = this.nivel;
        this.nivel = nivel;
        changeSupport.firePropertyChange("nivel", oldNivel, nivel);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        Idioma oldIdioma = this.idioma;
        this.idioma = idioma;
        changeSupport.firePropertyChange("idioma", oldIdioma, idioma);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerIdioma != null ? idPerIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaIdioma)) {
            return false;
        }
        PeriodistaIdioma other = (PeriodistaIdioma) object;
        if ((this.idPerIdioma == null && other.idPerIdioma != null) || (this.idPerIdioma != null && !this.idPerIdioma.equals(other.idPerIdioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaIdioma[idPerIdioma=" + idPerIdioma + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
