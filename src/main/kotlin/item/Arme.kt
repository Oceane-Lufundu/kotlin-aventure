package item
import jeu.TirageDes
import personnage.Personnage

class Arme constructor(nom: String, description: String, val qualite: Qualite, val typeArme: TypeArme):Item(nom,description){
     fun calculerDegat():Int{
             var desDegat = TirageDes(this.typeArme.nombreDes, this.typeArme.valeurDeMax).lance()
             var result = desDegat
             val desCritique = TirageDes(1, 20).lance()

          if(desCritique>=this.typeArme.activationCritique){

                  var critique = result * this.typeArme.multiplictaeurCritique
                  var degatsTotal = critique + this.qualite.bonusRarete
                  return degatsTotal

          } else {
                  var degatsTotal = result+this.qualite.bonusRarete
                  return degatsTotal
          }

     }

     override fun utiliser(cible: Personnage)  {
         cible.equipe(this)
     }
}

