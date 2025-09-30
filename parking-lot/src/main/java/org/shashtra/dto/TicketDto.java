package org.shashtra.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nullable;
import java.math.BigDecimal;
import org.shashtra.models.Vehicle;

@Serdeable
public record TicketDto(
    String id,
    Vehicle vehicle,
    String slotId,
    String parkedAt,
    @Nullable String unparkedAt,
    @Nullable BigDecimal charges) {}
