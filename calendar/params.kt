class Params {
    val year: Int
    val columnCount: Int

    constructor(args: Array<String>) {
        if (args.size < 1 || args.size > 2) {
            throw Exception("Invalid args size")
        }

        year = args[0].toInt()
        if (year <= 0) {
            throw Exception("Invalid year ${args[0]}")
        }

        columnCount = if (args.size == 2) args[1].toInt() else 1
        if (columnCount <= 0 || columnCount > 4) {
            throw Exception("Invalid columnCount ${args[1]}")
        }
    }
}
