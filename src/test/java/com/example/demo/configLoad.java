package com.example.demo;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:config/config.properties"})
public class configLoad {
}
