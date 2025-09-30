package org.shashtra.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import io.micronaut.context.annotation.Bean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.beans.beancontext.BeanContext;
import org.junit.jupiter.api.Test;

@MicronautTest
class ExceptionHandlerBeanTest {

  @Inject BeanContext context;

}

