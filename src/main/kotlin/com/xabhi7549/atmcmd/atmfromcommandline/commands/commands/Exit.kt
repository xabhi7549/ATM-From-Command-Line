/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.Commands

class Exit : Commands() {
    override fun execute(s: BankService, params: List<String>): String {
        return """
            
            Thanks For Using ATM. 
            Have A Nice Day!!
            """.trimIndent()
    }
}
