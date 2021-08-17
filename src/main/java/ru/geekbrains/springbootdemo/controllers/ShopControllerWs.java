package ru.geekbrains.springbootdemo.controllers;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.geekbrains.springbootdemo.entities.Greeting;
import ru.geekbrains.springbootdemo.entities.Message;

@Controller
public class ShopControllerWs {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting(message.getName() + " добавлен в коризну!");
    }
}
