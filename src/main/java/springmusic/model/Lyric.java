package springmusic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Embeddable
public class Lyric implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "lyric_date")
    private Date lyricDate;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "track_lyric")
    private String trackLyric;

    public Lyric() {
        lyricDate = new Date();
        trackLyric = "Hello World";
    }

    public Date getLyricDate() {
        return lyricDate;
    }

    public void setLyricDate(Date lyricDate) {
        this.lyricDate = lyricDate;
    }

    public String getTrackLyric() {
        return trackLyric;
    }

    public void setTrackLyric(String trackLyric) {
        lyricDate = new Date();
        this.trackLyric = trackLyric;
    }
}
