package com.abhinav.employee.registration.messaging.input

import com.abhinav.employee.registration.entity.Employee
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
open class EmployeeListener {

    @Bean
    fun employeeRegistration(): Consumer<Message<Employee>> {
        return Consumer { listen(message = it) }
    }

    private fun listen(message: Message<Employee>) {
        println("Consumer received: ${message.payload}")
    }
}
