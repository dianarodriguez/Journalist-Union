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
@Table(name = "categoria_docente")
@NamedQueries({
    @NamedQuery(name = "CategoriaDocente.findAll", query = "SELECT c FROM CategoriaDocente c"),
    @NamedQuery(name = "CategoriaDocente.findByNombreCategoria", query = "SELECT c FROM CategoriaDocente c WHERE c.nombreCategoria = :nombreCategoria"),
    @NamedQuery(name = "CategoriaDocente.findByDescripcionCategoria", query = "SELECT c FROM CategoriaDocente c WHERE c.descripcionCategoria = :descripcionCategoria"),
    @NamedQuery(name = "CategoriaDocente.findByIdCategoria", query = "SELECT c FROM CategoriaDocente c WHERE c.idCategoria = :idCategoria")})
public class CategoriaDocente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @OneToMany(mappedBy = "categoriaDocente")
    private List<PeriodistaCategoria> periodistaCategoriaList;

    public CategoriaDocente() {
    }

    public CategoriaDocente(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        String oldNombreCategoria = this.nombreCategoria;
        this.nombreCategoria = nombreCategoria;
        changeSupport.firePropertyChange("nombreCategoria", oldNombreCategoria, nombreCategoria);
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        String oldDescripcionCategoria = this.descripcionCategoria;
        this.descripcionCategoria = descripcionCategoria;
        changeSupport.firePropertyChange("descripcionCategoria", oldDescripcionCategoria, descripcionCategoria);
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        Integer oldIdCategoria = this.idCategoria;
        this.idCategoria = idCategoria;
        changeSupport.firePropertyChange("idCategoria", oldIdCategoria, idCategoria);
    }

    public List<PeriodistaCategoria> getPeriodistaCategoriaList() {
        return periodistaCategoriaList;
    }

    public void setPeriodistaCategoriaList(List<PeriodistaCategoria> periodistaCategoriaList) {
        this.periodistaCategoriaList = periodistaCategoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaDocente)) {
            return false;
        }
        CategoriaDocente other = (CategoriaDocente) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCategoria;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
