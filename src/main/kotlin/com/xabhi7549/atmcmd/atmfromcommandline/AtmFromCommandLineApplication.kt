/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline

import com.xabhi7549.atmcmd.atmfromcommandline.controllers.MyController
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AtmFromCommandLineApplication(val myController: MyController) : CommandLineRunner {
    override fun run(vararg args: String?) {
        myController.initiate(System.`in`, System.out)
    }
}

fun main(args: Array<String>) {
    runApplication<AtmFromCommandLineApplication>(*args)
}
