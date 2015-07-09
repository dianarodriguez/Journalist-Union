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
@Table(name = "periodista_postgrado")
@NamedQueries({
    @NamedQuery(name = "PeriodistaPostgrado.findAll", query = "SELECT p FROM PeriodistaPostgrado p"),
    @NamedQuery(name = "PeriodistaPostgrado.findByIdPerPostg", query = "SELECT p FROM PeriodistaPostgrado p WHERE p.idPerPostg = :idPerPostg"),
    @NamedQuery(name = "PeriodistaPostgrado.findByAportesPer", query = "SELECT p FROM PeriodistaPostgrado p WHERE p.aportesPer = :aportesPer"),
    @NamedQuery(name = "PeriodistaPostgrado.findByTituloPostgr", query = "SELECT p FROM PeriodistaPostgrado p WHERE p.tituloPostgr = :tituloPostgr"),
    @NamedQuery(name = "PeriodistaPostgrado.findByEvaluacionPeriodista", query = "SELECT p FROM PeriodistaPostgrado p WHERE p.evaluacionPeriodista = :evaluacionPeriodista"),
    @NamedQuery(name = "PeriodistaPostgrado.findByYearPostg", query = "SELECT p FROM PeriodistaPostgrado p WHERE p.yearPostg = :yearPostg")})
public class PeriodistaPostgrado implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_per_postg")
    private Integer idPerPostg;
    @Column(name = "aportes_per")
    private String aportesPer;
    @Column(name = "titulo_postgr")
    private String tituloPostgr;
    @Column(name = "evaluacion_periodista")
    private String evaluacionPeriodista;
    @Column(name = "year_postg")
    private String yearPostg;
    @JoinColumn(name = "idperiodista", referencedColumnName = "id_periodista")
    @ManyToOne
    private Periodista periodista;
    @JoinColumn(name = "idpostg", referencedColumnName = "id_postgrado")
    @ManyToOne
    private CursoPostgrado cursoPostgrado;

    public PeriodistaPostgrado() {
    }

    public PeriodistaPostgrado(Integer idPerPostg) {
        this.idPerPostg = idPerPostg;
    }

    public Integer getIdPerPostg() {
        return idPerPostg;
    }

    public void setIdPerPostg(Integer idPerPostg) {
        Integer oldIdPerPostg = this.idPerPostg;
        this.idPerPostg = idPerPostg;
        changeSupport.firePropertyChange("idPerPostg", oldIdPerPostg, idPerPostg);
    }

    public String getAportesPer() {
        return aportesPer;
    }

    public void setAportesPer(String aportesPer) {
        String oldAportesPer = this.aportesPer;
        this.aportesPer = aportesPer;
        changeSupport.firePropertyChange("aportesPer", oldAportesPer, aportesPer);
    }

    public String getTituloPostgr() {
        return tituloPostgr;
    }

    public void setTituloPostgr(String tituloPostgr) {
        String oldTituloPostgr = this.tituloPostgr;
        this.tituloPostgr = tituloPostgr;
        changeSupport.firePropertyChange("tituloPostgr", oldTituloPostgr, tituloPostgr);
    }

    public String getEvaluacionPeriodista() {
        return evaluacionPeriodista;
    }

    public void setEvaluacionPeriodista(String evaluacionPeriodista) {
        String oldEvaluacionPeriodista = this.evaluacionPeriodista;
        this.evaluacionPeriodista = evaluacionPeriodista;
        changeSupport.firePropertyChange("evaluacionPeriodista", oldEvaluacionPeriodista, evaluacionPeriodista);
    }

    public String getYearPostg() {
        return yearPostg;
    }

    public void setYearPostg(String yearPostg) {
        String oldYearPostg = this.yearPostg;
        this.yearPostg = yearPostg;
        changeSupport.firePropertyChange("yearPostg", oldYearPostg, yearPostg);
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        Periodista oldPeriodista = this.periodista;
        this.periodista = periodista;
        changeSupport.firePropertyChange("periodista", oldPeriodista, periodista);
    }

    public CursoPostgrado getCursoPostgrado() {
        return cursoPostgrado;
    }

    public void setCursoPostgrado(CursoPostgrado cursoPostgrado) {
        CursoPostgrado oldCursoPostgrado = this.cursoPostgrado;
        this.cursoPostgrado = cursoPostgrado;
        changeSupport.firePropertyChange("cursoPostgrado", oldCursoPostgrado, cursoPostgrado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerPostg != null ? idPerPostg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodistaPostgrado)) {
            return false;
        }
        PeriodistaPostgrado other = (PeriodistaPostgrado) object;
        if ((this.idPerPostg == null && other.idPerPostg != null) || (this.idPerPostg != null && !this.idPerPostg.equals(other.idPerPostg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodistaPostgrado[idPerPostg=" + idPerPostg + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
