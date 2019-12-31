package ru.mnegodaev.graph.algo

import ru.mnegodaev.graph.Graph

class DFS<T>(private val graph: Graph<T>) {
	lateinit var traverse: MutableList<T>
	lateinit var topoSorted: MutableList<T>
	private lateinit var visited: MutableMap<T, Boolean>

	fun from(node: T): DFS<T> {
		init()

		if (graph.nodes().contains(node)) {
			traverse(node)
			topoSorted.reverse()
		}

		return this
	}

	private fun traverse(node: T) {
		traverse.add(node)
		visited[node] = true

		for (child in graph.children(node)) {
			if (!visited[child]!!) {
				traverse(child)
			}
		}

		topoSorted.add(node)
	}

	private fun init() {
		traverse = ArrayList()
		topoSorted = ArrayList()
		visited = HashMap<T, Boolean>().apply { putAll(graph.nodes().map { Pair(it, false) }) }
	}

}
