package example.nio;

public class AnotherCoach implements Coach {

    private FortuneService fortuneService;

    public AnotherCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "This is another motivational phrase!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
