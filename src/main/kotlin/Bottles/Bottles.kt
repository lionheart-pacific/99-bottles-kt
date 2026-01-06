package Bottles

class Bottles {
    fun verse(number: Int): String {
        return """
            $number bottles of beer on the wall, $number bottles of beer.
            Take one down and pass it around, ${number-1} bottles of beer on the wall.
            """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        TODO("Me, too!")
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

}
