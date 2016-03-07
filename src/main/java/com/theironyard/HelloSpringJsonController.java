package com.theironyard;//Created by KevinBozic on 3/7/16.

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // returns json instead of mustache template
public class HelloSpringJsonController {
    @RequestMapping(path = "/person.json", method = RequestMethod.GET)
    public Person jsonHome() {
        return new Person("Alice", "Charleston", 30);
    }
}
