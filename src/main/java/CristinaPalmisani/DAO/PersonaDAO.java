package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private  final EntityManager em;

    public PersonaDAO(EntityManager eem) {
        this.em = eem;
    }

    public void save(Persona persona){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Persona " + persona.getNome() + persona.getCognome() + " salvata correttamente!");
    }

    public Persona getById(long id){
        return em.find(Persona.class, id);
    }

    public void delete(long id){
        Persona found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.out.println("Persona " + found.getNome() + " eliminata correttamente!");
        }
    }
}
