package com.pucetec.exam2.services

import com.pucetec.exam2.models.Ticket
import com.pucetec.exam2.repository.TicketRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class TicketService(
    private val ticketRepository: TicketRepository
) {

    fun startTicket(licensePlate: String): Ticket {
        val entryTime = LocalDateTime.now()
        val ticket = Ticket(
            licensePlate = licensePlate,
            entryTime = entryTime
        )
        return ticketRepository.save(ticket)
    }

    fun endTicket(licensePlate: String): Ticket? {
        val ticket = ticketRepository.findByLicensePlateAndExitTimeIsNull(licensePlate) ?: return null
        ticket.exitTime = LocalDateTime.now()
        ticket.totalCost = calculateCost(ticket.entryTime, ticket.exitTime!!)
        return ticketRepository.save(ticket)
    }

    private fun calculateCost(entry: LocalDateTime, exit: LocalDateTime): Double {
        val minutes = java.time.Duration.between(entry, exit).toMinutes()
        return (minutes * 0.10) // Ejemplo: $0.10 por minuto
    }
}