package example.nio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimConfigRun {

    public static void main(String[] args) {

        // use spring config class to create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);

        // retrieve beans from the container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkOut());
        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
