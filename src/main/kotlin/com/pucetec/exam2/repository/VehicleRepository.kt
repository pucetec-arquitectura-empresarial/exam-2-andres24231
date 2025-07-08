package com.pucetec.exam2.repository

import com.pucetec.exam2.models.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository : JpaRepository<Vehicle, String>