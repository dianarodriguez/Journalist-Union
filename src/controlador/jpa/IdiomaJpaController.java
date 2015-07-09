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
import modelo.Idioma;
import modelo.PeriodistaIdioma;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class IdiomaJpaController {

    public IdiomaJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Idioma idioma) throws PreexistingEntityException, Exception {
        if (idioma.getPeriodistaIdiomaList() == null) {
            idioma.setPeriodistaIdiomaList(new ArrayList<PeriodistaIdioma>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaIdioma> attachedPeriodistaIdiomaList = new ArrayList<PeriodistaIdioma>();
            for (PeriodistaIdioma periodistaIdiomaListPeriodistaIdiomaToAttach : idioma.getPeriodistaIdiomaList()) {
                periodistaIdiomaListPeriodistaIdiomaToAttach = em.getReference(periodistaIdiomaListPeriodistaIdiomaToAttach.getClass(), periodistaIdiomaListPeriodistaIdiomaToAttach.getIdPerIdioma());
                attachedPeriodistaIdiomaList.add(periodistaIdiomaListPeriodistaIdiomaToAttach);
            }
            idioma.setPeriodistaIdiomaList(attachedPeriodistaIdiomaList);
            em.persist(idioma);
            for (PeriodistaIdioma periodistaIdiomaListPeriodistaIdioma : idioma.getPeriodistaIdiomaList()) {
                Idioma oldIdiomaOfPeriodistaIdiomaListPeriodistaIdioma = periodistaIdiomaListPeriodistaIdioma.getIdioma();
                periodistaIdiomaListPeriodistaIdioma.setIdioma(idioma);
                periodistaIdiomaListPeriodistaIdioma = em.merge(periodistaIdiomaListPeriodistaIdioma);
                if (oldIdiomaOfPeriodistaIdiomaListPeriodistaIdioma != null) {
                    oldIdiomaOfPeriodistaIdiomaListPeriodistaIdioma.getPeriodistaIdiomaList().remove(periodistaIdiomaListPeriodistaIdioma);
                    oldIdiomaOfPeriodistaIdiomaListPeriodistaIdioma = em.merge(oldIdiomaOfPeriodistaIdiomaListPeriodistaIdioma);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIdioma(idioma.getIdIdioma()) != null) {
                throw new PreexistingEntityException("Idioma " + idioma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Idioma idioma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Idioma persistentIdioma = em.find(Idioma.class, idioma.getIdIdioma());
            List<PeriodistaIdioma> periodistaIdiomaListOld = persistentIdioma.getPeriodistaIdiomaList();
            List<PeriodistaIdioma> periodistaIdiomaListNew = idioma.getPeriodistaIdiomaList();
            List<PeriodistaIdioma> attachedPeriodistaIdiomaListNew = new ArrayList<PeriodistaIdioma>();
            for (PeriodistaIdioma periodistaIdiomaListNewPeriodistaIdiomaToAttach : periodistaIdiomaListNew) {
                periodistaIdiomaListNewPeriodistaIdiomaToAttach = em.getReference(periodistaIdiomaListNewPeriodistaIdiomaToAttach.getClass(), periodistaIdiomaListNewPeriodistaIdiomaToAttach.getIdPerIdioma());
                attachedPeriodistaIdiomaListNew.add(periodistaIdiomaListNewPeriodistaIdiomaToAttach);
            }
            periodistaIdiomaListNew = attachedPeriodistaIdiomaListNew;
            idioma.setPeriodistaIdiomaList(periodistaIdiomaListNew);
            idioma = em.merge(idioma);
            for (PeriodistaIdioma periodistaIdiomaListOldPeriodistaIdioma : periodistaIdiomaListOld) {
                if (!periodistaIdiomaListNew.contains(periodistaIdiomaListOldPeriodistaIdioma)) {
                    periodistaIdiomaListOldPeriodistaIdioma.setIdioma(null);
                    periodistaIdiomaListOldPeriodistaIdioma = em.merge(periodistaIdiomaListOldPeriodistaIdioma);
                }
            }
            for (PeriodistaIdioma periodistaIdiomaListNewPeriodistaIdioma : periodistaIdiomaListNew) {
                if (!periodistaIdiomaListOld.contains(periodistaIdiomaListNewPeriodistaIdioma)) {
                    Idioma oldIdiomaOfPeriodistaIdiomaListNewPeriodistaIdioma = periodistaIdiomaListNewPeriodistaIdioma.getIdioma();
                    periodistaIdiomaListNewPeriodistaIdioma.setIdioma(idioma);
                    periodistaIdiomaListNewPeriodistaIdioma = em.merge(periodistaIdiomaListNewPeriodistaIdioma);
                    if (oldIdiomaOfPeriodistaIdiomaListNewPeriodistaIdioma != null && !oldIdiomaOfPeriodistaIdiomaListNewPeriodistaIdioma.equals(idioma)) {
                        oldIdiomaOfPeriodistaIdiomaListNewPeriodistaIdioma.getPeriodistaIdiomaList().remove(periodistaIdiomaListNewPeriodistaIdioma);
                        oldIdiomaOfPeriodistaIdiomaListNewPeriodistaIdioma = em.merge(oldIdiomaOfPeriodistaIdiomaListNewPeriodistaIdioma);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = idioma.getIdIdioma();
                if (findIdioma(id) == null) {
                    throw new NonexistentEntityException("The idioma with id " + id + " no longer exists.");
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
            Idioma idioma;
            try {
                idioma = em.getReference(Idioma.class, id);
                idioma.getIdIdioma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The idioma with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaIdioma> periodistaIdiomaList = idioma.getPeriodistaIdiomaList();
            for (PeriodistaIdioma periodistaIdiomaListPeriodistaIdioma : periodistaIdiomaList) {
                periodistaIdiomaListPeriodistaIdioma.setIdioma(null);
                periodistaIdiomaListPeriodistaIdioma = em.merge(periodistaIdiomaListPeriodistaIdioma);
            }
            em.remove(idioma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Idioma> findIdiomaEntities() {
        return findIdiomaEntities(true, -1, -1);
    }

    public List<Idioma> findIdiomaEntities(int maxResults, int firstResult) {
        return findIdiomaEntities(false, maxResults, firstResult);
    }

    private List<Idioma> findIdiomaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Idioma.class));
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

    public Idioma findIdioma(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Idioma.class, id);
        } finally {
            em.close();
        }
    }

    public int getIdiomaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Idioma> rt = cq.from(Idioma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
