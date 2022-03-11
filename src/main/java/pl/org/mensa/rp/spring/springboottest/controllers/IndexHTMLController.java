package pl.org.mensa.rp.spring.springboottest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@Controller
public class IndexHTMLController {
	
	@GetMapping("/")
	public String handleGetIndex() {
		Utils.debug("Received /index/ GET request", this.getClass());
		
		return "index";
	}
	
}
