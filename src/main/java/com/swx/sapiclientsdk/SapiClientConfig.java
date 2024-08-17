package com.swx.sapiclientsdk;

import com.swx.sapiclientsdk.client.SapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("sapi.client")
@Data
@ComponentScan
public class SapiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public SapiClient sapiClient() {
        return new SapiClient(accessKey, secretKey);
    }



}
