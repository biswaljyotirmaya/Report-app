package com.jb.reportapp.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String to, String subject, String content, File file) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            if (file != null) {
                helper.addAttachment(file.getName(), file);
            }
            javaMailSender.send(message);
            System.out.println("Mail sent successfully");

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}