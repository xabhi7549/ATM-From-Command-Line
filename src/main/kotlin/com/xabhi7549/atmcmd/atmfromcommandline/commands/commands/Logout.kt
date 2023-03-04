/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.Commands

class Logout : Commands() {
    override fun execute(s: BankService, params: List<String>): String {
        return if (s.getCurrentUser() == null) {
            "Aaahhh... You are not logged In!"
        } else {
            s.logOut()
            "See You Again!! \nYou Have Logged Out!"
        }

    }
}