package org.code.notificationapproveconsumer.consumer;

import org.code.notificationapproveconsumer.service.*;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class NotificationConsumer {

  private final EmailService emailService;

  @Value("${email.to}")
  private String emailAddress;

  public NotificationConsumer(EmailService emailService) {
    this.emailService = emailService;
  }


  @RabbitListener(queues = "notification-queue")
  public void consume(String message) throws IOException {
    emailService.sendEmail(emailAddress, "Notificação de Aprovação", message);
  }
}
