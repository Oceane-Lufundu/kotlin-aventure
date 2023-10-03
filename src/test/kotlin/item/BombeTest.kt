package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import personnage.Personnage

class BombeTest {

    @Test
    fun utiliser() {
        val homme_lezard = Personnage(
            "l'homme-lèzard",
            pointDeVie = 20,
            pointDeVieMax = 22,
            attaque = 11,
            defense = 13,
            vitesse = 11,
            endurance = 11,
        )
        val grenade = Bombe(
            5,
            6,
            "Grenade",
            "Une contraception qui explose une fois lancée",
        )
        grenade.utiliser(homme_lezard)
        var degat=20-homme_lezard.pointDeVie
        Assertions.assertTrue(degat>=1)
        Assertions.assertTrue(degat<=24)

    }
}