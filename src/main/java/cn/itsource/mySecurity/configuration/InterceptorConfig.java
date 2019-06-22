package cn.itsource.mySecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.itsource.mySecurity.interceptor.AuthenticationInterceptor;
import cn.itsource.mySecurity.interceptor.SMPermissionInterceptor;
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(smPermissionInterceptor()).addPathPatterns("/**");
	}
	
	@Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
	
	@Bean
	public SMPermissionInterceptor smPermissionInterceptor() {
		return new SMPermissionInterceptor();
	}

}
