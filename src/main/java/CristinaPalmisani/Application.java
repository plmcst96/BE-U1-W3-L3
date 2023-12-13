package CristinaPalmisani;

import CristinaPalmisani.DAO.EventoDAO;
import CristinaPalmisani.entities.Evento;
import CristinaPalmisani.entities.TipoEvento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO evd = new EventoDAO(em);
        Evento evento;
        Faker faker = new Faker();
       /* Evento ev1 = new Evento("Compleanno", LocalDate.of(2024, 2, 8) ,"colore verde ", TipoEvento.PRIVATO, 30);
        Evento ev2 = new Evento("Convegno", LocalDate.of(2024, 6, 13) ,"ci devono essere solo medici ", TipoEvento.PRIVATO, 230);
        Evento ev3 = new Evento("Concerto", LocalDate.of(2024, 9, 23) ,"ci devono essere tanti fan ", TipoEvento.PUBBLICO, 23330);

      *//*  evd.save(ev1);
        evd.save(ev2);
        evd.save(ev3);*//*

     long id = 7;
     Evento evFromDB = evd.getById(id);
     if (evFromDB != null){
         System.out.println(evFromDB);
     } else {
         System.out.println("Evento con id " + id + " non trovato");
     }
        evd.save(ev3);
     */

        for (int i = 0; i < 15; i++) {
            evento = new Evento(faker.book().title(), LocalDate.of(2000, 3, 10),
                    faker.lorem().paragraph(), faker.options().option(TipoEvento.class), faker.number().numberBetween(10, 20300));
            evd.save(evento);
        }
        System.out.println("salvati");

        long id = 20;
        Evento evFromDB = evd.getById(id);
        if (evFromDB != null){
            System.out.println(evFromDB);
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }

        evd.delete(24);

     em.close();
     emf.close();

    }
}
