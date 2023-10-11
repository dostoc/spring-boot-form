package com.ripsa.springboot.form.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:index.properties"),
	@PropertySource("classpath:form.properties")
})
public class TextosPropertiesConfig {

}

