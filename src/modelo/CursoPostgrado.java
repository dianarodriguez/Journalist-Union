/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.Transient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "curso_postgrado")
@NamedQueries({
    @NamedQuery(name = "CursoPostgrado.findAll", query = "SELECT c FROM CursoPostgrado c"),
    @NamedQuery(name = "CursoPostgrado.findByTipoPostgrado", query = "SELECT c FROM CursoPostgrado c WHERE c.tipoPostgrado = :tipoPostgrado"),
    @NamedQuery(name = "CursoPostgrado.findByDescripcionPostgrado", query = "SELECT c FROM CursoPostgrado c WHERE c.descripcionPostgrado = :descripcionPostgrado"),
    @NamedQuery(name = "CursoPostgrado.findByIdPostgrado", query = "SELECT c FROM CursoPostgrado c WHERE c.idPostgrado = :idPostgrado")})
public class CursoPostgrado implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "tipo_postgrado")
    private String tipoPostgrado;
    @Column(name = "descripcion_postgrado")
    private String descripcionPostgrado;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_postgrado")
    private Integer idPostgrado;
    @OneToMany(mappedBy = "cursoPostgrado")
    private List<PeriodistaPostgrado> periodistaPostgradoList;

    public CursoPostgrado() {
    }

    public CursoPostgrado(Integer idPostgrado) {
        this.idPostgrado = idPostgrado;
    }

    public String getTipoPostgrado() {
        return tipoPostgrado;
    }

    public void setTipoPostgrado(String tipoPostgrado) {
        String oldTipoPostgrado = this.tipoPostgrado;
        this.tipoPostgrado = tipoPostgrado;
        changeSupport.firePropertyChange("tipoPostgrado", oldTipoPostgrado, tipoPostgrado);
    }

    public String getDescripcionPostgrado() {
        return descripcionPostgrado;
    }

    public void setDescripcionPostgrado(String descripcionPostgrado) {
        String oldDescripcionPostgrado = this.descripcionPostgrado;
        this.descripcionPostgrado = descripcionPostgrado;
        changeSupport.firePropertyChange("descripcionPostgrado", oldDescripcionPostgrado, descripcionPostgrado);
    }

    public Integer getIdPostgrado() {
        return idPostgrado;
    }

    public void setIdPostgrado(Integer idPostgrado) {
        Integer oldIdPostgrado = this.idPostgrado;
        this.idPostgrado = idPostgrado;
        changeSupport.firePropertyChange("idPostgrado", oldIdPostgrado, idPostgrado);
    }

    public List<PeriodistaPostgrado> getPeriodistaPostgradoList() {
        return periodistaPostgradoList;
    }

    public void setPeriodistaPostgradoList(List<PeriodistaPostgrado> periodistaPostgradoList) {
        this.periodistaPostgradoList = periodistaPostgradoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostgrado != null ? idPostgrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoPostgrado)) {
            return false;
        }
        CursoPostgrado other = (CursoPostgrado) object;
        if ((this.idPostgrado == null && other.idPostgrado != null) || (this.idPostgrado != null && !this.idPostgrado.equals(other.idPostgrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoPostgrado;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
