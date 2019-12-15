package de.tom.kaoc

import de.tom.kaoc.day01.fuel
import kotlin.test.assertNotNull

fun main() {
    println("Advent of Code 2019 - Kotlin")

    println("Day01: ${fuel(input("day01"))}")
}

private fun input(day: String): String {
    val resource = object {}.javaClass.getResource("/input/$day.txt")
    assertNotNull(resource, "Input for $day is missing")
    return resource.readText(Charsets.UTF_8)
}