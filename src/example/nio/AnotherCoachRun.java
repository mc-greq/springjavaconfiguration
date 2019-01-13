package example.nio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnotherCoachRun {

    public static void main(String[] args) {

        // create application context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyLoggerConfig.class, AnotherCoachConfig.class);

        // retrieve beans from the context
        AnotherCoach coach = context.getBean("anotherCoach", AnotherCoach.class);

        // run some instrictions
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());

        // close the context
        context.close();
    }

}
