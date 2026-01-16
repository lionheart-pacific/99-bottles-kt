package Bottles

class Bottles {
    fun verse(number: Int): String {
        if (number == 2) return """
            2 bottles of beer on the wall, 2 bottles of beer.
            Take one down and pass it around, 1 bottle of beer on the wall.
            """.trimIndent() + "\n\n"

        return """
            ${number} bottles of beer on the wall, ${number} bottles of beer.
            Take one down and pass it around, ${number - 1} bottles of beer on the wall.
            """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        TODO("Me, too!")
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

}
