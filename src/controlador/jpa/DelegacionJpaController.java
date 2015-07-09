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
import modelo.Periodista;
import java.util.ArrayList;
import java.util.List;
import modelo.Computadoras;

/**
 *
 * @author asus
 */
public class DelegacionJpaController {

    public DelegacionJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Delegacion delegacion) throws PreexistingEntityException, Exception {
        if (delegacion.getPeriodistaList() == null) {
            delegacion.setPeriodistaList(new ArrayList<Periodista>());
        }
        if (delegacion.getComputadorasList() == null) {
            delegacion.setComputadorasList(new ArrayList<Computadoras>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Periodista> attachedPeriodistaList = new ArrayList<Periodista>();
            for (Periodista periodistaListPeriodistaToAttach : delegacion.getPeriodistaList()) {
                periodistaListPeriodistaToAttach = em.getReference(periodistaListPeriodistaToAttach.getClass(), periodistaListPeriodistaToAttach.getIdPeriodista());
                attachedPeriodistaList.add(periodistaListPeriodistaToAttach);
            }
            delegacion.setPeriodistaList(attachedPeriodistaList);
            List<Computadoras> attachedComputadorasList = new ArrayList<Computadoras>();
            for (Computadoras computadorasListComputadorasToAttach : delegacion.getComputadorasList()) {
                computadorasListComputadorasToAttach = em.getReference(computadorasListComputadorasToAttach.getClass(), computadorasListComputadorasToAttach.getIdPc());
                attachedComputadorasList.add(computadorasListComputadorasToAttach);
            }
            delegacion.setComputadorasList(attachedComputadorasList);
            em.persist(delegacion);
            for (Periodista periodistaListPeriodista : delegacion.getPeriodistaList()) {
                Delegacion oldDelegacionOfPeriodistaListPeriodista = periodistaListPeriodista.getDelegacion();
                periodistaListPeriodista.setDelegacion(delegacion);
                periodistaListPeriodista = em.merge(periodistaListPeriodista);
                if (oldDelegacionOfPeriodistaListPeriodista != null) {
                    oldDelegacionOfPeriodistaListPeriodista.getPeriodistaList().remove(periodistaListPeriodista);
                    oldDelegacionOfPeriodistaListPeriodista = em.merge(oldDelegacionOfPeriodistaListPeriodista);
                }
            }
            for (Computadoras computadorasListComputadoras : delegacion.getComputadorasList()) {
                Delegacion oldDelegacionOfComputadorasListComputadoras = computadorasListComputadoras.getDelegacion();
                computadorasListComputadoras.setDelegacion(delegacion);
                computadorasListComputadoras = em.merge(computadorasListComputadoras);
                if (oldDelegacionOfComputadorasListComputadoras != null) {
                    oldDelegacionOfComputadorasListComputadoras.getComputadorasList().remove(computadorasListComputadoras);
                    oldDelegacionOfComputadorasListComputadoras = em.merge(oldDelegacionOfComputadorasListComputadoras);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDelegacion(delegacion.getIdDelegacion()) != null) {
                throw new PreexistingEntityException("Delegacion " + delegacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Delegacion delegacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Delegacion persistentDelegacion = em.find(Delegacion.class, delegacion.getIdDelegacion());
            List<Periodista> periodistaListOld = persistentDelegacion.getPeriodistaList();
            List<Periodista> periodistaListNew = delegacion.getPeriodistaList();
            List<Computadoras> computadorasListOld = persistentDelegacion.getComputadorasList();
            List<Computadoras> computadorasListNew = delegacion.getComputadorasList();
            List<Periodista> attachedPeriodistaListNew = new ArrayList<Periodista>();
            for (Periodista periodistaListNewPeriodistaToAttach : periodistaListNew) {
                periodistaListNewPeriodistaToAttach = em.getReference(periodistaListNewPeriodistaToAttach.getClass(), periodistaListNewPeriodistaToAttach.getIdPeriodista());
                attachedPeriodistaListNew.add(periodistaListNewPeriodistaToAttach);
            }
            periodistaListNew = attachedPeriodistaListNew;
            delegacion.setPeriodistaList(periodistaListNew);
            List<Computadoras> attachedComputadorasListNew = new ArrayList<Computadoras>();
            for (Computadoras computadorasListNewComputadorasToAttach : computadorasListNew) {
                computadorasListNewComputadorasToAttach = em.getReference(computadorasListNewComputadorasToAttach.getClass(), computadorasListNewComputadorasToAttach.getIdPc());
                attachedComputadorasListNew.add(computadorasListNewComputadorasToAttach);
            }
            computadorasListNew = attachedComputadorasListNew;
            delegacion.setComputadorasList(computadorasListNew);
            delegacion = em.merge(delegacion);
            for (Periodista periodistaListOldPeriodista : periodistaListOld) {
                if (!periodistaListNew.contains(periodistaListOldPeriodista)) {
                    periodistaListOldPeriodista.setDelegacion(null);
                    periodistaListOldPeriodista = em.merge(periodistaListOldPeriodista);
                }
            }
            for (Periodista periodistaListNewPeriodista : periodistaListNew) {
                if (!periodistaListOld.contains(periodistaListNewPeriodista)) {
                    Delegacion oldDelegacionOfPeriodistaListNewPeriodista = periodistaListNewPeriodista.getDelegacion();
                    periodistaListNewPeriodista.setDelegacion(delegacion);
                    periodistaListNewPeriodista = em.merge(periodistaListNewPeriodista);
                    if (oldDelegacionOfPeriodistaListNewPeriodista != null && !oldDelegacionOfPeriodistaListNewPeriodista.equals(delegacion)) {
                        oldDelegacionOfPeriodistaListNewPeriodista.getPeriodistaList().remove(periodistaListNewPeriodista);
                        oldDelegacionOfPeriodistaListNewPeriodista = em.merge(oldDelegacionOfPeriodistaListNewPeriodista);
                    }
                }
            }
            for (Computadoras computadorasListOldComputadoras : computadorasListOld) {
                if (!computadorasListNew.contains(computadorasListOldComputadoras)) {
                    computadorasListOldComputadoras.setDelegacion(null);
                    computadorasListOldComputadoras = em.merge(computadorasListOldComputadoras);
                }
            }
            for (Computadoras computadorasListNewComputadoras : computadorasListNew) {
                if (!computadorasListOld.contains(computadorasListNewComputadoras)) {
                    Delegacion oldDelegacionOfComputadorasListNewComputadoras = computadorasListNewComputadoras.getDelegacion();
                    computadorasListNewComputadoras.setDelegacion(delegacion);
                    computadorasListNewComputadoras = em.merge(computadorasListNewComputadoras);
                    if (oldDelegacionOfComputadorasListNewComputadoras != null && !oldDelegacionOfComputadorasListNewComputadoras.equals(delegacion)) {
                        oldDelegacionOfComputadorasListNewComputadoras.getComputadorasList().remove(computadorasListNewComputadoras);
                        oldDelegacionOfComputadorasListNewComputadoras = em.merge(oldDelegacionOfComputadorasListNewComputadoras);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = delegacion.getIdDelegacion();
                if (findDelegacion(id) == null) {
                    throw new NonexistentEntityException("The delegacion with id " + id + " no longer exists.");
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
            Delegacion delegacion;
            try {
                delegacion = em.getReference(Delegacion.class, id);
                delegacion.getIdDelegacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The delegacion with id " + id + " no longer exists.", enfe);
            }
            List<Periodista> periodistaList = delegacion.getPeriodistaList();
            for (Periodista periodistaListPeriodista : periodistaList) {
                periodistaListPeriodista.setDelegacion(null);
                periodistaListPeriodista = em.merge(periodistaListPeriodista);
            }
            List<Computadoras> computadorasList = delegacion.getComputadorasList();
            for (Computadoras computadorasListComputadoras : computadorasList) {
                computadorasListComputadoras.setDelegacion(null);
                computadorasListComputadoras = em.merge(computadorasListComputadoras);
            }
            em.remove(delegacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Delegacion> findDelegacionEntities() {
        return findDelegacionEntities(true, -1, -1);
    }

    public List<Delegacion> findDelegacionEntities(int maxResults, int firstResult) {
        return findDelegacionEntities(false, maxResults, firstResult);
    }

    private List<Delegacion> findDelegacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Delegacion.class));
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

    public Delegacion findDelegacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Delegacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDelegacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Delegacion> rt = cq.from(Delegacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
