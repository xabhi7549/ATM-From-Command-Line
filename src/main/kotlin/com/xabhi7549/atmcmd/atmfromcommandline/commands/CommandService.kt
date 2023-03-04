/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.commands

import com.xabhi7549.atmcmd.atmfromcommandline.commands.commands.*
import org.springframework.stereotype.Service

@Service
class CommandService {
    val commandMap: HashMap<String, Class<out Commands>> = hashMapOf(
        Pair("login", Login::class.java),
        Pair("help", Help::class.java),
        Pair("exit", Exit::class.java),
        Pair("deposit", Deposits::class.java),
        Pair("withdraw", Withdraw::class.java),
        Pair("wmi", WhoAmI::class.java),
        Pair("transfer", Transfer::class.java),
        Pair("logout", Logout::class.java)
    )
}