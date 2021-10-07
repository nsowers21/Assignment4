package edu.temple.assignment4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_activity)
        val name = findViewById<TextView>(R.id.playerName)
        val image = findViewById<ImageView>(R.id.playerPicture)
        name.text = intent.getStringExtra("DisplayText").toString()
        image.setImageResource(intent.getIntExtra("DisplayImage",1))
    }
}