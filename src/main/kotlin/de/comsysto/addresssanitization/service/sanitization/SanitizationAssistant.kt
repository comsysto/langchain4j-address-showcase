package de.comsysto.addresssanitization.service.sanitization

import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.V

interface SanitizationAssistant {

    @UserMessage("""
        The following text includes a possibly incorrectly formatted german address. 
        Extract the street, zipCode, houseNumber and city from it.
        It is possible that some parts are missing. Fill missing values with null.
        
        Input address: {{address}}
    """)
    fun getSanitizedAddress(@V("address") address: String): Address
}