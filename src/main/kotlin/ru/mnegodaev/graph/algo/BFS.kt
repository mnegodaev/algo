package ru.mnegodaev.graph.algo

import ru.mnegodaev.graph.Graph
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class BFS<T>(private val graph: Graph<T>) {
	private lateinit var visited: MutableMap<T, Boolean>
	private lateinit var queue: ArrayDeque<T>

	lateinit var traverse: MutableList<T>

	fun from(node: T): BFS<T> {
		if (!graph.nodes().contains(node)) {
			traverse = ArrayList()
			return this
		}

		init(node)
		traverse()

		return this
	}

	private fun traverse() {
		while (queue.isNotEmpty()) {
			val current = queue.remove()

			for (child in graph.children(current)) {
				if (!visited[child]!!) {
					visited[child] = true
					queue.add(child)
					traverse.add(child)
				}
			}
		}
	}

	private fun init(startNode: T) {
		visited = HashMap<T, Boolean>().apply { putAll(graph.nodes().map { Pair(it, false) }) }
		queue = ArrayDeque()
		traverse = ArrayList(graph.nodes().size)

		visited[startNode] = true
		queue.add(startNode)
		traverse.add(startNode)
	}
}
