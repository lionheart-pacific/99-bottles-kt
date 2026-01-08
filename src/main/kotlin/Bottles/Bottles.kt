package Bottles

class Bottles {
    fun verse(number: Int): String {
        val nextNumber = when {
            number > 0 -> number - 1
            else -> 99
        }
        val description = getDescription(number)
        val action = getAction(number)
        val nextDescription = getDescription(nextNumber)
        val lines = listOf(
            """$description on the wall, $description.""",
            """$action, $nextDescription on the wall.""",
            "\n",
        )
        return lines.joinToString("\n") { line ->
            line.replaceFirstChar { char -> char.uppercase() }
        }
    }

    private fun getAction(number: Int): String {
        return when {
            number > 1 -> "take one down and pass it around"
            number == 1 -> "take it down and pass it around"
            else -> "go to the store and buy some more"
        }
    }

    private fun getDescription(number: Int): String {
        return when {
            number > 1 -> "$number bottles of beer"
            number == 1 -> "$number bottle of beer"
            else -> "no more bottles of beer"
        }
    }

    fun verses(upper: Int, lower: Int): String {
        return (upper downTo lower).joinToString("") { number -> verse(number) }
    }

    fun song(): String {
        return verses(99, 0)
    }

}
