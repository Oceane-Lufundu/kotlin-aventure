package personnage

import item.*
import java.security.Principal

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    val armePrincipal: Arme?,
    val armure: Armure?,
    var inventaire: MutableList<Item> = mutableListOf(),
) {


     fun calculeDefense():Int{
         //TODO Mission 4.2
        return this.defense/2;
     }

     // Méthode pour attaquer un adversaire
     fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
       val degats= this.attaque/2
         adversaire.pointDeVie-=degats
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
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
    fun boirePotion(){
        var laPotion:Potion?=null
         if (avoirPotion()==true){
             for(item in inventaire){
                 if (item is Potion){
                    laPotion=item
                     break
                 }
             }
             var boire = laPotion!!.soin
             pointDeVie += boire
             if (pointDeVie > pointDeVieMax){
                 pointDeVie = pointDeVieMax
             }
             inventaire.remove(laPotion)
             println()
         }
    }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}