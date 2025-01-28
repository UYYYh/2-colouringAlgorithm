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
        // Find an uncoloured node as the starting node
        val startingNode: Node? =
            adjacencyList
                .toList()
                .map { it.first }
                .find { it.colour == "None" }
        // If all nodes are already coloured, terminate the algorithm
        if (startingNode == null) return

        // Typical DFS using a stack:
        val nodeStack = Stack<Node>()
        val visitedNodes = mutableSetOf<Node>()
        val colourPainter = Painter(colour1, colour2)

        colourPainter.paint(startingNode)
        nodeStack.push(startingNode)

        while (nodeStack.isNotEmpty()) {
            val currentNode = nodeStack.pop()
            println("painting node: $currentNode")
            visitedNodes.add(currentNode)
            colourPainter.switchToOther(currentNode.colour)

            // Get all unvisited nodes that are adjacent to the current node
            val adjacentNodes: List<Node> =
                adjacencyList[currentNode]!!
                    .filter { !visitedNodes.contains(it) && !nodeStack.contains(it) }
                    .sortedByDescending { it.alias }

            // Paint all the adjacent nodes with a different colour to the current node
            for (node in adjacentNodes) {
                colourPainter.paint(node)
                nodeStack.push(node)
            }
        }
        // Call the function again, in case the graph is not connected and not all nodes are coloured
        twoColour(colour1, colour2)
    }
}
