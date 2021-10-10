package com.caching.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.caching.example.Customer;
import com.caching.example.CustomerDataService;

@Configuration
@EnableCaching
@ComponentScan("com.caching.example")
public class CachingConfig {

	@Autowired
	private CustomerDataService customerDataService;
	
    @Bean
    public CacheManager cacheManager() {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("directory"), new ConcurrentMapCache("addresses")));
        return cacheManager;
    }


	Customer customer = new Customer("Danish", "India");
	
	public String demo() {
		System.out.println("Inside demo");
		System.out.println(customerDataService.getAddress(customer));
		
		return "";
	}
	
	public String demo1() {
		System.out.println("Inside demo1");
		System.out.println(customerDataService.getAddress(customer));
		return "";
	}
	

}
