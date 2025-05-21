package Dao;

import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDao {

    private EntityManager em;

    public PersonaDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Persona persona){

        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona findById(int id){
        return em.find(Persona.class,id);
    }

    public void rimuovi(int id){
        Persona p = findById(id);

        if(p!=null){
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
        else{
            System.out.println("non trovato" + id );
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }


}
