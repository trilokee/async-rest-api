package com.trilokee.asyncrestapi;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	@Test
	public void testMono() {
		Mono<?> monostr=Mono.just("reactive")
				.then(Mono.error(new RuntimeException("got some error ")))
				.log();
		monostr.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
		
	}
	
	@Test
	public void testFlux() {
		Flux<String> monostr=Flux.just("reactive","programming","react","angular")
				.concatWithValues("restapi")
				.concatWith(Flux.error(new RuntimeException("got some error ")))
				.log();
		monostr.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
		
	}
}
