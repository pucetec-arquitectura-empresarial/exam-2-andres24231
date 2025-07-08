package com.pucetec.exam2.controller

import com.pucetec.exam2.models.ParkingSpot
import com.pucetec.exam2.service.ParkingSpotService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(ParkingSpotController::class)
class ParkingSpotControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var parkingSpotService: ParkingSpotService

    // Datos de prueba
    private val spot = ParkingSpot(id = 1, spotNumber = 101, occupied = false, floorId = 1)

    @Test
    fun `debería obtener un espacio por ID`() {
        // Simular comportamiento del servicio
        `when`(parkingSpotService.getSpotById(1)).thenReturn(Optional.of(spot))

        // Hacer la petición GET
        mockMvc.perform(get("/api/parking-spots/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.spotNumber").value(101))
    }

    @Test
    fun `debería devolver 404 si no encuentra el espacio`() {
        // Simular que no hay datos
        `when`(parkingSpotService.getSpotById(999)).thenReturn(Optional.empty())

        // Hacer la petición GET
        mockMvc.perform(get("/api/parking-spots/999"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `debería registrar entrada de vehículo`() {
        val response = "Vehículo ABC123 estacionado en espacio ID: 1"
        `when`(parkingSpotService.enterVehicle("ABC123", 1)).thenReturn(response)

        mockMvc.perform(post("/api/parking-spots/enter")
            .param("plate", "ABC123")
            .param("floorId", "1"))
            .andExpect(status().isOk)
            .andExpect(content().string(response))
    }
}