package com.example.demo.controller

import com.example.demo.db.LiveDB
import com.example.demo.model.Customer

class UserManger() {
    companion object {


        public fun createCustomer(inputCustomer: Customer) {
            //  listOfCustomers.add(inputCustomer)

            LiveDB.dabaseSaticObj.listOfCustomers.add(inputCustomer)
        }

        public fun updateUser(inputCustomer: Customer) {
            //  listOfCustomers.add(inputCustomer)
            removeCustomer(inputCustomer)
            createCustomer(inputCustomer)
        }

        public fun removeCustomer(inputCustomer: Customer) {
            LiveDB.dabaseSaticObj.listOfCustomers.remove(inputCustomer)
        }

        public fun findCustomerById(cusomterId: String): Customer? {
            val found = LiveDB.dabaseSaticObj.listOfCustomers.firstOrNull { it.userName == cusomterId }
            return found

        }

    }
}
