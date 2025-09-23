package org.shashtra.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.factories.ParkingStrategyFactory;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.models.VehicleType;
import org.shashtra.repository.TicketRepository;
import org.shashtra.utils.Utilities;

class ParkingServiceTest {

  private ParkingService parkingService;

  @BeforeEach
  void init() {
    parkingService =
        new ParkingService(
            Utilities.createParkingLotWithoutFloors(1),
            new TicketService(new TicketRepository(), new ParkingStrategyFactory()));
  }

  @Test
  void parkVehicle() throws NotFoundException {
    parkingService.parkingLot().addFloor(Utilities.createFloor(1));
    Vehicle v = Utilities.createVehicle(VehicleType.BIKE);
    Ticket t = parkingService.parkVehicle(v);
    assertNotNull(t);
    assertEquals(VehicleType.BIKE, t.getVehicleType());
    assertEquals("1", t.getSlotId());
  }

  @Test
  void unparkVehicle() {}
}
