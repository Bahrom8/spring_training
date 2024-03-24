package bean_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class StringConfig {

    @Bean
    public String Cydeo(){
        return "Welcome Cydeo";
    }

    @Bean
    public String Practice(){
        return "Spring Core Practice";
    }


}
