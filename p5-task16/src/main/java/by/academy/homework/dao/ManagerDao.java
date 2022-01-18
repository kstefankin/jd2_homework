package by.academy.homework.dao;



import by.academy.homework.pojos.Manager1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ManagerDao {

    private SessionFactory factory;

    @Autowired
    public ManagerDao(SessionFactory factory){
        this.factory=factory;
    }

    private Session getSession(){
        Session session=factory.openSession();
        return session;
    }


    public void add(Manager1 manager1) {
        Session session=getSession();
        Transaction transaction = session.beginTransaction();
        session.save(manager1);
        transaction.commit();
    }



}