package com.nana.location.utility;

import javax.mail.MessagingException;

public interface EmailUtility {

    void sendEmail(String toAddress, String subject, String body) throws MessagingException;

}
