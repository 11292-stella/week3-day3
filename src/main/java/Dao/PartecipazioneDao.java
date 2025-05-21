package Dao;

import Entities.Partecipazione;
import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDao {

    private EntityManager em;

    public PartecipazioneDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Partecipazione partecipazione){

        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    public Partecipazione findById(int id){
        return em.find(Partecipazione.class,id);
    }

    public void rimuovi(int id){
        Partecipazione p = findById(id);

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
