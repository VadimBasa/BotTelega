package org.example;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {



public static void main(String[] args) throws TelegramApiException {
  TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
  Traslater trc = new Traslater();

  Bot bot = new Bot();                  //We moved this line out of the register method, to access it later
  botsApi.registerBot(bot);
}



}