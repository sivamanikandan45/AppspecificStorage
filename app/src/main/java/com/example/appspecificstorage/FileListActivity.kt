package com.example.appspecificstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FileListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_list)
        val fileListTextView=findViewById<TextView>(R.id.file_list)
        val list=intent.getStringExtra("List")
        fileListTextView.text=list
    }
}