package org.shashtra.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import org.shashtra.exceptions.ErrorResponse;
import org.shashtra.exceptions.NotFoundException;

@Produces
@Singleton
@Requires(classes = {NotFoundException.class, ExceptionHandler.class})
public class NotFoundExHandler
    implements ExceptionHandler<NotFoundException, HttpResponse<ErrorResponse>> {

  @Override
  public HttpResponse<ErrorResponse> handle(HttpRequest request, NotFoundException exception) {
    return HttpResponse.notFound(
        new ErrorResponse(HttpStatus.NOT_FOUND.name(), exception.getMessage()));
  }
}
