package dev.ogabek.java.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.widget.Toast;

public class CallBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (action.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            showToast(context, "Call started...");
        } else if (action.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            showToast(context, "Call ended...");
        } else if (action.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            showToast(context, "Incoming call...");
        }
    }

    private void showToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
