package hssaine.mohammedamine.ensam.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistes")
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String nationalite;

    @OneToMany(mappedBy = "artiste", cascade = CascadeType.ALL)
    private List<Album> albums = new ArrayList<>();

    @OneToMany(mappedBy = "artiste", cascade = CascadeType.ALL)
    private List<Chanson> chansons = new ArrayList<>();

    public Artiste() {}

    public Artiste(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getNationalite() { return nationalite; }
    public void setNationalite(String nationalite) { this.nationalite = nationalite; }

    public List<Album> getAlbums() { return albums; }
    public void setAlbums(List<Album> albums) { this.albums = albums; }

    public List<Chanson> getChansons() { return chansons; }
    public void setChansons(List<Chanson> chansons) { this.chansons = chansons; }
}
