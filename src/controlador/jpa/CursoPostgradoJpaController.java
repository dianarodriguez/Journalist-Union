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
import modelo.CursoPostgrado;
import modelo.PeriodistaPostgrado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class CursoPostgradoJpaController {

    public CursoPostgradoJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CursoPostgrado cursoPostgrado) throws PreexistingEntityException, Exception {
        if (cursoPostgrado.getPeriodistaPostgradoList() == null) {
            cursoPostgrado.setPeriodistaPostgradoList(new ArrayList<PeriodistaPostgrado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaPostgrado> attachedPeriodistaPostgradoList = new ArrayList<PeriodistaPostgrado>();
            for (PeriodistaPostgrado periodistaPostgradoListPeriodistaPostgradoToAttach : cursoPostgrado.getPeriodistaPostgradoList()) {
                periodistaPostgradoListPeriodistaPostgradoToAttach = em.getReference(periodistaPostgradoListPeriodistaPostgradoToAttach.getClass(), periodistaPostgradoListPeriodistaPostgradoToAttach.getIdPerPostg());
                attachedPeriodistaPostgradoList.add(periodistaPostgradoListPeriodistaPostgradoToAttach);
            }
            cursoPostgrado.setPeriodistaPostgradoList(attachedPeriodistaPostgradoList);
            em.persist(cursoPostgrado);
            for (PeriodistaPostgrado periodistaPostgradoListPeriodistaPostgrado : cursoPostgrado.getPeriodistaPostgradoList()) {
                CursoPostgrado oldCursoPostgradoOfPeriodistaPostgradoListPeriodistaPostgrado = periodistaPostgradoListPeriodistaPostgrado.getCursoPostgrado();
                periodistaPostgradoListPeriodistaPostgrado.setCursoPostgrado(cursoPostgrado);
                periodistaPostgradoListPeriodistaPostgrado = em.merge(periodistaPostgradoListPeriodistaPostgrado);
                if (oldCursoPostgradoOfPeriodistaPostgradoListPeriodistaPostgrado != null) {
                    oldCursoPostgradoOfPeriodistaPostgradoListPeriodistaPostgrado.getPeriodistaPostgradoList().remove(periodistaPostgradoListPeriodistaPostgrado);
                    oldCursoPostgradoOfPeriodistaPostgradoListPeriodistaPostgrado = em.merge(oldCursoPostgradoOfPeriodistaPostgradoListPeriodistaPostgrado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCursoPostgrado(cursoPostgrado.getIdPostgrado()) != null) {
                throw new PreexistingEntityException("CursoPostgrado " + cursoPostgrado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CursoPostgrado cursoPostgrado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoPostgrado persistentCursoPostgrado = em.find(CursoPostgrado.class, cursoPostgrado.getIdPostgrado());
            List<PeriodistaPostgrado> periodistaPostgradoListOld = persistentCursoPostgrado.getPeriodistaPostgradoList();
            List<PeriodistaPostgrado> periodistaPostgradoListNew = cursoPostgrado.getPeriodistaPostgradoList();
            List<PeriodistaPostgrado> attachedPeriodistaPostgradoListNew = new ArrayList<PeriodistaPostgrado>();
            for (PeriodistaPostgrado periodistaPostgradoListNewPeriodistaPostgradoToAttach : periodistaPostgradoListNew) {
                periodistaPostgradoListNewPeriodistaPostgradoToAttach = em.getReference(periodistaPostgradoListNewPeriodistaPostgradoToAttach.getClass(), periodistaPostgradoListNewPeriodistaPostgradoToAttach.getIdPerPostg());
                attachedPeriodistaPostgradoListNew.add(periodistaPostgradoListNewPeriodistaPostgradoToAttach);
            }
            periodistaPostgradoListNew = attachedPeriodistaPostgradoListNew;
            cursoPostgrado.setPeriodistaPostgradoList(periodistaPostgradoListNew);
            cursoPostgrado = em.merge(cursoPostgrado);
            for (PeriodistaPostgrado periodistaPostgradoListOldPeriodistaPostgrado : periodistaPostgradoListOld) {
                if (!periodistaPostgradoListNew.contains(periodistaPostgradoListOldPeriodistaPostgrado)) {
                    periodistaPostgradoListOldPeriodistaPostgrado.setCursoPostgrado(null);
                    periodistaPostgradoListOldPeriodistaPostgrado = em.merge(periodistaPostgradoListOldPeriodistaPostgrado);
                }
            }
            for (PeriodistaPostgrado periodistaPostgradoListNewPeriodistaPostgrado : periodistaPostgradoListNew) {
                if (!periodistaPostgradoListOld.contains(periodistaPostgradoListNewPeriodistaPostgrado)) {
                    CursoPostgrado oldCursoPostgradoOfPeriodistaPostgradoListNewPeriodistaPostgrado = periodistaPostgradoListNewPeriodistaPostgrado.getCursoPostgrado();
                    periodistaPostgradoListNewPeriodistaPostgrado.setCursoPostgrado(cursoPostgrado);
                    periodistaPostgradoListNewPeriodistaPostgrado = em.merge(periodistaPostgradoListNewPeriodistaPostgrado);
                    if (oldCursoPostgradoOfPeriodistaPostgradoListNewPeriodistaPostgrado != null && !oldCursoPostgradoOfPeriodistaPostgradoListNewPeriodistaPostgrado.equals(cursoPostgrado)) {
                        oldCursoPostgradoOfPeriodistaPostgradoListNewPeriodistaPostgrado.getPeriodistaPostgradoList().remove(periodistaPostgradoListNewPeriodistaPostgrado);
                        oldCursoPostgradoOfPeriodistaPostgradoListNewPeriodistaPostgrado = em.merge(oldCursoPostgradoOfPeriodistaPostgradoListNewPeriodistaPostgrado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cursoPostgrado.getIdPostgrado();
                if (findCursoPostgrado(id) == null) {
                    throw new NonexistentEntityException("The cursoPostgrado with id " + id + " no longer exists.");
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
            CursoPostgrado cursoPostgrado;
            try {
                cursoPostgrado = em.getReference(CursoPostgrado.class, id);
                cursoPostgrado.getIdPostgrado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cursoPostgrado with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaPostgrado> periodistaPostgradoList = cursoPostgrado.getPeriodistaPostgradoList();
            for (PeriodistaPostgrado periodistaPostgradoListPeriodistaPostgrado : periodistaPostgradoList) {
                periodistaPostgradoListPeriodistaPostgrado.setCursoPostgrado(null);
                periodistaPostgradoListPeriodistaPostgrado = em.merge(periodistaPostgradoListPeriodistaPostgrado);
            }
            em.remove(cursoPostgrado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CursoPostgrado> findCursoPostgradoEntities() {
        return findCursoPostgradoEntities(true, -1, -1);
    }

    public List<CursoPostgrado> findCursoPostgradoEntities(int maxResults, int firstResult) {
        return findCursoPostgradoEntities(false, maxResults, firstResult);
    }

    private List<CursoPostgrado> findCursoPostgradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CursoPostgrado.class));
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

    public CursoPostgrado findCursoPostgrado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CursoPostgrado.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoPostgradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CursoPostgrado> rt = cq.from(CursoPostgrado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
