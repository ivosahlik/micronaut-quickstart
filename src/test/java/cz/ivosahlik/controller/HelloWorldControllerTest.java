package cz.ivosahlik.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.micronaut.http.HttpStatus;
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

    @Test
    void helloWorldEndpointRespondsWithProperStatusCodeAndContent() {
        var response = httpClient.toBlocking().exchange("/helloworld", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello World!", response.getBody().get());
    }

    @Test
    void helloFromConfigEndpointReturnsMessageFromConfigFile() {
        var response = httpClient.toBlocking().exchange("/helloworld/config", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello World from application.yml", response.getBody().get());
    }

    @Test
    void helloFromTranslationEndpointReturnsContentFromConfigFile() {
        var response = httpClient.toBlocking().exchange("/helloworld/translation", JsonNode.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("{\"cz\":\"Ahoj Světe\",\"en\":\"Hello World\"}", response.getBody().get().toString());
    }
}