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
import modelo.Mision;
import modelo.PeriodistaMision;

/**
 *
 * @author asus
 */
public class PeriodistaMisionJpaController {

    public PeriodistaMisionJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaMision periodistaMision) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaMision.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaMision.setPeriodista(periodista);
            }
            Mision mision = periodistaMision.getMision();
            if (mision != null) {
                mision = em.getReference(mision.getClass(), mision.getIdMision());
                periodistaMision.setMision(mision);
            }
            em.persist(periodistaMision);
            if (periodista != null) {
                periodista.getPeriodistaMisionList().add(periodistaMision);
                periodista = em.merge(periodista);
            }
            if (mision != null) {
                mision.getPeriodistaMisionList().add(periodistaMision);
                mision = em.merge(mision);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaMision(periodistaMision.getIdPerMision()) != null) {
                throw new PreexistingEntityException("PeriodistaMision " + periodistaMision + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaMision periodistaMision) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaMision persistentPeriodistaMision = em.find(PeriodistaMision.class, periodistaMision.getIdPerMision());
            Periodista periodistaOld = persistentPeriodistaMision.getPeriodista();
            Periodista periodistaNew = periodistaMision.getPeriodista();
            Mision misionOld = persistentPeriodistaMision.getMision();
            Mision misionNew = periodistaMision.getMision();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaMision.setPeriodista(periodistaNew);
            }
            if (misionNew != null) {
                misionNew = em.getReference(misionNew.getClass(), misionNew.getIdMision());
                periodistaMision.setMision(misionNew);
            }
            periodistaMision = em.merge(periodistaMision);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaMisionList().remove(periodistaMision);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaMisionList().add(periodistaMision);
                periodistaNew = em.merge(periodistaNew);
            }
            if (misionOld != null && !misionOld.equals(misionNew)) {
                misionOld.getPeriodistaMisionList().remove(periodistaMision);
                misionOld = em.merge(misionOld);
            }
            if (misionNew != null && !misionNew.equals(misionOld)) {
                misionNew.getPeriodistaMisionList().add(periodistaMision);
                misionNew = em.merge(misionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaMision.getIdPerMision();
                if (findPeriodistaMision(id) == null) {
                    throw new NonexistentEntityException("The periodistaMision with id " + id + " no longer exists.");
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
            PeriodistaMision periodistaMision;
            try {
                periodistaMision = em.getReference(PeriodistaMision.class, id);
                periodistaMision.getIdPerMision();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaMision with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaMision.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaMisionList().remove(periodistaMision);
                periodista = em.merge(periodista);
            }
            Mision mision = periodistaMision.getMision();
            if (mision != null) {
                mision.getPeriodistaMisionList().remove(periodistaMision);
                mision = em.merge(mision);
            }
            em.remove(periodistaMision);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaMision> findPeriodistaMisionEntities() {
        return findPeriodistaMisionEntities(true, -1, -1);
    }

    public List<PeriodistaMision> findPeriodistaMisionEntities(int maxResults, int firstResult) {
        return findPeriodistaMisionEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaMision> findPeriodistaMisionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaMision.class));
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

    public PeriodistaMision findPeriodistaMision(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaMision.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaMisionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaMision> rt = cq.from(PeriodistaMision.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
