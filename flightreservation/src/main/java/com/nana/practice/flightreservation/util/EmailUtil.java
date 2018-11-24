package com.nana.practice.flightreservation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Value("${com.nana.practice.flightreservation.email.subject}")
    private String EMAIL_BODY;

    @Value("${com.nana.practice.flightreservation.email.body}")
    String EMAIL_SUBJECT;

    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toAddress, String filePath) {
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject(EMAIL_SUBJECT);
            mimeMessageHelper.setText(EMAIL_BODY);
            mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
