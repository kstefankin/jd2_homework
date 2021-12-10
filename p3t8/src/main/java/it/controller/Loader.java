package it.controller;

import it.pojos.*;
import it.util.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Loader {
    public static void main(String[] args) throws Exception{

        Empl1 worker =new Worker1("Ivan","Petrov","liteyka","4");
        Empl1 manager =new Manager1("Vladimir","Potapov","ved","specialist");

        Empl2 worker2 =new Worker2("Serge","Bely","pokraska","3");
        Empl2 manager2 =new Manager2("Andrew","Krasny","buhgalteria","glavbuh");

        Empl3 worker3 =new Worker3("Oleg","Cherny","transportny","5");
        Empl3 manager3 =new Manager3("Kostya","Shustry","marketing","manager");


        SessionFactory sessionFactory= SessionFactoryHolder.getSessionFactory();

        Session session= sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(worker);
        session.save(manager);
        session.save(worker2);
        session.save(manager2);
        session.save(worker3);
        session.save(manager3);

        int idManager=manager.getId();
        int idworker2=worker2.getId();
        int idManager3=manager3.getId();


        session.getTransaction().commit();
        session.close();


        Session session2= sessionFactory.openSession();
        session2.getTransaction().begin();

        Manager1 nman = session2.get(Manager1.class,idManager);
        Worker2 nworker = session2.get(Worker2.class,idworker2);
        Manager3 loadedman = session2.get(Manager3.class, idManager3);

        System.out.println(nman.getName()+" "+nman.getSurname()+" "+nman.getOtdel()+" "+nman.getDolzhnoct());
        System.out.println(nworker.getName()+" "+nworker.getSurname()+" "+nworker.getCeh()+" "+nworker.getRazryad());
        System.out.println(loadedman.getName()+" "+loadedman.getSurname()+" "+loadedman.getOtdel()+" "+loadedman.getDolzhnost());

        session2.getTransaction().commit();
        session2.close();

    }


}
