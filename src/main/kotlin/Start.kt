fun options(): Int {
    var userChoice: String? = ""
    println("1 - View invoice list\n" + "2 - Create invoice\n" + "3 - Delete invoice")

    userChoice = readln()

    if (!check(userChoice)) {
        println("Incorrect characters, please enter number from 1 to 3")
        return options()
    } else if (userChoice < "1" || userChoice > "3") {
        println("Please enter number from 1 to 3")
        return options()
    } else {
        when (userChoice) {
            "1" -> {
                printInvoiceList()
            }
            "2" -> {
                createInvoice()
            }
            "3" -> {
                deleteInvoice()
            }
            else -> return options()
        }
    }
    return 0
}