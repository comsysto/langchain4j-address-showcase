package de.comsysto.addresssanitization.service.zipcode

import dev.langchain4j.agent.tool.Tool
import dev.langchain4j.service.V
import java.util.Locale.IsoCountryCode

class ZipCodeServiceTool {

    @Tool(
        """
        Retrieve zip code for a given city name and country code.
    """
    )
    fun getZipCodeForCityAndCountry(
        @V("City name. e.g. München, Berlin, ...") city: String,
        @V("Country Code in the ISO3166-1 alpha-2 format. e.g. de for Germany") countryCode: IsoCountryCode
    ): String {
        println("retrieving zipCode for $city and $countryCode")
        return "1234"
    }
}