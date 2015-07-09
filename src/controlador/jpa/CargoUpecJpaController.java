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
import modelo.CargoUpec;
import modelo.Periodista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class CargoUpecJpaController {

    public CargoUpecJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CargoUpec cargoUpec) throws PreexistingEntityException, Exception {
        if (cargoUpec.getPeriodistaList() == null) {
            cargoUpec.setPeriodistaList(new ArrayList<Periodista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Periodista> attachedPeriodistaList = new ArrayList<Periodista>();
            for (Periodista periodistaListPeriodistaToAttach : cargoUpec.getPeriodistaList()) {
                periodistaListPeriodistaToAttach = em.getReference(periodistaListPeriodistaToAttach.getClass(), periodistaListPeriodistaToAttach.getIdPeriodista());
                attachedPeriodistaList.add(periodistaListPeriodistaToAttach);
            }
            cargoUpec.setPeriodistaList(attachedPeriodistaList);
            em.persist(cargoUpec);
            for (Periodista periodistaListPeriodista : cargoUpec.getPeriodistaList()) {
                CargoUpec oldCargoUpecOfPeriodistaListPeriodista = periodistaListPeriodista.getCargoUpec();
                periodistaListPeriodista.setCargoUpec(cargoUpec);
                periodistaListPeriodista = em.merge(periodistaListPeriodista);
                if (oldCargoUpecOfPeriodistaListPeriodista != null) {
                    oldCargoUpecOfPeriodistaListPeriodista.getPeriodistaList().remove(periodistaListPeriodista);
                    oldCargoUpecOfPeriodistaListPeriodista = em.merge(oldCargoUpecOfPeriodistaListPeriodista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCargoUpec(cargoUpec.getIdCargou()) != null) {
                throw new PreexistingEntityException("CargoUpec " + cargoUpec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CargoUpec cargoUpec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargoUpec persistentCargoUpec = em.find(CargoUpec.class, cargoUpec.getIdCargou());
            List<Periodista> periodistaListOld = persistentCargoUpec.getPeriodistaList();
            List<Periodista> periodistaListNew = cargoUpec.getPeriodistaList();
            List<Periodista> attachedPeriodistaListNew = new ArrayList<Periodista>();
            for (Periodista periodistaListNewPeriodistaToAttach : periodistaListNew) {
                periodistaListNewPeriodistaToAttach = em.getReference(periodistaListNewPeriodistaToAttach.getClass(), periodistaListNewPeriodistaToAttach.getIdPeriodista());
                attachedPeriodistaListNew.add(periodistaListNewPeriodistaToAttach);
            }
            periodistaListNew = attachedPeriodistaListNew;
            cargoUpec.setPeriodistaList(periodistaListNew);
            cargoUpec = em.merge(cargoUpec);
            for (Periodista periodistaListOldPeriodista : periodistaListOld) {
                if (!periodistaListNew.contains(periodistaListOldPeriodista)) {
                    periodistaListOldPeriodista.setCargoUpec(null);
                    periodistaListOldPeriodista = em.merge(periodistaListOldPeriodista);
                }
            }
            for (Periodista periodistaListNewPeriodista : periodistaListNew) {
                if (!periodistaListOld.contains(periodistaListNewPeriodista)) {
                    CargoUpec oldCargoUpecOfPeriodistaListNewPeriodista = periodistaListNewPeriodista.getCargoUpec();
                    periodistaListNewPeriodista.setCargoUpec(cargoUpec);
                    periodistaListNewPeriodista = em.merge(periodistaListNewPeriodista);
                    if (oldCargoUpecOfPeriodistaListNewPeriodista != null && !oldCargoUpecOfPeriodistaListNewPeriodista.equals(cargoUpec)) {
                        oldCargoUpecOfPeriodistaListNewPeriodista.getPeriodistaList().remove(periodistaListNewPeriodista);
                        oldCargoUpecOfPeriodistaListNewPeriodista = em.merge(oldCargoUpecOfPeriodistaListNewPeriodista);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cargoUpec.getIdCargou();
                if (findCargoUpec(id) == null) {
                    throw new NonexistentEntityException("The cargoUpec with id " + id + " no longer exists.");
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
            CargoUpec cargoUpec;
            try {
                cargoUpec = em.getReference(CargoUpec.class, id);
                cargoUpec.getIdCargou();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargoUpec with id " + id + " no longer exists.", enfe);
            }
            List<Periodista> periodistaList = cargoUpec.getPeriodistaList();
            for (Periodista periodistaListPeriodista : periodistaList) {
                periodistaListPeriodista.setCargoUpec(null);
                periodistaListPeriodista = em.merge(periodistaListPeriodista);
            }
            em.remove(cargoUpec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CargoUpec> findCargoUpecEntities() {
        return findCargoUpecEntities(true, -1, -1);
    }

    public List<CargoUpec> findCargoUpecEntities(int maxResults, int firstResult) {
        return findCargoUpecEntities(false, maxResults, firstResult);
    }

    private List<CargoUpec> findCargoUpecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CargoUpec.class));
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

    public CargoUpec findCargoUpec(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CargoUpec.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoUpecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CargoUpec> rt = cq.from(CargoUpec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
