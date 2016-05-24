package com.example.sidra.unplugme;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sidra on 5/24/2016.
 */
public class BatteryLevelCheck extends AsyncTask<Context, Void, Void> {

    @Override
    protected Void doInBackground(Context... params) {
        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(params[0],R.raw.alert);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();

        Intent batteryIntent = params[0].registerReceiver(null,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra("level", -1);

        if(level == 100){
            mMediaPlayer.setLooping(true);
            mMediaPlayer.start();
        }
        Log.v("level: ", String.valueOf(level));
//        Toast.makeText(params[0],"Level: " + level + "%",
//                Toast.LENGTH_SHORT).show();
        return null;
    }
}
