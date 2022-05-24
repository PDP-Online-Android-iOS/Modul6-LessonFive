package dev.ogabek.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        Button start, stop;
        TextView status;

        start = findViewById(R.id.btn_startService);
        stop = findViewById(R.id.btn_stopService);

        status = findViewById(R.id.tv_serviceStatus);

        start.setOnClickListener(view -> {
            startService(new Intent(getApplicationContext(), MyIntentService.class));
            status.setText("Service is Running");
        });

        stop.setOnClickListener(view -> {
            MyIntentService.stopService();
            status.setText("Service is Stopped");
        });

    }
}