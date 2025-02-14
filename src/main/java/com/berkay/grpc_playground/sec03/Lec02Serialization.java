package com.berkay.grpc_playground.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {

    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {

        var person = com.berkay.models.sec03.Person.newBuilder()
                .setLastName("sam")
                .setAge(12)
                .setEmail("sam@gmail.com")
                .setEmployed(false)
                .setSalary(1000.2345)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        serialize(person);
        log.info("{}", deserialize());
        log.info("equals: {}", person.equals(deserialize()));
        log.info("bytes length: {}", person.toByteArray().length);
    }

    public static void serialize(com.berkay.models.sec03.Person person) throws IOException {
        try(var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
        //person.writeTo(Files.newOutputStream(PATH));
    }

    public static com.berkay.models.sec03.Person deserialize() throws IOException {
        try(var stream = Files.newInputStream(PATH)){
            return com.berkay.models.sec03.Person.parseFrom(stream);
        }
        //return Person.parseFrom(Files.newInputStream(PATH));
    }

}