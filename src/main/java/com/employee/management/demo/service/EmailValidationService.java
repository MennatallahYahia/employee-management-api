package com.employee.management.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.regex.Pattern;

@Service
public class EmailValidationService {
    private static final Logger logger = LoggerFactory.getLogger(EmailValidationService.class);

    private final String apiKey;
    private final String apiUrl;
    private final RestClient restClient;

    public EmailValidationService(@Value("${zerobounce.api.key}") String apiKey, @Value("${zerobounce.api.url}") String apiUrl) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.restClient = RestClient.builder().baseUrl(apiUrl).build();
    }

    public boolean isValidEmail(String email) {
        logger.info("Calling ZeroBounce to validate the email");
        Map<String, String> response = restClient.get().uri(uriBuilder -> uriBuilder.queryParam("api_key", apiKey).queryParam("email", email).build()).retrieve().body(Map.class);
        if (response == null || response.get("error") != null) {
            logger.error("ZeroBounce response is null or has error {}", response);
            logger.info("Validating email via regex");
            return Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(email).matches();
        }
        logger.info("ZeroBounce response status {}", response.get("status"));
        return "valid".equalsIgnoreCase(response.get("status"));
    }
}
