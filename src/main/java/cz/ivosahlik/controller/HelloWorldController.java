package cz.ivosahlik.controller;

import cz.ivosahlik.service.MyService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/helloworld")
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @Inject
    private MyService myService;

//    private final MyService myService;
//
//    public HelloWorldController(MyService myService) {
//        this.myService = myService;
//    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        LOG.debug("Called the hello World API.");
        return myService.helloFromService();
    }

}
