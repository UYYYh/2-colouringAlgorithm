package org.example.graphs

data class Edge(
    val startNode: Node,
    val endNode: Node,
) {
    fun otherIfContains(node: Node): Node? {
        if (startNode == node) {
            return endNode
        }
        if (endNode == node) {
            return startNode
        }
        return null
    }
}
