package item

import jeu.TirageDes
import personnage.Personnage

class Bombe (val nombreDeDes:Int, val maxDes:Int, nom:String, description:String):Item(nom, description){
    override fun utiliser(cible:Personnage){
        val des = TirageDes(this.nombreDeDes, this.maxDes)
        val degats = des.lance()
        val protectionCible = cible.calculeDefense()

        val degatsPostProtection = maxOf(degats - protectionCible, 1)
        cible.pointDeVie -= degats
        println("La bombe a fait $degatsPostProtection points de dégâts à la cible $cible.")
    }
}
val grenade = Bombe(
    5,
    6,
    "Grenade",
    "Une contraception qui explose une fois lancée",
)