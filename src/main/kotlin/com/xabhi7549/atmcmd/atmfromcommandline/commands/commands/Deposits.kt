/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands.commands

import com.xabhi7549.atmcmd.atmfromcommandline.bank.BankService
import com.xabhi7549.atmcmd.atmfromcommandline.commands.Commands

class Deposits : Commands() {
    override fun execute(s: BankService, params: List<String>): String {
        val currentUser = s.getCurrentUser()
        return if (currentUser == null) {
            "Aaahhh... You are not logged In!"
        } else {
            if (params.size > 1) {
                if (s.depositBalanceTo(currentUser, params[1])) {
                    "Hey " + currentUser.userName + "\nYou successfully Deposited " + params[1] + "\nYour Updated balance is " + s.getCurrentUser()?.balance
                } else {
                    "Try Again?"
                }
            } else {
                "Wrong Input Deposit Amount Is Required."
            }

        }

    }


}