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
@Table(name = "periodista_categoria")
@NamedQueries({
    @NamedQuery(name = "PeriodistaCategoria.findAll", query = "SELECT p FROM PeriodistaCategoria p"),
    @NamedQuery(name = "PeriodistaCategoria.findByYearCategoria", query = "SELECT p FROM PeriodistaCategoria p WHERE p.yearCategoria = :yearCategoria"),
    @NamedQuery(name = "PeriodistaCategoria.findByIdPeriodsitaCateg", query = "SELECT p FROM PeriodistaCategoria p WHERE p.idPeriodsitaCateg = :idPeriodsitaCateg")})
public class PeriodistaCategoria implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "year_categoria")
    private String yearCategoria;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_periodsita_categ")
    private Integer idPeriodsitaCateg;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idcategoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private CategoriaDocente categoriaDocente;

    public PeriodistaCategoria() {
    }

    public PeriodistaCategoria(Integer idPeriodsitaCateg) {
        this.idPeriodsitaCateg = idPeriodsitaCateg;
    }

    public String getYearCategoria() {
        return yearCategoria;
    }

    public void setYearCategoria(String yearCategoria) {
        String oldYearCategoria = this.yearCategoria;
        this.yearCategoria = yearCategoria;
        changeSupport.firePropertyChange("yearCategoria", oldYearCategoria, yearCategoria);
    }

    public Integer getIdPeriodsitaCateg() {
        return idPeriodsitaCateg;
    }

    public void setIdPeriodsitaCateg(Integer idPeriodsitaCateg) {
        Integer oldIdPeriodsitaCateg = this.idPeriodsitaCateg;
        this.idPeriodsitaCateg = idPeriodsitaCateg;
        changeSupport.firePropertyChange("idPeriodsitaCateg", oldIdPeriodsitaCateg, idPeriodsitaCateg);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    public CategoriaDocente getCategoriaDocente() {
        return categoriaDocente;
    }

    public void setCategoriaDocente(CategoriaDocente categoriaDocente) {
        CategoriaDocente oldCategoriaDocente = this.categoriaDocente;
        this.categoriaDocente = categoriaDocente;
        changeSupport.firePropertyChange("categoriaDocente", oldCategoriaDocente, categoriaDocente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodsitaCateg != null ? idPeriodsitaCateg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaCategoria)) {
            return false;
        }
        PeriodistaCategoria other = (PeriodistaCategoria) object;
        if ((this.idPeriodsitaCateg == null && other.idPeriodsitaCateg != null) || (this.idPeriodsitaCateg != null && !this.idPeriodsitaCateg.equals(other.idPeriodsitaCateg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaCategoria[idPeriodsitaCateg=" + idPeriodsitaCateg + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
