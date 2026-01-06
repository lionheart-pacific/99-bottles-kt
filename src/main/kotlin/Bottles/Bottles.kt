package Bottles

import java.util.Locale
import java.util.Locale.getDefault

class Bottles {
    fun verse(number: Int): String {
        fun bott(bottles:Int) = if(bottles!=1) "bottles" else "bottle"
        fun numBott(bottles: Int) = if (bottles > 0) bottles else if (bottles == 0) "no more" else 100+bottles
        fun takeDownOrStore(bottles: Int) = if (bottles > 1)
            "Take one down and pass it around"
        else if (bottles > 0) "Take it down and pass it around" else "Go to the store and buy some more"
        return """
            ${numBott(number)} ${bott(number)} of beer on the wall, ${numBott(number)} ${bott(number)} of beer.
            ${takeDownOrStore(number)}, ${numBott(number - 1)} ${bott(number - 1)} of beer on the wall.
            """.trimIndent().replaceFirstChar { it.titlecase() } + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        var s = ""
        for (i in upper downTo lower) {
            s+= verse(i)
        }
    return s
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

}
