package Dao;

import Entities.Evento;
import Entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {


    private EntityManager em;



    public EventoDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento findById(int id) {
        return em.find(Evento.class, id);
    }

    public void rimuovi(int id) {
        Evento l = findById(id);
        if (l != null) {
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } else {
            System.out.println("Location con ID " + id + " non trovata.");
        }
    }
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
