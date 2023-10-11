package personnage

import arme1
import arme2
import bombe3
import item.*
import potion1
import java.security.Principal

open class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armePrincipal: Arme?,
    var armure: Armure?,
    var inventaire: MutableList<Item> = mutableListOf(),
) {


    // Methode pour équiper le personnage d'une arme
    open fun equipe(arme: Arme) { //prend en paramètre une arme.
        if (arme in inventaire) { //vérifie si l’arme (paramètre) est dans l’inventaire du personnage
            armePrincipal == arme //alors elle devient l’arme principale
        }
        println("${this.nom} equipe ${this.armePrincipal}")

    }

    // Methode pour équiper le personnage d'une armure
    fun equipe(armure: Armure) {
        if(armure in inventaire){
             this.armure = armure
        }
//        for (item in inventaire) {
//            if (item is Armure) {
//                if (armure == item) {
//                    this.armure = armure
//                }
//
//            }
//        }
        println("${this.nom} equipe ${this.armure}")
    }


    fun calculeDefense(): Int {
        //TODO Mission 4.2
        val result = this.defense / 2
        if (this.armure != null){
            defense += armure!!.calculProtection() //ajout bonus de l’armure en utilisant la méthode calculProtection()
        }
            return result;   // retourne resultat
        }

    // Méthode pour attaquer un adversaire
    open fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
        var degats = this.attaque /2 //calcul les degats de base
        if(armePrincipal != null) { //vérifie s'il a une arme équipée.
            degats += armePrincipal!!.calculerDegat() //Les dégâts infligés à l'adversaire sont calculés.
        }
        if (degats< 1){
            degats == 1
        }
        adversaire.pointDeVie -= degats //on retire des point de vie à l'adversaire
        println("$nom attaque ${adversaire.nom} avec ${this.armePrincipal!!} et inflige $degats points de dégâts.")
    }

    // Méthode pour avoir une potion
    fun avoirPotion(): Boolean {
        for (item in inventaire) {
            if (item is Potion) {
                return true
            }
        }
        return false
    }

    // Méthode pour avoir une bombe
    fun avoirBombe(): Boolean {
        for (item in inventaire) {
            if (item is Bombe) {
                return true
            }
        }
        return false
    }

    // Méthode pour boire une potion
    fun boirePotion(potion: Potion? = null) {
        var laPotion: Potion? = null
        if (avoirPotion() == true) { //Appelle la fonction avoirPotion
            if (potion == null) {
                for (item in inventaire) {
                    if (item is Potion) {
                        laPotion = item
                        break //Arrête la boucle à la première potion
                    }
                }
            } else {
                laPotion = potion
            }
            var boire = laPotion!!.soin //Le personnage récupère le montant de soin de la potion
            pointDeVie += boire
            //Le personnage met à jour ses points de vie en ajoutant le montant de soin de la potion. Si
            //les points de vie dépassent le maximum, ils sont ajustés au maximum
            if (pointDeVie > pointDeVieMax) {
                pointDeVie = pointDeVieMax
            }
            inventaire.remove(laPotion) //Le personnage retire la potion de son inventaire
            println("Vous avez bu la potion ${laPotion.nom} et avez récupéré $boire points de vie.")
        } else {
            println("Vous n'avez pas de potion dans votre inventaire.")
        }
    }


    fun afficheInventaire(){
        println("inventaire de ${this.nom}")//Afficher chaque item de l’inventaire du personnage.
         for (item in inventaire) {
             println(" ${inventaire.indexOf(item)} => ${item.nom}")//Afficher l'index de chaque élément de l'inventaire.
         }
    }

    fun loot(cible:Personnage){
        if (cible.pointDeVie <= 0){ //On vérifie que la cible a des pv inférieure ou égale à 0.
            this.inventaire += cible.inventaire
            cible.inventaire= mutableListOf()
            cible.armePrincipal = null
            cible.armure = null
        }
    }
    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}