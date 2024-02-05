package de.comsysto.addresssanitization.service.sanitization

import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.V

interface SanitizationAssistant {

    @UserMessage(
        """
        The following text includes a possibly incorrectly formatted german address. 
        Extract the street, zipCode, houseNumber and city from it and return it in the format:
        'street houseNumber, zipCode city'
        If some part of the address is missing, omit them in the output.
                
        No explanation, just the formatted address.
        
        Input address: {{address}}
    """
    )
    fun getSanitizedAddress(@V("address") address: String): String
}