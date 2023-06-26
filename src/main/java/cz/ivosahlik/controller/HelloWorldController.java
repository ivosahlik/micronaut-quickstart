package cz.ivosahlik.controller;

import cz.ivosahlik.service.MyService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/helloworld")
public class HelloWorldController {

    @Inject
    private MyService myService;

//    private final MyService myService;
//
//    public HelloWorldController(MyService myService) {
//        this.myService = myService;
//    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return myService.helloFromService();
    }

}
