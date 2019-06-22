package cn.itsource.mySecurity.configuration;

import org.springframework.beans.factory.annotation.Value;

public class DataSourceConfiguration {

	@Value("${jspring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    
}
