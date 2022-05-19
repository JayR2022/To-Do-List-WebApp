package com.jr.tdl.main.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class AppConfig {

	@Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
	
}
