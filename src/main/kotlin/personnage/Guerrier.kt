package personnage

import item.Arme
import item.Armure
import item.Item

class Guerrier constructor(nom:String,
                           pointDeVie:Int,
                           pointDeVieMax:Int,
                           attaque:Int, defense:Int,
                           endurance:Int, vitesse:Int,
                           armePrincipal:Arme?,
                           var armeSecondaire:Arme?,
                           armure:Armure?,
                           inventaire:MutableList<Item>)
    :Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire){
    override fun toString(): String {
        return super.toString()
    }

    override fun equipe(arme: Arme){ //permet de choisir l'emplacement de l'arme
        println("choisissez l’emplacement de l’arme ")
        println("Tapez 0 pour l'avoir en arme principal ")
        println("Ou Tapez 1 pour l'avoir en arme secondaire ")

        val choix_arme :Int = readln().toInt()
         if (choix_arme == 0) {
              super.equipe(arme) //lance la fonction equipe() de la classe Personnage
        }
        else {
             /**vérifie si l’arme (paramètre) est dans l’inventaire du personnage
              * si c'est le cas, alors elle devient l’arme secondaire
              */
             if (arme in inventaire) {
                 armeSecondaire = arme
                println("${this.armeSecondaire}est devenue votre arme secondaire")
             }
        }
    }

    override fun attaque(adversaire: Personnage){
        var degat = this.attaque/2

        super.attaque(adversaire) //lance la fonction attaque() de la classe Personnage

        if (armeSecondaire!= null){
            /**vérifie si on a une arme secondaire
            **si c'est le cas on calcul les dégats causé par celle-ci*/
            degat+= this.armeSecondaire!!.calculerDegat()
        }
        degat = degat - adversaire.calculeDefense()

        if (degat<1){
            degat=1 //un score de degat sera quand même infligé même si celui-ci est inférieur à 1
        }

    }

}