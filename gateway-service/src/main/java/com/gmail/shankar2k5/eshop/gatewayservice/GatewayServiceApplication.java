package com.gmail.shankar2k5.eshop.gatewayservice;

import com.gmail.shankar2k5.eshop.gatewayservice.filter.PreFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(/* scanBasePackages = "com.gmail.shankar2k5.eshop.gatewayservice" */)
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	PreFilter preFilter() {
		return new PreFilter();
	}

}
