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
import modelo.Baja;
import modelo.Periodista;

/**
 *
 * @author asus
 */
public class BajaJpaController {

    public BajaJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Baja baja) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = baja.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                baja.setPeriodista(periodista);
            }
            em.persist(baja);
            if (periodista != null) {
                periodista.getBajaList().add(baja);
                periodista = em.merge(periodista);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBaja(baja.getIdBaja()) != null) {
                throw new PreexistingEntityException("Baja " + baja + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Baja baja) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Baja persistentBaja = em.find(Baja.class, baja.getIdBaja());
            Periodista periodistaOld = persistentBaja.getPeriodista();
            Periodista periodistaNew = baja.getPeriodista();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                baja.setPeriodista(periodistaNew);
            }
            baja = em.merge(baja);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getBajaList().remove(baja);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getBajaList().add(baja);
                periodistaNew = em.merge(periodistaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = baja.getIdBaja();
                if (findBaja(id) == null) {
                    throw new NonexistentEntityException("The baja with id " + id + " no longer exists.");
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
            Baja baja;
            try {
                baja = em.getReference(Baja.class, id);
                baja.getIdBaja();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The baja with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = baja.getPeriodista();
            if (periodista != null) {
                periodista.getBajaList().remove(baja);
                periodista = em.merge(periodista);
            }
            em.remove(baja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Baja> findBajaEntities() {
        return findBajaEntities(true, -1, -1);
    }

    public List<Baja> findBajaEntities(int maxResults, int firstResult) {
        return findBajaEntities(false, maxResults, firstResult);
    }

    private List<Baja> findBajaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Baja.class));
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

    public Baja findBaja(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Baja.class, id);
        } finally {
            em.close();
        }
    }

    public int getBajaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Baja> rt = cq.from(Baja.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
