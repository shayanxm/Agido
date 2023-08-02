package com.example.demo.db

import com.example.demo.model.Customer
import com.example.demo.model.Transaction

class LiveDB() {
    companion object {
        @JvmStatic
        lateinit var dabaseSaticObj: LiveDB
    }
    init {
        dabaseSaticObj  = this
    }
    lateinit var currentLogedinCustomer:Customer
     var listOfCustomers: ArrayList<Customer> = ArrayList()

    var listOfTransaction: ArrayList<Transaction> = ArrayList()


}