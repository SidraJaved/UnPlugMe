package com.example.sidra.unplugme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sidra on 5/24/2016.
 */
public class MyReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        BatteryLevelCheck b1 = new BatteryLevelCheck();
        b1.execute(context);
    }

}
