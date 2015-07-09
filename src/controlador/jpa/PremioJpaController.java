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
import modelo.PeriodistaPremio;
import java.util.ArrayList;
import java.util.List;
import modelo.Premio;

/**
 *
 * @author asus
 */
public class PremioJpaController {

    public PremioJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Premio premio) throws PreexistingEntityException, Exception {
        if (premio.getPeriodistaPremioList() == null) {
            premio.setPeriodistaPremioList(new ArrayList<PeriodistaPremio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaPremio> attachedPeriodistaPremioList = new ArrayList<PeriodistaPremio>();
            for (PeriodistaPremio periodistaPremioListPeriodistaPremioToAttach : premio.getPeriodistaPremioList()) {
                periodistaPremioListPeriodistaPremioToAttach = em.getReference(periodistaPremioListPeriodistaPremioToAttach.getClass(), periodistaPremioListPeriodistaPremioToAttach.getIdPerPremio());
                attachedPeriodistaPremioList.add(periodistaPremioListPeriodistaPremioToAttach);
            }
            premio.setPeriodistaPremioList(attachedPeriodistaPremioList);
            em.persist(premio);
            for (PeriodistaPremio periodistaPremioListPeriodistaPremio : premio.getPeriodistaPremioList()) {
                Premio oldPremioOfPeriodistaPremioListPeriodistaPremio = periodistaPremioListPeriodistaPremio.getPremio();
                periodistaPremioListPeriodistaPremio.setPremio(premio);
                periodistaPremioListPeriodistaPremio = em.merge(periodistaPremioListPeriodistaPremio);
                if (oldPremioOfPeriodistaPremioListPeriodistaPremio != null) {
                    oldPremioOfPeriodistaPremioListPeriodistaPremio.getPeriodistaPremioList().remove(periodistaPremioListPeriodistaPremio);
                    oldPremioOfPeriodistaPremioListPeriodistaPremio = em.merge(oldPremioOfPeriodistaPremioListPeriodistaPremio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPremio(premio.getIdPremio()) != null) {
                throw new PreexistingEntityException("Premio " + premio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Premio premio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Premio persistentPremio = em.find(Premio.class, premio.getIdPremio());
            List<PeriodistaPremio> periodistaPremioListOld = persistentPremio.getPeriodistaPremioList();
            List<PeriodistaPremio> periodistaPremioListNew = premio.getPeriodistaPremioList();
            List<PeriodistaPremio> attachedPeriodistaPremioListNew = new ArrayList<PeriodistaPremio>();
            for (PeriodistaPremio periodistaPremioListNewPeriodistaPremioToAttach : periodistaPremioListNew) {
                periodistaPremioListNewPeriodistaPremioToAttach = em.getReference(periodistaPremioListNewPeriodistaPremioToAttach.getClass(), periodistaPremioListNewPeriodistaPremioToAttach.getIdPerPremio());
                attachedPeriodistaPremioListNew.add(periodistaPremioListNewPeriodistaPremioToAttach);
            }
            periodistaPremioListNew = attachedPeriodistaPremioListNew;
            premio.setPeriodistaPremioList(periodistaPremioListNew);
            premio = em.merge(premio);
            for (PeriodistaPremio periodistaPremioListOldPeriodistaPremio : periodistaPremioListOld) {
                if (!periodistaPremioListNew.contains(periodistaPremioListOldPeriodistaPremio)) {
                    periodistaPremioListOldPeriodistaPremio.setPremio(null);
                    periodistaPremioListOldPeriodistaPremio = em.merge(periodistaPremioListOldPeriodistaPremio);
                }
            }
            for (PeriodistaPremio periodistaPremioListNewPeriodistaPremio : periodistaPremioListNew) {
                if (!periodistaPremioListOld.contains(periodistaPremioListNewPeriodistaPremio)) {
                    Premio oldPremioOfPeriodistaPremioListNewPeriodistaPremio = periodistaPremioListNewPeriodistaPremio.getPremio();
                    periodistaPremioListNewPeriodistaPremio.setPremio(premio);
                    periodistaPremioListNewPeriodistaPremio = em.merge(periodistaPremioListNewPeriodistaPremio);
                    if (oldPremioOfPeriodistaPremioListNewPeriodistaPremio != null && !oldPremioOfPeriodistaPremioListNewPeriodistaPremio.equals(premio)) {
                        oldPremioOfPeriodistaPremioListNewPeriodistaPremio.getPeriodistaPremioList().remove(periodistaPremioListNewPeriodistaPremio);
                        oldPremioOfPeriodistaPremioListNewPeriodistaPremio = em.merge(oldPremioOfPeriodistaPremioListNewPeriodistaPremio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = premio.getIdPremio();
                if (findPremio(id) == null) {
                    throw new NonexistentEntityException("The premio with id " + id + " no longer exists.");
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
            Premio premio;
            try {
                premio = em.getReference(Premio.class, id);
                premio.getIdPremio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The premio with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaPremio> periodistaPremioList = premio.getPeriodistaPremioList();
            for (PeriodistaPremio periodistaPremioListPeriodistaPremio : periodistaPremioList) {
                periodistaPremioListPeriodistaPremio.setPremio(null);
                periodistaPremioListPeriodistaPremio = em.merge(periodistaPremioListPeriodistaPremio);
            }
            em.remove(premio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Premio> findPremioEntities() {
        return findPremioEntities(true, -1, -1);
    }

    public List<Premio> findPremioEntities(int maxResults, int firstResult) {
        return findPremioEntities(false, maxResults, firstResult);
    }

    private List<Premio> findPremioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Premio.class));
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

    public Premio findPremio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Premio.class, id);
        } finally {
            em.close();
        }
    }

    public int getPremioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Premio> rt = cq.from(Premio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
