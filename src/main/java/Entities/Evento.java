package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titolo;
    private LocalDate data;
    private String descrizione;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento() {
    }

    public Evento( String titolo, LocalDate data, String descrizione, Location location) {
        //this.id = id;
        this.titolo = titolo;
        this.data = data;
        this.descrizione = descrizione;
        this.partecipazioni =  new ArrayList<>();
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                '}';
    }
}
