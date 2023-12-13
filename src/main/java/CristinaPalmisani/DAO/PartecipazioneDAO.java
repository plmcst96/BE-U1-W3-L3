package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private  final EntityManager em;

    public PartecipazioneDAO(EntityManager eem) {
        this.em = eem;
    }

    public void savePartecipazione(Partecipazione partecipazione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione di: " + partecipazione.getPersona().getNome() + " per " + partecipazione.getEvento().getTitolo() + " salvata correttamente!");
    }

    public Partecipazione getById(long id){
        return em.find(Partecipazione.class, id);
    }

    public void deletePartecipazione(Partecipazione partecipazione){

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(partecipazione);

            System.out.println("Partecipazione di: " + partecipazione.getPersona().getNome() + " per " + partecipazione.getEvento() + " eliminata correttamente!");
    }
}
