package org.code.notificationapproveconsumer.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;
import com.sendgrid.helpers.mail.objects.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class EmailService {

  @Value("${sendgrid.api-key}")
  private String sendGridApiKey;

  @Value("${email.from}")
  private String emailAddress;

  public void sendEmail(String to, String subject, String contentText) throws IOException {
    Email from = new Email(emailAddress);
    Email toEmail = new Email(to);
    Content content = new Content("text/plain", contentText);
    Mail mail = new Mail(from, subject, toEmail, content);

    SendGrid sg = new SendGrid(sendGridApiKey);
    Request request = new Request();

    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());

    Response response = sg.api(request);
    System.out.println("Status: " + response.getStatusCode());
    System.out.println("Body: " + response.getBody());
    System.out.println("Headers: " + response.getHeaders());
  }
}
