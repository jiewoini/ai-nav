package com.aipcyes.ainav;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aipcyes.ainav.mapper")
public class AiNavApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiNavApplication.class, args);
	}

}
