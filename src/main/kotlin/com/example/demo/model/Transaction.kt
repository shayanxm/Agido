package com.example.demo.model

import com.example.demo.controller.UserManger
import com.example.demo.db.LiveDB

class Transaction(
    val customerId: String,
    val transactionValue: Double
) {
    var status: Boolean = false

    fun susessfullTransaction() {
        var foundedUser = UserManger.findCustomerById(customerId)
        if (foundedUser != null) {
            UserManger.removeCustomer(foundedUser)
        }
        if (foundedUser != null) {
            if (foundedUser.gutHaben -transactionValue<0){
                status=false
            }else{

            foundedUser.gutHaben -=transactionValue
            status=true
            }
        }
        if (foundedUser != null) {
            UserManger.createCustomer(foundedUser)
        }

    }
}