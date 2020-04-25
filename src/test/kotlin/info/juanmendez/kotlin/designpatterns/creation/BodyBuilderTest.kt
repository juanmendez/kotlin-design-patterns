package info.juanmendez.kotlin.designpatterns.creation

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class BodyBuilderTest {
    @Test
    fun `assert we can create instance`() {
        val bodyBuilder = BodyBuilder.Instance()
            .benchPress(true)
            .squats(true)
            .militaryPress(true)
            .create()

        assertAll(
            "body builder perfomrs the following",
            {
                assertTrue(bodyBuilder.militaryPress)
            }, {
                assertTrue(bodyBuilder.squats)
            }, {
                assertTrue(bodyBuilder.benchPress)
            }
        )
    }
}