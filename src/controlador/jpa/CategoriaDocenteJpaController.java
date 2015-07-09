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
import modelo.CategoriaDocente;
import modelo.PeriodistaCategoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class CategoriaDocenteJpaController {

    public CategoriaDocenteJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CategoriaDocente categoriaDocente) throws PreexistingEntityException, Exception {
        if (categoriaDocente.getPeriodistaCategoriaList() == null) {
            categoriaDocente.setPeriodistaCategoriaList(new ArrayList<PeriodistaCategoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaCategoria> attachedPeriodistaCategoriaList = new ArrayList<PeriodistaCategoria>();
            for (PeriodistaCategoria periodistaCategoriaListPeriodistaCategoriaToAttach : categoriaDocente.getPeriodistaCategoriaList()) {
                periodistaCategoriaListPeriodistaCategoriaToAttach = em.getReference(periodistaCategoriaListPeriodistaCategoriaToAttach.getClass(), periodistaCategoriaListPeriodistaCategoriaToAttach.getIdPeriodsitaCateg());
                attachedPeriodistaCategoriaList.add(periodistaCategoriaListPeriodistaCategoriaToAttach);
            }
            categoriaDocente.setPeriodistaCategoriaList(attachedPeriodistaCategoriaList);
            em.persist(categoriaDocente);
            for (PeriodistaCategoria periodistaCategoriaListPeriodistaCategoria : categoriaDocente.getPeriodistaCategoriaList()) {
                CategoriaDocente oldCategoriaDocenteOfPeriodistaCategoriaListPeriodistaCategoria = periodistaCategoriaListPeriodistaCategoria.getCategoriaDocente();
                periodistaCategoriaListPeriodistaCategoria.setCategoriaDocente(categoriaDocente);
                periodistaCategoriaListPeriodistaCategoria = em.merge(periodistaCategoriaListPeriodistaCategoria);
                if (oldCategoriaDocenteOfPeriodistaCategoriaListPeriodistaCategoria != null) {
                    oldCategoriaDocenteOfPeriodistaCategoriaListPeriodistaCategoria.getPeriodistaCategoriaList().remove(periodistaCategoriaListPeriodistaCategoria);
                    oldCategoriaDocenteOfPeriodistaCategoriaListPeriodistaCategoria = em.merge(oldCategoriaDocenteOfPeriodistaCategoriaListPeriodistaCategoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategoriaDocente(categoriaDocente.getIdCategoria()) != null) {
                throw new PreexistingEntityException("CategoriaDocente " + categoriaDocente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CategoriaDocente categoriaDocente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CategoriaDocente persistentCategoriaDocente = em.find(CategoriaDocente.class, categoriaDocente.getIdCategoria());
            List<PeriodistaCategoria> periodistaCategoriaListOld = persistentCategoriaDocente.getPeriodistaCategoriaList();
            List<PeriodistaCategoria> periodistaCategoriaListNew = categoriaDocente.getPeriodistaCategoriaList();
            List<PeriodistaCategoria> attachedPeriodistaCategoriaListNew = new ArrayList<PeriodistaCategoria>();
            for (PeriodistaCategoria periodistaCategoriaListNewPeriodistaCategoriaToAttach : periodistaCategoriaListNew) {
                periodistaCategoriaListNewPeriodistaCategoriaToAttach = em.getReference(periodistaCategoriaListNewPeriodistaCategoriaToAttach.getClass(), periodistaCategoriaListNewPeriodistaCategoriaToAttach.getIdPeriodsitaCateg());
                attachedPeriodistaCategoriaListNew.add(periodistaCategoriaListNewPeriodistaCategoriaToAttach);
            }
            periodistaCategoriaListNew = attachedPeriodistaCategoriaListNew;
            categoriaDocente.setPeriodistaCategoriaList(periodistaCategoriaListNew);
            categoriaDocente = em.merge(categoriaDocente);
            for (PeriodistaCategoria periodistaCategoriaListOldPeriodistaCategoria : periodistaCategoriaListOld) {
                if (!periodistaCategoriaListNew.contains(periodistaCategoriaListOldPeriodistaCategoria)) {
                    periodistaCategoriaListOldPeriodistaCategoria.setCategoriaDocente(null);
                    periodistaCategoriaListOldPeriodistaCategoria = em.merge(periodistaCategoriaListOldPeriodistaCategoria);
                }
            }
            for (PeriodistaCategoria periodistaCategoriaListNewPeriodistaCategoria : periodistaCategoriaListNew) {
                if (!periodistaCategoriaListOld.contains(periodistaCategoriaListNewPeriodistaCategoria)) {
                    CategoriaDocente oldCategoriaDocenteOfPeriodistaCategoriaListNewPeriodistaCategoria = periodistaCategoriaListNewPeriodistaCategoria.getCategoriaDocente();
                    periodistaCategoriaListNewPeriodistaCategoria.setCategoriaDocente(categoriaDocente);
                    periodistaCategoriaListNewPeriodistaCategoria = em.merge(periodistaCategoriaListNewPeriodistaCategoria);
                    if (oldCategoriaDocenteOfPeriodistaCategoriaListNewPeriodistaCategoria != null && !oldCategoriaDocenteOfPeriodistaCategoriaListNewPeriodistaCategoria.equals(categoriaDocente)) {
                        oldCategoriaDocenteOfPeriodistaCategoriaListNewPeriodistaCategoria.getPeriodistaCategoriaList().remove(periodistaCategoriaListNewPeriodistaCategoria);
                        oldCategoriaDocenteOfPeriodistaCategoriaListNewPeriodistaCategoria = em.merge(oldCategoriaDocenteOfPeriodistaCategoriaListNewPeriodistaCategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = categoriaDocente.getIdCategoria();
                if (findCategoriaDocente(id) == null) {
                    throw new NonexistentEntityException("The categoriaDocente with id " + id + " no longer exists.");
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
            CategoriaDocente categoriaDocente;
            try {
                categoriaDocente = em.getReference(CategoriaDocente.class, id);
                categoriaDocente.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoriaDocente with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaCategoria> periodistaCategoriaList = categoriaDocente.getPeriodistaCategoriaList();
            for (PeriodistaCategoria periodistaCategoriaListPeriodistaCategoria : periodistaCategoriaList) {
                periodistaCategoriaListPeriodistaCategoria.setCategoriaDocente(null);
                periodistaCategoriaListPeriodistaCategoria = em.merge(periodistaCategoriaListPeriodistaCategoria);
            }
            em.remove(categoriaDocente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CategoriaDocente> findCategoriaDocenteEntities() {
        return findCategoriaDocenteEntities(true, -1, -1);
    }

    public List<CategoriaDocente> findCategoriaDocenteEntities(int maxResults, int firstResult) {
        return findCategoriaDocenteEntities(false, maxResults, firstResult);
    }

    private List<CategoriaDocente> findCategoriaDocenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CategoriaDocente.class));
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

    public CategoriaDocente findCategoriaDocente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CategoriaDocente.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaDocenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CategoriaDocente> rt = cq.from(CategoriaDocente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
