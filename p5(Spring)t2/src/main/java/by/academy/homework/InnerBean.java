package by.academy.homework;

public class InnerBean {

    int id;
    String name;

    public void init() {
        System.out.println("InnerBean initialization");
    }
    public void destroy() {
        System.out.println("InnerBean destroing");
    }
    public void getName(){
        System.out.println(name);
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }


}
