package com.example.azat.mediaplayer.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


public class MyMediaPlayer extends Service {

    private MediaPlayer mediaPlayer;


    public MyMediaPlayer() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final int song = intent.getExtras().getInt("tag");
        mediaPlayer = MediaPlayer.create(this, song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();

    }


}
