package cl.serlitoral.desafiokotlinciclovia.util

import cl.serlitoral.desafiokotlinciclovia.model.Ciclovia

class SetupCiclovias {
    private val nombres = arrayOf(
        "Ciclovia 1",
        "Ciclovia 2",
        "Ciclovia 3",
        "Ciclovia 4",
        "Ciclovia 5",
        "Ciclovia 6",
        "Ciclovia 7",
        "Ciclovia 8",
        "Ciclovia 9",
        "Ciclovia 10"
    )
    private val comunas = arrayOf(
        "Las Condes",
        "La Reina",
        "Ñuñoa",
        "Macúl",
        "Providencia",
        "Las Condes",
        "La Reina",
        "Ñuñoa",
        "Macúl",
        "Providencia"
    )

    fun getCiclovias(): MutableList<Ciclovia> {
        val cicloviasList: MutableList<Ciclovia> = ArrayList()
        for (i in 0..9) {
            val ciclovia = Ciclovia(nombres[i], comunas[i])
            cicloviasList.add(ciclovia)
        }
        return cicloviasList
    }

    fun getSpinnerList(): List<String> {
        val spinnerList = mutableListOf<String>()
        spinnerList.add("Mostrar Todo")
        spinnerList.addAll(comunas.toSet())

        return spinnerList
    }

    fun getComunaFilter(pComuna: String): MutableList<Ciclovia> {
        var filterList: MutableList<Ciclovia> = ArrayList()
        for ( i in 0..9) {
            var ciclovia = Ciclovia(nombres[i], comunas[i])
            when (ciclovia.comuna) {
                pComuna -> filterList.add(ciclovia)
            }
        }
        return filterList
    }
}