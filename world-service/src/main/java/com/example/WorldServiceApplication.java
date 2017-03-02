package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class WorldServiceApplication {
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String helloworld(String message) {
        System.out.println("World:受け取ったよ: " + message); 
        return message + " world";
    }

	public static void main(String[] args) {
		SpringApplication.run(WorldServiceApplication.class, args);
	}
}
