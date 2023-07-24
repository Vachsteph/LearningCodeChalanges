package file

import java.io.File
import java.util.Collections.max

fun main(args :Array<String>) {

    val ipToCount = mutableMapOf<String, Int>()
    File("src/60.ips.txt").forEachLine {

        if (ipToCount.contains(it)) {

            ipToCount[it] = ipToCount[it]!! + 1

            ipToCount[it] = ipToCount.getOrDefault(it, 0) + 1

        } else {

            ipToCount[it] = 1

        }
    }
    val maxValue = max(ipToCount.values)
    println(maxValue)
}


