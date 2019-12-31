package ru.mnegodaev.graph


class Graph<T>(vararg edges: Pair<T, T>) {
	private val adjacent: HashMap<T, HashSet<T>> = HashMap()

	init {
		for (edge in edges) {
			adjacent.computeIfAbsent(edge.first) { HashSet() }.add(edge.second)
			adjacent.computeIfAbsent(edge.second) { HashSet() }
		}
	}

	fun nodes(): Set<T> {
		return adjacent.keys
	}

	fun children(key: T): Set<T> {
		return adjacent[key].orEmpty()
	}

	override fun toString(): String = StringBuilder().apply {
		for (source in adjacent.keys) {
			if (adjacent[source]!!.isNotEmpty()) {
				append("$source->")
				append(adjacent[source]?.joinToString(",", "", "; "))
			}
		}
	}.toString()

}
