package pl.org.mensa.rp.spring.springboottest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("Test");
		System.out.println(Utils.ANSIfyColors("&aColor test&0"));
		return "pog";
	}
	
	@GetMapping("/pog2/")
	public String index2() {
		return "pog2";
	}
}
