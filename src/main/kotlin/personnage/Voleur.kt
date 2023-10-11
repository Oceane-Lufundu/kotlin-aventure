package personnage

import item.Arme
import item.Armure
import item.Item

class Voleur (nom:String, pointDeVie:Int, pointDeVieMax:Int, attaque:Int, defense:Int, endurance:Int, vitesse:Int, armePrincipal:Arme?, armure:Armure?, inventaire:MutableList<Item>):Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire){
    override fun toString(): String {
        return super.toString()
    }

    fun voler(cible:Personnage){
        var objectVolee:Item? = null
        if (cible.inventaire.size > 0){
            for (item in inventaire){
                if(item == armePrincipal){
                    objectVolee = item
                    this.inventaire+=objectVolee
                    inventaire.remove(objectVolee)
                    cible.armePrincipal = null
                    break
                    println("Vous avez volé(e) ${objectVolee} de ${cible}")
                }
                else if(item == armure){
                    break
                    objectVolee = item
                    this.inventaire+=objectVolee
                    inventaire.remove(objectVolee)
                    cible.armure = null
                    println("Vous avez volé(e) ${objectVolee} de ${cible}")
                }
                else {
                    break
                    objectVolee = item
                    this.inventaire+=objectVolee
                    inventaire.remove(objectVolee)
                    println("Vous avez volé(e) ${objectVolee} de ${cible}")
                }
            }
        }
        else{
            println("L'inventaire de ${cible} est vide.")
        }
    }
}