package de.comsysto.addresssanitization.service.sanitization

import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.V

interface SanitizationAssistant {

    @UserMessage(
        """
        The following text includes a possibly incorrectly formatted german address. 
        Extract the street, zipCode, houseNumber and city from it and return it in the format:
        'street houseNumber, zipCode city'
        If the zipCode is missing, try to retrieve it. 
        If the zipCode is present in the input, use this one and do not try to retrieve it.
                
        No explanation, just the formatted address.
        
        Input address: {{address}}
    """
    )
    fun getSanitizedAddress(@V("address") address: String): String
}