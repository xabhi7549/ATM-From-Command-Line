/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
object MyUtils {
    fun getLogger(): Logger {
        return LoggerFactory.getLogger(this.javaClass)
    }
}