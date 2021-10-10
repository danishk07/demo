package com.caching.boot;

import com.caching.config.CachingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
@EnableCaching
public class CachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingApplication.class, args);
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CachingConfig.class);
		
		CachingConfig cc= ctx.getBean("cachingConfig",CachingConfig.class);
		
		cc.demo();
		cc.demo1();
	}

}
