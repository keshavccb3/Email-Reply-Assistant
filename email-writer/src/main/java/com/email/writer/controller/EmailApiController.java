package com.email.writer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.writer.model.EmailRequest;
import com.email.writer.service.EmailGeneratorService;

@RestController
@CrossOrigin(origins = "*://mail.google.com/*")
@RequestMapping("/api")
public class EmailApiController {

    @Autowired
    private EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    public String generateEmail(@RequestBody EmailRequest emailRequest) {
        return emailGeneratorService.generateEmailReply(emailRequest);
    }
}

