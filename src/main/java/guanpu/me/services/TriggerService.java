package guanpu.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TriggerService {
    @Autowired
    FileLoader fileLoader;

    @PostConstruct
    public void init() {
        fileLoader.load();
    }
}
