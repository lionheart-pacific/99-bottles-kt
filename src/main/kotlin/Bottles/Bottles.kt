package Bottles

class Bottles {
    fun verse(number: Int): String {
        fun bott(bottles:Int) = if(bottles!=1) "bottles" else "bottle"
        return """
            $number ${bott(number)} of beer on the wall, $number ${bott(number)} of beer.
            Take ${if (number > 1) "one" else "it"} down and pass it around, ${if(number-1>0) number-1 else "no more"} ${bott(number-1)} of beer on the wall.
            """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        TODO("Me, too!")
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

}
