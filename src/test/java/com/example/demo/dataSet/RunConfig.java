package com.example.demo.dataSet;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class RunConfig {
        @Value("${app.baseurl}")
        private String baseurl;
}
