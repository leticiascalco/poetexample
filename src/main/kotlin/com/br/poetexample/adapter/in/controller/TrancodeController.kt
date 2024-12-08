package com.br.poetexample.adapter.`in`.controller

import com.br.poetexample.application.core.usecase.TrancodeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TrancodeController(private val service: TrancodeService) {

    @GetMapping("/trancode")
    fun getTrancode(): String {
        return service.generateTrancode()
    }
}