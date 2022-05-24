package dev.ogabek.java.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompletedBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) || intent.getAction().equals(Intent.ACTION_REBOOT) || intent.getAction().equals(Intent.ACTION_LOCKED_BOOT_COMPLETED)) {
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_LONG).show();
        }
    }
}
