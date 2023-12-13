package CristinaPalmisani.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String città;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private Set<Evento> eventi;

    public Location(){}

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public Set<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(Set<Evento> eventi) {
        this.eventi = eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
