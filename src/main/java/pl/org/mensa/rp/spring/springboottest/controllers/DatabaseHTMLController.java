package pl.org.mensa.rp.spring.springboottest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@Controller
public class DatabaseHTMLController {
	
	@GetMapping("/database")
	public String getPersonDatabase() {
		Utils.debug("Received /database/ GET request", this.getClass());
		
		return "database";
	}
}
