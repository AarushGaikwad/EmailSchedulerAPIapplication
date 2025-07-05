package com.example.emailSchedulerAPI.scheduler;

import com.example.emailSchedulerAPI.service.EmailService;
import com.example.emailSchedulerAPI.service.ExternalApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledEmailTask {

    private final EmailService emailService;
    private final ExternalApiService externalApiService;

    @Scheduled(cron = "0 */5 * * * *")
    public void sendEmailTask(){
        String data = externalApiService.fetchData();
        String subject = "Scheduled Report";
        String body = "Here is your scheduled API data:\n\n" + data;

        emailService.sendEmail("recipient@example.com", subject, body);
    }

    @Scheduled(cron = "0 * * * * *")
    public void logHeartBeat(){
        System.out.println("Heartbeat - " + System.currentTimeMillis());
    }

}

