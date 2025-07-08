package com.pucetec.exam2.repository

import com.pucetec.exam2.models.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : JpaRepository<Ticket, Long> {

    fun findByLicensePlateAndExitTimeIsNull(licensePlate: String): Ticket?
}