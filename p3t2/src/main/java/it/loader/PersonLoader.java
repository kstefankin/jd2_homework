package it.loader;

import it.pojos.Person;
import it.util.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PersonLoader {
    public static void main(String[] args) throws Exception {
        Person person = new Person(null, 35, "SomeFirstName", "SomeSurname");
        Person person2 = new Person(null, 55, "NewFirstName", "NewSurname");
        Person person3 = new Person(null, 77, "ThirdName", "ThirdName");

        PersonDao personDao = new PersonDao();
        personDao.savePerson(person);
        personDao.savePerson(person2);
        personDao.savePerson(person3);

        Person perFromBase = personDao.findPerson(2);
        System.out.println(perFromBase.getSurname());

        personDao.deletePerson(person);

        // task 3 flush & refresh
        Person person4 = new Person(null, 80, "Peter", "Kozak");
        Person person5 = new Person(null, 90, "Kevin", "Pozner");
        Person person6 = new Person(null, 60, "Dmitry", "Kisel");

        SessionFactory sessionFactory = SessionFactoryHolder.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(person4);
        session.save(person5);
        session.getTransaction().commit();

        session.getTransaction().begin();

        person5.setName("ChangedName");
        session.persist(person6);
        if (session.isDirty()) {
            session.flush();
        }



        session.getTransaction().commit();

        session.getTransaction().begin();
        session.refresh(person5);
        person5.setAge(120);
        session.getTransaction().commit();


        session.close();









    }

}
