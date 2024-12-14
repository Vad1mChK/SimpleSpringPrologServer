package com.vad1mchk.simpleSpringPrologServer.services

import com.vad1mchk.simpleSpringPrologServer.engine.PrologEngine
import com.vad1mchk.simpleSpringPrologServer.entities.PrologSolution
import org.springframework.stereotype.Service
@Service
class PrologService(private val prologEngine: PrologEngine) {
    fun executeProlog(knowledge: List<String>, query: String): List<PrologSolution> {
        // Load the knowledge into the Prolog engine
        prologEngine.clear()
        prologEngine.loadKnowledge(knowledge)

        // Execute the query
        val results = prologEngine.runQuery(query)

        // Convert results into PrologSolution format
        return results.map { solutionVars ->
            PrologSolution(variables = solutionVars)
        }
    }
}
