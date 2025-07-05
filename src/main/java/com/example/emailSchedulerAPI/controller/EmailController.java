package com.example.emailSchedulerAPI.controller;

import com.example.emailSchedulerAPI.dto.EmailRequestDTO;
import com.example.emailSchedulerAPI.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendManualEmail(@RequestBody EmailRequestDTO requestDTO){
        emailService.sendEmail(requestDTO.getTo(), requestDTO.getSubject(), requestDTO.getBody());
        return ResponseEntity.ok("Email send successfully");
    }
}
