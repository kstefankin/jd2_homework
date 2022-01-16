package by.academy.homework.service;


import by.academy.homework.dao.DaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class MyService<T> {

    @Autowired
    private DaoImpl<T> dao;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,timeout = 30)
    public void add(T t) {
        dao.add(t);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,timeout = 30)
    public void delete(T t) {
        dao.delete(t);

    }

}
