package com.pucetec.exam2.controller

import com.pucetec.exam2.models.Floor
import com.pucetec.exam2.service.FloorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/floors")
class FloorController(
    private val floorService: FloorService
) {

    @GetMapping
    fun getAllFloors(): List<Floor> =
        floorService.getAllFloors()

    @GetMapping("/{id}")
    fun getFloorById(@PathVariable id: Long): ResponseEntity<Floor> {
        val floor = floorService.getFloorById(id)
        return ResponseEntity.of(floor)
    }

    @PostMapping
    fun createFloor(@RequestBody floor: Floor): Floor =
        floorService.saveFloor(floor)

    @DeleteMapping("/{id}")
    fun deleteFloor(@PathVariable id: Long) {
        floorService.deleteFloor(id)
    }
}