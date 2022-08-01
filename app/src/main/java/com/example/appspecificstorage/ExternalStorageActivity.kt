package com.example.appspecificstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ExternalStorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)
        val result=intent.getStringExtra("State")
        val tv=findViewById<TextView>(R.id.external_storage_state)
        tv.text=result
    }
}