package example.nio;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FromFileFortuneService implements FortuneService {

    private List<String> fortunes = new ArrayList<>();

    @PostConstruct
    public void populateFortunesFromFile(){
        System.out.println(">> FromFileFrotuneService: inside populateFortunesFromFile()");
        try(BufferedReader reader = new BufferedReader(new FileReader("fortunes.definition"))){

            String myLine;
            while ((myLine = reader.readLine()) != null){
                fortunes.add(myLine);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int randomIndex = new Random().nextInt(fortunes.size());
        return fortunes.get(randomIndex);
    }
}
