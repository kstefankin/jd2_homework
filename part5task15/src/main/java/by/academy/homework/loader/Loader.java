package by.academy.homework.loader;


import by.academy.homework.pojos.*;
import by.academy.homework.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Loader {
    public static void main(String[] args) throws Exception{


        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");




        Manager1 manager1=context.getBean("manager1",Manager1.class);
        Worker1 worker1=context.getBean("worker1",Worker1.class);

        manager1.setName("Vladimir");
        manager1.setSurname("Potapov");
        manager1.setOtdel("ved");
        manager1.setDolzhnoct("specialist");

        worker1.setName("Ivan");
        worker1.setSurname("Petrov");
        worker1.setRazryad("4");
        worker1.setCeh("liteyka");

        Manager1 manager2=context.getBean("manager1",Manager1.class);
        Worker1 worker2=context.getBean("worker1",Worker1.class);

        manager2.setName("Dmitr");
        manager2.setSurname("Smirnov");
        manager2.setOtdel("buh");
        manager2.setDolzhnoct("ved_specialist");

        worker2.setName("Tolik");
        worker2.setSurname("Bolik");
        worker2.setRazryad("3");
        worker2.setCeh("slesar");


        MyService d= context.getBean("myService", MyService.class);

        d.add(manager1);
        d.add(worker1);
        d.delete(manager1);
        d.add(manager2);
        d.add(worker2);













    }


}
