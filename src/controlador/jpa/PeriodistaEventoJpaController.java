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
import modelo.Evento;
import modelo.PeriodistaEvento;

/**
 *
 * @author asus
 */
public class PeriodistaEventoJpaController {

    public PeriodistaEventoJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodistaEvento periodistaEvento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodista periodista = periodistaEvento.getPeriodista();
            if (periodista != null) {
                periodista = em.getReference(periodista.getClass(), periodista.getIdPeriodista());
                periodistaEvento.setPeriodista(periodista);
            }
            Evento evento = periodistaEvento.getEvento();
            if (evento != null) {
                evento = em.getReference(evento.getClass(), evento.getIdEvento());
                periodistaEvento.setEvento(evento);
            }
            em.persist(periodistaEvento);
            if (periodista != null) {
                periodista.getPeriodistaEventoList().add(periodistaEvento);
                periodista = em.merge(periodista);
            }
            if (evento != null) {
                evento.getPeriodistaEventoList().add(periodistaEvento);
                evento = em.merge(evento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodistaEvento(periodistaEvento.getIdPerEvento()) != null) {
                throw new PreexistingEntityException("PeriodistaEvento " + periodistaEvento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodistaEvento periodistaEvento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodistaEvento persistentPeriodistaEvento = em.find(PeriodistaEvento.class, periodistaEvento.getIdPerEvento());
            Periodista periodistaOld = persistentPeriodistaEvento.getPeriodista();
            Periodista periodistaNew = periodistaEvento.getPeriodista();
            Evento eventoOld = persistentPeriodistaEvento.getEvento();
            Evento eventoNew = periodistaEvento.getEvento();
            if (periodistaNew != null) {
                periodistaNew = em.getReference(periodistaNew.getClass(), periodistaNew.getIdPeriodista());
                periodistaEvento.setPeriodista(periodistaNew);
            }
            if (eventoNew != null) {
                eventoNew = em.getReference(eventoNew.getClass(), eventoNew.getIdEvento());
                periodistaEvento.setEvento(eventoNew);
            }
            periodistaEvento = em.merge(periodistaEvento);
            if (periodistaOld != null && !periodistaOld.equals(periodistaNew)) {
                periodistaOld.getPeriodistaEventoList().remove(periodistaEvento);
                periodistaOld = em.merge(periodistaOld);
            }
            if (periodistaNew != null && !periodistaNew.equals(periodistaOld)) {
                periodistaNew.getPeriodistaEventoList().add(periodistaEvento);
                periodistaNew = em.merge(periodistaNew);
            }
            if (eventoOld != null && !eventoOld.equals(eventoNew)) {
                eventoOld.getPeriodistaEventoList().remove(periodistaEvento);
                eventoOld = em.merge(eventoOld);
            }
            if (eventoNew != null && !eventoNew.equals(eventoOld)) {
                eventoNew.getPeriodistaEventoList().add(periodistaEvento);
                eventoNew = em.merge(eventoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodistaEvento.getIdPerEvento();
                if (findPeriodistaEvento(id) == null) {
                    throw new NonexistentEntityException("The periodistaEvento with id " + id + " no longer exists.");
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
            PeriodistaEvento periodistaEvento;
            try {
                periodistaEvento = em.getReference(PeriodistaEvento.class, id);
                periodistaEvento.getIdPerEvento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodistaEvento with id " + id + " no longer exists.", enfe);
            }
            Periodista periodista = periodistaEvento.getPeriodista();
            if (periodista != null) {
                periodista.getPeriodistaEventoList().remove(periodistaEvento);
                periodista = em.merge(periodista);
            }
            Evento evento = periodistaEvento.getEvento();
            if (evento != null) {
                evento.getPeriodistaEventoList().remove(periodistaEvento);
                evento = em.merge(evento);
            }
            em.remove(periodistaEvento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodistaEvento> findPeriodistaEventoEntities() {
        return findPeriodistaEventoEntities(true, -1, -1);
    }

    public List<PeriodistaEvento> findPeriodistaEventoEntities(int maxResults, int firstResult) {
        return findPeriodistaEventoEntities(false, maxResults, firstResult);
    }

    private List<PeriodistaEvento> findPeriodistaEventoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodistaEvento.class));
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

    public PeriodistaEvento findPeriodistaEvento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodistaEvento.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodistaEventoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodistaEvento> rt = cq.from(PeriodistaEvento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
