package com.vad1mchk.simpleSpringPrologServer.engine

interface PrologEngine {
    fun clear()
    fun loadKnowledge(knowledge: List<String>)
    fun runQuery(query: String): List<Map<String, String>>
}