package by.academy.homework.dao;

import java.io.Serializable;

public interface Dao<T> {
    void add(T t);
    void delete (T t);

    //void  update(T t);
    //T get(Class cl, Serializable id);

}
