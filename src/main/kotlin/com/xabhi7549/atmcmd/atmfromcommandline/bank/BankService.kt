/*
 * Copyright (c) 2023.
 *
 * This is created/owned by XABHI7549
 * https://github.com/xabhi7549
 */

package com.xabhi7549.atmcmd.atmfromcommandline.bank

import com.xabhi7549.atmcmd.atmfromcommandline.bank.customer.User
import com.xabhi7549.atmcmd.atmfromcommandline.utils.MyUtils
import org.springframework.stereotype.Service

@Service
class BankService(val myUtils: MyUtils) {

    private val allUsers = HashMap<String, User>()

    private var currentUser: User? = null

    fun login(userName: String): User {
        currentUser = allUsers.getOrPut(userName) { User(userName, 0) }
        return currentUser as User
    }

    fun getCurrentUser(): User? {
        return currentUser
    }

    private fun getUser(userName: String): User? {
        return allUsers[userName]
    }

    fun depositBalanceTo(currentUser: User, amount: String): Boolean {
        return try {
            allUsers[currentUser.userName]?.balance = amount.toInt() + currentUser.balance
            true
        } catch (e: Exception) {
            myUtils.getLogger().error("Please deposit numerical value.")
            false
        }


    }

    fun withdrawBalanceTo(currentUser: User, amount: String): Boolean {
        return try {
            val withdrawAmount = amount.toInt()
            return if (currentUser.balance < withdrawAmount) {
                myUtils.getLogger().error("Your balance is low!! \nAvailable Balance: " + currentUser.balance)
                false
            } else {
                allUsers[currentUser.userName]?.balance = currentUser.balance - withdrawAmount
                true
            }

        } catch (e: Exception) {
            myUtils.getLogger().error("Please withdraw numerical value.")
            false
        }

    }

    fun logOut() {
        currentUser = null
    }

    fun transferTo(target: String, amount: String): String {
        val targetUser = getUser(target)
        return if (targetUser != null) {
            if (withdrawBalanceTo(currentUser!!, amount) && depositBalanceTo(targetUser, amount)) {
                return "Successfully transferred!! Your Available Balance: " + currentUser?.balance
            } else {
                return "Try Again?"
            }
        } else {
            "Sorry!! user with userName $target Not Found!"
        }

    }

}