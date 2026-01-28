package Bottles

class Bottles {
    fun verse(number: Int): String {
        return when (number) {
            0 -> """
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
                """.trimIndent() + "\n\n"

            1 -> """
                ${number} ${container(number)} of beer on the wall, ${number} ${container(number)} of beer.
                Take ${pronoun(number)} down and pass it around, no more bottles of beer on the wall.
                """.trimIndent() + "\n\n"

            else -> """
                ${number} ${container(number)} of beer on the wall, ${number} ${container(number)} of beer.
                Take ${pronoun(number)} down and pass it around, ${number - 1} ${container(number - 1)} of beer on the wall.
                """.trimIndent() + "\n\n"
        }
    }

    fun verses(upper: Int, lower: Int): String {
        return (upper downTo lower).map { verse(it) }.joinToString("")
    }

    fun song(): String {
        return verses(99, 0)
    }

    private fun container(number: Int): String {
        if (number == 1) return "bottle"
        return "bottles"
    }

    private fun pronoun(number: Int): String {
        if (number == 1) return "it"
        return "one"
    }
}
