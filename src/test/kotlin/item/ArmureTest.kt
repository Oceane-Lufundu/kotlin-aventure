package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import qualiteRare
import typearmure6

class ArmureTest {

    @Test
    fun calculProtection() {
        var armure = Armure("cotte de maille", "Cotte de mailles plus lourde mais aussi plus solide",qualiteRare,typearmure6)
    var result=armure.calculProtection();
        Assertions.assertEquals(7,result)
    }
}