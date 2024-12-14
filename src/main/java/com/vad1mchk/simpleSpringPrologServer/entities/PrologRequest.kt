package com.vad1mchk.simpleSpringPrologServer.entities

data class PrologRequest(
    val knowledge: List<String>, // Prolog clauses, e.g. "friend(john,mary). friend(mary,sue)."
    val query: String       // A query, e.g. "friend(X,sue)."
)
