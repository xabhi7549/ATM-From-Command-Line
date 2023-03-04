/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.Commands

class Login : Commands() {
    override fun execute(s: BankService, params: List<String>): String {
        return if (params.size > 1) {
            val user = s.login(params[1])
            "Hello " + user.userName + "\n Your Balance Is: " + user.balance
        } else {
            "User name is required."
        }

    }
}