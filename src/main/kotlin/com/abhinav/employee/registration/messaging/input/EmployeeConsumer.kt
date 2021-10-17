package com.abhinav.employee.registration.messaging.input

import com.abhinav.employee.registration.entity.Employee
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class EmployeeConsumer(private val listener: EmployeeListener) {

    @Bean
    fun employeeRegistration(): Consumer<Message<Employee>> {
        return Consumer { listener.listen(message = it) }
    }
}