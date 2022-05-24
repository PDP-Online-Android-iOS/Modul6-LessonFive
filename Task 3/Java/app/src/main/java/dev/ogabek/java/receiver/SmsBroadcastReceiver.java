package dev.ogabek.java.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            // Get SMS Message
            Bundle bundle = intent.getExtras();
            ArrayList<SmsMessage> smsMessages;
            String message = "";
            String format = bundle.getString("format");

            //Retrieve the SMS message received.
            Object[] pdus = (Object[]) bundle.get("pdus");
            if (pdus != null) {
                // Fill message array
                smsMessages = new ArrayList<>(pdus.length);
                int i = 0;
                for (Object pdu: pdus) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        // If Android version M or newer
                        smsMessages.add(0, SmsMessage.createFromPdu((byte[]) pdu, format));
                    } else {
                        // If Android version L or older
                        smsMessages.add(0, SmsMessage.createFromPdu((byte[]) pdu));
                    }
                    // Build the message to show
                    message = ("SMS from") + (smsMessages.get(0).getOriginatingAddress()) + (" : ") + (smsMessages.get(0).getMessageBody());
                    // Log and display the SMS Message
                    Log.d("SMSBroadcastReceiver", "SMS Received: " + message);
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

}
