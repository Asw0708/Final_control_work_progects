package ru.geekbrains_studies.Infrastructure.DB;

public interface Db<T> {
    void save(T entity);
    T load();
}
