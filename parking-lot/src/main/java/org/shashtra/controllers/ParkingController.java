package org.shashtra.controllers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.services.ParkingService;

@Controller("/parking")
public class ParkingController {
  private ParkingService parkingService;

  public ParkingController(ParkingService parkingService) {
    this.parkingService = parkingService;
  }

  @Post("/vehicle")
  public Ticket parkVehicle(@Body Vehicle vehicle) throws NotFoundException {
    return parkingService.parkVehicle(vehicle);
  }

  @Delete("/vehicle/{ticketId}")
  public Ticket unparkVehicle(@PathVariable String ticketId) throws NotFoundException {
    return parkingService.unparkVehicle(ticketId);
  }
}
