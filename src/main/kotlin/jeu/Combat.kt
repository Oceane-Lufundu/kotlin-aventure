package jeu

import item.Arme
import item.Bombe
import item.Potion
import personnage.Mage
import personnage.Personnage
import personnage.Voleur

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
       //TODO Mission 1.2
        //Le joueur est invité à choisir une action parmi les options affichées
        println("tape 0 pour attaquer, 1 pour boire une potion , 2 pour voler , 3 pour lancer un sort ou 4 pour utiliser un objet de l'inventaire : ")
        var choix: Int = readln().toInt()
        if( choix == 0){
        this.jeu.joueur.attaque(monstre) //appelle de la fonction attaque
        println("\u001b[0m")
        }
        else if( choix == 1){ // permet au joueur de boire une potion
            this.jeu.joueur.boirePotion() //appelle de la fonction boirepotion
            println("\u001b[0m") //
        }
        else if( choix == 2){ // permet au joueur de voler la cible
            var leVoleur= this.jeu.joueur as Voleur //fonctionne que si le joueur est un voleur
            leVoleur.voler(monstre)//appelle de la fonction voler
            println("\u001b[0m") //
        }
        else if (choix == 3) { //permet au joueur de lancer un sort
            var leMage= this.jeu.joueur as Mage //fonctionne que si le joueur est un mage
            leMage.choisirEtLancersort(monstre)//appelle de la fonction choisirEtLancersort
            println("\u001b[0m") //
        }
        else{ //permet au jouer de choisir puis d'utiliser un objet de l'inventaire
            this.jeu.joueur.afficheInventaire() //appelle de la fonction afficherInventaire
            println("tape le numéro de l'objet à utiliser : ")
            var choix_objet: Int = readln().toInt()
            val objet= this.jeu.joueur.inventaire[choix_objet]

            if(objet is Bombe) {
                objet.utiliser(this.monstre)
            }

            else{
                objet.utiliser(this.jeu.joueur)
            }
        }

    }

    // Méthode du tour de combat du monstre
    fun tourDeMonstre() {
        var resultat = (1..100).random() //Séléctionne un nombre aléatoire
        val passe : String = "Le monstre ${monstre.nom} passe son tour"
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---") //Affiche le nom du monstre et son nombre de point de vie
        if (resultat <= 70){
            //Le monstre attaque le joueur
              this.monstre.attaque(this.jeu.joueur)
                    println("Le monstre ${monstre.nom} a attaqué")
        }
        //Si le monstre a une potion dans son inventaire et que ses pv sont plus bas que la moitié de ses pvmax
        else if (monstre.pointDeVieMax / 2 < monstre.pointDeVie && resultat <= 80){ //alors il a une chance assez faible (10%) de boire une potion.
            //Le monstre boit la potion
            monstre.boirePotion()
        }
        else {
            println("$passe")
        }

        //TODO Mission 1.3
    }

    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}