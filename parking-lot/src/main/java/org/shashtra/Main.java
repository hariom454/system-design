package org.shashtra;

import java.util.ArrayList;
import java.util.List;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.factories.ParkingStrategyFactory;
import org.shashtra.models.Floor;
import org.shashtra.models.ParkingLot;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.models.VehicleType;
import org.shashtra.repository.TicketRepository;
import org.shashtra.services.ParkingService;
import org.shashtra.services.TicketService;
import org.shashtra.strategies.BikeParkingStrategy;
import org.shashtra.strategies.BusParkingStrategy;
import org.shashtra.strategies.ParkingChargeStrategy;
import org.shashtra.strategies.SUVParkingStrategy;

public class Main {
  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot(1, new ArrayList<>());
    TicketRepository ticketRepository = new TicketRepository();
    addFloors(parkingLot);
    List<ParkingChargeStrategy> strategies =
        List.of(new BikeParkingStrategy(), new BusParkingStrategy(), new SUVParkingStrategy());
    ParkingService parkingService =
        new ParkingService(
            parkingLot,
            new TicketService(ticketRepository, new ParkingStrategyFactory(strategies)));

    Vehicle bike = new Vehicle("UP84E3967", VehicleType.BIKE);
    Vehicle bike2 = new Vehicle("UP84E3967", VehicleType.BIKE);
    Vehicle bus = new Vehicle("UP84E3968", VehicleType.BUS);
    Vehicle suv = new Vehicle("UP84E3969", VehicleType.SUV);

    try {
      Ticket ticket = parkingService.parkVehicle(bike);
      System.out.println("Parked successfully, ticked: " + ticket);
      parkingService.parkVehicle(bike2);
      parkingService.parkVehicle(bus);
      parkingService.parkVehicle(bus);
      parkingService.parkVehicle(bus);
      parkingService.parkVehicle(suv);
      parkingLot.getParkedVehicles();
      Thread.sleep(500);

      Ticket charges = parkingService.unparkVehicle(ticket.getId());
      System.out.println("Final receipt: " + charges);
    } catch (Exception ex) {
      System.err.println("error: " + ex.getMessage());
    }

    try {
      // only 3 slots for bus, this should throw error
      parkingService.parkVehicle(bus);
    } catch (NotFoundException e) {
      e.printStackTrace();
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
    Floor floor = new Floor(1, id);

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
    return new Slot(String.format("%s-%s-%s", type.name(), floorId, number), floorId, type);
  }
}
