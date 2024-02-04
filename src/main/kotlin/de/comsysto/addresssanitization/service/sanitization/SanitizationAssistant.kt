package de.comsysto.addresssanitization.service.sanitization

import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.V

interface SanitizationAssistant {

    @UserMessage("""
        The following text includes a possibly incorrectly formatted german address. 
        Extract the street, zipCode, houseNumber and city from it and return it in the format:
        'street houseNumber, zipCode city'
        It is possible that some address parts are missing in the input. Omit these parts in the output.
        
        No explanation, just the formatted address.
        
        Input address: {{address}}
    """)
    fun getSanitizedAddress(@V("address") address: String): String
}