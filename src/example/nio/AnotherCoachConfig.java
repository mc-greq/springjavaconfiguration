package example.nio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherCoachConfig {

    @Bean
    public FortuneService anotherFortuneService(){
        return new AnotherFortuneService();
    }

    @Bean
    public Coach anotherCoach(){
        return new AnotherCoach(anotherFortuneService());
    }
}
