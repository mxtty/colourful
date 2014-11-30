package com.colourful.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller  
public class HomeController {  
     @RequestMapping("/home")  
     public String home() {  
    	 System.out.println("INSIDE HOME");
          return "home";  
     }  
     @RequestMapping("/order")  
     public String order() {  
    	 System.out.println("INSIDE ORDER");
          return "order";  
     } 
     @RequestMapping("/page/{pageNo}")  
     public String page(@PathVariable String pageNo,HttpServletRequest request, Model model) {
    	 System.out.println("PageNo: " + pageNo);
    	 request.setAttribute("pageNo", pageNo);
          return "page";  
     }  
}