package com.ddd.justeatit.web;

import com.ddd.justeatit.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    private UsersService usersService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", usersService.findAllDesc());
        return "main";
    }
}
