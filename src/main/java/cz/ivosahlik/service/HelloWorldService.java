package cz.ivosahlik.service;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Primary
@Singleton
public class HelloWorldService implements MyService {

    @Override
    public String helloFromService() {
        return "Hello World!";
    }
}
