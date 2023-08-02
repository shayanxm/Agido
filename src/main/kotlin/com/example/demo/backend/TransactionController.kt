package com.example.demo.backend

import com.example.demo.controller.UserManger
import com.example.demo.db.LiveDB
import com.example.demo.model.Customer
import com.example.demo.model.Transaction
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("transaction")
class TransactionController {
    @PostMapping("auszahlen")
    fun reduceAmount(@RequestBody request: Transaction): String {

        var transaction = Transaction(request.customerId, request.transactionValue)
        transaction.susessfullTransaction()

        LiveDB.dabaseSaticObj.listOfTransaction.add(transaction)
        if (transaction.status == false) return "failure due low currency"
        return "success"

    }
    @PostMapping("einzahlen")
    fun increaseAmount(@RequestBody request: Transaction): String {

        var transaction = Transaction(request.customerId, -request.transactionValue)
        transaction.susessfullTransaction()

        LiveDB.dabaseSaticObj.listOfTransaction.add(transaction)
        if (transaction.status == false) return "failure due low currency"
        return "success"

    }

    @GetMapping("/all")
    fun getAll(): List<ArrayList<Transaction>> {

        // if (LiveDB.dabaseSaticObj.listOfCustomers.isNotEmpty())
        return listOf(LiveDB.dabaseSaticObj.listOfTransaction)
        //catch here


    }


}


