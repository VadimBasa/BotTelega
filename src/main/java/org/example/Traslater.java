package org.example;

import org.telegram.telegrambots.meta.api.objects.Update;

public class Traslater extends Bot {


    @Override
     public void onUpdateReceived (Update update) {

        var msg = update.getMessage();
        var user = msg.getFrom();
        Long userId = user.getId();
        System.out.println("activated");
        String a = msg.getText();
        if (a.equals("Гроб")) {
            answer = "Хорошие новости - Вас ждет повышение по службе!";

            sendText(userId, answer);
        }
    }

}
