package com.example.demo.dataSet;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class RunConfig {
        @Value("${app.baseurl}")
        private String baseurl;

        @Value("${app.emailId}")
        private String userEmailId;

        @Value("${app.password}")
        private String userPassword;

        @Value("${app.recipient.emailId}")
        private String recipientEmailId;

        @Value("${app.email.subject}")
        private String userEmailSub;

        @Value("${app.email.msgBody}")
        private String userMessage;
}
