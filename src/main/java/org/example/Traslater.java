package org.example;

import org.telegram.telegrambots.meta.api.objects.Update;


public class Traslater extends Bot {

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        String userName = getUserName(msg);
        Long userId = user.getId();
        System.out.println(user.getFirstName() + " wrote " + msg.getText() + userName);
        String a = msg.getText();
        if (a.equals("/start")) {
            sendText(userId, answer);
        }
        if (a.equals("/about")) {
            String answer1 = "Пропишите  /start,чтобы я мог начать расшифровывать ваш сон." +
                    "Бот не расшифровал ваш сон? Пропишите /(не придумал команду),чтобы бот узнал о вашем сне.";
            SendImg(userId, "https://i.ibb.co/8c22RB2/sleeping.jpg", answer1);
        }
    }


}






