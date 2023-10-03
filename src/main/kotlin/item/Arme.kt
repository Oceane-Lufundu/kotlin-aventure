package item
import personnage.Personnage
import jeu.TirageDes

class Arme constructor(
        var nom: String,
        var description: String,
        val qualite: Qualite,
        val typeArme: TypeArme,
        val tirageDes: TirageDes
)

fun calculerDegats() {

}