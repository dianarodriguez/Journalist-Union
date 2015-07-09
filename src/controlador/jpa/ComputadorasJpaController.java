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
import modelo.Computadoras;
import modelo.Delegacion;
import modelo.PeriodistaComputadora;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ComputadorasJpaController {

    public ComputadorasJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Computadoras computadoras) throws PreexistingEntityException, Exception {
        if (computadoras.getPeriodistaComputadoraList() == null) {
            computadoras.setPeriodistaComputadoraList(new ArrayList<PeriodistaComputadora>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Delegacion delegacion = computadoras.getDelegacion();
            if (delegacion != null) {
                delegacion = em.getReference(delegacion.getClass(), delegacion.getIdDelegacion());
                computadoras.setDelegacion(delegacion);
            }
            List<PeriodistaComputadora> attachedPeriodistaComputadoraList = new ArrayList<PeriodistaComputadora>();
            for (PeriodistaComputadora periodistaComputadoraListPeriodistaComputadoraToAttach : computadoras.getPeriodistaComputadoraList()) {
                periodistaComputadoraListPeriodistaComputadoraToAttach = em.getReference(periodistaComputadoraListPeriodistaComputadoraToAttach.getClass(), periodistaComputadoraListPeriodistaComputadoraToAttach.getIdPerComp());
                attachedPeriodistaComputadoraList.add(periodistaComputadoraListPeriodistaComputadoraToAttach);
            }
            computadoras.setPeriodistaComputadoraList(attachedPeriodistaComputadoraList);
            em.persist(computadoras);
            if (delegacion != null) {
                delegacion.getComputadorasList().add(computadoras);
                delegacion = em.merge(delegacion);
            }
            for (PeriodistaComputadora periodistaComputadoraListPeriodistaComputadora : computadoras.getPeriodistaComputadoraList()) {
                Computadoras oldComputadorasOfPeriodistaComputadoraListPeriodistaComputadora = periodistaComputadoraListPeriodistaComputadora.getComputadoras();
                periodistaComputadoraListPeriodistaComputadora.setComputadoras(computadoras);
                periodistaComputadoraListPeriodistaComputadora = em.merge(periodistaComputadoraListPeriodistaComputadora);
                if (oldComputadorasOfPeriodistaComputadoraListPeriodistaComputadora != null) {
                    oldComputadorasOfPeriodistaComputadoraListPeriodistaComputadora.getPeriodistaComputadoraList().remove(periodistaComputadoraListPeriodistaComputadora);
                    oldComputadorasOfPeriodistaComputadoraListPeriodistaComputadora = em.merge(oldComputadorasOfPeriodistaComputadoraListPeriodistaComputadora);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComputadoras(computadoras.getIdPc()) != null) {
                throw new PreexistingEntityException("Computadoras " + computadoras + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Computadoras computadoras) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Computadoras persistentComputadoras = em.find(Computadoras.class, computadoras.getIdPc());
            Delegacion delegacionOld = persistentComputadoras.getDelegacion();
            Delegacion delegacionNew = computadoras.getDelegacion();
            List<PeriodistaComputadora> periodistaComputadoraListOld = persistentComputadoras.getPeriodistaComputadoraList();
            List<PeriodistaComputadora> periodistaComputadoraListNew = computadoras.getPeriodistaComputadoraList();
            if (delegacionNew != null) {
                delegacionNew = em.getReference(delegacionNew.getClass(), delegacionNew.getIdDelegacion());
                computadoras.setDelegacion(delegacionNew);
            }
            List<PeriodistaComputadora> attachedPeriodistaComputadoraListNew = new ArrayList<PeriodistaComputadora>();
            for (PeriodistaComputadora periodistaComputadoraListNewPeriodistaComputadoraToAttach : periodistaComputadoraListNew) {
                periodistaComputadoraListNewPeriodistaComputadoraToAttach = em.getReference(periodistaComputadoraListNewPeriodistaComputadoraToAttach.getClass(), periodistaComputadoraListNewPeriodistaComputadoraToAttach.getIdPerComp());
                attachedPeriodistaComputadoraListNew.add(periodistaComputadoraListNewPeriodistaComputadoraToAttach);
            }
            periodistaComputadoraListNew = attachedPeriodistaComputadoraListNew;
            computadoras.setPeriodistaComputadoraList(periodistaComputadoraListNew);
            computadoras = em.merge(computadoras);
            if (delegacionOld != null && !delegacionOld.equals(delegacionNew)) {
                delegacionOld.getComputadorasList().remove(computadoras);
                delegacionOld = em.merge(delegacionOld);
            }
            if (delegacionNew != null && !delegacionNew.equals(delegacionOld)) {
                delegacionNew.getComputadorasList().add(computadoras);
                delegacionNew = em.merge(delegacionNew);
            }
            for (PeriodistaComputadora periodistaComputadoraListOldPeriodistaComputadora : periodistaComputadoraListOld) {
                if (!periodistaComputadoraListNew.contains(periodistaComputadoraListOldPeriodistaComputadora)) {
                    periodistaComputadoraListOldPeriodistaComputadora.setComputadoras(null);
                    periodistaComputadoraListOldPeriodistaComputadora = em.merge(periodistaComputadoraListOldPeriodistaComputadora);
                }
            }
            for (PeriodistaComputadora periodistaComputadoraListNewPeriodistaComputadora : periodistaComputadoraListNew) {
                if (!periodistaComputadoraListOld.contains(periodistaComputadoraListNewPeriodistaComputadora)) {
                    Computadoras oldComputadorasOfPeriodistaComputadoraListNewPeriodistaComputadora = periodistaComputadoraListNewPeriodistaComputadora.getComputadoras();
                    periodistaComputadoraListNewPeriodistaComputadora.setComputadoras(computadoras);
                    periodistaComputadoraListNewPeriodistaComputadora = em.merge(periodistaComputadoraListNewPeriodistaComputadora);
                    if (oldComputadorasOfPeriodistaComputadoraListNewPeriodistaComputadora != null && !oldComputadorasOfPeriodistaComputadoraListNewPeriodistaComputadora.equals(computadoras)) {
                        oldComputadorasOfPeriodistaComputadoraListNewPeriodistaComputadora.getPeriodistaComputadoraList().remove(periodistaComputadoraListNewPeriodistaComputadora);
                        oldComputadorasOfPeriodistaComputadoraListNewPeriodistaComputadora = em.merge(oldComputadorasOfPeriodistaComputadoraListNewPeriodistaComputadora);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = computadoras.getIdPc();
                if (findComputadoras(id) == null) {
                    throw new NonexistentEntityException("The computadoras with id " + id + " no longer exists.");
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
            Computadoras computadoras;
            try {
                computadoras = em.getReference(Computadoras.class, id);
                computadoras.getIdPc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The computadoras with id " + id + " no longer exists.", enfe);
            }
            Delegacion delegacion = computadoras.getDelegacion();
            if (delegacion != null) {
                delegacion.getComputadorasList().remove(computadoras);
                delegacion = em.merge(delegacion);
            }
            List<PeriodistaComputadora> periodistaComputadoraList = computadoras.getPeriodistaComputadoraList();
            for (PeriodistaComputadora periodistaComputadoraListPeriodistaComputadora : periodistaComputadoraList) {
                periodistaComputadoraListPeriodistaComputadora.setComputadoras(null);
                periodistaComputadoraListPeriodistaComputadora = em.merge(periodistaComputadoraListPeriodistaComputadora);
            }
            em.remove(computadoras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Computadoras> findComputadorasEntities() {
        return findComputadorasEntities(true, -1, -1);
    }

    public List<Computadoras> findComputadorasEntities(int maxResults, int firstResult) {
        return findComputadorasEntities(false, maxResults, firstResult);
    }

    private List<Computadoras> findComputadorasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Computadoras.class));
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

    public Computadoras findComputadoras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Computadoras.class, id);
        } finally {
            em.close();
        }
    }

    public int getComputadorasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Computadoras> rt = cq.from(Computadoras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
