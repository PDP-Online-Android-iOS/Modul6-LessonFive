package dev.ogabek.kotlin.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleteBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED || intent.action == Intent.ACTION_REBOOT || intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_LONG).show()
        }
    }
}