package CristinaPalmisani;

import CristinaPalmisani.DAO.EventoDAO;
import CristinaPalmisani.DAO.LocationDAO;
import CristinaPalmisani.DAO.PartecipazioneDAO;
import CristinaPalmisani.DAO.PersonaDAO;
import CristinaPalmisani.entities.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO evd = new EventoDAO(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        PersonaDAO ped = new PersonaDAO(em);
        LocationDAO ld = new LocationDAO(em);
        Evento evento;
        Location location;
        Persona persona;
        Partecipazione partecipazione;
        Faker faker = new Faker();
        Random rndm = new Random();

        for (int i = 0; i < 15; i++) {

            location = new Location(faker.address().cityName(), faker.address().city());
            ld.save(location);

            evento = new Evento(faker.book().title(), LocalDate.of(rndm.nextInt(2023, 2026),
                    rndm.nextInt(1, 13), rndm.nextInt(1, 29) ),
                    faker.lorem().paragraph(), faker.options().option(TipoEvento.class),
                    faker.number().numberBetween(10, 20300), location);
            evd.save(evento);

            persona = new Persona(faker.artist().name(), faker.name().lastName(),
                    faker.internet().emailAddress(),LocalDate.of(rndm.nextInt(2023, 2026),
                    rndm.nextInt(1, 13), rndm.nextInt(1, 29) ),
                    faker.options().option(Sesso.class));
            ped.save(persona);
            partecipazione = new Partecipazione(persona, evento, faker.options().option(Stato.class));
            pd.savePartecipazione(partecipazione);
        }
        System.out.println("salvati");

        long id = 70;
        Evento evFromDB = evd.getById(id);
        if (evFromDB != null){
            System.out.println(evFromDB);
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }

        evd.delete(id);

     em.close();
     emf.close();

    }
}
