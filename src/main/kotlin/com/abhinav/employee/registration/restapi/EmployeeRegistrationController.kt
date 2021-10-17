package com.abhinav.employee.registration.restapi

import com.abhinav.employee.registration.entity.Employee
import com.abhinav.employee.registration.messaging.output.EmployeePublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.integration.support.MessageBuilder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController("employees")
class EmployeeRegistrationController {

    @Autowired
    lateinit var employeePublisher: EmployeePublisher

    @PostMapping("/register")
    @ResponseBody
    fun register(@RequestBody employee: Employee): String {
        employeePublisher.publish(MessageBuilder.withPayload(employee).build())
        return "Employee Registered"
    }
}
