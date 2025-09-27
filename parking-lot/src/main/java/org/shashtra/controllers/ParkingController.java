package org.shashtra.controllers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.services.ParkingService;

@Controller
public class ParkingController {
  private ParkingService parkingService;

  public ParkingController(ParkingService parkingService) {
    this.parkingService = parkingService;
  }

  @Post("/park-vehicle")
  public Ticket parkVehicle(@Body Vehicle vehicle) throws NotFoundException {
    return parkingService.parkVehicle(vehicle);
  }

  @Post("/unpark-vehicle")
  public String unparkVehicle() {
    return "unparked";
  }
}
