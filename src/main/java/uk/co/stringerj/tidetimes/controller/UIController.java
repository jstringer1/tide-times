package uk.co.stringerj.tidetimes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {


  @GetMapping("/")
  public String showUI() {
    return "tidetimes";
  }

}
