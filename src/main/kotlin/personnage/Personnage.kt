package personnage

import arme1
import item.*
import potion1
import java.security.Principal

class Personnage(
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
    fun equipe(arme: Arme) {
        if (arme in inventaire) {
            armePrincipal == arme
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
            defense += armure!!.calculProtection()
        }
            return result;   // retourne resultat
        }

    // Méthode pour attaquer un adversaire
    fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
        var degats = this.attaque /2
        if(armePrincipal != null) {
            degats += armePrincipal!!.calculerDegat()
        }
        if (degats< 1){
            degats == 1
        }
        adversaire.pointDeVie -= degats
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
        if (avoirPotion() == true) {
            if (potion == null) {
                for (item in inventaire) {
                    if (item is Potion) {
                        laPotion = item
                        break
                    }
                }
            } else {
                laPotion = potion
            }
            var boire = laPotion!!.soin
            pointDeVie += boire
            if (pointDeVie > pointDeVieMax) {
                pointDeVie = pointDeVieMax
            }
            inventaire.remove(laPotion)
            println("Vous avez bu la potion ${laPotion.nom} et avez récupéré $boire points de vie.")
        } else {
            println("Vous n'avez pas de potion dans votre inventaire.")
        }
    }
    fun afficheInventaire(){
        println("inventaire de ${this.nom}")
         for (item in inventaire) {
             println(" ${inventaire.indices} => ${item.nom}")
         }
    }

    fun loot(cible:Personnage){
        if (cible.pointDeVie <= 0){
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