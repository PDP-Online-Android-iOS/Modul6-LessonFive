package dev.ogabek.java;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    private static MyIntentService instance;
    public static boolean isRunning = false;

    public MyIntentService() {
        super("MyIntentService");
        instance = this;
    }

    public static void stopService() {
        Log.d("MyIntentService", "Service is stopped");
        isRunning = false;
        instance.stopSelf();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            isRunning = true;
            while (isRunning) {
                Log.d("MyIntentService", "Service is running ...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
