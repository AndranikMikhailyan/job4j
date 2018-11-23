package ru.job4j.tracker;

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
        Item[] result = null;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null && result == null) {
                result = new Item[i];
                System.arraycopy(this.items, 0, result, 0, result.length);
            }
        }

        return result;
    }

    /**
     * Метод возвращает все заявки с именем совпадающим аргументом.
     * @param key Аргумент (Name).
     * @return result Возвращаемые заявки.
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int i = 0; i < this.items.length && this.items[i] != null; i++) {
            Item item = this.items[i];
            if (item.getName().equals(key)) {
                count++;
            }
        }
        Item[] result = new Item[count];
        int index = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[index] = item;
                index++;
            }
        }
        return result;
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
