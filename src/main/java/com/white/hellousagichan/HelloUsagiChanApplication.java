package com.white.hellousagichan;

import com.white.hellousagichan.publisher.UsagiMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class HelloUsagiChanApplication {
    private final UsagiMQProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(HelloUsagiChanApplication.class, args);
    }

}
