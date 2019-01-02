package ru.job4j.generic;

public abstract class BaseStore<T extends Base> implements Store<T> {

    private SimpleArray<T> conteiner;
    private int lenght;

    public BaseStore(int size) {
        this.conteiner = new SimpleArray<>(size);
        this.lenght = size;
    }

    @Override
    public void add(T model) {
        conteiner.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < lenght; i++) {
            if (conteiner.get(i) != null && conteiner.get(i).getId().equals(id)) {
                conteiner.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < lenght; i++) {
            if (conteiner.get(i) != null && conteiner.get(i).getId().equals(id)) {
                result = conteiner.remove(i);
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < lenght; i++) {
            if (conteiner.get(i) != null && conteiner.get(i).getId().equals(id)) {
                result = conteiner.get(i);
                break;
            }
        }
        return result;
    }
}
