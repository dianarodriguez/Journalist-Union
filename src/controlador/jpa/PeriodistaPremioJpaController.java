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
import modelo.PeriodistaPremio;
import modelo.Premio;
import modelo.Periodista;

/**
 *
 * @author asus
 */
public class PeriodistaPremioJpaController {

    public PeriodistaPremioJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaPremio periodistaPremio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Premio premio = periodistaPremio.getPremio();
            if (premio != null) {
                premio = em.getReference(premio.getClass(), premio.getIdPremio());
                periodistaPremio.setPremio(premio);
            }
            Periodista periodista = periodistaPremio.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaPremio.setPeriodista(periodista);
            }
            em.persist(periodistaPremio);
            if (premio != null) {
                premio.getPeriodistaPremioList().add(periodistaPremio);
                premio = em.merge(premio);
            }
            if (periodista != null) {
                periodista.getPeriodistaPremioList().add(periodistaPremio);
                periodista = em.merge(periodista);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaPremio(periodistaPremio.getIdPerPremio()) != null) {
                throw new PreexistingEntityException("PeriodistaPremio " + periodistaPremio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaPremio periodistaPremio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaPremio persistentPeriodistaPremio = em.find(PeriodistaPremio.class, periodistaPremio.getIdPerPremio());
            Premio premioOld = persistentPeriodistaPremio.getPremio();
            Premio premioNew = periodistaPremio.getPremio();
            Periodista periodistaOld = persistentPeriodistaPremio.getPeriodista();
            Periodista periodistaNew = periodistaPremio.getPeriodista();
            if (premioNew != null) {
                premioNew = em.getReference(premioNew.getClass(), premioNew.getIdPremio());
                periodistaPremio.setPremio(premioNew);
            }
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaPremio.setPeriodista(periodistaNew);
            }
            periodistaPremio = em.merge(periodistaPremio);
            if (premioOld != null && !premioOld.equals(premioNew)) {
                premioOld.getPeriodistaPremioList().remove(periodistaPremio);
                premioOld = em.merge(premioOld);
            }
            if (premioNew != null && !premioNew.equals(premioOld)) {
                premioNew.getPeriodistaPremioList().add(periodistaPremio);
                premioNew = em.merge(premioNew);
            }
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaPremioList().remove(periodistaPremio);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaPremioList().add(periodistaPremio);
                periodistaNew = em.merge(periodistaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaPremio.getIdPerPremio();
                if (findPeriodistaPremio(id) == null) {
                    throw new NonexistentEntityException("The periodistaPremio with id " + id + " no longer exists.");
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
            PeriodistaPremio periodistaPremio;
            try {
                periodistaPremio = em.getReference(PeriodistaPremio.class, id);
                periodistaPremio.getIdPerPremio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaPremio with id " + id + " no longer exists.", enfe);
            }
            Premio premio = periodistaPremio.getPremio();
            if (premio != null) {
                premio.getPeriodistaPremioList().remove(periodistaPremio);
                premio = em.merge(premio);
            }
            Periodista periodista = periodistaPremio.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaPremioList().remove(periodistaPremio);
                periodista = em.merge(periodista);
            }
            em.remove(periodistaPremio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaPremio> findPeriodistaPremioEntities() {
        return findPeriodistaPremioEntities(true, -1, -1);
    }

    public List<PeriodistaPremio> findPeriodistaPremioEntities(int maxResults, int firstResult) {
        return findPeriodistaPremioEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaPremio> findPeriodistaPremioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaPremio.class));
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

    public PeriodistaPremio findPeriodistaPremio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaPremio.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaPremioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaPremio> rt = cq.from(PeriodistaPremio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
