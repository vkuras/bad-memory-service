package app.controller;

import app.dtos.CountDownDTO;
import app.service.CountDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountDownController {
    @Autowired
    private CountDownService countDownService;
    @GetMapping("/countDown/{number}")
    public CountDownDTO countDown(@PathVariable Integer number) {
        return countDownService.countDown(number);
    }
}
