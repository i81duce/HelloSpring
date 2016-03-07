package com.theironyard;//Created by KevinBozic on 3/7/16.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

// tells spring this is a controller
@Controller
public class HelloSpringController {
    User user = null;

    @RequestMapping(path = "/person", method = RequestMethod.GET) // defines the name of route. ITC, same as spark.get
    public String person(Model model, String name, String city, int age) {
        Person p = new Person(name, city, age);
        model.addAttribute("person", p); // mustache
        return "person";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName")); // userName matches the mustache in html
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }
}
