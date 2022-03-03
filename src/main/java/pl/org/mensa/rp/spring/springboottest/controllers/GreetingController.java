package pl.org.mensa.rp.spring.springboottest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.org.mensa.rp.spring.springboottest.json.Greeting;

@RestController
public class GreetingController {
	
	private static final String template = "Hullo, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "you") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
