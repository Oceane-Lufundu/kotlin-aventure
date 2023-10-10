import item.*
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

//CREATION DE L'INVENTAIRE
//création des bombes
val bombe1 = Bombe(4,6,"Feu grégeois","Une flasque qui contient un liquide inflammable.")
val bombe2 = Bombe(2,8,"Flasque dacide","Une flasque qui contient un liquide inflammable.")
val bombe3 = Bombe(5,6,"Grenade","Une flasque qui contient un liquide inflammable.")

//création des potions
val potion1 = Potion(20,"Potion de soins","Une potion qui contient un liquide rouge.")
val potion2 = Potion(30,"Grande potion de soins","Une contraception qui explose une fois lancée.")

//création des types d'armes
val typearme1 = TypeArme(1,4,3,18)
val typearme2 = TypeArme(1,8,2,19)
val typearme3 = TypeArme(1,8,3,20)
val typearme4 = TypeArme(1,8,3,20)
val typearme5 = TypeArme(1,8,3,20)

//création des armes
val arme1 =Arme("Légendaire","Une dague légendaire en mithril ",qualiteLegendaire ,typearme1)
val arme2 = Arme("Epée longue du droit","Une épée en fer froid",qualiteRare,typearme2)
val arme3 = Arme("Lance du kobold","Une lance rudimentaire",qualiteCommun,typearme3)
val arme4 = Arme("Hache +2","Une hache tranchante",qualiteEpic,typearme4)
val arme5 = Arme("Tonnerre","Un marteau légendaire frappe comme la foudre",qualiteLegendaire ,typearme5)

//création des types d'armure
val typearmure1= TypeArmure("Rembourré",1)
val typearmure2= TypeArmure("Cuir",2)
val typearmure3= TypeArmure("Cuir clouté",3)
val typearmure4= TypeArmure("Chemise à chaîne",4)
val typearmure5= TypeArmure("Pectoral",5)
val typearmure6= TypeArmure("Cotte de mailles",6)

//création des armures
val armure1= Armure("cotte de maille", "Cotte de mailles plus lourde mais aussi plus solide",qualiteRare,typearmure6)
val armure2= Armure("Le manteau de la nuit","Armure en cuire obscure comme la nuit",qualiteEpic,typearmure2)
val armure3= Armure("Armure du gobelin","Armure en cuir rudimentaire",qualiteCommun,typearmure3)

val grenade = Bombe(
    5,
    6,
    "Grenade",
    "Une contraception qui explose une fois lancée",
)
// TODO Intermission 1 Ajouter d'autres monstres
//On ajoute les monstres a la liste de monstres du jeu
fun main(args: Array<String>) {

    //Instantiation des monstres
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
    val gnoll = Personnage(
        "le gnoll",
        pointDeVie = 20,
        pointDeVieMax = 25,
        attaque = 11,
        defense = 8,
        vitesse = 14,
        endurance = 11,
        armePrincipal = arme2,
        armure = null,
        inventaire = mutableListOf(bombe1),
    )
    val homme_lezard = Personnage(
        "l'homme-lèzard",
        pointDeVie = 20,
        pointDeVieMax = 22,
        attaque = 11,
        defense = 13,
        vitesse = 11,
        endurance = 11,
        armePrincipal = arme3,
        armure = null,
    )
    val armure_animee = Personnage(
        "l'armure-animée",
        pointDeVie = 20,
        pointDeVieMax = 33,
        attaque = 8,
        defense = 15,
        vitesse = 6,
        endurance = 8,
        armePrincipal = null,
        armure = armure2,
    )
    val jeu = Jeu(listOf( gobelin, gnoll, homme_lezard, armure_animee))
    //Lancement du jeu
    jeu.lancerCombat()
}