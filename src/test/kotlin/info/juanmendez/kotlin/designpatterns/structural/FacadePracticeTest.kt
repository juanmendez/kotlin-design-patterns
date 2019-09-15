package info.juanmendez.kotlin.designpatterns.structural

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * This design-pattern is the kotlin version from this article
 * @see https://www.dofactory.com/net/facade-design-pattern
 */
class FacadePracticeTest {
    @Test
    @DisplayName("mortgage eligible")
    fun `verify if customer is eligible`() {
        // Facade
        val mortgage = Mortgage()

        // Evaluate mortgage eligibility for customer
        val customer = Customer("Ann McKinsey")
        val eligible = mortgage.IsEligible(customer, 125000)

        assertTrue(eligible, "${customer.name} is eligible?")

        /**
         * output:
         * Ann McKinsey applies for $125000 loan
         * Check bank for Ann McKinsey
         * Check loans for Ann McKinsey
         * Check credit for Ann McKinsey
         */
    }
}