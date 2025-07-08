package com.pucetec.exam2.controller

import com.pucetec.exam2.models.Ticket
import com.pucetec.exam2.service.TicketService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tickets")
class TicketController(private val ticketService: TicketService) {

    @PostMapping("/start")
    fun startTicket(@RequestParam plate: String): Ticket =
        ticketService.startTicket(plate)

    @PostMapping("/end")
    fun endTicket(@RequestParam plate: String): Ticket? =
        ticketService.endTicket(plate)
}