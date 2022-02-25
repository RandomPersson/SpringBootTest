package pl.org.mensa.rp.spring.springboottest.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> data_source_builder = DataSourceBuilder.create();
		
		data_source_builder.driverClassName("com.mysql.jdbc.Driver");
		data_source_builder.url("jdbc:mysql://localhost:3306/spring_boot_test");
		data_source_builder.username("root");
		data_source_builder.password("12346");
		
		return data_source_builder.build();
	}
}
