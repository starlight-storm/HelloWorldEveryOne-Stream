package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableBinding(Source.class)
public class HelloServiceApplication {
	private final Source source;

	public HelloServiceApplication(Source source) {
		this.source = source;
	}

	@GetMapping
	public void send() {
		source.output().send(MessageBuilder.withPayload("hello").build());
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}
}
