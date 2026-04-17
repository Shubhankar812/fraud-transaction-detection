package com.fraudDetection.Account.Service;

import com.fraudDetection.Account.DTO.customerDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerClientImpl {
    public WebClient.Builder webClient;
    public CustomerClientImpl(WebClient.Builder wcb) {
        this.webClient = wcb;
    }
    public customerDTO getCustomerWithAccount(Long id) {
        customerDTO dto = webClient.build()
                .get()
                .uri("http://CUSTOMER-SERVICE/customer/" + id)
                .retrieve()
                .bodyToMono(customerDTO.class)
                .block();


        return dto;
    }
}
