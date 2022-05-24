package dev.ogabek.kotlin.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class SMSBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.provider.Telephony.SMS_RECEIVED") {
            // Get SMS Message
            val bundle = intent.extras
            val smsMessages: ArrayList<SmsMessage>
            var message = ""
            val format = bundle!!.getString("format")

            //Retrieve the SMS message received.
            val pdus = bundle["pdus"] as Array<*>?
            if (pdus != null) {
                // Fill message array
                smsMessages = ArrayList(pdus.size)
                val i = 0
                for (pdu in pdus) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        // If Android version M or newer
                        smsMessages.add(0, SmsMessage.createFromPdu(pdu as ByteArray, format))
                    } else {
                        // If Android version L or older
                        smsMessages.add(0, SmsMessage.createFromPdu(pdu as ByteArray))
                    }
                    // Build the message to show
                    message =
                        "SMS from" + smsMessages[0].originatingAddress + " : " + smsMessages[0].messageBody
                    // Log and display the SMS Message
                    Log.d("SMSBroadcastReceiver", "SMS Received: $message")
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}