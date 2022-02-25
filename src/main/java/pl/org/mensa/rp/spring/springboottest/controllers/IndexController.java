package pl.org.mensa.rp.spring.springboottest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@RestController
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping("/")
	public String index() {
		Utils.log("Test", logger);
		return "pog";
	}
	
	@GetMapping("/database/")
	public String database() {
		
		return "database page";
	}
	
	@GetMapping("/colortest/")
	public String colortest() {
		Utils.log("Color test:", logger);
		Utils.log("&11&22&33&44&55&66&77&88&99&00&aa&bb&cc&dd&ee&ff&rr", logger);
		return "colortest page";
	}
}
