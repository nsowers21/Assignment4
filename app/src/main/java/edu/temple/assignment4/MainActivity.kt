package edu.temple.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var ViewModelPlayers: ViewModelPlayers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridManager = GridLayoutManager(this, 3)
        val recyclerview= findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager=gridManager
        recyclerview.adapter= ImageAdapter(this, getPlayers())

        ViewModelPlayers = ViewModelProvider(this).get(ViewModelPlayers::class.java)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentselect, SelectionFragment.newInstance(getPlayers()))
            .commit()


    }

    private fun getPlayers() : Array<ImageObject> {
        val playerArray = this.resources.getStringArray(R.array.players)
        val iterator = playerArray.iterator()
        val imageObjectList = arrayOf(ImageObject(iterator.next(), R.drawable.lebron)
            ,ImageObject(iterator.next(),R.drawable.ad)
            ,ImageObject(iterator.next(), R.drawable.ai)
            ,ImageObject(iterator.next(), R.drawable.dame)
            ,ImageObject(iterator.next(), R.drawable.harden)
            ,ImageObject(iterator.next(), R.drawable.joel)
            ,ImageObject(iterator.next(), R.drawable.steph)
            ,ImageObject(iterator.next(), R.drawable.jordan)
            ,ImageObject(iterator.next(), R.drawable.kd)
            ,ImageObject(iterator.next(), R.drawable.kobe)
            ,ImageObject(iterator.next(), R.drawable.shaq)
            ,ImageObject(iterator.next(), R.drawable.wade));
        return imageObjectList
    }

    //code from the DisplayActivity
    /*
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
     */
}