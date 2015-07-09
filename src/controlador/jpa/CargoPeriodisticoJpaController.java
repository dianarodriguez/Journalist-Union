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
import modelo.CargoPeriodistico;
import modelo.PeriodistaCargop;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class CargoPeriodisticoJpaController {

    public CargoPeriodisticoJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CargoPeriodistico cargoPeriodistico) throws PreexistingEntityException, Exception {
        if (cargoPeriodistico.getPeriodistaCargopList() == null) {
            cargoPeriodistico.setPeriodistaCargopList(new ArrayList<PeriodistaCargop>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaCargop> attachedPeriodistaCargopList = new ArrayList<PeriodistaCargop>();
            for (PeriodistaCargop periodistaCargopListPeriodistaCargopToAttach : cargoPeriodistico.getPeriodistaCargopList()) {
                periodistaCargopListPeriodistaCargopToAttach = em.getReference(periodistaCargopListPeriodistaCargopToAttach.getClass(), periodistaCargopListPeriodistaCargopToAttach.getIdPerCargo());
                attachedPeriodistaCargopList.add(periodistaCargopListPeriodistaCargopToAttach);
            }
            cargoPeriodistico.setPeriodistaCargopList(attachedPeriodistaCargopList);
            em.persist(cargoPeriodistico);
            for (PeriodistaCargop periodistaCargopListPeriodistaCargop : cargoPeriodistico.getPeriodistaCargopList()) {
                CargoPeriodistico oldCargoPeriodisticoOfPeriodistaCargopListPeriodistaCargop = periodistaCargopListPeriodistaCargop.getCargoPeriodistico();
                periodistaCargopListPeriodistaCargop.setCargoPeriodistico(cargoPeriodistico);
                periodistaCargopListPeriodistaCargop = em.merge(periodistaCargopListPeriodistaCargop);
                if (oldCargoPeriodisticoOfPeriodistaCargopListPeriodistaCargop != null) {
                    oldCargoPeriodisticoOfPeriodistaCargopListPeriodistaCargop.getPeriodistaCargopList().remove(periodistaCargopListPeriodistaCargop);
                    oldCargoPeriodisticoOfPeriodistaCargopListPeriodistaCargop = em.merge(oldCargoPeriodisticoOfPeriodistaCargopListPeriodistaCargop);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCargoPeriodistico(cargoPeriodistico.getIdCargop()) != null) {
                throw new PreexistingEntityException("CargoPeriodistico " + cargoPeriodistico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CargoPeriodistico cargoPeriodistico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargoPeriodistico persistentCargoPeriodistico = em.find(CargoPeriodistico.class, cargoPeriodistico.getIdCargop());
            List<PeriodistaCargop> periodistaCargopListOld = persistentCargoPeriodistico.getPeriodistaCargopList();
            List<PeriodistaCargop> periodistaCargopListNew = cargoPeriodistico.getPeriodistaCargopList();
            List<PeriodistaCargop> attachedPeriodistaCargopListNew = new ArrayList<PeriodistaCargop>();
            for (PeriodistaCargop periodistaCargopListNewPeriodistaCargopToAttach : periodistaCargopListNew) {
                periodistaCargopListNewPeriodistaCargopToAttach = em.getReference(periodistaCargopListNewPeriodistaCargopToAttach.getClass(), periodistaCargopListNewPeriodistaCargopToAttach.getIdPerCargo());
                attachedPeriodistaCargopListNew.add(periodistaCargopListNewPeriodistaCargopToAttach);
            }
            periodistaCargopListNew = attachedPeriodistaCargopListNew;
            cargoPeriodistico.setPeriodistaCargopList(periodistaCargopListNew);
            cargoPeriodistico = em.merge(cargoPeriodistico);
            for (PeriodistaCargop periodistaCargopListOldPeriodistaCargop : periodistaCargopListOld) {
                if (!periodistaCargopListNew.contains(periodistaCargopListOldPeriodistaCargop)) {
                    periodistaCargopListOldPeriodistaCargop.setCargoPeriodistico(null);
                    periodistaCargopListOldPeriodistaCargop = em.merge(periodistaCargopListOldPeriodistaCargop);
                }
            }
            for (PeriodistaCargop periodistaCargopListNewPeriodistaCargop : periodistaCargopListNew) {
                if (!periodistaCargopListOld.contains(periodistaCargopListNewPeriodistaCargop)) {
                    CargoPeriodistico oldCargoPeriodisticoOfPeriodistaCargopListNewPeriodistaCargop = periodistaCargopListNewPeriodistaCargop.getCargoPeriodistico();
                    periodistaCargopListNewPeriodistaCargop.setCargoPeriodistico(cargoPeriodistico);
                    periodistaCargopListNewPeriodistaCargop = em.merge(periodistaCargopListNewPeriodistaCargop);
                    if (oldCargoPeriodisticoOfPeriodistaCargopListNewPeriodistaCargop != null && !oldCargoPeriodisticoOfPeriodistaCargopListNewPeriodistaCargop.equals(cargoPeriodistico)) {
                        oldCargoPeriodisticoOfPeriodistaCargopListNewPeriodistaCargop.getPeriodistaCargopList().remove(periodistaCargopListNewPeriodistaCargop);
                        oldCargoPeriodisticoOfPeriodistaCargopListNewPeriodistaCargop = em.merge(oldCargoPeriodisticoOfPeriodistaCargopListNewPeriodistaCargop);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cargoPeriodistico.getIdCargop();
                if (findCargoPeriodistico(id) == null) {
                    throw new NonexistentEntityException("The cargoPeriodistico with id " + id + " no longer exists.");
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
            CargoPeriodistico cargoPeriodistico;
            try {
                cargoPeriodistico = em.getReference(CargoPeriodistico.class, id);
                cargoPeriodistico.getIdCargop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargoPeriodistico with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaCargop> periodistaCargopList = cargoPeriodistico.getPeriodistaCargopList();
            for (PeriodistaCargop periodistaCargopListPeriodistaCargop : periodistaCargopList) {
                periodistaCargopListPeriodistaCargop.setCargoPeriodistico(null);
                periodistaCargopListPeriodistaCargop = em.merge(periodistaCargopListPeriodistaCargop);
            }
            em.remove(cargoPeriodistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CargoPeriodistico> findCargoPeriodisticoEntities() {
        return findCargoPeriodisticoEntities(true, -1, -1);
    }

    public List<CargoPeriodistico> findCargoPeriodisticoEntities(int maxResults, int firstResult) {
        return findCargoPeriodisticoEntities(false, maxResults, firstResult);
    }

    private List<CargoPeriodistico> findCargoPeriodisticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CargoPeriodistico.class));
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

    public CargoPeriodistico findCargoPeriodistico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CargoPeriodistico.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoPeriodisticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CargoPeriodistico> rt = cq.from(CargoPeriodistico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
