package it.academy.controller;

import it.academy.pojos.*;
import it.academy.util.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) throws Exception{

        Worker worker1 =new Worker ("Ivan","Petrov","liteyka","4");
        Worker worker2 =new Worker ("Stepan","Slepakov","pokraska","5");


        Manager manager1 =new Manager("Vladimir","Potapov","ved","specialist");

        Manager manager2 =new Manager("Andrew","Krasny","buhgalteria","glavbuh");

        Address ad1 = new Address("Minsk","Gikalo","3","45","220034");
        Address ad2 = new Address("Minsk","Gikalo","3","46","220034");
        Details d1 = new Details("1985",4);
        Details d2= new Details("1999",3);

        Student stud1 =new Student("Oleg","Cherny","narhoz","audit",ad1,d1);
        Student stud2 =new Student("Kostya","Shustry","bgu","managment",ad2,d2);


        SessionFactory sessionFactory = SessionFactoryHolder.getSessionFactory();

        Session session= sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(worker1);
        session.save(worker2);
        session.save(manager1);
        session.save(manager2);
        session.save(stud1);
        session.save(stud2);

        System.out.println(worker1.getId()+"  "+ worker2.getId());
        System.out.println(manager1.getId()+"  "+ manager2.getId());
        System.out.println(stud1.getId()+"  "+ stud2.getId());


        session.getTransaction().commit();
        session.close();



    }


}




