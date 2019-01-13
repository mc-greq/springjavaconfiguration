package example.nio;

public class AnotherFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "This is another fortune for another coach";
    }
}
