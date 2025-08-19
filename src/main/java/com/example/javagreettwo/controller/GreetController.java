package com.example.javagreettwo.controller;

import com.example.javagreettwo.entity.Greet;
import com.example.javagreettwo.entity.Person;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {

  private static final String template = "Hola, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping
  @ResponseBody
  public Greet getPersonalizedGreet(@RequestParam(name = "name", required = false) String name) {
    String greet = String.format(template, (name != null) ? name : "mundo");
    return new Greet(counter.incrementAndGet(), greet);
  }

  @PostMapping
  @ResponseBody
  public Greet postPersonalizedGreet(@RequestBody(required = false) Person person) {
    String greet = String.format(template, (person != null) ? person.getName() : "mundo");
    return new Greet(counter.incrementAndGet(), greet);
  }


}
