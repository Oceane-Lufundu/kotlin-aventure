import item.*
import jeu.Jeu
import jeu.TirageDes
import personnage.Mage
import personnage.Personnage
import personnage.Sort

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

// TODO Intermission 8
//Création de sorts
val projectionAcide = Sort("Sort de projection d'acide"){ joueur, cible-> Unit
    run{
        val des = TirageDes(1,10)
        var degats = des.lance()
        degats = maxOf(1, degats - cible.calculeDefense())//calcul les dégats
        cible.pointDeVie -= degats//réduit les points de vie de la cible
        println("Le sort de projection d'acide inflige $degats points de dégats à ${cible.nom}")
    }
}
//création du sort de guérison
val guerison = Sort("Sort de guérison"){ joueur, cible-> Unit
    run{
        val des = TirageDes(1,6) //crétion de l'objet TirageDes
        var soins = des.lance()//appelle de la méthode lance()
        soins = maxOf(1, soins + joueur.attaque / 2)
        joueur.pointDeVie += soins //application des soins à la cible
        if(joueur.pointDeVie > joueur.pointDeVieMax){
            joueur.pointDeVie = joueur.pointDeVieMax
        }
        println("Le sort de guérison donne $soins points de soin à ${joueur.nom}")
    }
}

//création du sort de boule de feu
val bouleDeFeu = Sort("Sort de boule de feu"){ joueur, cible-> Unit
    run{
        var degatCaster = joueur.attaque/3
        val des = TirageDes(1,6)//crétion de l'objet TirageDes
        var degats = des.lance()//appelle de la méthode lance()
        degats+=degatCaster
        degats = maxOf(1, degats - cible.calculeDefense())//calcul les dégats
        cible.pointDeVie -= degats//réduit les points de vie de la cible
        println("Le sort de boule de feu inflige $degats points de dégats à ${cible.nom}")
    }
}

// sort de lancement de missile
val missileMagique = Sort("Sort de missile magique"){ joueur, cible-> Unit
    run{
        val des = TirageDes(1,6)//crétion de l'objet TirageDes
        var compteur = joueur.attaque/2 // calcul le nombre de tour de la boucle

        /**Le joueur tire des missiles magiques en boucle et le nombre de tour
         * correspond à son score d'attaque divisé par deux
         */
        repeat(compteur) {
            var degats = des.lance()//appelle de la méthode lance()
            degats = maxOf(1, degats - cible.calculeDefense())//calcul les dégats
            cible.pointDeVie -= degats//réduit les points de vie de la cible
            println("Le sort de missile magique inflige $degats points de dégats à ${cible.nom}")
        }
    }
}


val armeMagique = Sort("utilisation d'arme magique"){ joueur, cible-> Unit
    run{
        val des = TirageDes(1,20)//tire un dé
        var resultats = des.lance()
        /**la qualité de l'arme sera défini
         * en fonction de la valeur du dé lancé
         */
        var qualite: Qualite?= null
        if (resultats < 5) {
            qualite = qualiteCommun
        }
        else if (resultats < 10){
            qualite = qualiteRare
        }
        else if (resultats < 15){
            qualite = qualiteEpic
        }
        else{
            qualite = qualiteLegendaire
        }
        val epee = Arme("Epée longue ","Une épée en fer froid",qualite,typearme2)//creer une épee
        joueur.inventaire.add(epee)
        println("Une arme magique a été ajoutée à l'inventaire")
        joueur.equipe(epee)//ajoute l'epee dans l'inventaire
    }
}
//invoque une armure magique
val armureMagique = Sort("Armure magique"){ joueur, cible-> Unit
    run{
        val des = TirageDes(1,20)//création de l'oje
        var degats = des.lance() //appelle de la méthode lance()
        var qualite: Qualite? = null //déclaration d'une variable
        if (degats < 5){
            qualite = qualiteCommun
        }
        else if (degats<10){
            qualite = qualiteRare
        }
        else if (degats<15){
            qualite = qualiteEpic
        }
        else{
            qualite = qualiteLegendaire
        }
        var armureMagique = Armure("Armure magique", "Une armure en cuir d'apparence mystérieuse, imprégnée de magie.",qualite, typearmure2) //création de l'armure magique
        joueur.inventaire += armureMagique //ajoute l'armure dans l'inventaire
        println("Une armure magique est ajoutée à l'inventaire") //affichage d'une message
        joueur.equipe(armureMagique) //équipe la cible de l'armure
    }
}

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