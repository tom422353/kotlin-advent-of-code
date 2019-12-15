package de.tom.kaoc.day01

fun fuel(input: String): Pair<Int, Int> {
    val masses = input.lines().map(String::toInt)
    return Pair(simple(masses), recursive(masses.toMutableList()))
}

private fun simple(masses: List<Int>): Int = masses.map { calcMassToFuel(it) }.sum()

private fun recursive(masses: List<Int>): Int {
    var recursiveTotalFuel: Int = 0
    val massesQueue = masses.toMutableList()
    while (massesQueue.isNotEmpty()) {
        val mass = massesQueue.removeAt(0)
        val fuel = calcMassToFuel(mass)
        if (fuel > 0) {
            recursiveTotalFuel += fuel
            massesQueue.add(fuel)
        }
    }
    return recursiveTotalFuel
}

private fun calcMassToFuel(mass: Int) = (mass / 3) - 2