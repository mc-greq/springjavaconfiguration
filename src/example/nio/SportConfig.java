package example.nio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("example.nio") used to define beans by scanning connected classes, here the config is done manually
@PropertySource("classpath:sadsport.properties")
public class SportConfig {

    // all the code below would have been unnecessary if we used @ComponentScan annotation
//    @Bean
//    public MyLoggerConfig myLoggerConfig(){
//        return new MyLoggerConfig();
//    }

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }

}
