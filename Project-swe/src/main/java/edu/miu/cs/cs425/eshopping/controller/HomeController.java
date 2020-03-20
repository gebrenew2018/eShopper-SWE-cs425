package edu.miu.cs.cs425.eshopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public void loadIndex(HttpServletResponse httpResponse) throws Exception {
        //String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        //httpResponse.sendRedirect("/user/"+currentUsername);
        httpResponse.sendRedirect("/swagger-ui.html");
    }
}
