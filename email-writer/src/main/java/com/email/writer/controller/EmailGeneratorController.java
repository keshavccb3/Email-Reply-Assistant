package com.email.writer.controller;

import com.email.writer.model.EmailRequest;
import com.email.writer.service.EmailGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailGeneratorController {

    @Autowired
    private EmailGeneratorService emailGeneratorService;

    @GetMapping("/")
    public String homePage(Model m) {
        m.addAttribute("emailRequest", new EmailRequest());
        return "index";
    }

    @PostMapping("/generate")
    public String generateEmail(@ModelAttribute EmailRequest emailRequest, Model model) {
        String reply = emailGeneratorService.generateEmailReply(emailRequest);
        model.addAttribute("emailRequest", emailRequest);
        model.addAttribute("response", reply);
        return "index";
    }
}
