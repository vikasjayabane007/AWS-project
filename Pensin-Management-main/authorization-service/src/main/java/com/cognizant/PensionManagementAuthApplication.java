package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PensionManagementAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionManagementAuthApplication.class, args);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		MyFilter myFilter = new MyFilter();
		filterRegistrationBean.setFilter(myFilter);
		return filterRegistrationBean;
	}

}
