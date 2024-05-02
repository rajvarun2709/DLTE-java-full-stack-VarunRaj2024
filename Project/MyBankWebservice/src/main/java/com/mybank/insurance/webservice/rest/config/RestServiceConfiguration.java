package com.mybank.insurance.webservice.rest.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class RestServiceConfiguration {
        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("application");
            messageSource.setDefaultEncoding("UTF-8");
            return messageSource;
        }
    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
    }

//http://localhost:8084/v3/api-docs
//http://localhost:7001/webservice-0.0.1-SNAPSHOT/login