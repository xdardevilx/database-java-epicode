package Valerio;

import Valerio.dao.EventoDao;
import Valerio.entities.Evento;
import Valerio.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = entityManagerFactory.createEntityManager();
        EventoDao dao = new EventoDao(em);
        Evento evento = new Evento("tutti al mare", new Date(), "giornata al mare con gli amici", TipoEvento.PRIVATO, 15);
        Evento evento1 = new Evento("tutti in montagna", new Date(), "giornata in motagna con gli amici", TipoEvento.PUBBLICO, 50);

        try {
            dao.save(evento);
            dao.save(evento1);


        } catch (Exception e) {
            System.out.println("Errore nella salvataggio dell'evento: " + e.getMessage());


        }
        try {
            Evento datoSalvato = dao.getById(evento.getId());
            System.out.println("il dato salvato è: " + datoSalvato);
        } catch (Exception e) {
            System.out.println("Errore nella ricerca dell'evento: " + e.getMessage());
        }
        try {
            dao.delete(evento);
        } catch (Exception e) {
            System.out.println("Errore nella cancellazione dell'evento: " + e.getMessage());
        } finally {
            em.close();
            entityManagerFactory.close();
        }
    }
}
