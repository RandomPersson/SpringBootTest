package pl.org.mensa.rp.spring.springboottest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@SpringBootApplication
public class SpringBootTestApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// init suff
			Utils.log("&aApplication initialized, i think?&r", this.getClass());
		};
	}
	
}
