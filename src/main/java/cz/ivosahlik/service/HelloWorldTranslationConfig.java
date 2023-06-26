package cz.ivosahlik.service;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldTranslationConfig {

  @NotBlank
  String getCz();

  @NotBlank
  String getEn();

}
