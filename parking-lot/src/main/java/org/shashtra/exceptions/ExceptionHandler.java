package org.shashtra.exceptions;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Error;
import jakarta.inject.Singleton;

@Singleton
public class ExceptionHandler {

  @Error(global = true)
  public HttpResponse<ErrorResponse> handleNotFound(NotFoundException ex) {
    return HttpResponse.notFound(
        new ErrorResponse(HttpStatus.NOT_FOUND.toString(), ex.getMessage()));
  }
}
