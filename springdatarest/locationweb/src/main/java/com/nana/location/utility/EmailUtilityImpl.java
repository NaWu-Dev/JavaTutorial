package com.nana.location.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtilityImpl implements EmailUtility {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(String toAddress, String subject, String body) throws MessagingException {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(body);

        sender.send(message);

    }
}
