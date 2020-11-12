package sani.sanispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping("hello")  // /hello로 들어오면 이 모델을 보여줌
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }
}
