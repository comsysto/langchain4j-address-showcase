package de.comsysto.addresssanitization.controller

import de.comsysto.addresssanitization.service.sanitization.SanitizationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SanitizationController(val sanitizationService: SanitizationService) {
    @GetMapping("/sanitize", produces = ["application/json"])
    fun get(@RequestParam address: String): String {
        return sanitizationService.getSanitizedAddress(address)
    }
}