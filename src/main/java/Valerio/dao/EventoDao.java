package Valerio.dao;

import Valerio.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDao {

    private EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(evento);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio dell'evento");
        }
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(evento);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio dell'evento");
        }
    }
}
