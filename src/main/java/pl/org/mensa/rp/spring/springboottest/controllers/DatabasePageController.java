package pl.org.mensa.rp.spring.springboottest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabasePageController {
	
	@GetMapping("/database/")
	public String requestIndex() {
		return "database_page";
	}
}
