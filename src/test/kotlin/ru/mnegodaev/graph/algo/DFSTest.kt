package ru.mnegodaev.graph.algo

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ru.mnegodaev.graph.Graph

object DFSTest : Spek({
	describe("DFS") {
		listOf(
			Triple(Graph(1 to 1), listOf(1), listOf(1)),
			Triple(Graph(1 to 2), listOf(1, 2), listOf(1, 2)),
			Triple(Graph(1 to 2, 1 to 3), listOf(1, 2, 3), listOf(1, 3, 2)),
			Triple(Graph(1 to 2, 1 to 3, 2 to 4), listOf(1, 2, 4, 3), listOf(1, 3, 2, 4)),
			Triple(Graph(1 to 2, 1 to 3, 2 to 4, 3 to 5), listOf(1, 2, 4, 3, 5), listOf(1, 3, 2, 5, 4)),
			Triple(Graph(), emptyList(), emptyList())
		).forEach(action = { (graph, traverse, topoSort) ->
			val dfs = DFS(graph)

			dfs.from(1)

			it("Traverse for {$graph}") {
				assertIterableEquals(traverse, dfs.traverse)
			}

			it("Topologically sorted nodes for {$graph}") {
				assertIterableEquals(topoSort, dfs.topoSorted)
			}
		})
	}
})