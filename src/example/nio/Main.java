package example.nio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // use spring config class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // retrieve beans from the container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        theCoach.getDailyFortune();

        context.close();
    }
}
