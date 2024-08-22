package org.example.Database;

import org.example.Entity;

import java.util.Collection;

/**
 * Интерфейс взаимодействия с БД
 */
public interface Database {
    void load();
    void save();
    Collection<Entity> getAll();
}
