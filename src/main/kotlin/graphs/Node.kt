package org.example.graphs

data class Node(
    val alias: Int,
    var colour: String = "None",
) {
    override fun toString(): String = "$alias $colour"

    override fun equals(other: Any?): Boolean {
        if (other is Node) {
            return this.alias == other.alias
        }
        return false
    }

    override fun hashCode(): Int = this.alias.hashCode()
}
