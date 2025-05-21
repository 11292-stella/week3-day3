import Dao.EventoDao;
import Dao.LocationDao;
import Dao.PartecipazioneDao;
import Dao.PersonaDao;
import Entities.Evento;
import Entities.Location;
import Entities.Partecipazione;
import Entities.Persona;
import Enumeration.Sesso;
import Enumeration.Stato;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        PersonaDao personaDao = new PersonaDao();
        LocationDao locationDao = new LocationDao();
        EventoDao eventoDao = new EventoDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();

        Persona persona = new Persona("Mario","Bros","its_me_mario@live.it",
                LocalDate.of(2000,4,3),Sesso.M);

        personaDao.save(persona);

        Location location = new Location("Teatro Verdi","Firenze");
        locationDao.save(location);

        Evento evento = new Evento("Concerto Topo Gigio",LocalDate.of(2000,3,6),"Live",location);
        eventoDao.save(evento);

        Partecipazione partecipazione = new Partecipazione(persona,evento, Stato.CONFERMATA);
        partecipazioneDao.save(partecipazione);
        System.out.println("Dati salvati con successo!");






    }
}
