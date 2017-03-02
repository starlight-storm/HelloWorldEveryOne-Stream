package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EveryoneServiceApplication {
	
	@StreamListener(Sink.INPUT)
    public void print(String message) {
        System.out.println("EveryOne 受け取ったよ: " + message);
    }

	public static void main(String[] args) {
		SpringApplication.run(EveryoneServiceApplication.class, args);
	}
}
