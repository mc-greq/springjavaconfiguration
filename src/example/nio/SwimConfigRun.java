package example.nio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimConfigRun {

    public static void main(String[] args) {

        // use spring config class to create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);

        // retrieve beans from the container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(theCoach.getDailyWorkOut());
        System.out.println(theCoach.getDailyFortune());

        // calling swimcoach methods
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());

        context.close();
    }
}
