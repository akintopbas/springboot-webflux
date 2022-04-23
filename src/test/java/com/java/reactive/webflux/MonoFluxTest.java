package com.java.reactive.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("javatechie")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Spring","Spring Boot","Hibernate","MicroService")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
                .concatWithValues("Cloud")
                .log();

        fluxString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
    }
}
