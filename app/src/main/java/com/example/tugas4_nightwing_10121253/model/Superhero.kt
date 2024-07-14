package com.example.tugas4_nightwing_10121253.model

data class Superhero(
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val image: Image,
//    val connections: Connections
)

data class Biography(
    val `full-name`: String,
    val aliases: List<String>,
    val alignment: String,
    val publisher: String
)

data class Appearance(
    val gender: String,
    val race: String
)

data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

//data class Connections(
//    val relatives: List<String>
//)

data class Image(
    val url: String
)