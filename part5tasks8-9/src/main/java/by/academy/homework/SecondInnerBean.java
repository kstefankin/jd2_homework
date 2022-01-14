package by.academy.homework;

import org.springframework.stereotype.Component;

@Component
public class SecondInnerBean implements InBean{
    int id;
    String name="second inner bean";


    public void getName(){
        System.out.println(name);
    }
    public void setId(int id){
        this.id=id;
    }


}
