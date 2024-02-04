package de.comsysto.addresssanitization.service.zipcode

import dev.langchain4j.agent.tool.P
import dev.langchain4j.agent.tool.Tool
import org.springframework.web.client.RestTemplate

data class ZipCodeBaseResponse(val results: List<String>)

class ZipCodeServiceTool(private val restTemplate: RestTemplate) {

    @Tool(
        """
                Retrieve zip code for a given city name and country code.
        """
    )
    fun getZipCodeForCityAndCountry(
        @P("City name. e.g. München, Berlin, ...") city: String,
        @P("Country Code in the ISO3166-1 alpha-2 format") countryCode: String
    ): String {
        println("retrieving zipCode for $city and $countryCode")
        val response = restTemplate.getForObject(
            "city?city=$city&country=$countryCode",
            ZipCodeBaseResponse::class.java,
        )
        if (response?.results == null || response.results.isEmpty()) {
            println("No zip code found for $city and $countryCode")
            return "00000"
        }
        return response.results[0]
    }
}