package com.prototype.interactiveMenu.services;

import com.prototype.interactiveMenu.model.Order;
import com.prototype.interactiveMenu.services.bots.TelegramNotifyBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class OrderFoodImpl {
    private TelegramNotifyBot bot = new TelegramNotifyBot();
    public int orderFood(Order order){
        Update update = setUpdate(order);
        bot.onUpdateReceived(update);
        return order.getId();
    }

    private Update setUpdate(Order order) {
        Update update = new Update();
        Message message = new Message();
        message.setText(order.toString());
        message.setChat(new Chat(473483882L,"private"));
        update.setMessage(message);
        return update;
    }
}
