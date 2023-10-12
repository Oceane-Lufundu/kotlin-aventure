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
        println("Grimoire ${this.nom}") //affiche tous les sorts présents dans le grimoire
        for(unSort in this.grimoire) {
            println("${grimoire.indexOf(unSort)} => ${unSort.nom}")// affiche l'index de chaque sort
        }
    }
    fun choisirEtLancersort(monstre:Personnage) { //Invoquer la méthode afficherGrimoire() puis demander à l'utilisateur de choisir un sort.
        this.afficheGrimoire()
        println("choisis une cible: Tape 1 Pour joueur; 2 pour monstre")//l’utilisateur choisis la cible du sort
        var choixsort = readln().toInt()
        println("choix du sort: Tape 0 = Boule de feu; 1 = Sort de soins") //l'utilisateur choisis un sort.
        this.grimoire[choixsort].effet(this,monstre)
        for (choixSort in this.grimoire) {
        }
        println("${afficheGrimoire()} choisir ${this.grimoire}")
    }
}