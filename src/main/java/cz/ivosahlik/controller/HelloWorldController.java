package cz.ivosahlik.controller;

import cz.ivosahlik.service.HelloWorldTranslationConfig;
import cz.ivosahlik.service.MyService;
import io.micronaut.context.annotation.Property;
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

    @Property(name = "hello.world.message")
    private  String helloWorldFromConfig;

    @Inject
    private HelloWorldTranslationConfig helloWorldTranslationConfig;

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

    @Get(uri = "/config", produces = MediaType.TEXT_PLAIN)
    public String helloConfig() {
        LOG.debug("Return Hello From Config Message: {}", helloWorldFromConfig);
        return helloWorldFromConfig;
    }

    @Get(uri = "/translation", produces = MediaType.APPLICATION_JSON)
    public HelloWorldTranslationConfig helloTranslation() {
        LOG.debug("Return Hello From Config Message: {}", helloWorldTranslationConfig.getCz());
        LOG.debug("Return Hello From Config Message: {}", helloWorldTranslationConfig.getEn());
        return helloWorldTranslationConfig;
    }

}
