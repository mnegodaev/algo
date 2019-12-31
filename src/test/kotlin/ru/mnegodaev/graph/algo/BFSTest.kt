package ru.mnegodaev.graph.algo

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ru.mnegodaev.graph.Graph

object BFSTest : Spek({
	describe("BFS") {
		mapOf(
			Graph(1 to 1) to listOf(1),
			Graph(1 to 2) to listOf(1, 2),
			Graph(1 to 2, 2 to 3) to listOf(1, 2, 3),
			Graph(1 to 2, 2 to 3, 3 to 1) to listOf(1, 2, 3),
			Graph(1 to 2, 2 to 3, 2 to 4) to listOf(1, 2, 3, 4),
			Graph(1 to 2, 2 to 3, 2 to 4, 1 to 5, 1 to 3) to listOf(1, 2, 3, 5, 4),
			Graph(1 to 2, 2 to 3, 2 to 4, 3 to 5) to listOf(1, 2, 3, 4, 5),
			Graph(1 to 2, 1 to 3, 3 to 4, 4 to 2) to listOf(1, 2, 3, 4),
			Graph<Int>() to emptyList()
		).forEach { (graph, traverse) ->
			val bfs = BFS(graph).from(1)

			it("Traverse for {$graph}") {
				assertIterableEquals(traverse, bfs.traverse)
			}
		}
	}
})
