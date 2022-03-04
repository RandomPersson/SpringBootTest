package pl.org.mensa.rp.spring.springboottest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@SpringBootApplication
public class SpringBootTestApplication extends SpringBootServletInitializer {
	
	@Value("${code_debug:false}")
	private boolean debug;
	@Value("${color_debug:false}")
	private boolean color_debug;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// should run this earlier but too lazy to research how
			Utils.debug = debug;
			if (color_debug) Utils.debugPrefix = "&8[&bDEBUG&8] &r";
			
			Utils.debug("&aDebug enabled!&r", this.getClass());
			Utils.debug("&aApplication initialized, i think?&r", this.getClass());
		};
	}
	
}
