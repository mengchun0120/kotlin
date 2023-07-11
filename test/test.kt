fun main() {
    val arr = Array(3){ 0 }
    for (i in 0 until arr.size) {
        arr[i] += 2
    }

    arr.forEach{ println("$it") }
}
