package example.nio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// custom bean ID
// @Component("myTennisCoach")
// default bean ID
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

    // field injection
    // added implementation of RegularFortuneService to show use of qualifier
    // having 2 implementations of same interface we need to tell Spring which one to use
//    @Autowired
//    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String teamName;

    // default constructor, some debugging info
    public TennisCoach() {
        System.out.println(">> TennisCoach inside default constructor");
    }

    // using qualifier in a constructor is a bit different, has to be put inside passing variables
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        System.out.println(">> TennisCoach inside default constructor");
        this.fortuneService = fortuneService;
    }

    @PostConstruct
    public void doMyStrartupStuff(){
        System.out.println(">> TennisCoach: inside doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
    }

    /*
    // define setter method for injections
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }
    // if there are two methods @Autowired both will be used
    */

    // setter method for injection can have any name, just @Autowired it
    /*
    @Autowired
    public void anyMethodName(FortuneService fortuneService){
        System.out.println(">> TennisCoach: inside anyMethodName() method");
        this.fortuneService = fortuneService;
    }
    */

    @Override
    public String getDailyWorkOut() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeamName() {
        return teamName;
    }
}
