package com.example.demo

import com.example.demo.db.LiveDB
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Demo2Application

fun main(args: Array<String>) {
	runApplication<Demo2Application>(*args)

LiveDB.dabaseSaticObj=LiveDB()

}
