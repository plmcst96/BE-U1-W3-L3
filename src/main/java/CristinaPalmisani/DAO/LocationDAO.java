package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private  final EntityManager em;

    public LocationDAO(EntityManager eem) {
        this.em = eem;
    }

    public void save(Location location){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location " + location.getCittà() + " salvato correttamente!");
    }

    public Location getById(long id){
        return em.find(Location.class, id);
    }

    public void delete(long id){
        Location found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.out.println("Location eliminata correttamente!");
        }
    }
}
