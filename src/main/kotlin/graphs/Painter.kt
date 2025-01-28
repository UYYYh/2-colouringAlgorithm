package org.example.graphs

data class Painter(
    val colour1: String,
    val colour2: String,
) {
    var useColour1: Boolean = true

    fun paint(node: Node) {
        node.colour = if (useColour1) colour1 else colour2
    }

    fun switchToOther(colour: String) {
        useColour1 = colour != colour1
    }
}
