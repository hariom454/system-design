package org.shashtra.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import org.shashtra.exceptions.ErrorResponse;

@Singleton
@Requires(classes = {Exception.class, ExceptionHandler.class})
public class InternalServerExHandler
    implements ExceptionHandler<Exception, HttpResponse<ErrorResponse>> {

  @Override
  public HttpResponse<ErrorResponse> handle(HttpRequest request, Exception exception) {
    return HttpResponse.serverError(
        new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), exception.getMessage()));
  }
}
