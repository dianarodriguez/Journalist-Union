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
@Table(name = "periodista")
@NamedQueries({
    @NamedQuery(name = "Periodista.findAll", query = "SELECT p FROM Periodista p"),
    @NamedQuery(name = "Periodista.findByNombrePeriodista", query = "SELECT p FROM Periodista p WHERE p.nombrePeriodista = :nombrePeriodista"),
    @NamedQuery(name = "Periodista.findByCiPeriod", query = "SELECT p FROM Periodista p WHERE p.ciPeriod = :ciPeriod"),
    @NamedQuery(name = "Periodista.findByMilitanciaPeriod", query = "SELECT p FROM Periodista p WHERE p.militanciaPeriod = :militanciaPeriod"),
    @NamedQuery(name = "Periodista.findByTelefonoPeriod", query = "SELECT p FROM Periodista p WHERE p.telefonoPeriod = :telefonoPeriod"),
    @NamedQuery(name = "Periodista.findByDireccionPeriod", query = "SELECT p FROM Periodista p WHERE p.direccionPeriod = :direccionPeriod"),
    @NamedQuery(name = "Periodista.findByNivelEscolaridad", query = "SELECT p FROM Periodista p WHERE p.nivelEscolaridad = :nivelEscolaridad"),
    @NamedQuery(name = "Periodista.findByMunicipioPeriod", query = "SELECT p FROM Periodista p WHERE p.municipioPeriod = :municipioPeriod"),
    @NamedQuery(name = "Periodista.findByCalidadPeriod", query = "SELECT p FROM Periodista p WHERE p.calidadPeriod = :calidadPeriod"),
    @NamedQuery(name = "Periodista.findByCorreoElectronico", query = "SELECT p FROM Periodista p WHERE p.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Periodista.findBySelarioPeriod", query = "SELECT p FROM Periodista p WHERE p.selarioPeriod = :selarioPeriod"),
    @NamedQuery(name = "Periodista.findByIdPeriodista", query = "SELECT p FROM Periodista p WHERE p.idPeriodista = :idPeriodista")})
public class Periodista implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_periodista")
    private String nombrePeriodista;
    @Column(name = "ci_period")
    private String ciPeriod;
    @Column(name = "militancia_period")
    private String militanciaPeriod;
    @Column(name = "telefono_period")
    private String telefonoPeriod;
    @Column(name = "direccion_period")
    private String direccionPeriod;
    @Column(name = "nivel_escolaridad")
    private String nivelEscolaridad;
    @Column(name = "municipio_period")
    private String municipioPeriod;
    @Column(name = "calidad_period")
    private String calidadPeriod;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "selario_period")
    private Double selarioPeriod;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_periodista")
    private Integer idPeriodista;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaPostgrado> periodistaPostgradoList;
    @JoinColumn(name = "iddelegacion", referencedColumnName = "id_delegacion")
    @ManyToOne
    private Delegacion delegacion;
    @JoinColumn(name = "idcargou", referencedColumnName = "id_cargou")
    @ManyToOne
    private CargoUpec cargoUpec;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaCategoria> periodistaCategoriaList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaPremio> periodistaPremioList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaComputadora> periodistaComputadoraList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaMision> periodistaMisionList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaIdioma> periodistaIdiomaList;
    @OneToMany(mappedBy = "periodista")
    private List<Baja> bajaList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaCargop> periodistaCargopList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaCondecoracion> periodistaCondecoracionList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaCirculo> periodistaCirculoList;
    @OneToMany(mappedBy = "periodista")
    private List<PeriodistaEvento> periodistaEventoList;

    public Periodista() {
    }

    public Periodista(Integer idPeriodista) {
        this.idPeriodista = idPeriodista;
    }

    public String getNombrePeriodista() {
        return nombrePeriodista;
    }

    public void setNombrePeriodista(String nombrePeriodista) {
        String oldNombrePeriodista = this.nombrePeriodista;
        this.nombrePeriodista = nombrePeriodista;
        changeSupport.firePropertyChange("nombrePeriodista", oldNombrePeriodista, nombrePeriodista);
    }

    public String getCiPeriod() {
        return ciPeriod;
    }

    public void setCiPeriod(String ciPeriod) {
        String oldCiPeriod = this.ciPeriod;
        this.ciPeriod = ciPeriod;
        changeSupport.firePropertyChange("ciPeriod", oldCiPeriod, ciPeriod);
    }

    public String getMilitanciaPeriod() {
        return militanciaPeriod;
    }

    public void setMilitanciaPeriod(String militanciaPeriod) {
        String oldMilitanciaPeriod = this.militanciaPeriod;
        this.militanciaPeriod = militanciaPeriod;
        changeSupport.firePropertyChange("militanciaPeriod", oldMilitanciaPeriod, militanciaPeriod);
    }

    public String getTelefonoPeriod() {
        return telefonoPeriod;
    }

    public void setTelefonoPeriod(String telefonoPeriod) {
        String oldTelefonoPeriod = this.telefonoPeriod;
        this.telefonoPeriod = telefonoPeriod;
        changeSupport.firePropertyChange("telefonoPeriod", oldTelefonoPeriod, telefonoPeriod);
    }

    public String getDireccionPeriod() {
        return direccionPeriod;
    }

    public void setDireccionPeriod(String direccionPeriod) {
        String oldDireccionPeriod = this.direccionPeriod;
        this.direccionPeriod = direccionPeriod;
        changeSupport.firePropertyChange("direccionPeriod", oldDireccionPeriod, direccionPeriod);
    }

    public String getNivelEscolaridad() {
        return nivelEscolaridad;
    }

    public void setNivelEscolaridad(String nivelEscolaridad) {
        String oldNivelEscolaridad = this.nivelEscolaridad;
        this.nivelEscolaridad = nivelEscolaridad;
        changeSupport.firePropertyChange("nivelEscolaridad", oldNivelEscolaridad, nivelEscolaridad);
    }

    public String getMunicipioPeriod() {
        return municipioPeriod;
    }

    public void setMunicipioPeriod(String municipioPeriod) {
        String oldMunicipioPeriod = this.municipioPeriod;
        this.municipioPeriod = municipioPeriod;
        changeSupport.firePropertyChange("municipioPeriod", oldMunicipioPeriod, municipioPeriod);
    }

    public String getCalidadPeriod() {
        return calidadPeriod;
    }

    public void setCalidadPeriod(String calidadPeriod) {
        String oldCalidadPeriod = this.calidadPeriod;
        this.calidadPeriod = calidadPeriod;
        changeSupport.firePropertyChange("calidadPeriod", oldCalidadPeriod, calidadPeriod);
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        String oldCorreoElectronico = this.correoElectronico;
        this.correoElectronico = correoElectronico;
        changeSupport.firePropertyChange("correoElectronico", oldCorreoElectronico, correoElectronico);
    }

    public Double getSelarioPeriod() {
        return selarioPeriod;
    }

    public void setSelarioPeriod(Double selarioPeriod) {
        Double oldSelarioPeriod = this.selarioPeriod;
        this.selarioPeriod = selarioPeriod;
        changeSupport.firePropertyChange("selarioPeriod", oldSelarioPeriod, selarioPeriod);
    }

    public Integer getIdPeriodista() {
        return idPeriodista;
    }

    public void setIdPeriodista(Integer idPeriodista) {
        Integer oldIdPeriodista = this.idPeriodista;
        this.idPeriodista = idPeriodista;
        changeSupport.firePropertyChange("idPeriodista", oldIdPeriodista, idPeriodista);
    }

    public List<PeriodistaPostgrado> getPeriodistaPostgradoList() {
        return periodistaPostgradoList;
    }

    public void setPeriodistaPostgradoList(List<PeriodistaPostgrado> periodistaPostgradoList) {
        this.periodistaPostgradoList = periodistaPostgradoList;
    }

    public Delegacion getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(Delegacion delegacion) {
        Delegacion oldDelegacion = this.delegacion;
        this.delegacion = delegacion;
        changeSupport.firePropertyChange("delegacion", oldDelegacion, delegacion);
    }

    public CargoUpec getCargoUpec() {
        return cargoUpec;
    }

    public void setCargoUpec(CargoUpec cargoUpec) {
        CargoUpec oldCargoUpec = this.cargoUpec;
        this.cargoUpec = cargoUpec;
        changeSupport.firePropertyChange("cargoUpec", oldCargoUpec, cargoUpec);
    }

    public List<PeriodistaCategoria> getPeriodistaCategoriaList() {
        return periodistaCategoriaList;
    }

    public void setPeriodistaCategoriaList(List<PeriodistaCategoria> periodistaCategoriaList) {
        this.periodistaCategoriaList = periodistaCategoriaList;
    }

    public List<PeriodistaPremio> getPeriodistaPremioList() {
        return periodistaPremioList;
    }

    public void setPeriodistaPremioList(List<PeriodistaPremio> periodistaPremioList) {
        this.periodistaPremioList = periodistaPremioList;
    }

    public List<PeriodistaComputadora> getPeriodistaComputadoraList() {
        return periodistaComputadoraList;
    }

    public void setPeriodistaComputadoraList(List<PeriodistaComputadora> periodistaComputadoraList) {
        this.periodistaComputadoraList = periodistaComputadoraList;
    }

    public List<PeriodistaMision> getPeriodistaMisionList() {
        return periodistaMisionList;
    }

    public void setPeriodistaMisionList(List<PeriodistaMision> periodistaMisionList) {
        this.periodistaMisionList = periodistaMisionList;
    }

    public List<PeriodistaIdioma> getPeriodistaIdiomaList() {
        return periodistaIdiomaList;
    }

    public void setPeriodistaIdiomaList(List<PeriodistaIdioma> periodistaIdiomaList) {
        this.periodistaIdiomaList = periodistaIdiomaList;
    }

    public List<Baja> getBajaList() {
        return bajaList;
    }

    public void setBajaList(List<Baja> bajaList) {
        this.bajaList = bajaList;
    }

    public List<PeriodistaCargop> getPeriodistaCargopList() {
        return periodistaCargopList;
    }

    public void setPeriodistaCargopList(List<PeriodistaCargop> periodistaCargopList) {
        this.periodistaCargopList = periodistaCargopList;
    }

    public List<PeriodistaCondecoracion> getPeriodistaCondecoracionList() {
        return periodistaCondecoracionList;
    }

    public void setPeriodistaCondecoracionList(List<PeriodistaCondecoracion> periodistaCondecoracionList) {
        this.periodistaCondecoracionList = periodistaCondecoracionList;
    }

    public List<PeriodistaCirculo> getPeriodistaCirculoList() {
        return periodistaCirculoList;
    }

    public void setPeriodistaCirculoList(List<PeriodistaCirculo> periodistaCirculoList) {
        this.periodistaCirculoList = periodistaCirculoList;
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
        hash += (idPeriodista != null ? idPeriodista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodista)) {
            return false;
        }
        Periodista other = (Periodista) object;
        if ((this.idPeriodista == null && other.idPeriodista != null) || (this.idPeriodista != null && !this.idPeriodista.equals(other.idPeriodista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePeriodista;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
