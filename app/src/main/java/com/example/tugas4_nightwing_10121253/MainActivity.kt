package com.example.tugas4_nightwing_10121253

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.tugas4_nightwing_10121253.api.RetrofitInstance
import com.example.tugas4_nightwing_10121253.model.Superhero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var superheroImage: ImageView
    private lateinit var superheroName: TextView
    private lateinit var superheroDetails: TextView
    private lateinit var superheroBiography: TextView
    private lateinit var superheroFamily: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        superheroImage = findViewById(R.id.superheroImage)
        superheroName = findViewById(R.id.superheroName)
        superheroDetails = findViewById(R.id.superheroDetails)
        superheroBiography = findViewById(R.id.superheroBiography)
//        superheroFamily = findViewById(R.id.superheroFamily)

        fetchSuperheroData()
    }
    private fun fetchSuperheroData() {
        RetrofitInstance.api.getSuperHero().enqueue(object : Callback<Superhero> {
            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                if (response.isSuccessful) {
                    response.body()?.let { superhero ->
                        val imageUrl = superhero.image.url
                        val name = superhero.name
                        val powerstats = superhero.powerstats
                        val intelligence = powerstats.intelligence
                        val strength = powerstats.strength
                        val speed = powerstats.speed
                        val durability = powerstats.durability
                        val power = powerstats.power
                        val combat = powerstats.combat

                        val biography = superhero.biography
                        val aliases = biography.aliases.joinToString(", ")
//                        val alignment = biography.alignment
//                        val publisher = biography.publisher
//                        val connections = superhero.connections

                        val appearance = superhero.appearance
//                        val gender = appearance.gender
//                        val race = appearance.race
//                        val `full-name` = biography.`full-name`
//                        val relatives = connections.relatives.joinToString(",")


                        val biographyDetails = """
                            Full-Name   : ${biography.`full-name`}
                            Gender      : ${appearance.gender}
                            Race        : ${appearance.race}
                            Alignment   : ${biography.alignment}
                            Publisher   : ${biography.publisher}
                            Aliases     : $aliases
                        """.trimIndent()

                        val details = """
                            Intelligence: $intelligence
                            Strength    : $strength
                            Speed       : $speed
                            Durability  : $durability
                            Power       : $power
                            Combat      : $combat
                        """.trimIndent()

//                        val family = """
//                            Family: $relatives
//                        """.trimIndent()




                        Glide.with(this@MainActivity).load(imageUrl).into(superheroImage)
                        superheroName.text = name
                        superheroBiography.text = biographyDetails
                        superheroDetails.text = details
//                        superheroFamily.text = family
                    }
                }
            }
        })
    }
}