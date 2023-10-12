package item

import jeu.TirageDes
import personnage.Personnage

class Bombe (val nombreDeDes:Int, val maxDes:Int, nom:String, description:String):Item(nom, description){
    override fun utiliser(cible:Personnage){
        val des = TirageDes(this.nombreDeDes, this.maxDes) //création un objet de la classe TirageDes pour simuler le lancer de dés de dégâts
        val degats = des.lance()
        val protectionCible = cible.calculeDefense()

        val degatsPostProtection = maxOf(degats - protectionCible, 1) //soustraction du bonus de protection de la cible
        cible.pointDeVie -= degats //on retire au pv de la cible le nombre de points de dégâts.
        println("La bombe a fait $degatsPostProtection points de dégâts à la cible $cible.")
    }
}
