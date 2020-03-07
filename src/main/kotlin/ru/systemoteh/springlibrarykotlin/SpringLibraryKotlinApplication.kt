package ru.systemoteh.springlibrarykotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringLibraryKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringLibraryKotlinApplication>(*args)
}