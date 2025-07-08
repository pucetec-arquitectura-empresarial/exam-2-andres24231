package com.pucetec.exam2.controller

import com.pucetec.exam2.models.Vehicle
import com.pucetec.exam2.service.VehicleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vehicles")
class VehicleController(private val vehicleService: VehicleService) {

    @GetMapping
    fun getAllVehicles() = vehicleService.getAllVehicles()

    @GetMapping("/{plate}")
    fun getVehicleByPlate(@PathVariable plate: String): ResponseEntity<Vehicle> =
        ResponseEntity.of(vehicleService.getVehicleByLicensePlate(plate))

    @PostMapping
    fun createVehicle(@RequestBody vehicle: Vehicle): Vehicle =
        vehicleService.saveVehicle(vehicle)

    @DeleteMapping("/{plate}")
    fun deleteVehicle(@PathVariable plate: String) {
        vehicleService.deleteVehicle(plate)
    }
}