package cz.ivosahlik.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/helloworld")
public class HelloWorldController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World!";
    }

}
