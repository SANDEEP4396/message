package com.microservices.message.functions;

import com.microservices.message.dto.AccountMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccountMessageDTO, AccountMessageDTO> email() {
        return accountMessageDTO ->{
          LOGGER.info("Sending email to {} at {}", accountMessageDTO.name(),accountMessageDTO.email());

          return  accountMessageDTO;
        };
    }

    @Bean
    public Function<AccountMessageDTO, Long> sms() {
        return accountMessageDTO -> {
            LOGGER.info("Account {} created successfully, sending SMS to {} at {}",accountMessageDTO.accountNumber().toString() ,accountMessageDTO.name(),accountMessageDTO.phoneNumber());
            return  accountMessageDTO.accountNumber();
        };
    }
}
