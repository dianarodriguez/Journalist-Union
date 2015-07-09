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
import modelo.Evento;
import modelo.PeriodistaEvento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class EventoJpaController {

    public EventoJpaController() {
        emf = Persistence.createEntityManagerFactory("tesisUpecPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Evento evento) throws PreexistingEntityException, Exception {
        if (evento.getPeriodistaEventoList() == null) {
            evento.setPeriodistaEventoList(new ArrayList<PeriodistaEvento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PeriodistaEvento> attachedPeriodistaEventoList = new ArrayList<PeriodistaEvento>();
            for (PeriodistaEvento periodistaEventoListPeriodistaEventoToAttach : evento.getPeriodistaEventoList()) {
                periodistaEventoListPeriodistaEventoToAttach = em.getReference(periodistaEventoListPeriodistaEventoToAttach.getClass(), periodistaEventoListPeriodistaEventoToAttach.getIdPerEvento());
                attachedPeriodistaEventoList.add(periodistaEventoListPeriodistaEventoToAttach);
            }
            evento.setPeriodistaEventoList(attachedPeriodistaEventoList);
            em.persist(evento);
            for (PeriodistaEvento periodistaEventoListPeriodistaEvento : evento.getPeriodistaEventoList()) {
                Evento oldEventoOfPeriodistaEventoListPeriodistaEvento = periodistaEventoListPeriodistaEvento.getEvento();
                periodistaEventoListPeriodistaEvento.setEvento(evento);
                periodistaEventoListPeriodistaEvento = em.merge(periodistaEventoListPeriodistaEvento);
                if (oldEventoOfPeriodistaEventoListPeriodistaEvento != null) {
                    oldEventoOfPeriodistaEventoListPeriodistaEvento.getPeriodistaEventoList().remove(periodistaEventoListPeriodistaEvento);
                    oldEventoOfPeriodistaEventoListPeriodistaEvento = em.merge(oldEventoOfPeriodistaEventoListPeriodistaEvento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEvento(evento.getIdEvento()) != null) {
                throw new PreexistingEntityException("Evento " + evento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Evento evento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Evento persistentEvento = em.find(Evento.class, evento.getIdEvento());
            List<PeriodistaEvento> periodistaEventoListOld = persistentEvento.getPeriodistaEventoList();
            List<PeriodistaEvento> periodistaEventoListNew = evento.getPeriodistaEventoList();
            List<PeriodistaEvento> attachedPeriodistaEventoListNew = new ArrayList<PeriodistaEvento>();
            for (PeriodistaEvento periodistaEventoListNewPeriodistaEventoToAttach : periodistaEventoListNew) {
                periodistaEventoListNewPeriodistaEventoToAttach = em.getReference(periodistaEventoListNewPeriodistaEventoToAttach.getClass(), periodistaEventoListNewPeriodistaEventoToAttach.getIdPerEvento());
                attachedPeriodistaEventoListNew.add(periodistaEventoListNewPeriodistaEventoToAttach);
            }
            periodistaEventoListNew = attachedPeriodistaEventoListNew;
            evento.setPeriodistaEventoList(periodistaEventoListNew);
            evento = em.merge(evento);
            for (PeriodistaEvento periodistaEventoListOldPeriodistaEvento : periodistaEventoListOld) {
                if (!periodistaEventoListNew.contains(periodistaEventoListOldPeriodistaEvento)) {
                    periodistaEventoListOldPeriodistaEvento.setEvento(null);
                    periodistaEventoListOldPeriodistaEvento = em.merge(periodistaEventoListOldPeriodistaEvento);
                }
            }
            for (PeriodistaEvento periodistaEventoListNewPeriodistaEvento : periodistaEventoListNew) {
                if (!periodistaEventoListOld.contains(periodistaEventoListNewPeriodistaEvento)) {
                    Evento oldEventoOfPeriodistaEventoListNewPeriodistaEvento = periodistaEventoListNewPeriodistaEvento.getEvento();
                    periodistaEventoListNewPeriodistaEvento.setEvento(evento);
                    periodistaEventoListNewPeriodistaEvento = em.merge(periodistaEventoListNewPeriodistaEvento);
                    if (oldEventoOfPeriodistaEventoListNewPeriodistaEvento != null && !oldEventoOfPeriodistaEventoListNewPeriodistaEvento.equals(evento)) {
                        oldEventoOfPeriodistaEventoListNewPeriodistaEvento.getPeriodistaEventoList().remove(periodistaEventoListNewPeriodistaEvento);
                        oldEventoOfPeriodistaEventoListNewPeriodistaEvento = em.merge(oldEventoOfPeriodistaEventoListNewPeriodistaEvento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = evento.getIdEvento();
                if (findEvento(id) == null) {
                    throw new NonexistentEntityException("The evento with id " + id + " no longer exists.");
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
            Evento evento;
            try {
                evento = em.getReference(Evento.class, id);
                evento.getIdEvento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evento with id " + id + " no longer exists.", enfe);
            }
            List<PeriodistaEvento> periodistaEventoList = evento.getPeriodistaEventoList();
            for (PeriodistaEvento periodistaEventoListPeriodistaEvento : periodistaEventoList) {
                periodistaEventoListPeriodistaEvento.setEvento(null);
                periodistaEventoListPeriodistaEvento = em.merge(periodistaEventoListPeriodistaEvento);
            }
            em.remove(evento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Evento> findEventoEntities() {
        return findEventoEntities(true, -1, -1);
    }

    public List<Evento> findEventoEntities(int maxResults, int firstResult) {
        return findEventoEntities(false, maxResults, firstResult);
    }

    private List<Evento> findEventoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Evento.class));
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

    public Evento findEvento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Evento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEventoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Evento> rt = cq.from(Evento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
