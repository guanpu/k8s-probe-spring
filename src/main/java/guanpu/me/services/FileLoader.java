package guanpu.me.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@EnableAsync
public class FileLoader {
    private String lastLine = "empty";

    @Async
    public void load() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.getClass().getResourceAsStream("/resources.txt"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = new String();
            while ((line = bufferedReader.readLine()) != null) {
                Thread.sleep(50);
                lastLine = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLastLine() {
        return lastLine;
    }
}
