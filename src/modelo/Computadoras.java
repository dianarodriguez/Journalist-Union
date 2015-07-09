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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "computadoras")
@NamedQueries({
    @NamedQuery(name = "Computadoras.findAll", query = "SELECT c FROM Computadoras c"),
    @NamedQuery(name = "Computadoras.findByTipoPc", query = "SELECT c FROM Computadoras c WHERE c.tipoPc = :tipoPc"),
    @NamedQuery(name = "Computadoras.findByMarcaPc", query = "SELECT c FROM Computadoras c WHERE c.marcaPc = :marcaPc"),
    @NamedQuery(name = "Computadoras.findByYearFabricacion", query = "SELECT c FROM Computadoras c WHERE c.yearFabricacion = :yearFabricacion"),
    @NamedQuery(name = "Computadoras.findByCapacidad", query = "SELECT c FROM Computadoras c WHERE c.capacidad = :capacidad"),
    @NamedQuery(name = "Computadoras.findByIdPc", query = "SELECT c FROM Computadoras c WHERE c.idPc = :idPc"),
    @NamedQuery(name = "Computadoras.findByCodigoPc", query = "SELECT c FROM Computadoras c WHERE c.codigoPc = :codigoPc")})
public class Computadoras implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "tipo_pc")
    private String tipoPc;
    @Column(name = "marca_pc")
    private String marcaPc;
    @Column(name = "year_fabricacion")
    private String yearFabricacion;
    @Column(name = "capacidad")
    private String capacidad;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pc")
    private Integer idPc;
    @Column(name = "codigo_pc")
    private String codigoPc;
    @OneToMany(mappedBy = "computadoras")
    private List<PeriodistaComputadora> periodistaComputadoraList;
    @JoinColumn(name = "iddelegacion", referencedColumnName = "id_delegacion")
    @ManyToOne
    private Delegacion delegacion;

    public Computadoras() {
    }

    public Computadoras(Integer idPc) {
        this.idPc = idPc;
    }

    public String getTipoPc() {
        return tipoPc;
    }

    public void setTipoPc(String tipoPc) {
        String oldTipoPc = this.tipoPc;
        this.tipoPc = tipoPc;
        changeSupport.firePropertyChange("tipoPc", oldTipoPc, tipoPc);
    }

    public String getMarcaPc() {
        return marcaPc;
    }

    public void setMarcaPc(String marcaPc) {
        String oldMarcaPc = this.marcaPc;
        this.marcaPc = marcaPc;
        changeSupport.firePropertyChange("marcaPc", oldMarcaPc, marcaPc);
    }

    public String getYearFabricacion() {
        return yearFabricacion;
    }

    public void setYearFabricacion(String yearFabricacion) {
        String oldYearFabricacion = this.yearFabricacion;
        this.yearFabricacion = yearFabricacion;
        changeSupport.firePropertyChange("yearFabricacion", oldYearFabricacion, yearFabricacion);
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        String oldCapacidad = this.capacidad;
        this.capacidad = capacidad;
        changeSupport.firePropertyChange("capacidad", oldCapacidad, capacidad);
    }

    public Integer getIdPc() {
        return idPc;
    }

    public void setIdPc(Integer idPc) {
        Integer oldIdPc = this.idPc;
        this.idPc = idPc;
        changeSupport.firePropertyChange("idPc", oldIdPc, idPc);
    }

    public String getCodigoPc() {
        return codigoPc;
    }

    public void setCodigoPc(String codigoPc) {
        String oldCodigoPc = this.codigoPc;
        this.codigoPc = codigoPc;
        changeSupport.firePropertyChange("codigoPc", oldCodigoPc, codigoPc);
    }

    public List<PeriodistaComputadora> getPeriodistaComputadoraList() {
        return periodistaComputadoraList;
    }

    public void setPeriodistaComputadoraList(List<PeriodistaComputadora> periodistaComputadoraList) {
        this.periodistaComputadoraList = periodistaComputadoraList;
    }

    public Delegacion getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(Delegacion delegacion) {
        Delegacion oldDelegacion = this.delegacion;
        this.delegacion = delegacion;
        changeSupport.firePropertyChange("delegacion", oldDelegacion, delegacion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPc != null ? idPc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computadoras)) {
            return false;
        }
        Computadoras other = (Computadoras) object;
        if ((this.idPc == null && other.idPc != null) || (this.idPc != null && !this.idPc.equals(other.idPc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoPc;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
