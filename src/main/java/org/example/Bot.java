package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


    public String answer = "Приветствую тебя! Я бот-сонник . " +
            "Напиши, что тебе приснилось, и я расскажу, к чему снятся такие сны.";


    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        String userName = getUserName(msg);
        Long userId = user.getId();
        System.out.println(user.getFirstName() + " wrote " + msg.getText() + userName);


    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "MiskFredeRofl";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    /**
     * Формирование имени пользователя
     *
     * @param msg сообщение
     */
    String getUserName(Message msg) {
        User user = msg.getFrom();
        String userName = user.getUserName();
        return (userName != null) ? userName : String.format("%s %s", user.getLastName(), user.getFirstName());
    }

    @Override
    public String getBotToken() {
        return "6207924449:AAFub2RDRghO3WtZnzqWB0OXRib-bq9VlKM";
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    public void SendImg(Long who, String file, String capt) {
        InputFile input = new InputFile(file);
        SendPhoto msg1 = SendPhoto.builder()
                .chatId(who.toString())
                .photo(input)
                .caption(capt).build();
        try {
            execute(msg1);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
