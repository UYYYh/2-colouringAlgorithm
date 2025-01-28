package org.example

import org.example.graphs.Edge
import org.example.graphs.Graph
import org.example.graphs.Node

fun main1() {
    val node1: Node = Node(1)
    val node2: Node = Node(2)
    val node3: Node = Node(3)
    val node4: Node = Node(4)
    val node5: Node = Node(5)
    val node6: Node = Node(6)
    val node7: Node = Node(7)
    val node8: Node = Node(8)

    val edge1: Edge = Edge(node1, node2)
    val edge2: Edge = Edge(node2, node3)
    val edge3: Edge = Edge(node3, node4)
    val edge4: Edge = Edge(node4, node1)
    val edge5: Edge = Edge(node5, node6)
    val edge6: Edge = Edge(node6, node7)
    val edge7: Edge = Edge(node7, node8)
    val edge8: Edge = Edge(node5, node8)

    val graph: Graph =
        Graph(
            listOf(node1, node2, node3, node4, node5, node6, node7, node8),
            listOf(edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8),
        )
    println(graph)
    println(graph.adjacencyList[node1])
    graph.twoColour()
    println(graph)
}

fun main() {
    val node1: Node = Node(1)
    val node2: Node = Node(2)
    val node3: Node = Node(3)
    val node4: Node = Node(4)
    val node5: Node = Node(5)
    val node6: Node = Node(6)

    val edge1: Edge = Edge(node1, node2)
    val edge2: Edge = Edge(node2, node3)
    val edge3: Edge = Edge(node3, node4)
    val edge4: Edge = Edge(node4, node5)
    val edge5: Edge = Edge(node5, node6)
    val edge6: Edge = Edge(node6, node1)
    val edge7: Edge = Edge(node2, node5)

    val graph: Graph = Graph(listOf(node1, node2, node3, node4, node5, node6), listOf(edge1, edge2, edge3, edge4, edge5, edge6, edge7))
    println(graph)
    println(graph.adjacencyList[node1])
    graph.twoColour()
    println(graph)
}
