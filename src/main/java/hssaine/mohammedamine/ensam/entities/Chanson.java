package hssaine.mohammedamine.ensam.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chansons")
public class Chanson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    private Integer duree; // seconds

    private String genre;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artiste_id")
    private Artiste artiste;

    @OneToMany(mappedBy = "chanson", cascade = CascadeType.ALL)
    private List<PlaylistItem> playlistItems = new ArrayList<>();

    public Chanson() {}

    public Chanson(String titre, Integer duree, String genre) {
        this.titre = titre;
        this.duree = duree;
        this.genre = genre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public Integer getDuree() { return duree; }
    public void setDuree(Integer duree) { this.duree = duree; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }

    public Artiste getArtiste() { return artiste; }
    public void setArtiste(Artiste artiste) { this.artiste = artiste; }

    public List<PlaylistItem> getPlaylistItems() { return playlistItems; }
    public void setPlaylistItems(List<PlaylistItem> playlistItems) { this.playlistItems = playlistItems; }
}
