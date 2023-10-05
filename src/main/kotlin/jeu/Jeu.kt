package jeu

import personnage.Personnage


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
        println("Création votre personnage:")
        println("saisissez votre nom")
        // TODO Mission 1.1
        val name: String = readln()
        println("vous avez 40 points à répartir ")
        var scoreAtk = 0
        var scoreVIT = 0
        var scoreDef = 0
        var scoreEND = 0
        var totalscore: Int

        do {
            totalscore = 40
            println("Saisissez votre score d'attaque : ")
            var scoreAtk: Int = readln().toInt()
            totalscore -= scoreAtk

            println("Saisissez votre score de défense : ")
            var scoreDef: Int = readln().toInt()
            totalscore -= scoreDef

            println("Saisissez votre score de vitesse : ")
            var scoreVIT: Int = readln().toInt()
            totalscore -= scoreVIT

            println("Saisissez votre score d'endurance : ")
            var scoreEND: Int = readln().toInt()
            totalscore -= scoreEND
//            totalscore = scoreAtk + scoreDef + scoreEND + scoreEND
        } while (totalscore < 0)

        val hero = Personnage(name, 150, 150, 12, 8, 8, 12,null,null)
        this.joueur = hero
        return hero
    }
}