package com.exampleforsb.demo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController

public class ResponseController {
    @GetMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        response.setStatus(401);

        response.setHeader("name", "choupi");

        response.getWriter().write("<h1>Hello, Response!</h1>");


    }
}