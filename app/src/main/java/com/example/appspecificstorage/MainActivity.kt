package com.example.appspecificstorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input=findViewById<EditText>(R.id.input)
        val output=findViewById<TextView>(R.id.output)
        val btn=findViewById<Button>(R.id.submit)
        val externalBtn=findViewById<Button>(R.id.external_state_btn)
        externalBtn.setOnClickListener {
            var result:String=""
            if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED){
                //println("External storage is available for read and write")
                result="External storage is available for read and write"
            }else if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED_READ_ONLY){
                //println("External storage is not available for read and write")
                result="External storage is available for read only"
            }
            val intent= Intent(this,ExternalStorageActivity::class.java)
            intent.putExtra("State",result)
            startActivity(intent)
        }

        val fileBtn=findViewById<Button>(R.id.file_list_button)
        fileBtn.setOnClickListener{
            val intent=Intent(this,FileListActivity::class.java)
            val list=fileList()
            var ans=""
            for(element in list){
                //println(element)
                ans+=element
            }
            intent.putExtra("List",ans)
            startActivity(intent)
        }
        btn.setOnClickListener {
            val msg:String=input.text.toString()
            val file=openFileOutput("outputfile", MODE_PRIVATE)
            file.write(msg.toByteArray())
            //file.close()
            println(file)
            println("App-specific directory in internal storage: $filesDir")


        }

        val getBtn=findViewById<Button>(R.id.get)
        getBtn.setOnClickListener {
            //val file=openFileInput("outputfile")
            //output.text=file.useLines()
            val file=openFileInput("outputfile").bufferedReader().useLines { lines ->
                lines.fold("") { some, text ->
                    "$some\n$text"
                }
            }
            output.text=file.lines().toString()
        }

    }
}