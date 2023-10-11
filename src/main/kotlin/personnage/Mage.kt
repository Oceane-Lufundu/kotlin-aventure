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

    fun choisirEtLancersort(monstre:Personnage) {
        this.afficheGrimoire()

        this.grimoire[0].effet(this,monstre)
        for (choixSort in this.grimoire) {
        }
        println("${afficheGrimoire()} choisir ${this.grimoire}") //Invoquer la méthode afficherGrimoire() puis demander à l'utilisateur de choisir un sort.
    }
}