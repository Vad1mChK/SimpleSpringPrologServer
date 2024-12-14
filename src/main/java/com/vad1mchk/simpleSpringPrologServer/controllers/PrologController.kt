package com.vad1mchk.simpleSpringPrologServer.controllers

import com.vad1mchk.simpleSpringPrologServer.entities.PrologRequest
import com.vad1mchk.simpleSpringPrologServer.entities.PrologResponse
import com.vad1mchk.simpleSpringPrologServer.services.PrologService
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/prolog")
class PrologController(private val prologService: PrologService) {
    @PostMapping("/query")
    fun runQuery(@RequestBody request: PrologRequest): ResponseEntity<PrologResponse> {
        val solutions = prologService.executeProlog(request.knowledge, request.query)
        return ResponseEntity.ok(PrologResponse(solutions))
    }
}
