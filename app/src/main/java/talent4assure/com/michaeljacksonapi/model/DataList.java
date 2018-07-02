package talent4assure.com.michaeljacksonapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adity on 4/18/2018.
 */

public class DataList {

    @SerializedName("artworkUrl30")
    private String image;

    @SerializedName("artistName")
    private String artist;

    @SerializedName("trackName")
    private String nameOfSong;

    @SerializedName("collectionName")
    private String album;

    @SerializedName("previewUrl")
    private String song;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }


}
