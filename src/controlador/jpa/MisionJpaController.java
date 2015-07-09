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
import modelo.Mision;
import modelo.PeriodistaMision;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class MisionJpaController {

    public MisionJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mision mision) throws PreexistingEntityException, Exception {
        if (mision.getPeriodistaMisionList() == null) {
            mision.setPeriodistaMisionList(new ArrayList<PeriodistaMision>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaMision> attachedPeriodistaMisionList = new ArrayList<PeriodistaMision>();
            for (PeriodistaMision periodistaMisionListPeriodistaMisionToAttach : mision.getPeriodistaMisionList()) {
                periodistaMisionListPeriodistaMisionToAttach = em.getReference(periodistaMisionListPeriodistaMisionToAttach.getClass(), periodistaMisionListPeriodistaMisionToAttach.getIdPerMision());
                attachedPeriodistaMisionList.add(periodistaMisionListPeriodistaMisionToAttach);
            }
            mision.setPeriodistaMisionList(attachedPeriodistaMisionList);
            em.persist(mision);
            for (PeriodistaMision periodistaMisionListPeriodistaMision : mision.getPeriodistaMisionList()) {
                Mision oldMisionOfPeriodistaMisionListPeriodistaMision = periodistaMisionListPeriodistaMision.getMision();
                periodistaMisionListPeriodistaMision.setMision(mision);
                periodistaMisionListPeriodistaMision = em.merge(periodistaMisionListPeriodistaMision);
                if (oldMisionOfPeriodistaMisionListPeriodistaMision != null) {
                    oldMisionOfPeriodistaMisionListPeriodistaMision.getPeriodistaMisionList().remove(periodistaMisionListPeriodistaMision);
                    oldMisionOfPeriodistaMisionListPeriodistaMision = em.merge(oldMisionOfPeriodistaMisionListPeriodistaMision);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMision(mision.getIdMision()) != null) {
                throw new PreexistingEntityException("Mision " + mision + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mision mision) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mision persistentMision = em.find(Mision.class, mision.getIdMision());
            List<PeriodistaMision> periodistaMisionListOld = persistentMision.getPeriodistaMisionList();
            List<PeriodistaMision> periodistaMisionListNew = mision.getPeriodistaMisionList();
            List<PeriodistaMision> attachedPeriodistaMisionListNew = new ArrayList<PeriodistaMision>();
            for (PeriodistaMision periodistaMisionListNewPeriodistaMisionToAttach : periodistaMisionListNew) {
                periodistaMisionListNewPeriodistaMisionToAttach = em.getReference(periodistaMisionListNewPeriodistaMisionToAttach.getClass(), periodistaMisionListNewPeriodistaMisionToAttach.getIdPerMision());
                attachedPeriodistaMisionListNew.add(periodistaMisionListNewPeriodistaMisionToAttach);
            }
            periodistaMisionListNew = attachedPeriodistaMisionListNew;
            mision.setPeriodistaMisionList(periodistaMisionListNew);
            mision = em.merge(mision);
            for (PeriodistaMision periodistaMisionListOldPeriodistaMision : periodistaMisionListOld) {
                if (!periodistaMisionListNew.contains(periodistaMisionListOldPeriodistaMision)) {
                    periodistaMisionListOldPeriodistaMision.setMision(null);
                    periodistaMisionListOldPeriodistaMision = em.merge(periodistaMisionListOldPeriodistaMision);
                }
            }
            for (PeriodistaMision periodistaMisionListNewPeriodistaMision : periodistaMisionListNew) {
                if (!periodistaMisionListOld.contains(periodistaMisionListNewPeriodistaMision)) {
                    Mision oldMisionOfPeriodistaMisionListNewPeriodistaMision = periodistaMisionListNewPeriodistaMision.getMision();
                    periodistaMisionListNewPeriodistaMision.setMision(mision);
                    periodistaMisionListNewPeriodistaMision = em.merge(periodistaMisionListNewPeriodistaMision);
                    if (oldMisionOfPeriodistaMisionListNewPeriodistaMision != null && !oldMisionOfPeriodistaMisionListNewPeriodistaMision.equals(mision)) {
                        oldMisionOfPeriodistaMisionListNewPeriodistaMision.getPeriodistaMisionList().remove(periodistaMisionListNewPeriodistaMision);
                        oldMisionOfPeriodistaMisionListNewPeriodistaMision = em.merge(oldMisionOfPeriodistaMisionListNewPeriodistaMision);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mision.getIdMision();
                if (findMision(id) == null) {
                    throw new NonexistentEntityException("The mision with id " + id + " no longer exists.");
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
            Mision mision;
            try {
                mision = em.getReference(Mision.class, id);
                mision.getIdMision();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mision with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaMision> periodistaMisionList = mision.getPeriodistaMisionList();
            for (PeriodistaMision periodistaMisionListPeriodistaMision : periodistaMisionList) {
                periodistaMisionListPeriodistaMision.setMision(null);
                periodistaMisionListPeriodistaMision = em.merge(periodistaMisionListPeriodistaMision);
            }
            em.remove(mision);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mision> findMisionEntities() {
        return findMisionEntities(true, -1, -1);
    }

    public List<Mision> findMisionEntities(int maxResults, int firstResult) {
        return findMisionEntities(false, maxResults, firstResult);
    }

    private List<Mision> findMisionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mision.class));
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

    public Mision findMision(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mision.class, id);
        } finally {
            em.close();
        }
    }

    public int getMisionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mision> rt = cq.from(Mision.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
