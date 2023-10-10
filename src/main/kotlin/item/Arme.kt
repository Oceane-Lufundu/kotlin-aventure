package item
import jeu.TirageDes
import personnage.Personnage

class Arme constructor(nom: String, description: String, val qualite: Qualite, val typeArme: TypeArme):Item(nom,description){


     fun calculerDegat():Int{//Ne prend pas de paramètres, retourne un entier.
             var desDegat = TirageDes(this.typeArme.nombreDes, this.typeArme.valeurDeMax).lance()
             var result = desDegat
             val desCritique = TirageDes(1, 20).lance()

          if(desCritique>=this.typeArme.activationCritique){

                  var critique = result * this.typeArme.multiplictaeurCritique
                  var degatsTotal = critique + this.qualite.bonusRarete
                  return degatsTotal

          } else {
                  var degatsTotal = result+this.qualite.bonusRarete //on ajoute le bonusRarete de la qualité de l’arme.
                  return degatsTotal
          }

     }

     override fun utiliser(cible: Personnage)  { //Prend un paramètre cible de type Personnage et ne retourne rien.
         cible.equipe(this) //*la cible (paramètre) equipe l’arme en utilisant la méthode equipe() de la classe Personnage.//
     }
}

