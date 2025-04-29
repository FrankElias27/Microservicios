package com.stech.mcc_notification_service.service;

import com.stech.mcc_notification_service.event.CreditDisbursementEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class NotificationService {

    private JavaMailSender mailSender;

    public void sendNotification(CreditDisbursementEvent creditDisbursementEvent) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("frankmascco@gmail.com");
            messageHelper.setTo(creditDisbursementEvent.getEmail());
            messageHelper.setSubject("Notification Service");
            messageHelper.setText("Dear Customer, your credit disbursement of S/ " + creditDisbursementEvent.getAmount()
                    + " has been successfully completed.");
            log.info("send notification");
        };
        try {
            mailSender.send(messagePreparator);
        }catch (Exception e) {
            log.error("Error sending notification", e);
            throw new RuntimeException(e);
        }
    }
}

