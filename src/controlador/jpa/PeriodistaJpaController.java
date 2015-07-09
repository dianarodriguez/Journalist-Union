/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.jpa;

import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Delegacion;
import modelo.CargoUpec;
import modelo.Periodista;
import modelo.PeriodistaPostgrado;
import java.util.ArrayList;
import java.util.List;
import modelo.PeriodistaCategoria;
import modelo.PeriodistaPremio;
import modelo.PeriodistaComputadora;
import modelo.PeriodistaMision;
import modelo.PeriodistaIdioma;
import modelo.Baja;
import modelo.PeriodistaCargop;
import modelo.PeriodistaCondecoracion;
import modelo.PeriodistaCirculo;
import modelo.PeriodistaEvento;

/**
 *
 * @author asus
 */
public class PeriodistaJpaController {

    public PeriodistaJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Periodista periodista) throws PreexistingEntityException, Exception {
        if (periodista.getPeriodistaPostgradoList() == null) {
            periodista.setPeriodistaPostgradoList(new ArrayList<PeriodistaPostgrado>());
        }
        if (periodista.getPeriodistaCategoriaList() == null) {
            periodista.setPeriodistaCategoriaList(new ArrayList<PeriodistaCategoria>());
        }
        if (periodista.getPeriodistaPremioList() == null) {
            periodista.setPeriodistaPremioList(new ArrayList<PeriodistaPremio>());
        }
        if (periodista.getPeriodistaComputadoraList() == null) {
            periodista.setPeriodistaComputadoraList(new ArrayList<PeriodistaComputadora>());
        }
        if (periodista.getPeriodistaMisionList() == null) {
            periodista.setPeriodistaMisionList(new ArrayList<PeriodistaMision>());
        }
        if (periodista.getPeriodistaIdiomaList() == null) {
            periodista.setPeriodistaIdiomaList(new ArrayList<PeriodistaIdioma>());
        }
        if (periodista.getBajaList() == null) {
            periodista.setBajaList(new ArrayList<Baja>());
        }
        if (periodista.getPeriodistaCargopList() == null) {
            periodista.setPeriodistaCargopList(new ArrayList<PeriodistaCargop>());
        }
        if (periodista.getPeriodistaCondecoracionList() == null) {
            periodista.setPeriodistaCondecoracionList(new ArrayList<PeriodistaCondecoracion>());
        }
        if (periodista.getPeriodistaCirculoList() == null) {
            periodista.setPeriodistaCirculoList(new ArrayList<PeriodistaCirculo>());
        }
        if (periodista.getPeriodistaEventoList() == null) {
            periodista.setPeriodistaEventoList(new ArrayList<PeriodistaEvento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Delegacion delegacion = periodista.getDelegacion();
            if (delegacion != null) {
                delegacion = em.getReference(delegacion.getClass(), delegacion.getIdDelegacion());
                periodista.setDelegacion(delegacion);
            }
            CargoUpec cargoUpec = periodista.getCargoUpec();
            if (cargoUpec != null) {
                cargoUpec = em.getReference(cargoUpec.getClass(), cargoUpec.getIdCargou());
                periodista.setCargoUpec(cargoUpec);
            }
            List<PeriodistaPostgrado> attachedPeriodistaPostgradoList = new ArrayList<PeriodistaPostgrado>();
            for (PeriodistaPostgrado periodistaPostgradoListPeriodistaPostgradoToAttach : periodista.getPeriodistaPostgradoList()) {
                periodistaPostgradoListPeriodistaPostgradoToAttach = em.getReference(periodistaPostgradoListPeriodistaPostgradoToAttach.getClass(), periodistaPostgradoListPeriodistaPostgradoToAttach.getIdPerPostg());
                attachedPeriodistaPostgradoList.add(periodistaPostgradoListPeriodistaPostgradoToAttach);
            }
            periodista.setPeriodistaPostgradoList(attachedPeriodistaPostgradoList);
            List<PeriodistaCategoria> attachedPeriodistaCategoriaList = new ArrayList<PeriodistaCategoria>();
            for (PeriodistaCategoria periodistaCategoriaListPeriodistaCategoriaToAttach : periodista.getPeriodistaCategoriaList()) {
                periodistaCategoriaListPeriodistaCategoriaToAttach = em.getReference(periodistaCategoriaListPeriodistaCategoriaToAttach.getClass(), periodistaCategoriaListPeriodistaCategoriaToAttach.getIdPeriodsitaCateg());
                attachedPeriodistaCategoriaList.add(periodistaCategoriaListPeriodistaCategoriaToAttach);
            }
            periodista.setPeriodistaCategoriaList(attachedPeriodistaCategoriaList);
            List<PeriodistaPremio> attachedPeriodistaPremioList = new ArrayList<PeriodistaPremio>();
            for (PeriodistaPremio periodistaPremioListPeriodistaPremioToAttach : periodista.getPeriodistaPremioList()) {
                periodistaPremioListPeriodistaPremioToAttach = em.getReference(periodistaPremioListPeriodistaPremioToAttach.getClass(), periodistaPremioListPeriodistaPremioToAttach.getIdPerPremio());
                attachedPeriodistaPremioList.add(periodistaPremioListPeriodistaPremioToAttach);
            }
            periodista.setPeriodistaPremioList(attachedPeriodistaPremioList);
            List<PeriodistaComputadora> attachedPeriodistaComputadoraList = new ArrayList<PeriodistaComputadora>();
            for (PeriodistaComputadora periodistaComputadoraListPeriodistaComputadoraToAttach : periodista.getPeriodistaComputadoraList()) {
                periodistaComputadoraListPeriodistaComputadoraToAttach = em.getReference(periodistaComputadoraListPeriodistaComputadoraToAttach.getClass(), periodistaComputadoraListPeriodistaComputadoraToAttach.getIdPerComp());
                attachedPeriodistaComputadoraList.add(periodistaComputadoraListPeriodistaComputadoraToAttach);
            }
            periodista.setPeriodistaComputadoraList(attachedPeriodistaComputadoraList);
            List<PeriodistaMision> attachedPeriodistaMisionList = new ArrayList<PeriodistaMision>();
            for (PeriodistaMision periodistaMisionListPeriodistaMisionToAttach : periodista.getPeriodistaMisionList()) {
                periodistaMisionListPeriodistaMisionToAttach = em.getReference(periodistaMisionListPeriodistaMisionToAttach.getClass(), periodistaMisionListPeriodistaMisionToAttach.getIdPerMision());
                attachedPeriodistaMisionList.add(periodistaMisionListPeriodistaMisionToAttach);
            }
            periodista.setPeriodistaMisionList(attachedPeriodistaMisionList);
            List<PeriodistaIdioma> attachedPeriodistaIdiomaList = new ArrayList<PeriodistaIdioma>();
            for (PeriodistaIdioma periodistaIdiomaListPeriodistaIdiomaToAttach : periodista.getPeriodistaIdiomaList()) {
                periodistaIdiomaListPeriodistaIdiomaToAttach = em.getReference(periodistaIdiomaListPeriodistaIdiomaToAttach.getClass(), periodistaIdiomaListPeriodistaIdiomaToAttach.getIdPerIdioma());
                attachedPeriodistaIdiomaList.add(periodistaIdiomaListPeriodistaIdiomaToAttach);
            }
            periodista.setPeriodistaIdiomaList(attachedPeriodistaIdiomaList);
            List<Baja> attachedBajaList = new ArrayList<Baja>();
            for (Baja bajaListBajaToAttach : periodista.getBajaList()) {
                bajaListBajaToAttach = em.getReference(bajaListBajaToAttach.getClass(), bajaListBajaToAttach.getIdBaja());
                attachedBajaList.add(bajaListBajaToAttach);
            }
            periodista.setBajaList(attachedBajaList);
            List<PeriodistaCargop> attachedPeriodistaCargopList = new ArrayList<PeriodistaCargop>();
            for (PeriodistaCargop periodistaCargopListPeriodistaCargopToAttach : periodista.getPeriodistaCargopList()) {
                periodistaCargopListPeriodistaCargopToAttach = em.getReference(periodistaCargopListPeriodistaCargopToAttach.getClass(), periodistaCargopListPeriodistaCargopToAttach.getIdPerCargo());
                attachedPeriodistaCargopList.add(periodistaCargopListPeriodistaCargopToAttach);
            }
            periodista.setPeriodistaCargopList(attachedPeriodistaCargopList);
            List<PeriodistaCondecoracion> attachedPeriodistaCondecoracionList = new ArrayList<PeriodistaCondecoracion>();
            for (PeriodistaCondecoracion periodistaCondecoracionListPeriodistaCondecoracionToAttach : periodista.getPeriodistaCondecoracionList()) {
                periodistaCondecoracionListPeriodistaCondecoracionToAttach = em.getReference(periodistaCondecoracionListPeriodistaCondecoracionToAttach.getClass(), periodistaCondecoracionListPeriodistaCondecoracionToAttach.getIdPerCondec());
                attachedPeriodistaCondecoracionList.add(periodistaCondecoracionListPeriodistaCondecoracionToAttach);
            }
            periodista.setPeriodistaCondecoracionList(attachedPeriodistaCondecoracionList);
            List<PeriodistaCirculo> attachedPeriodistaCirculoList = new ArrayList<PeriodistaCirculo>();
            for (PeriodistaCirculo periodistaCirculoListPeriodistaCirculoToAttach : periodista.getPeriodistaCirculoList()) {
                periodistaCirculoListPeriodistaCirculoToAttach = em.getReference(periodistaCirculoListPeriodistaCirculoToAttach.getClass(), periodistaCirculoListPeriodistaCirculoToAttach.getIdPerCirculo());
                attachedPeriodistaCirculoList.add(periodistaCirculoListPeriodistaCirculoToAttach);
            }
            periodista.setPeriodistaCirculoList(attachedPeriodistaCirculoList);
            List<PeriodistaEvento> attachedPeriodistaEventoList = new ArrayList<PeriodistaEvento>();
            for (PeriodistaEvento periodistaEventoListPeriodistaEventoToAttach : periodista.getPeriodistaEventoList()) {
                periodistaEventoListPeriodistaEventoToAttach = em.getReference(periodistaEventoListPeriodistaEventoToAttach.getClass(), periodistaEventoListPeriodistaEventoToAttach.getIdPerEvento());
                attachedPeriodistaEventoList.add(periodistaEventoListPeriodistaEventoToAttach);
            }
            periodista.setPeriodistaEventoList(attachedPeriodistaEventoList);
            em.persist(periodista);
            if (delegacion != null) {
                delegacion.getPeriodistaList().add(periodista);
                delegacion = em.merge(delegacion);
            }
            if (cargoUpec != null) {
                cargoUpec.getPeriodistaList().add(periodista);
                cargoUpec = em.merge(cargoUpec);
            }
            for (PeriodistaPostgrado periodistaPostgradoListPeriodistaPostgrado : periodista.getPeriodistaPostgradoList()) {
                Periodista oldPeriodistaOfPeriodistaPostgradoListPeriodistaPostgrado = periodistaPostgradoListPeriodistaPostgrado.getPeriodista();
                periodistaPostgradoListPeriodistaPostgrado.setPeriodista(periodista);
                periodistaPostgradoListPeriodistaPostgrado = em.merge(periodistaPostgradoListPeriodistaPostgrado);
                if (oldPeriodistaOfPeriodistaPostgradoListPeriodistaPostgrado != null) {
                    oldPeriodistaOfPeriodistaPostgradoListPeriodistaPostgrado.getPeriodistaPostgradoList().remove(periodistaPostgradoListPeriodistaPostgrado);
                    oldPeriodistaOfPeriodistaPostgradoListPeriodistaPostgrado = em.merge(oldPeriodistaOfPeriodistaPostgradoListPeriodistaPostgrado);
                }
            }
            for (PeriodistaCategoria periodistaCategoriaListPeriodistaCategoria : periodista.getPeriodistaCategoriaList()) {
                Periodista oldPeriodistaOfPeriodistaCategoriaListPeriodistaCategoria = periodistaCategoriaListPeriodistaCategoria.getPeriodista();
                periodistaCategoriaListPeriodistaCategoria.setPeriodista(periodista);
                periodistaCategoriaListPeriodistaCategoria = em.merge(periodistaCategoriaListPeriodistaCategoria);
                if (oldPeriodistaOfPeriodistaCategoriaListPeriodistaCategoria != null) {
                    oldPeriodistaOfPeriodistaCategoriaListPeriodistaCategoria.getPeriodistaCategoriaList().remove(periodistaCategoriaListPeriodistaCategoria);
                    oldPeriodistaOfPeriodistaCategoriaListPeriodistaCategoria = em.merge(oldPeriodistaOfPeriodistaCategoriaListPeriodistaCategoria);
                }
            }
            for (PeriodistaPremio periodistaPremioListPeriodistaPremio : periodista.getPeriodistaPremioList()) {
                Periodista oldPeriodistaOfPeriodistaPremioListPeriodistaPremio = periodistaPremioListPeriodistaPremio.getPeriodista();
                periodistaPremioListPeriodistaPremio.setPeriodista(periodista);
                periodistaPremioListPeriodistaPremio = em.merge(periodistaPremioListPeriodistaPremio);
                if (oldPeriodistaOfPeriodistaPremioListPeriodistaPremio != null) {
                    oldPeriodistaOfPeriodistaPremioListPeriodistaPremio.getPeriodistaPremioList().remove(periodistaPremioListPeriodistaPremio);
                    oldPeriodistaOfPeriodistaPremioListPeriodistaPremio = em.merge(oldPeriodistaOfPeriodistaPremioListPeriodistaPremio);
                }
            }
            for (PeriodistaComputadora periodistaComputadoraListPeriodistaComputadora : periodista.getPeriodistaComputadoraList()) {
                Periodista oldPeriodistaOfPeriodistaComputadoraListPeriodistaComputadora = periodistaComputadoraListPeriodistaComputadora.getPeriodista();
                periodistaComputadoraListPeriodistaComputadora.setPeriodista(periodista);
                periodistaComputadoraListPeriodistaComputadora = em.merge(periodistaComputadoraListPeriodistaComputadora);
                if (oldPeriodistaOfPeriodistaComputadoraListPeriodistaComputadora != null) {
                    oldPeriodistaOfPeriodistaComputadoraListPeriodistaComputadora.getPeriodistaComputadoraList().remove(periodistaComputadoraListPeriodistaComputadora);
                    oldPeriodistaOfPeriodistaComputadoraListPeriodistaComputadora = em.merge(oldPeriodistaOfPeriodistaComputadoraListPeriodistaComputadora);
                }
            }
            for (PeriodistaMision periodistaMisionListPeriodistaMision : periodista.getPeriodistaMisionList()) {
                Periodista oldPeriodistaOfPeriodistaMisionListPeriodistaMision = periodistaMisionListPeriodistaMision.getPeriodista();
                periodistaMisionListPeriodistaMision.setPeriodista(periodista);
                periodistaMisionListPeriodistaMision = em.merge(periodistaMisionListPeriodistaMision);
                if (oldPeriodistaOfPeriodistaMisionListPeriodistaMision != null) {
                    oldPeriodistaOfPeriodistaMisionListPeriodistaMision.getPeriodistaMisionList().remove(periodistaMisionListPeriodistaMision);
                    oldPeriodistaOfPeriodistaMisionListPeriodistaMision = em.merge(oldPeriodistaOfPeriodistaMisionListPeriodistaMision);
                }
            }
            for (PeriodistaIdioma periodistaIdiomaListPeriodistaIdioma : periodista.getPeriodistaIdiomaList()) {
                Periodista oldPeriodistaOfPeriodistaIdiomaListPeriodistaIdioma = periodistaIdiomaListPeriodistaIdioma.getPeriodista();
                periodistaIdiomaListPeriodistaIdioma.setPeriodista(periodista);
                periodistaIdiomaListPeriodistaIdioma = em.merge(periodistaIdiomaListPeriodistaIdioma);
                if (oldPeriodistaOfPeriodistaIdiomaListPeriodistaIdioma != null) {
                    oldPeriodistaOfPeriodistaIdiomaListPeriodistaIdioma.getPeriodistaIdiomaList().remove(periodistaIdiomaListPeriodistaIdioma);
                    oldPeriodistaOfPeriodistaIdiomaListPeriodistaIdioma = em.merge(oldPeriodistaOfPeriodistaIdiomaListPeriodistaIdioma);
                }
            }
            for (Baja bajaListBaja : periodista.getBajaList()) {
                Periodista oldPeriodistaOfBajaListBaja = bajaListBaja.getPeriodista();
                bajaListBaja.setPeriodista(periodista);
                bajaListBaja = em.merge(bajaListBaja);
                if (oldPeriodistaOfBajaListBaja != null) {
                    oldPeriodistaOfBajaListBaja.getBajaList().remove(bajaListBaja);
                    oldPeriodistaOfBajaListBaja = em.merge(oldPeriodistaOfBajaListBaja);
                }
            }
            for (PeriodistaCargop periodistaCargopListPeriodistaCargop : periodista.getPeriodistaCargopList()) {
                Periodista oldPeriodistaOfPeriodistaCargopListPeriodistaCargop = periodistaCargopListPeriodistaCargop.getPeriodista();
                periodistaCargopListPeriodistaCargop.setPeriodista(periodista);
                periodistaCargopListPeriodistaCargop = em.merge(periodistaCargopListPeriodistaCargop);
                if (oldPeriodistaOfPeriodistaCargopListPeriodistaCargop != null) {
                    oldPeriodistaOfPeriodistaCargopListPeriodistaCargop.getPeriodistaCargopList().remove(periodistaCargopListPeriodistaCargop);
                    oldPeriodistaOfPeriodistaCargopListPeriodistaCargop = em.merge(oldPeriodistaOfPeriodistaCargopListPeriodistaCargop);
                }
            }
            for (PeriodistaCondecoracion periodistaCondecoracionListPeriodistaCondecoracion : periodista.getPeriodistaCondecoracionList()) {
                Periodista oldPeriodistaOfPeriodistaCondecoracionListPeriodistaCondecoracion = periodistaCondecoracionListPeriodistaCondecoracion.getPeriodista();
                periodistaCondecoracionListPeriodistaCondecoracion.setPeriodista(periodista);
                periodistaCondecoracionListPeriodistaCondecoracion = em.merge(periodistaCondecoracionListPeriodistaCondecoracion);
                if (oldPeriodistaOfPeriodistaCondecoracionListPeriodistaCondecoracion != null) {
                    oldPeriodistaOfPeriodistaCondecoracionListPeriodistaCondecoracion.getPeriodistaCondecoracionList().remove(periodistaCondecoracionListPeriodistaCondecoracion);
                    oldPeriodistaOfPeriodistaCondecoracionListPeriodistaCondecoracion = em.merge(oldPeriodistaOfPeriodistaCondecoracionListPeriodistaCondecoracion);
                }
            }
            for (PeriodistaCirculo periodistaCirculoListPeriodistaCirculo : periodista.getPeriodistaCirculoList()) {
                Periodista oldPeriodistaOfPeriodistaCirculoListPeriodistaCirculo = periodistaCirculoListPeriodistaCirculo.getPeriodista();
                periodistaCirculoListPeriodistaCirculo.setPeriodista(periodista);
                periodistaCirculoListPeriodistaCirculo = em.merge(periodistaCirculoListPeriodistaCirculo);
                if (oldPeriodistaOfPeriodistaCirculoListPeriodistaCirculo != null) {
                    oldPeriodistaOfPeriodistaCirculoListPeriodistaCirculo.getPeriodistaCirculoList().remove(periodistaCirculoListPeriodistaCirculo);
                    oldPeriodistaOfPeriodistaCirculoListPeriodistaCirculo = em.merge(oldPeriodistaOfPeriodistaCirculoListPeriodistaCirculo);
                }
            }
            for (PeriodistaEvento periodistaEventoListPeriodistaEvento : periodista.getPeriodistaEventoList()) {
                Periodista oldPeriodistaOfPeriodistaEventoListPeriodistaEvento = periodistaEventoListPeriodistaEvento.getPeriodista();
                periodistaEventoListPeriodistaEvento.setPeriodista(periodista);
                periodistaEventoListPeriodistaEvento = em.merge(periodistaEventoListPeriodistaEvento);
                if (oldPeriodistaOfPeriodistaEventoListPeriodistaEvento != null) {
                    oldPeriodistaOfPeriodistaEventoListPeriodistaEvento.getPeriodistaEventoList().remove(periodistaEventoListPeriodistaEvento);
                    oldPeriodistaOfPeriodistaEventoListPeriodistaEvento = em.merge(oldPeriodistaOfPeriodistaEventoListPeriodistaEvento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodista(periodista.getIdPeriodista()) != null) {
                throw new PreexistingEntityException("Periodista " + periodista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Periodista periodista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista persistentPeriodista = em.find(Periodista.class, periodista.getIdPeriodista());
            Delegacion delegacionOld = persistentPeriodista.getDelegacion();
            Delegacion delegacionNew = periodista.getDelegacion();
            CargoUpec cargoUpecOld = persistentPeriodista.getCargoUpec();
            CargoUpec cargoUpecNew = periodista.getCargoUpec();
            List<PeriodistaPostgrado> periodistaPostgradoListOld = persistentPeriodista.getPeriodistaPostgradoList();
            List<PeriodistaPostgrado> periodistaPostgradoListNew = periodista.getPeriodistaPostgradoList();
            List<PeriodistaCategoria> periodistaCategoriaListOld = persistentPeriodista.getPeriodistaCategoriaList();
            List<PeriodistaCategoria> periodistaCategoriaListNew = periodista.getPeriodistaCategoriaList();
            List<PeriodistaPremio> periodistaPremioListOld = persistentPeriodista.getPeriodistaPremioList();
            List<PeriodistaPremio> periodistaPremioListNew = periodista.getPeriodistaPremioList();
            List<PeriodistaComputadora> periodistaComputadoraListOld = persistentPeriodista.getPeriodistaComputadoraList();
            List<PeriodistaComputadora> periodistaComputadoraListNew = periodista.getPeriodistaComputadoraList();
            List<PeriodistaMision> periodistaMisionListOld = persistentPeriodista.getPeriodistaMisionList();
            List<PeriodistaMision> periodistaMisionListNew = periodista.getPeriodistaMisionList();
            List<PeriodistaIdioma> periodistaIdiomaListOld = persistentPeriodista.getPeriodistaIdiomaList();
            List<PeriodistaIdioma> periodistaIdiomaListNew = periodista.getPeriodistaIdiomaList();
            List<Baja> bajaListOld = persistentPeriodista.getBajaList();
            List<Baja> bajaListNew = periodista.getBajaList();
            List<PeriodistaCargop> periodistaCargopListOld = persistentPeriodista.getPeriodistaCargopList();
            List<PeriodistaCargop> periodistaCargopListNew = periodista.getPeriodistaCargopList();
            List<PeriodistaCondecoracion> periodistaCondecoracionListOld = persistentPeriodista.getPeriodistaCondecoracionList();
            List<PeriodistaCondecoracion> periodistaCondecoracionListNew = periodista.getPeriodistaCondecoracionList();
            List<PeriodistaCirculo> periodistaCirculoListOld = persistentPeriodista.getPeriodistaCirculoList();
            List<PeriodistaCirculo> periodistaCirculoListNew = periodista.getPeriodistaCirculoList();
            List<PeriodistaEvento> periodistaEventoListOld = persistentPeriodista.getPeriodistaEventoList();
            List<PeriodistaEvento> periodistaEventoListNew = periodista.getPeriodistaEventoList();
            if (delegacionNew != null) {
                delegacionNew = em.getReference(delegacionNew.getClass(), delegacionNew.getIdDelegacion());
                periodista.setDelegacion(delegacionNew);
            }
            if (cargoUpecNew != null) {
                cargoUpecNew = em.getReference(cargoUpecNew.getClass(), cargoUpecNew.getIdCargou());
                periodista.setCargoUpec(cargoUpecNew);
            }
            List<PeriodistaPostgrado> attachedPeriodistaPostgradoListNew = new ArrayList<PeriodistaPostgrado>();
            for (PeriodistaPostgrado periodistaPostgradoListNewPeriodistaPostgradoToAttach : periodistaPostgradoListNew) {
                periodistaPostgradoListNewPeriodistaPostgradoToAttach = em.getReference(periodistaPostgradoListNewPeriodistaPostgradoToAttach.getClass(), periodistaPostgradoListNewPeriodistaPostgradoToAttach.getIdPerPostg());
                attachedPeriodistaPostgradoListNew.add(periodistaPostgradoListNewPeriodistaPostgradoToAttach);
            }
            periodistaPostgradoListNew = attachedPeriodistaPostgradoListNew;
            periodista.setPeriodistaPostgradoList(periodistaPostgradoListNew);
            List<PeriodistaCategoria> attachedPeriodistaCategoriaListNew = new ArrayList<PeriodistaCategoria>();
            for (PeriodistaCategoria periodistaCategoriaListNewPeriodistaCategoriaToAttach : periodistaCategoriaListNew) {
                periodistaCategoriaListNewPeriodistaCategoriaToAttach = em.getReference(periodistaCategoriaListNewPeriodistaCategoriaToAttach.getClass(), periodistaCategoriaListNewPeriodistaCategoriaToAttach.getIdPeriodsitaCateg());
                attachedPeriodistaCategoriaListNew.add(periodistaCategoriaListNewPeriodistaCategoriaToAttach);
            }
            periodistaCategoriaListNew = attachedPeriodistaCategoriaListNew;
            periodista.setPeriodistaCategoriaList(periodistaCategoriaListNew);
            List<PeriodistaPremio> attachedPeriodistaPremioListNew = new ArrayList<PeriodistaPremio>();
            for (PeriodistaPremio periodistaPremioListNewPeriodistaPremioToAttach : periodistaPremioListNew) {
                periodistaPremioListNewPeriodistaPremioToAttach = em.getReference(periodistaPremioListNewPeriodistaPremioToAttach.getClass(), periodistaPremioListNewPeriodistaPremioToAttach.getIdPerPremio());
                attachedPeriodistaPremioListNew.add(periodistaPremioListNewPeriodistaPremioToAttach);
            }
            periodistaPremioListNew = attachedPeriodistaPremioListNew;
            periodista.setPeriodistaPremioList(periodistaPremioListNew);
            List<PeriodistaComputadora> attachedPeriodistaComputadoraListNew = new ArrayList<PeriodistaComputadora>();
            for (PeriodistaComputadora periodistaComputadoraListNewPeriodistaComputadoraToAttach : periodistaComputadoraListNew) {
                periodistaComputadoraListNewPeriodistaComputadoraToAttach = em.getReference(periodistaComputadoraListNewPeriodistaComputadoraToAttach.getClass(), periodistaComputadoraListNewPeriodistaComputadoraToAttach.getIdPerComp());
                attachedPeriodistaComputadoraListNew.add(periodistaComputadoraListNewPeriodistaComputadoraToAttach);
            }
            periodistaComputadoraListNew = attachedPeriodistaComputadoraListNew;
            periodista.setPeriodistaComputadoraList(periodistaComputadoraListNew);
            List<PeriodistaMision> attachedPeriodistaMisionListNew = new ArrayList<PeriodistaMision>();
            for (PeriodistaMision periodistaMisionListNewPeriodistaMisionToAttach : periodistaMisionListNew) {
                periodistaMisionListNewPeriodistaMisionToAttach = em.getReference(periodistaMisionListNewPeriodistaMisionToAttach.getClass(), periodistaMisionListNewPeriodistaMisionToAttach.getIdPerMision());
                attachedPeriodistaMisionListNew.add(periodistaMisionListNewPeriodistaMisionToAttach);
            }
            periodistaMisionListNew = attachedPeriodistaMisionListNew;
            periodista.setPeriodistaMisionList(periodistaMisionListNew);
            List<PeriodistaIdioma> attachedPeriodistaIdiomaListNew = new ArrayList<PeriodistaIdioma>();
            for (PeriodistaIdioma periodistaIdiomaListNewPeriodistaIdiomaToAttach : periodistaIdiomaListNew) {
                periodistaIdiomaListNewPeriodistaIdiomaToAttach = em.getReference(periodistaIdiomaListNewPeriodistaIdiomaToAttach.getClass(), periodistaIdiomaListNewPeriodistaIdiomaToAttach.getIdPerIdioma());
                attachedPeriodistaIdiomaListNew.add(periodistaIdiomaListNewPeriodistaIdiomaToAttach);
            }
            periodistaIdiomaListNew = attachedPeriodistaIdiomaListNew;
            periodista.setPeriodistaIdiomaList(periodistaIdiomaListNew);
            List<Baja> attachedBajaListNew = new ArrayList<Baja>();
            for (Baja bajaListNewBajaToAttach : bajaListNew) {
                bajaListNewBajaToAttach = em.getReference(bajaListNewBajaToAttach.getClass(), bajaListNewBajaToAttach.getIdBaja());
                attachedBajaListNew.add(bajaListNewBajaToAttach);
            }
            bajaListNew = attachedBajaListNew;
            periodista.setBajaList(bajaListNew);
            List<PeriodistaCargop> attachedPeriodistaCargopListNew = new ArrayList<PeriodistaCargop>();
            for (PeriodistaCargop periodistaCargopListNewPeriodistaCargopToAttach : periodistaCargopListNew) {
                periodistaCargopListNewPeriodistaCargopToAttach = em.getReference(periodistaCargopListNewPeriodistaCargopToAttach.getClass(), periodistaCargopListNewPeriodistaCargopToAttach.getIdPerCargo());
                attachedPeriodistaCargopListNew.add(periodistaCargopListNewPeriodistaCargopToAttach);
            }
            periodistaCargopListNew = attachedPeriodistaCargopListNew;
            periodista.setPeriodistaCargopList(periodistaCargopListNew);
            List<PeriodistaCondecoracion> attachedPeriodistaCondecoracionListNew = new ArrayList<PeriodistaCondecoracion>();
            for (PeriodistaCondecoracion periodistaCondecoracionListNewPeriodistaCondecoracionToAttach : periodistaCondecoracionListNew) {
                periodistaCondecoracionListNewPeriodistaCondecoracionToAttach = em.getReference(periodistaCondecoracionListNewPeriodistaCondecoracionToAttach.getClass(), periodistaCondecoracionListNewPeriodistaCondecoracionToAttach.getIdPerCondec());
                attachedPeriodistaCondecoracionListNew.add(periodistaCondecoracionListNewPeriodistaCondecoracionToAttach);
            }
            periodistaCondecoracionListNew = attachedPeriodistaCondecoracionListNew;
            periodista.setPeriodistaCondecoracionList(periodistaCondecoracionListNew);
            List<PeriodistaCirculo> attachedPeriodistaCirculoListNew = new ArrayList<PeriodistaCirculo>();
            for (PeriodistaCirculo periodistaCirculoListNewPeriodistaCirculoToAttach : periodistaCirculoListNew) {
                periodistaCirculoListNewPeriodistaCirculoToAttach = em.getReference(periodistaCirculoListNewPeriodistaCirculoToAttach.getClass(), periodistaCirculoListNewPeriodistaCirculoToAttach.getIdPerCirculo());
                attachedPeriodistaCirculoListNew.add(periodistaCirculoListNewPeriodistaCirculoToAttach);
            }
            periodistaCirculoListNew = attachedPeriodistaCirculoListNew;
            periodista.setPeriodistaCirculoList(periodistaCirculoListNew);
            List<PeriodistaEvento> attachedPeriodistaEventoListNew = new ArrayList<PeriodistaEvento>();
            for (PeriodistaEvento periodistaEventoListNewPeriodistaEventoToAttach : periodistaEventoListNew) {
                periodistaEventoListNewPeriodistaEventoToAttach = em.getReference(periodistaEventoListNewPeriodistaEventoToAttach.getClass(), periodistaEventoListNewPeriodistaEventoToAttach.getIdPerEvento());
                attachedPeriodistaEventoListNew.add(periodistaEventoListNewPeriodistaEventoToAttach);
            }
            periodistaEventoListNew = attachedPeriodistaEventoListNew;
            periodista.setPeriodistaEventoList(periodistaEventoListNew);
            periodista = em.merge(periodista);
            if (delegacionOld != null && !delegacionOld.equals(delegacionNew)) {
                delegacionOld.getPeriodistaList().remove(periodista);
                delegacionOld = em.merge(delegacionOld);
            }
            if (delegacionNew != null && !delegacionNew.equals(delegacionOld)) {
                delegacionNew.getPeriodistaList().add(periodista);
                delegacionNew = em.merge(delegacionNew);
            }
            if (cargoUpecOld != null && !cargoUpecOld.equals(cargoUpecNew)) {
                cargoUpecOld.getPeriodistaList().remove(periodista);
                cargoUpecOld = em.merge(cargoUpecOld);
            }
            if (cargoUpecNew != null && !cargoUpecNew.equals(cargoUpecOld)) {
                cargoUpecNew.getPeriodistaList().add(periodista);
                cargoUpecNew = em.merge(cargoUpecNew);
            }
            for (PeriodistaPostgrado periodistaPostgradoListOldPeriodistaPostgrado : periodistaPostgradoListOld) {
                if (!periodistaPostgradoListNew.contains(periodistaPostgradoListOldPeriodistaPostgrado)) {
                    periodistaPostgradoListOldPeriodistaPostgrado.setPeriodista(null);
                    periodistaPostgradoListOldPeriodistaPostgrado = em.merge(periodistaPostgradoListOldPeriodistaPostgrado);
                }
            }
            for (PeriodistaPostgrado periodistaPostgradoListNewPeriodistaPostgrado : periodistaPostgradoListNew) {
                if (!periodistaPostgradoListOld.contains(periodistaPostgradoListNewPeriodistaPostgrado)) {
                    Periodista oldPeriodistaOfPeriodistaPostgradoListNewPeriodistaPostgrado = periodistaPostgradoListNewPeriodistaPostgrado.getPeriodista();
                    periodistaPostgradoListNewPeriodistaPostgrado.setPeriodista(periodista);
                    periodistaPostgradoListNewPeriodistaPostgrado = em.merge(periodistaPostgradoListNewPeriodistaPostgrado);
                    if (oldPeriodistaOfPeriodistaPostgradoListNewPeriodistaPostgrado != null && !oldPeriodistaOfPeriodistaPostgradoListNewPeriodistaPostgrado.equals(periodista)) {
                        oldPeriodistaOfPeriodistaPostgradoListNewPeriodistaPostgrado.getPeriodistaPostgradoList().remove(periodistaPostgradoListNewPeriodistaPostgrado);
                        oldPeriodistaOfPeriodistaPostgradoListNewPeriodistaPostgrado = em.merge(oldPeriodistaOfPeriodistaPostgradoListNewPeriodistaPostgrado);
                    }
                }
            }
            for (PeriodistaCategoria periodistaCategoriaListOldPeriodistaCategoria : periodistaCategoriaListOld) {
                if (!periodistaCategoriaListNew.contains(periodistaCategoriaListOldPeriodistaCategoria)) {
                    periodistaCategoriaListOldPeriodistaCategoria.setPeriodista(null);
                    periodistaCategoriaListOldPeriodistaCategoria = em.merge(periodistaCategoriaListOldPeriodistaCategoria);
                }
            }
            for (PeriodistaCategoria periodistaCategoriaListNewPeriodistaCategoria : periodistaCategoriaListNew) {
                if (!periodistaCategoriaListOld.contains(periodistaCategoriaListNewPeriodistaCategoria)) {
                    Periodista oldPeriodistaOfPeriodistaCategoriaListNewPeriodistaCategoria = periodistaCategoriaListNewPeriodistaCategoria.getPeriodista();
                    periodistaCategoriaListNewPeriodistaCategoria.setPeriodista(periodista);
                    periodistaCategoriaListNewPeriodistaCategoria = em.merge(periodistaCategoriaListNewPeriodistaCategoria);
                    if (oldPeriodistaOfPeriodistaCategoriaListNewPeriodistaCategoria != null && !oldPeriodistaOfPeriodistaCategoriaListNewPeriodistaCategoria.equals(periodista)) {
                        oldPeriodistaOfPeriodistaCategoriaListNewPeriodistaCategoria.getPeriodistaCategoriaList().remove(periodistaCategoriaListNewPeriodistaCategoria);
                        oldPeriodistaOfPeriodistaCategoriaListNewPeriodistaCategoria = em.merge(oldPeriodistaOfPeriodistaCategoriaListNewPeriodistaCategoria);
                    }
                }
            }
            for (PeriodistaPremio periodistaPremioListOldPeriodistaPremio : periodistaPremioListOld) {
                if (!periodistaPremioListNew.contains(periodistaPremioListOldPeriodistaPremio)) {
                    periodistaPremioListOldPeriodistaPremio.setPeriodista(null);
                    periodistaPremioListOldPeriodistaPremio = em.merge(periodistaPremioListOldPeriodistaPremio);
                }
            }
            for (PeriodistaPremio periodistaPremioListNewPeriodistaPremio : periodistaPremioListNew) {
                if (!periodistaPremioListOld.contains(periodistaPremioListNewPeriodistaPremio)) {
                    Periodista oldPeriodistaOfPeriodistaPremioListNewPeriodistaPremio = periodistaPremioListNewPeriodistaPremio.getPeriodista();
                    periodistaPremioListNewPeriodistaPremio.setPeriodista(periodista);
                    periodistaPremioListNewPeriodistaPremio = em.merge(periodistaPremioListNewPeriodistaPremio);
                    if (oldPeriodistaOfPeriodistaPremioListNewPeriodistaPremio != null && !oldPeriodistaOfPeriodistaPremioListNewPeriodistaPremio.equals(periodista)) {
                        oldPeriodistaOfPeriodistaPremioListNewPeriodistaPremio.getPeriodistaPremioList().remove(periodistaPremioListNewPeriodistaPremio);
                        oldPeriodistaOfPeriodistaPremioListNewPeriodistaPremio = em.merge(oldPeriodistaOfPeriodistaPremioListNewPeriodistaPremio);
                    }
                }
            }
            for (PeriodistaComputadora periodistaComputadoraListOldPeriodistaComputadora : periodistaComputadoraListOld) {
                if (!periodistaComputadoraListNew.contains(periodistaComputadoraListOldPeriodistaComputadora)) {
                    periodistaComputadoraListOldPeriodistaComputadora.setPeriodista(null);
                    periodistaComputadoraListOldPeriodistaComputadora = em.merge(periodistaComputadoraListOldPeriodistaComputadora);
                }
            }
            for (PeriodistaComputadora periodistaComputadoraListNewPeriodistaComputadora : periodistaComputadoraListNew) {
                if (!periodistaComputadoraListOld.contains(periodistaComputadoraListNewPeriodistaComputadora)) {
                    Periodista oldPeriodistaOfPeriodistaComputadoraListNewPeriodistaComputadora = periodistaComputadoraListNewPeriodistaComputadora.getPeriodista();
                    periodistaComputadoraListNewPeriodistaComputadora.setPeriodista(periodista);
                    periodistaComputadoraListNewPeriodistaComputadora = em.merge(periodistaComputadoraListNewPeriodistaComputadora);
                    if (oldPeriodistaOfPeriodistaComputadoraListNewPeriodistaComputadora != null && !oldPeriodistaOfPeriodistaComputadoraListNewPeriodistaComputadora.equals(periodista)) {
                        oldPeriodistaOfPeriodistaComputadoraListNewPeriodistaComputadora.getPeriodistaComputadoraList().remove(periodistaComputadoraListNewPeriodistaComputadora);
                        oldPeriodistaOfPeriodistaComputadoraListNewPeriodistaComputadora = em.merge(oldPeriodistaOfPeriodistaComputadoraListNewPeriodistaComputadora);
                    }
                }
            }
            for (PeriodistaMision periodistaMisionListOldPeriodistaMision : periodistaMisionListOld) {
                if (!periodistaMisionListNew.contains(periodistaMisionListOldPeriodistaMision)) {
                    periodistaMisionListOldPeriodistaMision.setPeriodista(null);
                    periodistaMisionListOldPeriodistaMision = em.merge(periodistaMisionListOldPeriodistaMision);
                }
            }
            for (PeriodistaMision periodistaMisionListNewPeriodistaMision : periodistaMisionListNew) {
                if (!periodistaMisionListOld.contains(periodistaMisionListNewPeriodistaMision)) {
                    Periodista oldPeriodistaOfPeriodistaMisionListNewPeriodistaMision = periodistaMisionListNewPeriodistaMision.getPeriodista();
                    periodistaMisionListNewPeriodistaMision.setPeriodista(periodista);
                    periodistaMisionListNewPeriodistaMision = em.merge(periodistaMisionListNewPeriodistaMision);
                    if (oldPeriodistaOfPeriodistaMisionListNewPeriodistaMision != null && !oldPeriodistaOfPeriodistaMisionListNewPeriodistaMision.equals(periodista)) {
                        oldPeriodistaOfPeriodistaMisionListNewPeriodistaMision.getPeriodistaMisionList().remove(periodistaMisionListNewPeriodistaMision);
                        oldPeriodistaOfPeriodistaMisionListNewPeriodistaMision = em.merge(oldPeriodistaOfPeriodistaMisionListNewPeriodistaMision);
                    }
                }
            }
            for (PeriodistaIdioma periodistaIdiomaListOldPeriodistaIdioma : periodistaIdiomaListOld) {
                if (!periodistaIdiomaListNew.contains(periodistaIdiomaListOldPeriodistaIdioma)) {
                    periodistaIdiomaListOldPeriodistaIdioma.setPeriodista(null);
                    periodistaIdiomaListOldPeriodistaIdioma = em.merge(periodistaIdiomaListOldPeriodistaIdioma);
                }
            }
            for (PeriodistaIdioma periodistaIdiomaListNewPeriodistaIdioma : periodistaIdiomaListNew) {
                if (!periodistaIdiomaListOld.contains(periodistaIdiomaListNewPeriodistaIdioma)) {
                    Periodista oldPeriodistaOfPeriodistaIdiomaListNewPeriodistaIdioma = periodistaIdiomaListNewPeriodistaIdioma.getPeriodista();
                    periodistaIdiomaListNewPeriodistaIdioma.setPeriodista(periodista);
                    periodistaIdiomaListNewPeriodistaIdioma = em.merge(periodistaIdiomaListNewPeriodistaIdioma);
                    if (oldPeriodistaOfPeriodistaIdiomaListNewPeriodistaIdioma != null && !oldPeriodistaOfPeriodistaIdiomaListNewPeriodistaIdioma.equals(periodista)) {
                        oldPeriodistaOfPeriodistaIdiomaListNewPeriodistaIdioma.getPeriodistaIdiomaList().remove(periodistaIdiomaListNewPeriodistaIdioma);
                        oldPeriodistaOfPeriodistaIdiomaListNewPeriodistaIdioma = em.merge(oldPeriodistaOfPeriodistaIdiomaListNewPeriodistaIdioma);
                    }
                }
            }
            for (Baja bajaListOldBaja : bajaListOld) {
                if (!bajaListNew.contains(bajaListOldBaja)) {
                    bajaListOldBaja.setPeriodista(null);
                    bajaListOldBaja = em.merge(bajaListOldBaja);
                }
            }
            for (Baja bajaListNewBaja : bajaListNew) {
                if (!bajaListOld.contains(bajaListNewBaja)) {
                    Periodista oldPeriodistaOfBajaListNewBaja = bajaListNewBaja.getPeriodista();
                    bajaListNewBaja.setPeriodista(periodista);
                    bajaListNewBaja = em.merge(bajaListNewBaja);
                    if (oldPeriodistaOfBajaListNewBaja != null && !oldPeriodistaOfBajaListNewBaja.equals(periodista)) {
                        oldPeriodistaOfBajaListNewBaja.getBajaList().remove(bajaListNewBaja);
                        oldPeriodistaOfBajaListNewBaja = em.merge(oldPeriodistaOfBajaListNewBaja);
                    }
                }
            }
            for (PeriodistaCargop periodistaCargopListOldPeriodistaCargop : periodistaCargopListOld) {
                if (!periodistaCargopListNew.contains(periodistaCargopListOldPeriodistaCargop)) {
                    periodistaCargopListOldPeriodistaCargop.setPeriodista(null);
                    periodistaCargopListOldPeriodistaCargop = em.merge(periodistaCargopListOldPeriodistaCargop);
                }
            }
            for (PeriodistaCargop periodistaCargopListNewPeriodistaCargop : periodistaCargopListNew) {
                if (!periodistaCargopListOld.contains(periodistaCargopListNewPeriodistaCargop)) {
                    Periodista oldPeriodistaOfPeriodistaCargopListNewPeriodistaCargop = periodistaCargopListNewPeriodistaCargop.getPeriodista();
                    periodistaCargopListNewPeriodistaCargop.setPeriodista(periodista);
                    periodistaCargopListNewPeriodistaCargop = em.merge(periodistaCargopListNewPeriodistaCargop);
                    if (oldPeriodistaOfPeriodistaCargopListNewPeriodistaCargop != null && !oldPeriodistaOfPeriodistaCargopListNewPeriodistaCargop.equals(periodista)) {
                        oldPeriodistaOfPeriodistaCargopListNewPeriodistaCargop.getPeriodistaCargopList().remove(periodistaCargopListNewPeriodistaCargop);
                        oldPeriodistaOfPeriodistaCargopListNewPeriodistaCargop = em.merge(oldPeriodistaOfPeriodistaCargopListNewPeriodistaCargop);
                    }
                }
            }
            for (PeriodistaCondecoracion periodistaCondecoracionListOldPeriodistaCondecoracion : periodistaCondecoracionListOld) {
                if (!periodistaCondecoracionListNew.contains(periodistaCondecoracionListOldPeriodistaCondecoracion)) {
                    periodistaCondecoracionListOldPeriodistaCondecoracion.setPeriodista(null);
                    periodistaCondecoracionListOldPeriodistaCondecoracion = em.merge(periodistaCondecoracionListOldPeriodistaCondecoracion);
                }
            }
            for (PeriodistaCondecoracion periodistaCondecoracionListNewPeriodistaCondecoracion : periodistaCondecoracionListNew) {
                if (!periodistaCondecoracionListOld.contains(periodistaCondecoracionListNewPeriodistaCondecoracion)) {
                    Periodista oldPeriodistaOfPeriodistaCondecoracionListNewPeriodistaCondecoracion = periodistaCondecoracionListNewPeriodistaCondecoracion.getPeriodista();
                    periodistaCondecoracionListNewPeriodistaCondecoracion.setPeriodista(periodista);
                    periodistaCondecoracionListNewPeriodistaCondecoracion = em.merge(periodistaCondecoracionListNewPeriodistaCondecoracion);
                    if (oldPeriodistaOfPeriodistaCondecoracionListNewPeriodistaCondecoracion != null && !oldPeriodistaOfPeriodistaCondecoracionListNewPeriodistaCondecoracion.equals(periodista)) {
                        oldPeriodistaOfPeriodistaCondecoracionListNewPeriodistaCondecoracion.getPeriodistaCondecoracionList().remove(periodistaCondecoracionListNewPeriodistaCondecoracion);
                        oldPeriodistaOfPeriodistaCondecoracionListNewPeriodistaCondecoracion = em.merge(oldPeriodistaOfPeriodistaCondecoracionListNewPeriodistaCondecoracion);
                    }
                }
            }
            for (PeriodistaCirculo periodistaCirculoListOldPeriodistaCirculo : periodistaCirculoListOld) {
                if (!periodistaCirculoListNew.contains(periodistaCirculoListOldPeriodistaCirculo)) {
                    periodistaCirculoListOldPeriodistaCirculo.setPeriodista(null);
                    periodistaCirculoListOldPeriodistaCirculo = em.merge(periodistaCirculoListOldPeriodistaCirculo);
                }
            }
            for (PeriodistaCirculo periodistaCirculoListNewPeriodistaCirculo : periodistaCirculoListNew) {
                if (!periodistaCirculoListOld.contains(periodistaCirculoListNewPeriodistaCirculo)) {
                    Periodista oldPeriodistaOfPeriodistaCirculoListNewPeriodistaCirculo = periodistaCirculoListNewPeriodistaCirculo.getPeriodista();
                    periodistaCirculoListNewPeriodistaCirculo.setPeriodista(periodista);
                    periodistaCirculoListNewPeriodistaCirculo = em.merge(periodistaCirculoListNewPeriodistaCirculo);
                    if (oldPeriodistaOfPeriodistaCirculoListNewPeriodistaCirculo != null && !oldPeriodistaOfPeriodistaCirculoListNewPeriodistaCirculo.equals(periodista)) {
                        oldPeriodistaOfPeriodistaCirculoListNewPeriodistaCirculo.getPeriodistaCirculoList().remove(periodistaCirculoListNewPeriodistaCirculo);
                        oldPeriodistaOfPeriodistaCirculoListNewPeriodistaCirculo = em.merge(oldPeriodistaOfPeriodistaCirculoListNewPeriodistaCirculo);
                    }
                }
            }
            for (PeriodistaEvento periodistaEventoListOldPeriodistaEvento : periodistaEventoListOld) {
                if (!periodistaEventoListNew.contains(periodistaEventoListOldPeriodistaEvento)) {
                    periodistaEventoListOldPeriodistaEvento.setPeriodista(null);
                    periodistaEventoListOldPeriodistaEvento = em.merge(periodistaEventoListOldPeriodistaEvento);
                }
            }
            for (PeriodistaEvento periodistaEventoListNewPeriodistaEvento : periodistaEventoListNew) {
                if (!periodistaEventoListOld.contains(periodistaEventoListNewPeriodistaEvento)) {
                    Periodista oldPeriodistaOfPeriodistaEventoListNewPeriodistaEvento = periodistaEventoListNewPeriodistaEvento.getPeriodista();
                    periodistaEventoListNewPeriodistaEvento.setPeriodista(periodista);
                    periodistaEventoListNewPeriodistaEvento = em.merge(periodistaEventoListNewPeriodistaEvento);
                    if (oldPeriodistaOfPeriodistaEventoListNewPeriodistaEvento != null && !oldPeriodistaOfPeriodistaEventoListNewPeriodistaEvento.equals(periodista)) {
                        oldPeriodistaOfPeriodistaEventoListNewPeriodistaEvento.getPeriodistaEventoList().remove(periodistaEventoListNewPeriodistaEvento);
                        oldPeriodistaOfPeriodistaEventoListNewPeriodistaEvento = em.merge(oldPeriodistaOfPeriodistaEventoListNewPeriodistaEvento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodista.getIdPeriodista();
                if (findPeriodista(id) == null) {
                    throw new NonexistentEntityException("The periodista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista;
            try {
                periodista = em.getReference(Periodista.class, id);
                periodista.getIdPeriodista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodista with id " + id + " no longer exists.", enfe);
            }
            Delegacion delegacion = periodista.getDelegacion();
            if (delegacion != null) {
                delegacion.getPeriodistaList().remove(periodista);
                delegacion = em.merge(delegacion);
            }
            CargoUpec cargoUpec = periodista.getCargoUpec();
            if (cargoUpec != null) {
                cargoUpec.getPeriodistaList().remove(periodista);
                cargoUpec = em.merge(cargoUpec);
            }
            List<PeriodistaPostgrado> periodistaPostgradoList = periodista.getPeriodistaPostgradoList();
            for (PeriodistaPostgrado periodistaPostgradoListPeriodistaPostgrado : periodistaPostgradoList) {
                periodistaPostgradoListPeriodistaPostgrado.setPeriodista(null);
                periodistaPostgradoListPeriodistaPostgrado = em.merge(periodistaPostgradoListPeriodistaPostgrado);
            }
            List<PeriodistaCategoria> periodistaCategoriaList = periodista.getPeriodistaCategoriaList();
            for (PeriodistaCategoria periodistaCategoriaListPeriodistaCategoria : periodistaCategoriaList) {
                periodistaCategoriaListPeriodistaCategoria.setPeriodista(null);
                periodistaCategoriaListPeriodistaCategoria = em.merge(periodistaCategoriaListPeriodistaCategoria);
            }
            List<PeriodistaPremio> periodistaPremioList = periodista.getPeriodistaPremioList();
            for (PeriodistaPremio periodistaPremioListPeriodistaPremio : periodistaPremioList) {
                periodistaPremioListPeriodistaPremio.setPeriodista(null);
                periodistaPremioListPeriodistaPremio = em.merge(periodistaPremioListPeriodistaPremio);
            }
            List<PeriodistaComputadora> periodistaComputadoraList = periodista.getPeriodistaComputadoraList();
            for (PeriodistaComputadora periodistaComputadoraListPeriodistaComputadora : periodistaComputadoraList) {
                periodistaComputadoraListPeriodistaComputadora.setPeriodista(null);
                periodistaComputadoraListPeriodistaComputadora = em.merge(periodistaComputadoraListPeriodistaComputadora);
            }
            List<PeriodistaMision> periodistaMisionList = periodista.getPeriodistaMisionList();
            for (PeriodistaMision periodistaMisionListPeriodistaMision : periodistaMisionList) {
                periodistaMisionListPeriodistaMision.setPeriodista(null);
                periodistaMisionListPeriodistaMision = em.merge(periodistaMisionListPeriodistaMision);
            }
            List<PeriodistaIdioma> periodistaIdiomaList = periodista.getPeriodistaIdiomaList();
            for (PeriodistaIdioma periodistaIdiomaListPeriodistaIdioma : periodistaIdiomaList) {
                periodistaIdiomaListPeriodistaIdioma.setPeriodista(null);
                periodistaIdiomaListPeriodistaIdioma = em.merge(periodistaIdiomaListPeriodistaIdioma);
            }
            List<Baja> bajaList = periodista.getBajaList();
            for (Baja bajaListBaja : bajaList) {
                bajaListBaja.setPeriodista(null);
                bajaListBaja = em.merge(bajaListBaja);
            }
            List<PeriodistaCargop> periodistaCargopList = periodista.getPeriodistaCargopList();
            for (PeriodistaCargop periodistaCargopListPeriodistaCargop : periodistaCargopList) {
                periodistaCargopListPeriodistaCargop.setPeriodista(null);
                periodistaCargopListPeriodistaCargop = em.merge(periodistaCargopListPeriodistaCargop);
            }
            List<PeriodistaCondecoracion> periodistaCondecoracionList = periodista.getPeriodistaCondecoracionList();
            for (PeriodistaCondecoracion periodistaCondecoracionListPeriodistaCondecoracion : periodistaCondecoracionList) {
                periodistaCondecoracionListPeriodistaCondecoracion.setPeriodista(null);
                periodistaCondecoracionListPeriodistaCondecoracion = em.merge(periodistaCondecoracionListPeriodistaCondecoracion);
            }
            List<PeriodistaCirculo> periodistaCirculoList = periodista.getPeriodistaCirculoList();
            for (PeriodistaCirculo periodistaCirculoListPeriodistaCirculo : periodistaCirculoList) {
                periodistaCirculoListPeriodistaCirculo.setPeriodista(null);
                periodistaCirculoListPeriodistaCirculo = em.merge(periodistaCirculoListPeriodistaCirculo);
            }
            List<PeriodistaEvento> periodistaEventoList = periodista.getPeriodistaEventoList();
            for (PeriodistaEvento periodistaEventoListPeriodistaEvento : periodistaEventoList) {
                periodistaEventoListPeriodistaEvento.setPeriodista(null);
                periodistaEventoListPeriodistaEvento = em.merge(periodistaEventoListPeriodistaEvento);
            }
            em.remove(periodista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Periodista> findPeriodistaEntities() {
        return findPeriodistaEntities(true, -1, -1);
    }

    public List<Periodista> findPeriodistaEntities(int maxResults, int firstResult) {
        return findPeriodistaEntities(false, maxResults, firstResult);
    }

    private List<Periodista> findPeriodistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Periodista.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Periodista findPeriodista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Periodista.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Periodista> rt = cq.from(Periodista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
