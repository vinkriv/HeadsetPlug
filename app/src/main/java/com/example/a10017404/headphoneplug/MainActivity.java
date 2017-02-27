package com.example.a10017404.headphoneplug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        receiver = new HeadsetMonitor();
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(receiver,filter);
    }

    public class HeadsetMonitor extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(AudioManager.ACTION_HEADSET_PLUG,-1);
            if (status==0){
                Toast.makeText(context,"PLUGGED OUT",Toast.LENGTH_SHORT).show();
            }
            if (status==1){
                Toast.makeText(context,"PLUGGED IN",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
