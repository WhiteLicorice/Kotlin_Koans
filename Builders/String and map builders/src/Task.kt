import java.util.HashMap

fun buildMutableMap(build: HashMap<Int, String>.() -> Unit): Map<Int, String> {
    val mapBuilder = HashMap<Int, String>()
    mapBuilder.build()
    return mapBuilder.toMap()

}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
