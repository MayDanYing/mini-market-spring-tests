package ru.geekbrains.mini.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniMarketApplication {
	// Домашнее задание:
	// 1. Протестировать CRUD-операции для продуктов
	// 2. Проверить что при отправке некорректных запросов
	// backend должен выдать 400 (возможно придется где-то
	// backend подкрутить)
	// 3. Проверить корректность сообщения об ошибке
	// в случае POST/PUT запросов

	public static void main(String[] args) {
		SpringApplication.run(MiniMarketApplication.class, args);
	}
}
