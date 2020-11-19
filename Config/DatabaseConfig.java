package com.cred.io.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {
	
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/CRED_DB");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("123456");
  
        return dataSourceBuilder.build();
        
    }

	@Bean("DBTemplate")
	public JdbcTemplate createJdbcTemplate() {

		JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
	}

}
