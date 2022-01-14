package by.academy.homework;

import org.springframework.stereotype.Component;

@Component
public class InnerBean implements InBean {
    int id;
    String name="first inner";


    public void getName(){
        System.out.println(name);
    }
    public void setId(int id){
        this.id=id;
    }


}