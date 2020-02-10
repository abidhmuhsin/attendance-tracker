package com.abidh.attendance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

   @ResponseBody
   @RequestMapping(method = RequestMethod.GET, produces = "application/json")
   public String demo() {

       return "{\"hello\":\"world\"}";

   }
   
}

