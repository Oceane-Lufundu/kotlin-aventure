package item

import jeu.TirageDes
import personnage.Personnage

class Potion ( val soin:Int, nom:String, description:String):Item (nom, description){
    override fun utiliser(cible:Personnage){
        cible.boirePotion(this)


    }
}