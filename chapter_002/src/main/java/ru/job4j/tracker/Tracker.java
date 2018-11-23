package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return id Уникальный ключ.
     */

    private String generateId() {
        String id = System.currentTimeMillis() + "111";
        return id;
    }

    /**
     * Метод реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод заменяет заявку в хранилище.
     * @param id Ключ для поиска заменяемой заявки.
     * @param item Заменяющая заявка.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                break;
            }
        }
    }

    /**
     * Метод удаляет заявку по уникальному ключу.
     * @param id Уникальный ключ.
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - 1);
                this.position--;
                break;
            }
        }
    }

    /**
     * Метод возвращает список всех заявок.
     * @return Список всех заявок.
     */

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод возвращает все заявки с именем совпадающим аргументом.
     * @param key Аргумент (Name).
     * @return result Возвращаемые заявки.
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] temp = new Item[position];
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                temp[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    /**
     * Метод находит заявку по Id.
     * @param id Id.
     * @return result Возвращаемая заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item :  this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }




}
