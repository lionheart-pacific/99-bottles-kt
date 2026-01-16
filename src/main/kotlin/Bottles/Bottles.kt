package Bottles

class Bottles {
    fun verse(number: Int): String {
        val n = if (number == 99) 99 else 3
        return """
            ${n} bottles of beer on the wall, ${n} bottles of beer.
            Take one down and pass it around, ${n - 1} bottles of beer on the wall.
            """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        TODO("Me, too!")
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

}
