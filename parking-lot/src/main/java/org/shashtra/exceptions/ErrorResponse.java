package org.shashtra.exceptions;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ErrorResponse(String type, String message) {}
