package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private  final EntityManager em;

    public EventoDAO(EntityManager eem) {
        this.em = eem;
    }

    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " salvato correttamente!");
    }

    public Evento getById(long id){
        return em.find(Evento.class, id);
    }

    public void delete(long id){
        Evento found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.out.println("Evento " + found.getTitolo() + " eliminato correttamente!");
        }
    }
}
