package com.abhinav.employee.registration.messaging.output

import com.abhinav.employee.registration.entity.Employee
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.Message
import org.springframework.stereotype.Service

@Service
class EmployeePublisher (private val streamBridge: StreamBridge) {

    companion object {
        const val OUTPUT_CHANNEL = "employeeRegistration-out-0"
    }

    fun publish(message: Message<Employee>) {
        streamBridge.send(OUTPUT_CHANNEL, message)
            .also { println("Producer sent: ${message.payload}") }
    }
}