package item

import personnage.Personnage

open class Item (val nom: String, val description: String){
    open fun utiliser(cible:Personnage){
        println()
    }
    val grenade = Bombe(
        5,
        6,
        "Grenade",
        "Une contraception qui explose une fois lancée",
    )


}