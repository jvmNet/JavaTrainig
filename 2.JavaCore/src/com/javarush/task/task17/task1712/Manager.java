package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Manager {      //singleton

    private static final Object obj = new Object();
    private static volatile Manager ourInstance = null;

    private final List<Table> restaurantTables = new ArrayList<Table>(10);
    private int currentIndex = 0;

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();        // очередь с заказами
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();     // очередь с готовыми блюдами


    // custom
    public synchronized void setDishesQueue(final Dishes dishes) {
        dishesQueue.add(dishes);
    }


    public synchronized static Manager getInstance() {
        if(ourInstance == null)
            synchronized (obj) {
                if(ourInstance == null)
                    ourInstance = new Manager();
            }
        return ourInstance;
    }

    private Manager() {               // создаем 10 столов
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table());
        }
    }

    public synchronized Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
        Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    }
}
