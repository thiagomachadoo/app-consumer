package org.code.notificationapproveconsumer;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class NotificationApproveConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationApproveConsumerApplication.class, args);
  }

}
