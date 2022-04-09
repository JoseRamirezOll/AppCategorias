package com.example.appmovile
// clse que permitira mostrar la lista de peliculas del genero
class peliculaOrganizadaz
{
    var listaDePelis  = listOf<peliculasVO>()
    // constructor donde se lllenara la lista con las pleliculas
     constructor(){
        listaDePelis= listOf(
            peliculasVO("Iron man 1 ", "ACTION") ,
            peliculasVO("Iron man 2", "ACTION"),
            peliculasVO("Iron man 3", "ACRION"),
            peliculasVO("John Week", "ACTION"),
            peliculasVO("Un viaje al centro de la tierra", "AVENTURAS"),
            peliculasVO("Jumnji", "AVENTURAS"),
            peliculasVO("Los cruts", "AVENTURAS"),
            peliculasVO("Los minions", "AVENTURAS"),
            peliculasVO("La hielo de hilo ", "AVENTURAS")
        )
     }// fin de la lista
   public fun obtenerPeliculasPorGenero( gen: String): ArrayList<peliculasVO>
   {
       var  result= arrayListOf<peliculasVO>()
        // recorrer  la lista
       for (pelicula in listaDePelis )
       {
            if (pelicula.generoPel.equals(gen))
            {
                result.add(pelicula)
            }
       }
       return result
   }

}