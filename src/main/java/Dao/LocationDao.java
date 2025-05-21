package Dao;

import Entities.Location;
import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {

    private EntityManager em;



    public LocationDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location findById(int id) {
        return em.find(Location.class, id);
    }

    public void rimuovi(int id) {
        Location l = findById(id);
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
