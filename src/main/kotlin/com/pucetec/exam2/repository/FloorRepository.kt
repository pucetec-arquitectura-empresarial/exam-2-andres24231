package com.pucetec.exam2.repository

import com.pucetec.exam2.models.Floor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FloorRepository : JpaRepository<Floor, Long> {

    fun findByFloorNumber(floorNumber: Int): Floor?
}