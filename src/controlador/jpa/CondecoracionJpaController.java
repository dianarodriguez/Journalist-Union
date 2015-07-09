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
import modelo.Condecoracion;
import modelo.PeriodistaCondecoracion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class CondecoracionJpaController {

    public CondecoracionJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Condecoracion condecoracion) throws PreexistingEntityException, Exception {
        if (condecoracion.getPeriodistaCondecoracionList() == null) {
            condecoracion.setPeriodistaCondecoracionList(new ArrayList<PeriodistaCondecoracion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaCondecoracion> attachedPeriodistaCondecoracionList = new ArrayList<PeriodistaCondecoracion>();
            for (PeriodistaCondecoracion periodistaCondecoracionListPeriodistaCondecoracionToAttach : condecoracion.getPeriodistaCondecoracionList()) {
                periodistaCondecoracionListPeriodistaCondecoracionToAttach = em.getReference(periodistaCondecoracionListPeriodistaCondecoracionToAttach.getClass(), periodistaCondecoracionListPeriodistaCondecoracionToAttach.getIdPerCondec());
                attachedPeriodistaCondecoracionList.add(periodistaCondecoracionListPeriodistaCondecoracionToAttach);
            }
            condecoracion.setPeriodistaCondecoracionList(attachedPeriodistaCondecoracionList);
            em.persist(condecoracion);
            for (PeriodistaCondecoracion periodistaCondecoracionListPeriodistaCondecoracion : condecoracion.getPeriodistaCondecoracionList()) {
                Condecoracion oldCondecoracionOfPeriodistaCondecoracionListPeriodistaCondecoracion = periodistaCondecoracionListPeriodistaCondecoracion.getCondecoracion();
                periodistaCondecoracionListPeriodistaCondecoracion.setCondecoracion(condecoracion);
                periodistaCondecoracionListPeriodistaCondecoracion = em.merge(periodistaCondecoracionListPeriodistaCondecoracion);
                if (oldCondecoracionOfPeriodistaCondecoracionListPeriodistaCondecoracion != null) {
                    oldCondecoracionOfPeriodistaCondecoracionListPeriodistaCondecoracion.getPeriodistaCondecoracionList().remove(periodistaCondecoracionListPeriodistaCondecoracion);
                    oldCondecoracionOfPeriodistaCondecoracionListPeriodistaCondecoracion = em.merge(oldCondecoracionOfPeriodistaCondecoracionListPeriodistaCondecoracion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCondecoracion(condecoracion.getIdCondecoracion()) != null) {
                throw new PreexistingEntityException("Condecoracion " + condecoracion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Condecoracion condecoracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Condecoracion persistentCondecoracion = em.find(Condecoracion.class, condecoracion.getIdCondecoracion());
            List<PeriodistaCondecoracion> periodistaCondecoracionListOld = persistentCondecoracion.getPeriodistaCondecoracionList();
            List<PeriodistaCondecoracion> periodistaCondecoracionListNew = condecoracion.getPeriodistaCondecoracionList();
            List<PeriodistaCondecoracion> attachedPeriodistaCondecoracionListNew = new ArrayList<PeriodistaCondecoracion>();
            for (PeriodistaCondecoracion periodistaCondecoracionListNewPeriodistaCondecoracionToAttach : periodistaCondecoracionListNew) {
                periodistaCondecoracionListNewPeriodistaCondecoracionToAttach = em.getReference(periodistaCondecoracionListNewPeriodistaCondecoracionToAttach.getClass(), periodistaCondecoracionListNewPeriodistaCondecoracionToAttach.getIdPerCondec());
                attachedPeriodistaCondecoracionListNew.add(periodistaCondecoracionListNewPeriodistaCondecoracionToAttach);
            }
            periodistaCondecoracionListNew = attachedPeriodistaCondecoracionListNew;
            condecoracion.setPeriodistaCondecoracionList(periodistaCondecoracionListNew);
            condecoracion = em.merge(condecoracion);
            for (PeriodistaCondecoracion periodistaCondecoracionListOldPeriodistaCondecoracion : periodistaCondecoracionListOld) {
                if (!periodistaCondecoracionListNew.contains(periodistaCondecoracionListOldPeriodistaCondecoracion)) {
                    periodistaCondecoracionListOldPeriodistaCondecoracion.setCondecoracion(null);
                    periodistaCondecoracionListOldPeriodistaCondecoracion = em.merge(periodistaCondecoracionListOldPeriodistaCondecoracion);
                }
            }
            for (PeriodistaCondecoracion periodistaCondecoracionListNewPeriodistaCondecoracion : periodistaCondecoracionListNew) {
                if (!periodistaCondecoracionListOld.contains(periodistaCondecoracionListNewPeriodistaCondecoracion)) {
                    Condecoracion oldCondecoracionOfPeriodistaCondecoracionListNewPeriodistaCondecoracion = periodistaCondecoracionListNewPeriodistaCondecoracion.getCondecoracion();
                    periodistaCondecoracionListNewPeriodistaCondecoracion.setCondecoracion(condecoracion);
                    periodistaCondecoracionListNewPeriodistaCondecoracion = em.merge(periodistaCondecoracionListNewPeriodistaCondecoracion);
                    if (oldCondecoracionOfPeriodistaCondecoracionListNewPeriodistaCondecoracion != null && !oldCondecoracionOfPeriodistaCondecoracionListNewPeriodistaCondecoracion.equals(condecoracion)) {
                        oldCondecoracionOfPeriodistaCondecoracionListNewPeriodistaCondecoracion.getPeriodistaCondecoracionList().remove(periodistaCondecoracionListNewPeriodistaCondecoracion);
                        oldCondecoracionOfPeriodistaCondecoracionListNewPeriodistaCondecoracion = em.merge(oldCondecoracionOfPeriodistaCondecoracionListNewPeriodistaCondecoracion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = condecoracion.getIdCondecoracion();
                if (findCondecoracion(id) == null) {
                    throw new NonexistentEntityException("The condecoracion with id " + id + " no longer exists.");
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
            Condecoracion condecoracion;
            try {
                condecoracion = em.getReference(Condecoracion.class, id);
                condecoracion.getIdCondecoracion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The condecoracion with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaCondecoracion> periodistaCondecoracionList = condecoracion.getPeriodistaCondecoracionList();
            for (PeriodistaCondecoracion periodistaCondecoracionListPeriodistaCondecoracion : periodistaCondecoracionList) {
                periodistaCondecoracionListPeriodistaCondecoracion.setCondecoracion(null);
                periodistaCondecoracionListPeriodistaCondecoracion = em.merge(periodistaCondecoracionListPeriodistaCondecoracion);
            }
            em.remove(condecoracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Condecoracion> findCondecoracionEntities() {
        return findCondecoracionEntities(true, -1, -1);
    }

    public List<Condecoracion> findCondecoracionEntities(int maxResults, int firstResult) {
        return findCondecoracionEntities(false, maxResults, firstResult);
    }

    private List<Condecoracion> findCondecoracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Condecoracion.class));
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

    public Condecoracion findCondecoracion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Condecoracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCondecoracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Condecoracion> rt = cq.from(Condecoracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
