package personnage

import armeMagique
import armureMagique
import bouleDeFeu
import missileMagique
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SortTest{
    @Test
    fun testBouleDeFeu(){
        val gobelin = Personnage(
            "le gobelin",
            pointDeVie = 20,
            pointDeVieMax = 20,
            attaque = 5,
            defense = 4,
            vitesse = 11,
            endurance = 6,
            armePrincipal = null,
            armure = null,
        )
        val mage= Mage(
            "Le mage",
            pointDeVie = 20,
            pointDeVieMax = 20,
            attaque = 10,
            defense = 10,
            vitesse = 10,
            endurance = 10,
            armePrincipal = null,
            armure = null,
            inventaire = mutableListOf(),
            grimoire = mutableListOf(),
        )

        println(mage.inventaire.size)
        armureMagique.effet(mage,mage)
        println(mage.inventaire.size)

    }

}