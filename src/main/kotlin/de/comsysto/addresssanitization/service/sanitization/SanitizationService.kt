package de.comsysto.addresssanitization.service.sanitization

import org.springframework.stereotype.Service

@Service
class SanitizationService(val sanitizationAssistant: SanitizationAssistant) {
    fun getSanitizedAddress(address: String): Address {
        return sanitizationAssistant.getSanitizedAddress(address)
    }
}