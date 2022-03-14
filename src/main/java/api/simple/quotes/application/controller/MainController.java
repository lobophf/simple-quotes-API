package api.simple.quotes.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class MainController {

    @GetMapping
    public String getRandomQuote() {
      return "hello world";
    }
}
