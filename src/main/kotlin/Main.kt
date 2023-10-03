import item.Qualite
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

fun main(args: Array<String>) {
    //Instantiation des monstres
    val gobelin = Personnage(
        "le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6)
    val gnoll = Personnage(
        "le gnoll",
        pointDeVie = 20,
        pointDeVieMax = 25,
        attaque = 11,
        defense = 8,
        vitesse = 14,
        endurance = 11
    )
    val homme_lezard = Personnage(
        "l'homme-lèzard",
        pointDeVie = 20,
        pointDeVieMax = 22,
        attaque = 11,
        defense = 13,
        vitesse = 11,
        endurance = 11,
    )
    val armure_animee = Personnage(
        "l'armure-animée",
        pointDeVie = 20,
        pointDeVieMax = 33,
        attaque = 8,
        defense = 15,
        vitesse = 6,
        endurance = 8,
    )
    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin, gnoll, homme_lezard, armure_animee))
    //Lancement du jeu
    jeu.lancerCombat()
}