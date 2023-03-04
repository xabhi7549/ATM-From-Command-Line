/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.Commands

class Withdraw : Commands() {
    override fun execute(s: BankService, params: List<String>): String {
        val currentUser = s.getCurrentUser()
        return if (currentUser == null) {
            "Aaahhh... You are not logged In!"
        } else {
            if (params.size > 1) {
                if (s.withdrawBalanceTo(currentUser, params[1])) {
                    "Hey " + currentUser.userName + "\nYou successfully Withdraw " + params[1] + "\nYour Updated balance is " + s.getCurrentUser()?.balance
                } else {
                    "Try Again?"
                }
            } else {
                "Wrong Input Withdraw Amount Is Required."
            }

        }

    }
}
