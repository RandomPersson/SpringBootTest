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
	
	@Value("${debug}")
	private boolean debug;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// should run this earlier but too lazy to research how
			Utils.debug = debug;
			
			Utils.debug("Debug enabled!", this.getClass());
			Utils.debug("&aApplication initialized, i think?&r", this.getClass());
		};
	}
	
}
