package com.trueact.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/demo")
public class demoController {

  @PostMapping(value = "/tok")
  public ResponseEntity getok(HttpServletRequest httpRequest) {
    return new ResponseEntity(HttpStatus.OK);
  }
}
