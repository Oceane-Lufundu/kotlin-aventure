package item

import personnage.Personnage

class Armure constructor( nom: String, description: String, val qualite: Qualite, val typeArmure: TypeArmure):Item(nom, description)
 {
    fun calculProtection(): Int {
        var protection = this.typeArmure.bonusType + this.qualite.bonusRarete
        return protection
    }

     override fun utiliser(cible: Personnage) {
     }

}
