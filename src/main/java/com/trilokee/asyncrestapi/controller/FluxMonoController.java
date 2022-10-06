package com.trilokee.asyncrestapi.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class FluxMonoController {

	@RequestMapping(value="/flux",method = RequestMethod.GET)
    public Flux<Integer> flux(){
        return Flux.just(1,2,3)
                .log();
    }

    @GetMapping("/mono")
    public Mono<String> helloWorldMono(){
        return Mono.just("hello-world");
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Long> stream(){
        return Flux.interval(Duration.ofSeconds(3))
                .log();
    }
}
