package hssaine.mohammedamine.ensam.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Temporal(TemporalType.DATE)
    private Date dateSortie;

    @ManyToOne
    @JoinColumn(name = "artiste_id")
    private Artiste artiste;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Chanson> chansons = new ArrayList<>();

    public Album() {}

    public Album(String titre, Date dateSortie) {
        this.titre = titre;
        this.dateSortie = dateSortie;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public Date getDateSortie() { return dateSortie; }
    public void setDateSortie(Date dateSortie) { this.dateSortie = dateSortie; }

    public Artiste getArtiste() { return artiste; }
    public void setArtiste(Artiste artiste) { this.artiste = artiste; }

    public List<Chanson> getChansons() { return chansons; }
    public void setChansons(List<Chanson> chansons) { this.chansons = chansons; }
}
