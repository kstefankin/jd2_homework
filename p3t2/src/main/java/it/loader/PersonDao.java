package it.loader;

import it.pojos.Person;
import it.util.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class PersonDao {
    private final SessionFactory sessionFactory;

    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        //Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return person.getId();
    }

    public Person findPerson(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        Person person =null;
        try {
            tr = session.beginTransaction();
            person=session.get(Person.class,id);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return person;
    }


    public void deletePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public List<Person> getAllPersons() {
        Session session = sessionFactory.openSession();
        List<Person> personList =
                session.createQuery("from Person", Person.class).list();
        session.close();
        return personList;
    }



}






