package vod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class VodConfig {
    @Bean
    String foo() { return new String("bar"); }
}
