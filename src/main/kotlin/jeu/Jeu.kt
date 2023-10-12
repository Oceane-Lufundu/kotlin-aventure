package jeu

import arme1
import arme2
import armeMagique
import armure1
import armure2
import armureMagique
import bouleDeFeu
import guerison
import missileMagique
import personnage.Guerrier
import personnage.Mage
import personnage.Personnage
import personnage.Voleur
import projectionAcide


class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage
    var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres) {
            // On créer un combat
            val unCombat = Combat(this, unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Créez votre personnage:")
        println("saisissez votre nom") //L'utilisateur saisit le nom du personnage.
        // TODO Mission 1.1
        val nom: String = readln()
        println("vous avez 40 points à répartir ")
        var scoreAtk = 0 // attaque
        var scoreVIT = 0 // vitesse
        var scoreDef = 0 // défense
        var scoreEND = 0 // endurance
        var totalscore: Int

        do {
            totalscore = 40
            println("Saisissez votre score d'attaque : ") // Saisit scores attaque
             scoreAtk= readln().toInt()
            totalscore -= scoreAtk // 40 est soustrait par le score

            println("Saisissez votre score de défense : ") //Saisit scores défense
             scoreDef = readln().toInt()
            totalscore -= scoreDef // 40 est soustrait par le score

                    println("Saisissez votre score de vitesse : ") //Saisit scores vitesse
             scoreVIT = readln().toInt()
            totalscore -= scoreVIT // 40 est soustrait par le score

            println("Saisissez votre score d'endurance : ") //Saisit scores endurance
             scoreEND = readln().toInt()
            totalscore -= scoreEND
//            totalscore = scoreAtk + scoreDef + scoreEND + scoreEND
        } while (totalscore < 0)
        val pv= 50 +(10*scoreEND)

        println("Choisissez la classe de votre personnage :") //demande de choisir la classe de son personnage
        println("Tapez 0 pour Voleur, Tapez 1 pour mage ou Tapez 2 pour guerrier : ")

        var choix_classe:Int = readln().toInt()
        var hero = Personnage(nom, pv, pv, scoreAtk, scoreDef, scoreEND, scoreVIT,null,null)
        if (choix_classe == 0){ //En fonction du choix de l'utilisateur, il faut instancier le bon type de personnage
            hero = Voleur(nom, pv, pv, scoreAtk, scoreDef, scoreEND, scoreVIT,null,null, mutableListOf())
        }
        else if (choix_classe == 1) {
            hero = Mage(nom, pv, pv, scoreAtk, scoreDef, scoreEND, scoreVIT,null,null, mutableListOf(),mutableListOf(projectionAcide,guerison,bouleDeFeu,missileMagique,armeMagique,armureMagique))

           // hero.armure=armure1
        }
        else {
            hero = Guerrier(nom, pv, pv, scoreAtk, scoreDef, scoreEND, scoreVIT,null,null,null,mutableListOf())
        }




        this.joueur = hero
        return hero


    }

}