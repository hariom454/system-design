package org.shashtra.controllers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import org.shashtra.dto.TicketDto;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Vehicle;
import org.shashtra.services.ParkingService;

@Controller("/parking")
public class ParkingController {
  private final ParkingService parkingService;

  public ParkingController(ParkingService parkingService) {
    this.parkingService = parkingService;
  }

  @Post("/vehicle")
  public TicketDto parkVehicle(@Body Vehicle vehicle) throws NotFoundException {
    return parkingService.parkVehicle(vehicle).ticketDto();
  }

  @Delete("/vehicle/{ticketId}")
  public TicketDto unparkVehicle(@PathVariable String ticketId) throws NotFoundException {
    return parkingService.unparkVehicle(ticketId).ticketDto();
  }
}
