package item

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import personnage.Personnage


class ArmeTest {

    fun utiliser(){
        val homme_lezard = Personnage(
            "l'homme-lèzard",
            pointDeVie = 20,
            pointDeVieMax = 22,
            attaque = 11,
            defense = 13,
            vitesse = 11,
            endurance = 11,
            armePrincipal = null,
            armure = null,
        )
        val arme3 = Arme("Lance du kobold","Une lance rudimentaire",qualiteCommun,typearme3)
    }


}