package it.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;


public class SessionFactoryHolder {

    private static SessionFactory sessionFactory;

    static  {

     try {
         StandardServiceRegistry reg =
                 new StandardServiceRegistryBuilder()
                         .configure("hibernate.cfg.xml")
                         .build();
         sessionFactory = new MetadataSources(reg)
                 .buildMetadata()
                 .buildSessionFactory();

     } catch (Throwable e) {

         throw new ExceptionInInitializerError(e);
     }
 }
    public  static SessionFactory getSessionFactory(){
     return sessionFactory;
    }


}
