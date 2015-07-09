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
import modelo.CirculoEspecial;
import modelo.PeriodistaCirculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class CirculoEspecialJpaController {

    public CirculoEspecialJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CirculoEspecial circuloEspecial) throws PreexistingEntityException, Exception {
        if (circuloEspecial.getPeriodistaCirculoList() == null) {
            circuloEspecial.setPeriodistaCirculoList(new ArrayList<PeriodistaCirculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaCirculo> attachedPeriodistaCirculoList = new ArrayList<PeriodistaCirculo>();
            for (PeriodistaCirculo periodistaCirculoListPeriodistaCirculoToAttach : circuloEspecial.getPeriodistaCirculoList()) {
                periodistaCirculoListPeriodistaCirculoToAttach = em.getReference(periodistaCirculoListPeriodistaCirculoToAttach.getClass(), periodistaCirculoListPeriodistaCirculoToAttach.getIdPerCirculo());
                attachedPeriodistaCirculoList.add(periodistaCirculoListPeriodistaCirculoToAttach);
            }
            circuloEspecial.setPeriodistaCirculoList(attachedPeriodistaCirculoList);
            em.persist(circuloEspecial);
            for (PeriodistaCirculo periodistaCirculoListPeriodistaCirculo : circuloEspecial.getPeriodistaCirculoList()) {
                CirculoEspecial oldCirculoEspecialOfPeriodistaCirculoListPeriodistaCirculo = periodistaCirculoListPeriodistaCirculo.getCirculoEspecial();
                periodistaCirculoListPeriodistaCirculo.setCirculoEspecial(circuloEspecial);
                periodistaCirculoListPeriodistaCirculo = em.merge(periodistaCirculoListPeriodistaCirculo);
                if (oldCirculoEspecialOfPeriodistaCirculoListPeriodistaCirculo != null) {
                    oldCirculoEspecialOfPeriodistaCirculoListPeriodistaCirculo.getPeriodistaCirculoList().remove(periodistaCirculoListPeriodistaCirculo);
                    oldCirculoEspecialOfPeriodistaCirculoListPeriodistaCirculo = em.merge(oldCirculoEspecialOfPeriodistaCirculoListPeriodistaCirculo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCirculoEspecial(circuloEspecial.getIdCirculoe()) != null) {
                throw new PreexistingEntityException("CirculoEspecial " + circuloEspecial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CirculoEspecial circuloEspecial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CirculoEspecial persistentCirculoEspecial = em.find(CirculoEspecial.class, circuloEspecial.getIdCirculoe());
            List<PeriodistaCirculo> periodistaCirculoListOld = persistentCirculoEspecial.getPeriodistaCirculoList();
            List<PeriodistaCirculo> periodistaCirculoListNew = circuloEspecial.getPeriodistaCirculoList();
            List<PeriodistaCirculo> attachedPeriodistaCirculoListNew = new ArrayList<PeriodistaCirculo>();
            for (PeriodistaCirculo periodistaCirculoListNewPeriodistaCirculoToAttach : periodistaCirculoListNew) {
                periodistaCirculoListNewPeriodistaCirculoToAttach = em.getReference(periodistaCirculoListNewPeriodistaCirculoToAttach.getClass(), periodistaCirculoListNewPeriodistaCirculoToAttach.getIdPerCirculo());
                attachedPeriodistaCirculoListNew.add(periodistaCirculoListNewPeriodistaCirculoToAttach);
            }
            periodistaCirculoListNew = attachedPeriodistaCirculoListNew;
            circuloEspecial.setPeriodistaCirculoList(periodistaCirculoListNew);
            circuloEspecial = em.merge(circuloEspecial);
            for (PeriodistaCirculo periodistaCirculoListOldPeriodistaCirculo : periodistaCirculoListOld) {
                if (!periodistaCirculoListNew.contains(periodistaCirculoListOldPeriodistaCirculo)) {
                    periodistaCirculoListOldPeriodistaCirculo.setCirculoEspecial(null);
                    periodistaCirculoListOldPeriodistaCirculo = em.merge(periodistaCirculoListOldPeriodistaCirculo);
                }
            }
            for (PeriodistaCirculo periodistaCirculoListNewPeriodistaCirculo : periodistaCirculoListNew) {
                if (!periodistaCirculoListOld.contains(periodistaCirculoListNewPeriodistaCirculo)) {
                    CirculoEspecial oldCirculoEspecialOfPeriodistaCirculoListNewPeriodistaCirculo = periodistaCirculoListNewPeriodistaCirculo.getCirculoEspecial();
                    periodistaCirculoListNewPeriodistaCirculo.setCirculoEspecial(circuloEspecial);
                    periodistaCirculoListNewPeriodistaCirculo = em.merge(periodistaCirculoListNewPeriodistaCirculo);
                    if (oldCirculoEspecialOfPeriodistaCirculoListNewPeriodistaCirculo != null && !oldCirculoEspecialOfPeriodistaCirculoListNewPeriodistaCirculo.equals(circuloEspecial)) {
                        oldCirculoEspecialOfPeriodistaCirculoListNewPeriodistaCirculo.getPeriodistaCirculoList().remove(periodistaCirculoListNewPeriodistaCirculo);
                        oldCirculoEspecialOfPeriodistaCirculoListNewPeriodistaCirculo = em.merge(oldCirculoEspecialOfPeriodistaCirculoListNewPeriodistaCirculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = circuloEspecial.getIdCirculoe();
                if (findCirculoEspecial(id) == null) {
                    throw new NonexistentEntityException("The circuloEspecial with id " + id + " no longer exists.");
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
            CirculoEspecial circuloEspecial;
            try {
                circuloEspecial = em.getReference(CirculoEspecial.class, id);
                circuloEspecial.getIdCirculoe();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The circuloEspecial with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaCirculo> periodistaCirculoList = circuloEspecial.getPeriodistaCirculoList();
            for (PeriodistaCirculo periodistaCirculoListPeriodistaCirculo : periodistaCirculoList) {
                periodistaCirculoListPeriodistaCirculo.setCirculoEspecial(null);
                periodistaCirculoListPeriodistaCirculo = em.merge(periodistaCirculoListPeriodistaCirculo);
            }
            em.remove(circuloEspecial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CirculoEspecial> findCirculoEspecialEntities() {
        return findCirculoEspecialEntities(true, -1, -1);
    }

    public List<CirculoEspecial> findCirculoEspecialEntities(int maxResults, int firstResult) {
        return findCirculoEspecialEntities(false, maxResults, firstResult);
    }

    private List<CirculoEspecial> findCirculoEspecialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CirculoEspecial.class));
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

    public CirculoEspecial findCirculoEspecial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CirculoEspecial.class, id);
        } finally {
            em.close();
        }
    }

    public int getCirculoEspecialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CirculoEspecial> rt = cq.from(CirculoEspecial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
