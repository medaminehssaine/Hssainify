package hssaine.mohammedamine.ensam.entities;

import javax.persistence.*;

@Entity
@Table(name = "playlist_items")
public class PlaylistItem {

    @EmbeddedId
    private PlaylistItemKey id = new PlaylistItemKey();

    @ManyToOne
    @MapsId("playlistId")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @MapsId("chansonId")
    @JoinColumn(name = "chanson_id")
    private Chanson chanson;

    private Integer ordre; // position in playlist

    public PlaylistItem() {}

    public PlaylistItem(Playlist playlist, Chanson chanson, Integer ordre) {
        this.playlist = playlist;
        this.chanson = chanson;
        this.ordre = ordre;
        if (playlist != null && chanson != null && playlist.getId() != null && chanson.getId() != null) {
            this.id = new PlaylistItemKey(playlist.getId(), chanson.getId());
        }
    }

    public PlaylistItemKey getId() { return id; }
    public void setId(PlaylistItemKey id) { this.id = id; }

    public Playlist getPlaylist() { return playlist; }
    public void setPlaylist(Playlist playlist) { this.playlist = playlist; }

    public Chanson getChanson() { return chanson; }
    public void setChanson(Chanson chanson) { this.chanson = chanson; }

    public Integer getOrdre() { return ordre; }
    public void setOrdre(Integer ordre) { this.ordre = ordre; }
}
