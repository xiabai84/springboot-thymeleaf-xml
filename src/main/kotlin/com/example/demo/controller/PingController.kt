package com.example.demo.controller

import com.example.demo.model.Company
import com.example.demo.util.XmlConverter
import com.example.demo.model.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class PingController(val xmlConverter: XmlConverter) {

    @GetMapping("/person")
    @ResponseBody
    @Throws(Exception::class)
    fun getPersonXml(): String {
        val data = Person(response = "my-person-test")
        return xmlConverter.buildSOAP("person", "person/person-details", data)
    }

    @GetMapping("/company")
    @ResponseBody
    @Throws(Exception::class)
    fun getCompanyXml(): String {
        val data = Company(address = "my-company-test")
        return xmlConverter.buildSOAP("company", "company/company-details", data)
    }
}