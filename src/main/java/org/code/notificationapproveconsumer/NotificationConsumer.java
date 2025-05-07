package org.code.notificationapproveconsumer;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class NotificationConsumer {

  private final EmailService emailService;

  public NotificationConsumer(EmailService emailService) {
    this.emailService = emailService;
  }


  @RabbitListener(queues = "notification-queue")
  public void consume(String message) throws IOException {
    System.out.println("Mensagem recebida: " + message);
    emailService.sendEmail("thiagodasilvamachadoo44@gmail.com", "Notificação de Aprovação", message);
  }
}
