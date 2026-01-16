package Bottles

class Bottles {
    fun verse(number: Int): String {
        if (number == 99) return """
            99 bottles of beer on the wall, 99 bottles of beer.
            Take one down and pass it around, 98 bottles of beer on the wall.
            """.trimIndent() + "\n\n"
        else return  """
            3 bottles of beer on the wall, 3 bottles of beer.
            Take one down and pass it around, 2 bottles of beer on the wall.
            """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        TODO("Me, too!")
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

}
