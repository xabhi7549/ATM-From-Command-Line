/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.controllers

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.CommandService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.commands.Exit
import com.xabhi7549.atmcmd.atmfromcommandline.utils.MyUtils
import org.springframework.stereotype.Controller
import java.io.InputStream
import java.io.PrintStream
import java.util.*

@Controller
class MyController(val myUtils: MyUtils, val commandService: CommandService, val bankService: BankService) {
    private lateinit var scanner: Scanner

    fun initiate(inputStream: InputStream, out: PrintStream) {
        scanner = Scanner(inputStream)
        val outStream = PrintStream(out)
        outStream.println("**** ATM Command Line APP Started! *****")
        outStream.println("**** Waiting For Input *****")
        outStream.println()

        //Infinite loop to read CLI
        while (true) {
            if (scanner.hasNextLine()) {

                val commandInput = scanner.nextLine().split(" ")
                if (commandService.commandMap.containsKey(commandInput[0])) {
                    val classGot = commandService.commandMap[commandInput[0]]
                    val outPut = classGot?.getConstructor()?.newInstance()?.execute(bankService, commandInput)
                    outStream.println(outPut)
                    if (classGot?.simpleName == Exit::class.java.simpleName) {
                        break
                    }
                } else {
                    myUtils.getLogger().error("-::Wrong Command:: ${commandInput[0]}")
                    myUtils.getLogger().error("Run \"help\" to see available commands.")
                }
            }
        }

    }

}