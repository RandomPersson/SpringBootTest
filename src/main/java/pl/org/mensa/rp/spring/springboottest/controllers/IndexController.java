package pl.org.mensa.rp.spring.springboottest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@RestController
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public String requestIndex() {
		return "index";
	}
	
	@GetMapping("/")
	public String getIndex() {
		return "pog";
	}
	
	@GetMapping("/colortest/")
	public String colortest() {
		Utils.log("Color test:", logger);
		Utils.log("&11&22&33&44&55&66&77&88&99&00&aa&bb&cc&dd&ee&ff&rr", logger);
		return "colortest page";
	}
}
