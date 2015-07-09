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
import modelo.CursoPostgrado;
import modelo.PeriodistaPostgrado;

/**
 *
 * @author asus
 */
public class PeriodistaPostgradoJpaController {

    public PeriodistaPostgradoJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaPostgrado periodistaPostgrado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaPostgrado.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaPostgrado.setPeriodista(periodista);
            }
            CursoPostgrado cursoPostgrado = periodistaPostgrado.getCursoPostgrado();
            if (cursoPostgrado != null) {
                cursoPostgrado = em.getReference(cursoPostgrado.getClass(), cursoPostgrado.getIdPostgrado());
                periodistaPostgrado.setCursoPostgrado(cursoPostgrado);
            }
            em.persist(periodistaPostgrado);
            if (periodista != null) {
                periodista.getPeriodistaPostgradoList().add(periodistaPostgrado);
                periodista = em.merge(periodista);
            }
            if (cursoPostgrado != null) {
                cursoPostgrado.getPeriodistaPostgradoList().add(periodistaPostgrado);
                cursoPostgrado = em.merge(cursoPostgrado);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaPostgrado(periodistaPostgrado.getIdPerPostg()) != null) {
                throw new PreexistingEntityException("PeriodistaPostgrado " + periodistaPostgrado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaPostgrado periodistaPostgrado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaPostgrado persistentPeriodistaPostgrado = em.find(PeriodistaPostgrado.class, periodistaPostgrado.getIdPerPostg());
            Periodista periodistaOld = persistentPeriodistaPostgrado.getPeriodista();
            Periodista periodistaNew = periodistaPostgrado.getPeriodista();
            CursoPostgrado cursoPostgradoOld = persistentPeriodistaPostgrado.getCursoPostgrado();
            CursoPostgrado cursoPostgradoNew = periodistaPostgrado.getCursoPostgrado();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaPostgrado.setPeriodista(periodistaNew);
            }
            if (cursoPostgradoNew != null) {
                cursoPostgradoNew = em.getReference(cursoPostgradoNew.getClass(), cursoPostgradoNew.getIdPostgrado());
                periodistaPostgrado.setCursoPostgrado(cursoPostgradoNew);
            }
            periodistaPostgrado = em.merge(periodistaPostgrado);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaPostgradoList().remove(periodistaPostgrado);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaPostgradoList().add(periodistaPostgrado);
                periodistaNew = em.merge(periodistaNew);
            }
            if (cursoPostgradoOld != null && !cursoPostgradoOld.equals(cursoPostgradoNew)) {
                cursoPostgradoOld.getPeriodistaPostgradoList().remove(periodistaPostgrado);
                cursoPostgradoOld = em.merge(cursoPostgradoOld);
            }
            if (cursoPostgradoNew != null && !cursoPostgradoNew.equals(cursoPostgradoOld)) {
                cursoPostgradoNew.getPeriodistaPostgradoList().add(periodistaPostgrado);
                cursoPostgradoNew = em.merge(cursoPostgradoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaPostgrado.getIdPerPostg();
                if (findPeriodistaPostgrado(id) == null) {
                    throw new NonexistentEntityException("The periodistaPostgrado with id " + id + " no longer exists.");
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
            PeriodistaPostgrado periodistaPostgrado;
            try {
                periodistaPostgrado = em.getReference(PeriodistaPostgrado.class, id);
                periodistaPostgrado.getIdPerPostg();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaPostgrado with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaPostgrado.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaPostgradoList().remove(periodistaPostgrado);
                periodista = em.merge(periodista);
            }
            CursoPostgrado cursoPostgrado = periodistaPostgrado.getCursoPostgrado();
            if (cursoPostgrado != null) {
                cursoPostgrado.getPeriodistaPostgradoList().remove(periodistaPostgrado);
                cursoPostgrado = em.merge(cursoPostgrado);
            }
            em.remove(periodistaPostgrado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaPostgrado> findPeriodistaPostgradoEntities() {
        return findPeriodistaPostgradoEntities(true, -1, -1);
    }

    public List<PeriodistaPostgrado> findPeriodistaPostgradoEntities(int maxResults, int firstResult) {
        return findPeriodistaPostgradoEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaPostgrado> findPeriodistaPostgradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaPostgrado.class));
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

    public PeriodistaPostgrado findPeriodistaPostgrado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaPostgrado.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaPostgradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaPostgrado> rt = cq.from(PeriodistaPostgrado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
