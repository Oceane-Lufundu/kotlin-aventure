package personnage

import item.Arme
import item.Armure
import item.Item

class Mage constructor( nom: String, pointDeVie: Int, pointDeVieMax: Int, attaque: Int, defense: Int, endurance: Int, vitesse: Int, armePrincipal: Arme?, armure: Armure?, inventaire: MutableList<Item> = mutableListOf(),var grimoire:MutableList<Sort> = mutableListOf())
    : Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire) {

    override fun toString(): String {
        return super.toString()
    }
    fun afficheGrimoire() {
        for (unSort in this.grimoire) {
        }
    }

    fun choisirEtLancersort() {
        for (choixSort in this.grimoire) {

        }
    }
}