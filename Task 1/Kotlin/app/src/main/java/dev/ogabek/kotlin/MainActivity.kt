package dev.ogabek.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val start: Button = findViewById(R.id.btn_startService)
        val stop: Button = findViewById(R.id.btn_stopService)
        val status: TextView = findViewById(R.id.tv_serviceStatus)

        start.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                status.text = "Intent Service Started"
            }
        }

        stop.setOnClickListener {
            MyIntentService.stopService()
            status.text = "Intent Service Stopped"
        }

    }
}