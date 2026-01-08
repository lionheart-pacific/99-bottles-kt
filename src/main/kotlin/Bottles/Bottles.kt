package Bottles

class Bottles {
    fun verse(number: Int): String {
        fun bottlesOrBottle(bottles:Int) = if(bottles!=1) "bottles" else "bottle"
        fun numberOfBottles(bottles: Int) = if (bottles > 0) bottles else if (bottles == 0) "no more" else 100+bottles
        fun takeDownOrStore(bottles: Int) = if (bottles > 1)
            "Take one down and pass it around"
        else if (bottles > 0) "Take it down and pass it around" else "Go to the store and buy some more"
        return """
            ${numberOfBottles(number)} ${bottlesOrBottle(number)} of beer on the wall, ${numberOfBottles(number)} ${bottlesOrBottle(number)} of beer.
            ${takeDownOrStore(number)}, ${numberOfBottles(number - 1)} ${bottlesOrBottle(number - 1)} of beer on the wall.
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
        return verses(99, 0)
    }

}
