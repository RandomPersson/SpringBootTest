package pl.org.mensa.rp.spring.springboottest.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/spring_boot_test");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("12346");
		
		return dataSourceBuilder.build();
	}
}
