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
@Table(name = "idioma")
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByNombreIdioma", query = "SELECT i FROM Idioma i WHERE i.nombreIdioma = :nombreIdioma"),
    @NamedQuery(name = "Idioma.findByDificultadIdioma", query = "SELECT i FROM Idioma i WHERE i.dificultadIdioma = :dificultadIdioma"),
    @NamedQuery(name = "Idioma.findByIdIdioma", query = "SELECT i FROM Idioma i WHERE i.idIdioma = :idIdioma"),
    @NamedQuery(name = "Idioma.findByDificultadEscritura", query = "SELECT i FROM Idioma i WHERE i.dificultadEscritura = :dificultadEscritura"),
    @NamedQuery(name = "Idioma.findByDificultadExpresion", query = "SELECT i FROM Idioma i WHERE i.dificultadExpresion = :dificultadExpresion"),
    @NamedQuery(name = "Idioma.findByDificultadLectura", query = "SELECT i FROM Idioma i WHERE i.dificultadLectura = :dificultadLectura")})
public class Idioma implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_idioma")
    private String nombreIdioma;
    @Column(name = "dificultad_idioma")
    private String dificultadIdioma;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Integer idIdioma;
    @Column(name = "dificultad_escritura")
    private String dificultadEscritura;
    @Column(name = "dificultad_expresion")
    private String dificultadExpresion;
    @Column(name = "dificultad_lectura")
    private String dificultadLectura;
    @OneToMany(mappedBy = "idioma")
    private List<PeriodistaIdioma> periodistaIdiomaList;

    public Idioma() {
    }

    public Idioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        String oldNombreIdioma = this.nombreIdioma;
        this.nombreIdioma = nombreIdioma;
        changeSupport.firePropertyChange("nombreIdioma", oldNombreIdioma, nombreIdioma);
    }

    public String getDificultadIdioma() {
        return dificultadIdioma;
    }

    public void setDificultadIdioma(String dificultadIdioma) {
        String oldDificultadIdioma = this.dificultadIdioma;
        this.dificultadIdioma = dificultadIdioma;
        changeSupport.firePropertyChange("dificultadIdioma", oldDificultadIdioma, dificultadIdioma);
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        Integer oldIdIdioma = this.idIdioma;
        this.idIdioma = idIdioma;
        changeSupport.firePropertyChange("idIdioma", oldIdIdioma, idIdioma);
    }

    public String getDificultadEscritura() {
        return dificultadEscritura;
    }

    public void setDificultadEscritura(String dificultadEscritura) {
        String oldDificultadEscritura = this.dificultadEscritura;
        this.dificultadEscritura = dificultadEscritura;
        changeSupport.firePropertyChange("dificultadEscritura", oldDificultadEscritura, dificultadEscritura);
    }

    public String getDificultadExpresion() {
        return dificultadExpresion;
    }

    public void setDificultadExpresion(String dificultadExpresion) {
        String oldDificultadExpresion = this.dificultadExpresion;
        this.dificultadExpresion = dificultadExpresion;
        changeSupport.firePropertyChange("dificultadExpresion", oldDificultadExpresion, dificultadExpresion);
    }

    public String getDificultadLectura() {
        return dificultadLectura;
    }

    public void setDificultadLectura(String dificultadLectura) {
        String oldDificultadLectura = this.dificultadLectura;
        this.dificultadLectura = dificultadLectura;
        changeSupport.firePropertyChange("dificultadLectura", oldDificultadLectura, dificultadLectura);
    }

    public List<PeriodistaIdioma> getPeriodistaIdiomaList() {
        return periodistaIdiomaList;
    }

    public void setPeriodistaIdiomaList(List<PeriodistaIdioma> periodistaIdiomaList) {
        this.periodistaIdiomaList = periodistaIdiomaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdioma != null ? idIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.idIdioma == null && other.idIdioma != null) || (this.idIdioma != null && !this.idIdioma.equals(other.idIdioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreIdioma;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
