package com.example.demo.backend

import com.example.demo.CreateAccount
import com.example.demo.ViewUser
import com.example.demo.controller.UserManger
import com.example.demo.db.LiveDB
import com.example.demo.model.Customer
import org.apache.catalina.User
import org.springframework.boot.availability.LivenessState
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    @PostMapping("/new")
    fun createNewUser(@RequestBody request: Customer) {

        var currentCustomer = Customer(request.userName, request.passWord)
       currentCustomer.gutHaben = request.gutHaben
        currentCustomer.firstName = request.firstName
        currentCustomer.lastName = request.lastName


        UserManger.createCustomer(inputCustomer = currentCustomer)
        println(request.userName)
    }

    @GetMapping("/all")
    fun getAll(): List<ArrayList<Customer>> {

       // if (LiveDB.dabaseSaticObj.listOfCustomers.isNotEmpty())
            return listOf( LiveDB.dabaseSaticObj.listOfCustomers)
        //catch here



    }

    @GetMapping("/hi")
    fun sayHi(): String=
        "hi"


    @GetMapping("/count")
    fun counter(): Int=
        LiveDB.dabaseSaticObj.listOfCustomers.size


}


//
//@RestController
//@RequestMapping("customers")
//class CustomController {
//    @GetMapping("get_name")
//    fun returnUserName(): String = "shayan Moradi"
//
//    @GetMapping("/all")
//    fun getAll(): Iterable<ViewUser> =
//        listOf(ViewUser(12,"shayan"))
//
//
//
//
//    @PostMapping("/m")
//    fun create(@RequestBody request: CreateAccount): ViewUser =
//        ViewUser(2,"shayan")

//}