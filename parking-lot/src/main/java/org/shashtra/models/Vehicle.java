package org.shashtra.models;

import io.micronaut.serde.annotation.Serdeable;

/*
Vehicle Representation for testing purpose
Parking system just need few details regarding vehicle
 */
@Serdeable
public record Vehicle(String id, VehicleType vehicleType) {}
