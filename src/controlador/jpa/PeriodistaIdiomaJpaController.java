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
import modelo.Idioma;
import modelo.PeriodistaIdioma;

/**
 *
 * @author asus
 */
public class PeriodistaIdiomaJpaController {

    public PeriodistaIdiomaJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaIdioma periodistaIdioma) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaIdioma.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaIdioma.setPeriodista(periodista);
            }
            Idioma idioma = periodistaIdioma.getIdioma();
            if (idioma != null) {
                idioma = em.getReference(idioma.getClass(), idioma.getIdIdioma());
                periodistaIdioma.setIdioma(idioma);
            }
            em.persist(periodistaIdioma);
            if (periodista != null) {
                periodista.getPeriodistaIdiomaList().add(periodistaIdioma);
                periodista = em.merge(periodista);
            }
            if (idioma != null) {
                idioma.getPeriodistaIdiomaList().add(periodistaIdioma);
                idioma = em.merge(idioma);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaIdioma(periodistaIdioma.getIdPerIdioma()) != null) {
                throw new PreexistingEntityException("PeriodistaIdioma " + periodistaIdioma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaIdioma periodistaIdioma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaIdioma persistentPeriodistaIdioma = em.find(PeriodistaIdioma.class, periodistaIdioma.getIdPerIdioma());
            Periodista periodistaOld = persistentPeriodistaIdioma.getPeriodista();
            Periodista periodistaNew = periodistaIdioma.getPeriodista();
            Idioma idiomaOld = persistentPeriodistaIdioma.getIdioma();
            Idioma idiomaNew = periodistaIdioma.getIdioma();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaIdioma.setPeriodista(periodistaNew);
            }
            if (idiomaNew != null) {
                idiomaNew = em.getReference(idiomaNew.getClass(), idiomaNew.getIdIdioma());
                periodistaIdioma.setIdioma(idiomaNew);
            }
            periodistaIdioma = em.merge(periodistaIdioma);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaIdiomaList().remove(periodistaIdioma);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaIdiomaList().add(periodistaIdioma);
                periodistaNew = em.merge(periodistaNew);
            }
            if (idiomaOld != null && !idiomaOld.equals(idiomaNew)) {
                idiomaOld.getPeriodistaIdiomaList().remove(periodistaIdioma);
                idiomaOld = em.merge(idiomaOld);
            }
            if (idiomaNew != null && !idiomaNew.equals(idiomaOld)) {
                idiomaNew.getPeriodistaIdiomaList().add(periodistaIdioma);
                idiomaNew = em.merge(idiomaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaIdioma.getIdPerIdioma();
                if (findPeriodistaIdioma(id) == null) {
                    throw new NonexistentEntityException("The periodistaIdioma with id " + id + " no longer exists.");
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
            PeriodistaIdioma periodistaIdioma;
            try {
                periodistaIdioma = em.getReference(PeriodistaIdioma.class, id);
                periodistaIdioma.getIdPerIdioma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaIdioma with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaIdioma.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaIdiomaList().remove(periodistaIdioma);
                periodista = em.merge(periodista);
            }
            Idioma idioma = periodistaIdioma.getIdioma();
            if (idioma != null) {
                idioma.getPeriodistaIdiomaList().remove(periodistaIdioma);
                idioma = em.merge(idioma);
            }
            em.remove(periodistaIdioma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaIdioma> findPeriodistaIdiomaEntities() {
        return findPeriodistaIdiomaEntities(true, -1, -1);
    }

    public List<PeriodistaIdioma> findPeriodistaIdiomaEntities(int maxResults, int firstResult) {
        return findPeriodistaIdiomaEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaIdioma> findPeriodistaIdiomaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaIdioma.class));
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

    public PeriodistaIdioma findPeriodistaIdioma(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaIdioma.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaIdiomaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaIdioma> rt = cq.from(PeriodistaIdioma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
