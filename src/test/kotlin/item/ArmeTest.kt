package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import qualiteLegendaire
import typearme1

class ArmeTest {

    @Test
    fun calculerDegat() {
        var arme1 =Arme("Légendaire","Une dague légendaire en mithril ",qualiteLegendaire ,typearme1)
        var result:Int=arme1.calculerDegat();
        println(result)

        Assertions.assertTrue(result>=1)
        Assertions.assertTrue(result<=20)
    }
    }
