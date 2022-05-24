package dev.ogabek.kotlin.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import dev.ogabek.kotlin.R

class MainActivity : AppCompatActivity() {

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission()
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun requestPermission() {
        val hasBootCompletePermission = checkSelfPermission(Manifest.permission.RECEIVE_BOOT_COMPLETED) == PackageManager.PERMISSION_GRANTED
        if (!hasBootCompletePermission) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_BOOT_COMPLETED), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (!(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }
}