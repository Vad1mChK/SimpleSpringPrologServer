package com.vad1mchk.simpleSpringPrologServer.engine

import alice.tuprolog.Prolog
import alice.tuprolog.Theory
import alice.tuprolog.SolveInfo

class PrologTuprologEngine : PrologEngine {
    var prolog = Prolog().apply {
        loadLibrary("alice.tuprolog.lib.BasicLibrary")
    }

    override fun clear() {
        prolog.clearTheory()
    }

    override fun loadKnowledge(knowledge: List<String>) {
        for (knowledgeLine in knowledge) {
            prolog.addTheory(Theory(knowledgeLine))
        }
    }

    override fun runQuery(query: String): List<Map<String, String>> {
        val solutions = mutableListOf<Map<String, String>>()
        try {
            val querySolveInfo = prolog.solve(query) // Initial solve call
            processSolution(querySolveInfo, solutions)

            // Continue fetching alternative solutions
            while (prolog.hasOpenAlternatives()) {
                val nextSolution = prolog.solveNext()
                processSolution(nextSolution, solutions)
            }
        } catch (e: Exception) {
            println("Error running query: ${e.message}")
        }
        return solutions
    }

    private fun processSolution(solveInfo: SolveInfo, solutions: MutableList<Map<String, String>>) {
        if (solveInfo.isSuccess) {
            val variableBindings = mutableMapOf<String, String>()
            solveInfo.bindingVars.forEach { variable ->
                variableBindings[variable.name] = solveInfo.getTerm(variable?.name).toString()
                println(variable.name)
            }
            solutions.add(variableBindings)
        }
    }
}
