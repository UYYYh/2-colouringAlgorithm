package org.example.graphs

import java.util.Stack

// Graph represented using adjacency list
class Graph(
    nodes: List<Node>,
    edges: List<Edge>,
) {
    val adjacencyList: MutableMap<Node, List<Node>> =
        nodes
            .associateWith { node ->
                edges.mapNotNull { it.otherIfContains(node) }
            }.toMutableMap()

    override fun toString(): String = adjacencyList.toList().toString()

    fun twoColour(
        colour1: String = "Red",
        colour2: String = "Blue",
    ) {
        val startingNode: Node? =
            adjacencyList
                .toList()
                .map { it.first }
                .find { it.colour == "None" }
        if (startingNode == null) return

        val nodeStack = Stack<Node>()
        val visitedNodes = mutableSetOf<Node>()
        val colourPainter = Painter(colour1, colour2)

        colourPainter.paint(startingNode)
        nodeStack.push(startingNode)

        while (nodeStack.isNotEmpty()) {
            val currentNode = nodeStack.pop()
            visitedNodes.add(currentNode)
            colourPainter.switchToOther(currentNode.colour)

            val adjacentNodes: List<Node> =
                adjacencyList[currentNode]!!
                    .filter { !visitedNodes.contains(it) }
                    .sortedByDescending { it.alias }

            for (node in adjacentNodes) {
                colourPainter.paint(node)
                nodeStack.push(node)
            }
        }
        twoColour(colour1, colour2)
    }
}
