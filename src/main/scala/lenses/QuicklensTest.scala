package lenses

/**
  * Quicklens is here: https://github.com/adamw/quicklens
  */
object QuicklensTest extends App {

    val user = User(
        id = 1,
        name = Name(
            firstName = "Al",
            lastName = "Alexander"
        ),
        billingInfo = BillingInfo(
            creditCards = Seq(
                CreditCard(
                    name = Name("John", "Doe"),
                    number = "1111111111111111",
                    month = 3,
                    year = 2020,
                    cvv = ""
                )
            )
        ),
        phone = "907-555-1212",
        email = "al@al.com"
        )

    {
        import com.softwaremill.quicklens._

        // (1) one step at a time
        //val userWithRating = user.modify(_.billingInfo.siteInfo.userRating).using(_ + 1)
        val user1 = user.modify(_.phone).setTo("720-555-1212")
        val user2 = user1.modify(_.email).setTo("al@example.com")
        println(user2)

        // (2) update several fields at once
        val u3 = user.modify(_.phone).setTo("720-555-1212")
                     .modify(_.email).setTo("al@example.com")
                     .modify(_.name.firstName).setTo("Alvin")
        println(u3)

    }

}



