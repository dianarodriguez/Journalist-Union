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
import modelo.CategoriaDocente;
import modelo.PeriodistaCategoria;

/**
 *
 * @author asus
 */
public class PeriodistaCategoriaJpaController {

    public PeriodistaCategoriaJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaCategoria periodistaCategoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaCategoria.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaCategoria.setPeriodista(periodista);
            }
            CategoriaDocente categoriaDocente = periodistaCategoria.getCategoriaDocente();
            if (categoriaDocente != null) {
                categoriaDocente = em.getReference(categoriaDocente.getClass(), categoriaDocente.getIdCategoria());
                periodistaCategoria.setCategoriaDocente(categoriaDocente);
            }
            em.persist(periodistaCategoria);
            if (periodista != null) {
                periodista.getPeriodistaCategoriaList().add(periodistaCategoria);
                periodista = em.merge(periodista);
            }
            if (categoriaDocente != null) {
                categoriaDocente.getPeriodistaCategoriaList().add(periodistaCategoria);
                categoriaDocente = em.merge(categoriaDocente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaCategoria(periodistaCategoria.getIdPeriodsitaCateg()) != null) {
                throw new PreexistingEntityException("PeriodistaCategoria " + periodistaCategoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaCategoria periodistaCategoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaCategoria persistentPeriodistaCategoria = em.find(PeriodistaCategoria.class, periodistaCategoria.getIdPeriodsitaCateg());
            Periodista periodistaOld = persistentPeriodistaCategoria.getPeriodista();
            Periodista periodistaNew = periodistaCategoria.getPeriodista();
            CategoriaDocente categoriaDocenteOld = persistentPeriodistaCategoria.getCategoriaDocente();
            CategoriaDocente categoriaDocenteNew = periodistaCategoria.getCategoriaDocente();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaCategoria.setPeriodista(periodistaNew);
            }
            if (categoriaDocenteNew != null) {
                categoriaDocenteNew = em.getReference(categoriaDocenteNew.getClass(), categoriaDocenteNew.getIdCategoria());
                periodistaCategoria.setCategoriaDocente(categoriaDocenteNew);
            }
            periodistaCategoria = em.merge(periodistaCategoria);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaCategoriaList().remove(periodistaCategoria);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaCategoriaList().add(periodistaCategoria);
                periodistaNew = em.merge(periodistaNew);
            }
            if (categoriaDocenteOld != null && !categoriaDocenteOld.equals(categoriaDocenteNew)) {
                categoriaDocenteOld.getPeriodistaCategoriaList().remove(periodistaCategoria);
                categoriaDocenteOld = em.merge(categoriaDocenteOld);
            }
            if (categoriaDocenteNew != null && !categoriaDocenteNew.equals(categoriaDocenteOld)) {
                categoriaDocenteNew.getPeriodistaCategoriaList().add(periodistaCategoria);
                categoriaDocenteNew = em.merge(categoriaDocenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaCategoria.getIdPeriodsitaCateg();
                if (findPeriodistaCategoria(id) == null) {
                    throw new NonexistentEntityException("The periodistaCategoria with id " + id + " no longer exists.");
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
            PeriodistaCategoria periodistaCategoria;
            try {
                periodistaCategoria = em.getReference(PeriodistaCategoria.class, id);
                periodistaCategoria.getIdPeriodsitaCateg();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaCategoria with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaCategoria.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaCategoriaList().remove(periodistaCategoria);
                periodista = em.merge(periodista);
            }
            CategoriaDocente categoriaDocente = periodistaCategoria.getCategoriaDocente();
            if (categoriaDocente != null) {
                categoriaDocente.getPeriodistaCategoriaList().remove(periodistaCategoria);
                categoriaDocente = em.merge(categoriaDocente);
            }
            em.remove(periodistaCategoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaCategoria> findPeriodistaCategoriaEntities() {
        return findPeriodistaCategoriaEntities(true, -1, -1);
    }

    public List<PeriodistaCategoria> findPeriodistaCategoriaEntities(int maxResults, int firstResult) {
        return findPeriodistaCategoriaEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaCategoria> findPeriodistaCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaCategoria.class));
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

    public PeriodistaCategoria findPeriodistaCategoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaCategoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaCategoria> rt = cq.from(PeriodistaCategoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
