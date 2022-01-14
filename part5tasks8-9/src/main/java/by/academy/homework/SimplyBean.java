package by.academy.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SimplyBean {

    @Autowired
    @Qualifier("secondInnerBean")
    InBean inBean;

    public void sayHello(){
        System.out.println("Hello, i am  a SimplyBean!");

    }

    public void sayname(){
        inBean.getName();
    }
}
