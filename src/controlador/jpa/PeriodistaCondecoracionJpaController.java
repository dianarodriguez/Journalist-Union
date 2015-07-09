/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.jpa;

import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Periodista;
import modelo.Condecoracion;
import modelo.PeriodistaCondecoracion;

/**
 *
 * @author asus
 */
public class PeriodistaCondecoracionJpaController {

    public PeriodistaCondecoracionJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaCondecoracion periodistaCondecoracion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaCondecoracion.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaCondecoracion.setPeriodista(periodista);
            }
            Condecoracion condecoracion = periodistaCondecoracion.getCondecoracion();
            if (condecoracion != null) {
                condecoracion = em.getReference(condecoracion.getClass(), condecoracion.getIdCondecoracion());
                periodistaCondecoracion.setCondecoracion(condecoracion);
            }
            em.persist(periodistaCondecoracion);
            if (periodista != null) {
                periodista.getPeriodistaCondecoracionList().add(periodistaCondecoracion);
                periodista = em.merge(periodista);
            }
            if (condecoracion != null) {
                condecoracion.getPeriodistaCondecoracionList().add(periodistaCondecoracion);
                condecoracion = em.merge(condecoracion);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaCondecoracion(periodistaCondecoracion.getIdPerCondec()) != null) {
                throw new PreexistingEntityException("PeriodistaCondecoracion " + periodistaCondecoracion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaCondecoracion periodistaCondecoracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaCondecoracion persistentPeriodistaCondecoracion = em.find(PeriodistaCondecoracion.class, periodistaCondecoracion.getIdPerCondec());
            Periodista periodistaOld = persistentPeriodistaCondecoracion.getPeriodista();
            Periodista periodistaNew = periodistaCondecoracion.getPeriodista();
            Condecoracion condecoracionOld = persistentPeriodistaCondecoracion.getCondecoracion();
            Condecoracion condecoracionNew = periodistaCondecoracion.getCondecoracion();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaCondecoracion.setPeriodista(periodistaNew);
            }
            if (condecoracionNew != null) {
                condecoracionNew = em.getReference(condecoracionNew.getClass(), condecoracionNew.getIdCondecoracion());
                periodistaCondecoracion.setCondecoracion(condecoracionNew);
            }
            periodistaCondecoracion = em.merge(periodistaCondecoracion);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaCondecoracionList().remove(periodistaCondecoracion);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaCondecoracionList().add(periodistaCondecoracion);
                periodistaNew = em.merge(periodistaNew);
            }
            if (condecoracionOld != null && !condecoracionOld.equals(condecoracionNew)) {
                condecoracionOld.getPeriodistaCondecoracionList().remove(periodistaCondecoracion);
                condecoracionOld = em.merge(condecoracionOld);
            }
            if (condecoracionNew != null && !condecoracionNew.equals(condecoracionOld)) {
                condecoracionNew.getPeriodistaCondecoracionList().add(periodistaCondecoracion);
                condecoracionNew = em.merge(condecoracionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaCondecoracion.getIdPerCondec();
                if (findPeriodistaCondecoracion(id) == null) {
                    throw new NonexistentEntityException("The periodistaCondecoracion with id " + id + " no longer exists.");
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
            PeriodistaCondecoracion periodistaCondecoracion;
            try {
                periodistaCondecoracion = em.getReference(PeriodistaCondecoracion.class, id);
                periodistaCondecoracion.getIdPerCondec();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaCondecoracion with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaCondecoracion.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaCondecoracionList().remove(periodistaCondecoracion);
                periodista = em.merge(periodista);
            }
            Condecoracion condecoracion = periodistaCondecoracion.getCondecoracion();
            if (condecoracion != null) {
                condecoracion.getPeriodistaCondecoracionList().remove(periodistaCondecoracion);
                condecoracion = em.merge(condecoracion);
            }
            em.remove(periodistaCondecoracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaCondecoracion> findPeriodistaCondecoracionEntities() {
        return findPeriodistaCondecoracionEntities(true, -1, -1);
    }

    public List<PeriodistaCondecoracion> findPeriodistaCondecoracionEntities(int maxResults, int firstResult) {
        return findPeriodistaCondecoracionEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaCondecoracion> findPeriodistaCondecoracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaCondecoracion.class));
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

    public PeriodistaCondecoracion findPeriodistaCondecoracion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaCondecoracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaCondecoracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaCondecoracion> rt = cq.from(PeriodistaCondecoracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
