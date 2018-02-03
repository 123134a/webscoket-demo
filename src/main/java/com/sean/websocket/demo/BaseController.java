package com.sean.websocket.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * samples.websocket.tomcat
 *
 * @author Sean
 * @time 2018/2/3
 */
@RestController
@RequestMapping("/test")
public class BaseController {

  @GetMapping("/get")
  public Boolean get() {
    return true;
  }
}
