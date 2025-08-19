package com.example.javagreettwo.controller;

import com.example.javagreettwo.entity.Greet;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
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
  public Greet personalizedGreet(@RequestParam(name = "name", required = false) String name) {
    String greet = String.format(template, (name != null) ? name : "mundo");
    return new Greet(counter.incrementAndGet(), greet);
  }


}
