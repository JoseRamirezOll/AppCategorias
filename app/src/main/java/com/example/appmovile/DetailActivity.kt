package com.example.appmovile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmovile.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val genID = intent?.extras?.getString(GENERO).toString().uppercase()
        val recilcerView= binding.recyclerView

        recilcerView.layoutManager= LinearLayoutManager(this)
        recilcerView.adapter= peliculasAdapter(genID, this)
        title = "Peliculas cuyo genero es " + " " +genID
    }

    companion object{
        const val  GENERO= "genero"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

}