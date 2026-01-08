package Bottles

class Bottles {
    fun verse(number: Int): String {
        fun checkS(number: Int) : String {
            return if(number > 1) "s" else ""
        }

        if(number == 0) {
            return """
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
            """.trimIndent() + "\n\n"
        }

        val currentBottleNoun = "bottle" + checkS(number)
        val itOrOne = if(number > 1) "one" else "it"

        val nextNumber = number-1
        val lastPhase =
            if(nextNumber == 0) "no more bottles of beer on the wall."
            else "$nextNumber bottle${checkS(nextNumber)} of beer on the wall."

        return """
            $number $currentBottleNoun of beer on the wall, $number $currentBottleNoun of beer.
            Take $itOrOne down and pass it around, $lastPhase
        """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        var verses = ""
        for ( i in upper downTo lower ) {
            verses += verse(i)
        }
        return verses
    }

    fun song(): String {
        return verses(99, 0)
    }

}
