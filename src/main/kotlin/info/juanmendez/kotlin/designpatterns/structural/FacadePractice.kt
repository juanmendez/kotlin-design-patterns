package info.juanmendez.kotlin.designpatterns.structural

data class Customer(val name: String)

/**
 * This pattern reminds me of clean-architecture. In here each facade dependency doesn't know
 * the facade class. This pattern goes really well within clean-architecture as a large computation can
 * be broken into separate tasks being facade dependencies.
 *
 * For example a large computation dealing with an rxjava observable ensembled by several observables.
 * Where each observable is its own class, and the main observable operates inside a facade, or the facade itself
 * by subclassing the observable class
 *
 * In summary, the Facade-Pattern eases testing for each of its dependencies. Similarly the facade pattern is
 * great injected inside an MV* pattern.
 */
class Mortgage {
    private val bank = Bank()
    private val loan = Loan()
    private val credit = Credit()

    fun IsEligible(cust: Customer, amount: Int): Boolean {
        println("${cust.name} applies for \$${amount} loan")

        // Check credit worthyness of applicant
        return when {
            !bank.hasSufficientSavings(cust, amount) -> false
            !loan.hasNoBadLoans(cust) -> false
            !credit.hasGoodCredit(cust) -> false
            else -> true
        }
    }
}

class Bank {
    fun hasSufficientSavings(c: Customer, amount: Int): Boolean {
        println("Check bank for ${c.name}")
        return true
    }
}

class Credit {
    fun hasGoodCredit(c: Customer): Boolean {
        println("Check credit for ${c.name}")
        return true
    }
}

class Loan {
    fun hasNoBadLoans(c: Customer): Boolean {
        println("Check loans for ${c.name}")
        return true
    }
}