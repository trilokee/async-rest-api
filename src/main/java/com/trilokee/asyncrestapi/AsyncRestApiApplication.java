package com.trilokee.asyncrestapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class AsyncRestApiApplication {

	public Flux<String> nameFlux(){
		return Flux.fromIterable(List.of("trilokee","ruchi","bhai"));
		
	}
	public Mono<String> nameMono(){
		return Mono.just("test");
		
	}
	public static void main(String[] args) {
		SpringApplication.run(AsyncRestApiApplication.class, args);
		AsyncRestApiApplication asyncRestApiApplication=new AsyncRestApiApplication();
//		asyncRestApiApplication.nameFlux().log().subscribe(name->{
//			System.out.println("name is >"+name);
//		});
		asyncRestApiApplication.nameFlux().log().subscribe(System.out::println);
		asyncRestApiApplication.nameMono().log().subscribe(System.out::println);
		System.out.println("projeclt reactor");
		
	}

}
