package com.abhinav.employee.registration.messaging.input

import com.abhinav.employee.registration.entity.Employee
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
open class EmployeeListener {

    fun listen(message: Message<Employee>) {
        println("Consumer received: ${message.payload}")
    }
}
