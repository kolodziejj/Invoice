import java.io.File

fun createInvoice(): Int {
    var invoiceNumber: Int = readFile(fileName = "InvoiceCount" + ".cfg")
    var contractorName: String
    var productName: String
    var unitPrice: String
    var amount: String


    println("Eneter contractor name")
    contractorName = readln()
    while (!checkString(contractorName)) {
        println("ContractorName price must be a text")
        contractorName = readln()
    }

    println("Enter product/service name")
    productName = readln()
    while (!checkString(productName)) {
        println("ProductName price must be a text")
        productName = readln()
    }

    println("Enter unit price")
    unitPrice = readln()
    while (!check(unitPrice)) {
        println("Unit price must be a number")
        unitPrice = readln()
    }

    println("Enter amount")
    amount = readln()
    while (!check(amount)) {
        println("Amount must be a number")
        amount = readln()
    }

    var fileName = "Invoice.txt"
    var answ: String?
    println("Click 'y' if you want to create a new invoice or 'n' if you don't want to create it")
    answ = readln()
    when (answ) {
        "y" -> {
            invoiceNumber++
            fileName = contractorName + "Invoice $invoiceNumber" + ".txt"
        }
        "n" -> return options()
        else -> {
            println("Incorrect characters, please enter your answer again"); answ = readln()
        }
    }
    var file = File(fileName)
    val isNewFileCreated: Boolean = file.createNewFile()
    if (isNewFileCreated) {
        println("$fileName is created successfully.")
    } else {
        println("$fileName already exists.")
        return createInvoice()
    }
    var price = unitPrice.toInt() * amount.toInt()
    File(fileName).printWriter()
        .use { out -> out.println("number: $invoiceNumber\nname: $contractorName\nproduct: $productName\nunit price: $unitPrice\namount: $amount\nprice: $price") }

    println("Press Enter to continue")
    try {
        System.`in`.read()
        return invoiceCountpp()
    } catch (e: Exception) {
    }

    return 0
}


