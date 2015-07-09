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
import modelo.Computadoras;
import modelo.PeriodistaComputadora;

/**
 *
 * @author asus
 */
public class PeriodistaComputadoraJpaController {

    public PeriodistaComputadoraJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaComputadora periodistaComputadora) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaComputadora.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaComputadora.setPeriodista(periodista);
            }
            Computadoras computadoras = periodistaComputadora.getComputadoras();
            if (computadoras != null) {
                computadoras = em.getReference(computadoras.getClass(), computadoras.getIdPc());
                periodistaComputadora.setComputadoras(computadoras);
            }
            em.persist(periodistaComputadora);
            if (periodista != null) {
                periodista.getPeriodistaComputadoraList().add(periodistaComputadora);
                periodista = em.merge(periodista);
            }
            if (computadoras != null) {
                computadoras.getPeriodistaComputadoraList().add(periodistaComputadora);
                computadoras = em.merge(computadoras);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaComputadora(periodistaComputadora.getIdPerComp()) != null) {
                throw new PreexistingEntityException("PeriodistaComputadora " + periodistaComputadora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaComputadora periodistaComputadora) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaComputadora persistentPeriodistaComputadora = em.find(PeriodistaComputadora.class, periodistaComputadora.getIdPerComp());
            Periodista periodistaOld = persistentPeriodistaComputadora.getPeriodista();
            Periodista periodistaNew = periodistaComputadora.getPeriodista();
            Computadoras computadorasOld = persistentPeriodistaComputadora.getComputadoras();
            Computadoras computadorasNew = periodistaComputadora.getComputadoras();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaComputadora.setPeriodista(periodistaNew);
            }
            if (computadorasNew != null) {
                computadorasNew = em.getReference(computadorasNew.getClass(), computadorasNew.getIdPc());
                periodistaComputadora.setComputadoras(computadorasNew);
            }
            periodistaComputadora = em.merge(periodistaComputadora);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaComputadoraList().remove(periodistaComputadora);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaComputadoraList().add(periodistaComputadora);
                periodistaNew = em.merge(periodistaNew);
            }
            if (computadorasOld != null && !computadorasOld.equals(computadorasNew)) {
                computadorasOld.getPeriodistaComputadoraList().remove(periodistaComputadora);
                computadorasOld = em.merge(computadorasOld);
            }
            if (computadorasNew != null && !computadorasNew.equals(computadorasOld)) {
                computadorasNew.getPeriodistaComputadoraList().add(periodistaComputadora);
                computadorasNew = em.merge(computadorasNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaComputadora.getIdPerComp();
                if (findPeriodistaComputadora(id) == null) {
                    throw new NonexistentEntityException("The periodistaComputadora with id " + id + " no longer exists.");
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
            PeriodistaComputadora periodistaComputadora;
            try {
                periodistaComputadora = em.getReference(PeriodistaComputadora.class, id);
                periodistaComputadora.getIdPerComp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaComputadora with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaComputadora.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaComputadoraList().remove(periodistaComputadora);
                periodista = em.merge(periodista);
            }
            Computadoras computadoras = periodistaComputadora.getComputadoras();
            if (computadoras != null) {
                computadoras.getPeriodistaComputadoraList().remove(periodistaComputadora);
                computadoras = em.merge(computadoras);
            }
            em.remove(periodistaComputadora);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaComputadora> findPeriodistaComputadoraEntities() {
        return findPeriodistaComputadoraEntities(true, -1, -1);
    }

    public List<PeriodistaComputadora> findPeriodistaComputadoraEntities(int maxResults, int firstResult) {
        return findPeriodistaComputadoraEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaComputadora> findPeriodistaComputadoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaComputadora.class));
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

    public PeriodistaComputadora findPeriodistaComputadora(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaComputadora.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaComputadoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaComputadora> rt = cq.from(PeriodistaComputadora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
