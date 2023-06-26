package cz.ivosahlik.controller;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void helloWorldEndpointRespondsWithProperContent() {
        var response = httpClient.toBlocking().retrieve("/helloworld");
        assertEquals("Hello World!", response);
    }
}