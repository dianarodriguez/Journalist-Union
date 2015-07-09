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
import modelo.CargoPeriodistico;
import modelo.PeriodistaCargop;

/**
 *
 * @author asus
 */
public class PeriodistaCargopJpaController {

    public PeriodistaCargopJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaCargop periodistaCargop) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaCargop.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaCargop.setPeriodista(periodista);
            }
            CargoPeriodistico cargoPeriodistico = periodistaCargop.getCargoPeriodistico();
            if (cargoPeriodistico != null) {
                cargoPeriodistico = em.getReference(cargoPeriodistico.getClass(), cargoPeriodistico.getIdCargop());
                periodistaCargop.setCargoPeriodistico(cargoPeriodistico);
            }
            em.persist(periodistaCargop);
            if (periodista != null) {
                periodista.getPeriodistaCargopList().add(periodistaCargop);
                periodista = em.merge(periodista);
            }
            if (cargoPeriodistico != null) {
                cargoPeriodistico.getPeriodistaCargopList().add(periodistaCargop);
                cargoPeriodistico = em.merge(cargoPeriodistico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaCargop(periodistaCargop.getIdPerCargo()) != null) {
                throw new PreexistingEntityException("PeriodistaCargop " + periodistaCargop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaCargop periodistaCargop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaCargop persistentPeriodistaCargop = em.find(PeriodistaCargop.class, periodistaCargop.getIdPerCargo());
            Periodista periodistaOld = persistentPeriodistaCargop.getPeriodista();
            Periodista periodistaNew = periodistaCargop.getPeriodista();
            CargoPeriodistico cargoPeriodisticoOld = persistentPeriodistaCargop.getCargoPeriodistico();
            CargoPeriodistico cargoPeriodisticoNew = periodistaCargop.getCargoPeriodistico();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaCargop.setPeriodista(periodistaNew);
            }
            if (cargoPeriodisticoNew != null) {
                cargoPeriodisticoNew = em.getReference(cargoPeriodisticoNew.getClass(), cargoPeriodisticoNew.getIdCargop());
                periodistaCargop.setCargoPeriodistico(cargoPeriodisticoNew);
            }
            periodistaCargop = em.merge(periodistaCargop);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaCargopList().remove(periodistaCargop);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaCargopList().add(periodistaCargop);
                periodistaNew = em.merge(periodistaNew);
            }
            if (cargoPeriodisticoOld != null && !cargoPeriodisticoOld.equals(cargoPeriodisticoNew)) {
                cargoPeriodisticoOld.getPeriodistaCargopList().remove(periodistaCargop);
                cargoPeriodisticoOld = em.merge(cargoPeriodisticoOld);
            }
            if (cargoPeriodisticoNew != null && !cargoPeriodisticoNew.equals(cargoPeriodisticoOld)) {
                cargoPeriodisticoNew.getPeriodistaCargopList().add(periodistaCargop);
                cargoPeriodisticoNew = em.merge(cargoPeriodisticoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaCargop.getIdPerCargo();
                if (findPeriodistaCargop(id) == null) {
                    throw new NonexistentEntityException("The periodistaCargop with id " + id + " no longer exists.");
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
            PeriodistaCargop periodistaCargop;
            try {
                periodistaCargop = em.getReference(PeriodistaCargop.class, id);
                periodistaCargop.getIdPerCargo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaCargop with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaCargop.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaCargopList().remove(periodistaCargop);
                periodista = em.merge(periodista);
            }
            CargoPeriodistico cargoPeriodistico = periodistaCargop.getCargoPeriodistico();
            if (cargoPeriodistico != null) {
                cargoPeriodistico.getPeriodistaCargopList().remove(periodistaCargop);
                cargoPeriodistico = em.merge(cargoPeriodistico);
            }
            em.remove(periodistaCargop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaCargop> findPeriodistaCargopEntities() {
        return findPeriodistaCargopEntities(true, -1, -1);
    }

    public List<PeriodistaCargop> findPeriodistaCargopEntities(int maxResults, int firstResult) {
        return findPeriodistaCargopEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaCargop> findPeriodistaCargopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaCargop.class));
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

    public PeriodistaCargop findPeriodistaCargop(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaCargop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaCargopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaCargop> rt = cq.from(PeriodistaCargop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
