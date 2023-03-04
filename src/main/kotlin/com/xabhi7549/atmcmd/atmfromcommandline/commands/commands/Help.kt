/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.Commands

class Help : Commands() {
    override fun execute(s: BankService, params: List<String>): String {
        return """
            
            login [name] - authenticates customer to system with provided login name and create it if not exist
            logout - performs logout current authenticated customer
            deposit [amount] - deposits given amount of money to current authenticated customer's account
            withdraw [amount] - withdraws given amount of money from current authenticated customer's account
            transfer [target] [amount] - transfers given amount of money from current authenticated customer's account to the given customer's account
            exit - stops the program
            wmi - Give userName of current user
            help - prints help
            
            """.trimIndent()

    }
}