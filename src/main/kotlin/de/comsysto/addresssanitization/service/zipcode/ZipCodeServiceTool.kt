package de.comsysto.addresssanitization.service.zipcode

import dev.langchain4j.agent.tool.P
import dev.langchain4j.agent.tool.Tool

class ZipCodeServiceTool {

    @Tool(
        """
        Retrieve zip code for a given city name and country code.
    """
    )
    fun getZipCodeForCityAndCountry(
        @P("City name. e.g. München, Berlin, ...") city: String,
        @P("Country Code in the ISO3166-1 alpha-2 format. e.g. de for Germany") countryCode: String
    ): String {
        println("retrieving zipCode for $city and $countryCode")
        return "1234"
    }
}