package pl.org.mensa.rp.spring.springboottest.debug.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@Controller
public class ColortestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ColortestController.class);
	
	@GetMapping("/debug/colortest")
	@ResponseBody
	public String colortest() {
		Utils.log("Color test:", logger);
		Utils.log("&11&22&33&44&55&66&77&88&99&00&aa&bb&cc&dd&ee&ff&rr", logger);
		return "colortest page";
	}
}
