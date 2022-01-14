package by.academy.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SimplyBean sb=context.getBean("simplyBean",SimplyBean.class);
        sb.sayHello();

        sb.sayname();
        ((ClassPathXmlApplicationContext) context).close();

    }
}