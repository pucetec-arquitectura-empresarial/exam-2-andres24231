package com.pucetec.exam2.services

import com.pucetec.exam2.models.Floor
import com.pucetec.exam2.repository.FloorRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FloorService(
    private val floorRepository: FloorRepository
) {

    fun getAllFloors(): List<Floor> = floorRepository.findAll()

    fun getFloorById(id: Long): Optional<Floor> = floorRepository.findById(id)

    fun saveFloor(floor: Floor): Floor = floorRepository.save(floor)

    fun deleteFloor(id: Long) = floorRepository.deleteById(id)
}