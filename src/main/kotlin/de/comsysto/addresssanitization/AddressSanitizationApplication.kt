package de.comsysto.addresssanitization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AddressSanitizationApplication

fun main(args: Array<String>) {
	runApplication<AddressSanitizationApplication>(*args)
}
