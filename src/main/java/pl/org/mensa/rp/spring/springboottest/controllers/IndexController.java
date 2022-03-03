package pl.org.mensa.rp.spring.springboottest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String requestIndex() {
		return "index";
	}
	
}
