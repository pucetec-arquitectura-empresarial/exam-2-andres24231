package com.pucetec.exam2.controller

import com.pucetec.exam2.models.ParkingSpot
import com.pucetec.exam2.service.ParkingSpotService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/parking-spots")
class ParkingSpotController(
    private val parkingSpotService: ParkingSpotService
) {

    @GetMapping
    fun getAllSpots(): List<ParkingSpot> =
        parkingSpotService.getAllSpots()

    @GetMapping("/{id}")
    fun getSpotById(@PathVariable id: Long): ResponseEntity<ParkingSpot> {
        val spot = parkingSpotService.getSpotById(id)
        return ResponseEntity.of(spot)
    }

    @PostMapping
    fun createSpot(@RequestBody spot: ParkingSpot): ParkingSpot =
        parkingSpotService.saveSpot(spot)

    @DeleteMapping("/{id}")
    fun deleteSpot(@PathVariable id: Long) {
        parkingSpotService.deleteSpot(id)
    }

    @PostMapping("/enter")
    fun enterVehicle(
        @RequestParam plate: String,
        @RequestParam floorId: Long
    ): String = parkingSpotService.enterVehicle(plate, floorId)

    @PostMapping("/exit")
    fun exitVehicle(@RequestParam plate: String): String =
        parkingSpotService.exitVehicle(plate)
}