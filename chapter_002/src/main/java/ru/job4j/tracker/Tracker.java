package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return id Уникальный ключ.
     */

    private String generateId() {
        return System.currentTimeMillis() + "111";
    }

    /**
     * Метод реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод заменяет заявку в хранилище.
     * @param id Ключ для поиска заменяемой заявки.
     * @param item Заменяющая заявка.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку по уникальному ключу.
     * @param id Уникальный ключ.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size() && this.items.get(i) != null; i++) {
            if (this.items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает список всех заявок.
     * @return Список всех заявок.
     */

    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод возвращает все заявки с именем совпадающим аргументом.
     * @param key Аргумент (Name).
     * @return result Возвращаемые заявки.
     */
    public List<Item> findByName(String key) {
        return this.items.stream().filter(
                item -> item != null && item.getName().equals(key))
                .collect(Collectors.toList());
    }

    /**
     * Метод находит заявку по Id.
     * @param id Id.
     * @return result Возвращаемая заявка.
     */
    public Item findById(String id) {
        return this.items.stream().filter(item -> item.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }




}
