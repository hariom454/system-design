package org.shashtra;

import java.util.ArrayList;
import org.shashtra.models.Floor;
import org.shashtra.models.ParkingLot;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.models.VehicleType;
import org.shashtra.repository.TicketRepository;
import org.shashtra.services.ParkingService;
import org.shashtra.services.TicketService;

public class Main {
  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot(1, new ArrayList<>());
    TicketRepository ticketRepository = new TicketRepository();
    addFloors(parkingLot);
    ParkingService parkingService =
        new ParkingService(parkingLot, new TicketService(ticketRepository));

    Vehicle vehicle = new Vehicle("UP84E3967", VehicleType.BIKE);

    try {
      Ticket ticket = parkingService.parkVehicle(vehicle);
      System.out.println("Parked successfully, ticked: " + ticket);

      parkingLot.getParkedVehicles();

      Thread.sleep(500);

      Ticket charges = parkingService.unparkVehicle(ticket.getId());
      System.out.println("Final receipt: " + charges);
    } catch (Exception ex) {
      System.err.println("error: " + ex.getMessage());
    }

    parkingLot.getParkedVehicles();
  }

  private static void addFloors(ParkingLot parkingLot) {
    for (int i = 0; i < 3; i++) {
      Floor floor = createFloor(i);
      parkingLot.addFloor(floor);
    }
    parkingLot.displayFreeSlots();
  }

  private static Floor createFloor(int id) {
    Floor floor = new Floor(id);

    // add 5 slots for bike
    for (int i = 0; i < 3; i++) {
      Slot slot = getSlot(VehicleType.BIKE, id, i);
      floor.addSlot(slot);
    }

    // add 5 slots for SUV
    for (int i = 0; i < 2; i++) {
      Slot slot = getSlot(VehicleType.SUV, id, i);
      floor.addSlot(slot);
    }

    // add 2 slots for bus
    for (int i = 0; i < 1; i++) {
      Slot slot = getSlot(VehicleType.BUS, id, i);
      floor.addSlot(slot);
    }

    return floor;
  }

  private static Slot getSlot(VehicleType type, int floorId, int number) {
    return new Slot(String.format("%s-%s-%s", type.name(), floorId, number), type);
  }
}
