package com.example.azat.mediaplayer.models;

public class MediaPlayerModel {
    private final int imageId;
    private final String musicName;
    private final String name;
    private boolean playMedia;
    private final int songs;

    public MediaPlayerModel(final int imageId, final String musicName, final String name, final int songs, final boolean playMedia) {
        this.imageId = imageId;
        this.musicName = musicName;
        this.name = name;
        this.songs = songs;
        this.playMedia = playMedia;
    }

    public int getImageid() {
        return imageId;
    }

    public String getMusicName() {
        return musicName;
    }


    public String getName() {
        return name;
    }

    public int getSongs() {
        return songs;
    }

    public boolean isPlayMedia() {
        return playMedia;
    }

    public void setPlayMedia(boolean playMedia) {
        this.playMedia = playMedia;
    }
}
