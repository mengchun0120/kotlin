fun main(args: Array<String>) {
    try {
        val params = Params(args)
        val calendar = Calendar(params.year)
        calendar.print(params.columnCount)
    } catch (e: Exception) {
        println("Caught exception $e")
        println("Args: year [columnCount]")
    }
}
