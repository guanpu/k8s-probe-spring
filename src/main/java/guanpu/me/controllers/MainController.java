package guanpu.me.controllers;

import guanpu.me.services.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {
    @Autowired
    FileLoader fileLoader;
    @RequestMapping("/")
    public ResponseEntity<String> home() {
        if (fileLoader.getLastLine().startsWith("last")) {
            return ResponseEntity.ok(fileLoader.getLastLine());
        }
        return ResponseEntity.badRequest().build();
    }
}
