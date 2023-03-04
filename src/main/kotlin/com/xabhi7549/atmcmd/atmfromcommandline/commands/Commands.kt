/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService

abstract class Commands : CommandService() {
    abstract fun execute(s: BankService, params: List<String>): String
}