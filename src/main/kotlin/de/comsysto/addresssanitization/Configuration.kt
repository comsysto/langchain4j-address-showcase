package de.comsysto.addresssanitization

import de.comsysto.addresssanitization.service.sanitization.SanitizationAssistant
import de.comsysto.addresssanitization.service.zipcode.ZipCodeServiceTool
import dev.langchain4j.memory.chat.MessageWindowChatMemory
import dev.langchain4j.model.chat.ChatLanguageModel
import dev.langchain4j.model.openai.OpenAiChatModel
import dev.langchain4j.service.AiServices
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {
    @Bean
    fun model(): ChatLanguageModel {
        return OpenAiChatModel.builder()
            .apiKey(System.getenv("OPENAI_API_KEY"))
            .modelName("gpt-3.5-turbo")
            .build()
    }

    @Bean
    fun zipCodeServiceTool(): ZipCodeServiceTool {
        return ZipCodeServiceTool()
    }

    @Bean
    fun sanitizationAssistant(model: ChatLanguageModel, zipCodeServiceTool: ZipCodeServiceTool): SanitizationAssistant {
        return AiServices.builder(SanitizationAssistant::class.java)
            .chatLanguageModel(model)
            .tools(zipCodeServiceTool)
            .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
            .build()
    }
}