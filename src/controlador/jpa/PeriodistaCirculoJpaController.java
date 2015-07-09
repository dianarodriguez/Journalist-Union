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
import modelo.CirculoEspecial;
import modelo.PeriodistaCirculo;

/**
 *
 * @author asus
 */
public class PeriodistaCirculoJpaController {

    public PeriodistaCirculoJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaCirculo periodistaCirculo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaCirculo.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaCirculo.setPeriodista(periodista);
            }
            CirculoEspecial circuloEspecial = periodistaCirculo.getCirculoEspecial();
            if (circuloEspecial != null) {
                circuloEspecial = em.getReference(circuloEspecial.getClass(), circuloEspecial.getIdCirculoe());
                periodistaCirculo.setCirculoEspecial(circuloEspecial);
            }
            em.persist(periodistaCirculo);
            if (periodista != null) {
                periodista.getPeriodistaCirculoList().add(periodistaCirculo);
                periodista = em.merge(periodista);
            }
            if (circuloEspecial != null) {
                circuloEspecial.getPeriodistaCirculoList().add(periodistaCirculo);
                circuloEspecial = em.merge(circuloEspecial);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaCirculo(periodistaCirculo.getIdPerCirculo()) != null) {
                throw new PreexistingEntityException("PeriodistaCirculo " + periodistaCirculo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaCirculo periodistaCirculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaCirculo persistentPeriodistaCirculo = em.find(PeriodistaCirculo.class, periodistaCirculo.getIdPerCirculo());
            Periodista periodistaOld = persistentPeriodistaCirculo.getPeriodista();
            Periodista periodistaNew = periodistaCirculo.getPeriodista();
            CirculoEspecial circuloEspecialOld = persistentPeriodistaCirculo.getCirculoEspecial();
            CirculoEspecial circuloEspecialNew = periodistaCirculo.getCirculoEspecial();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaCirculo.setPeriodista(periodistaNew);
            }
            if (circuloEspecialNew != null) {
                circuloEspecialNew = em.getReference(circuloEspecialNew.getClass(), circuloEspecialNew.getIdCirculoe());
                periodistaCirculo.setCirculoEspecial(circuloEspecialNew);
            }
            periodistaCirculo = em.merge(periodistaCirculo);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaCirculoList().remove(periodistaCirculo);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaCirculoList().add(periodistaCirculo);
                periodistaNew = em.merge(periodistaNew);
            }
            if (circuloEspecialOld != null && !circuloEspecialOld.equals(circuloEspecialNew)) {
                circuloEspecialOld.getPeriodistaCirculoList().remove(periodistaCirculo);
                circuloEspecialOld = em.merge(circuloEspecialOld);
            }
            if (circuloEspecialNew != null && !circuloEspecialNew.equals(circuloEspecialOld)) {
                circuloEspecialNew.getPeriodistaCirculoList().add(periodistaCirculo);
                circuloEspecialNew = em.merge(circuloEspecialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaCirculo.getIdPerCirculo();
                if (findPeriodistaCirculo(id) == null) {
                    throw new NonexistentEntityException("The periodistaCirculo with id " + id + " no longer exists.");
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
            PeriodistaCirculo periodistaCirculo;
            try {
                periodistaCirculo = em.getReference(PeriodistaCirculo.class, id);
                periodistaCirculo.getIdPerCirculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaCirculo with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaCirculo.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaCirculoList().remove(periodistaCirculo);
                periodista = em.merge(periodista);
            }
            CirculoEspecial circuloEspecial = periodistaCirculo.getCirculoEspecial();
            if (circuloEspecial != null) {
                circuloEspecial.getPeriodistaCirculoList().remove(periodistaCirculo);
                circuloEspecial = em.merge(circuloEspecial);
            }
            em.remove(periodistaCirculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaCirculo> findPeriodistaCirculoEntities() {
        return findPeriodistaCirculoEntities(true, -1, -1);
    }

    public List<PeriodistaCirculo> findPeriodistaCirculoEntities(int maxResults, int firstResult) {
        return findPeriodistaCirculoEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaCirculo> findPeriodistaCirculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaCirculo.class));
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

    public PeriodistaCirculo findPeriodistaCirculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaCirculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaCirculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaCirculo> rt = cq.from(PeriodistaCirculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
