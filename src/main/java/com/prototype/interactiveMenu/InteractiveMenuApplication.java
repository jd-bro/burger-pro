package com.prototype.interactiveMenu;

import com.prototype.interactiveMenu.model.CarDetails;
import com.prototype.interactiveMenu.model.Item;
import com.prototype.interactiveMenu.model.Order;
import com.prototype.interactiveMenu.services.OrderFoodImpl;
import com.prototype.interactiveMenu.services.bots.TelegramNotifyBot;
import org.checkerframework.checker.units.qual.C;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;

@SpringBootApplication
public class InteractiveMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteractiveMenuApplication.class, args);
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new TelegramNotifyBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		test();
	}

	private static void test() {
		Item item1 = new Item();
		item1.setId(5);
		item1.setItemName("Burger");
		item1.setItemPrice(1.5);
		item1.setItemDescription("Juicy Burger");
		item1.setItemQuantity("1 Pc");
		Item item2 = new Item();
		item2.setId(12);
		item2.setItemName("Strawberry Shake");
		item2.setItemQuantity("200ml");
		item2.setItemDescription("Juicy Juice");
		item2.setItemPrice(0.5);
		HashMap<Item,Integer> itemList = new HashMap<>();
		itemList.put(item1,2);
		itemList.put(item2,1);
		CarDetails carDetails = new CarDetails();
		carDetails.setColor("white");
		carDetails.setPlateNumber("1234");

		Order order = new Order(itemList,carDetails);
		OrderFoodImpl orderFood = new OrderFoodImpl();
		System.out.println(orderFood.orderFood(order));

	}

}
