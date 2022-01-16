package by.academy.homework.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DaoImpl<T> implements Dao<T>{

    private SessionFactory factory;

    @Autowired
    public DaoImpl(SessionFactory factory){
        this.factory=factory;
    }

    private Session getSession(){
        Session session=factory.openSession();
        return session;
    }




    @Override
    public void add(T t) {
    Session session=getSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
    }

    @Override
    public void delete(T t) {
        Session session=getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();

    }
}
