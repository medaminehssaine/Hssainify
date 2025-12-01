package hssaine.mohammedamine.ensam.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaylistItemKey implements Serializable {

    private Long playlistId;
    private Long chansonId;

    public PlaylistItemKey() {}

    public PlaylistItemKey(Long playlistId, Long chansonId) {
        this.playlistId = playlistId;
        this.chansonId = chansonId;
    }

    public Long getPlaylistId() { return playlistId; }
    public void setPlaylistId(Long playlistId) { this.playlistId = playlistId; }

    public Long getChansonId() { return chansonId; }
    public void setChansonId(Long chansonId) { this.chansonId = chansonId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistItemKey that = (PlaylistItemKey) o;
        return Objects.equals(playlistId, that.playlistId) &&
               Objects.equals(chansonId, that.chansonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, chansonId);
    }
}
