package by.academy.homework;

public class SimplyBean {

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    InnerBean innerBean;


    public static SimplyBean getSimplyBean(){
       return new SimplyBean();
        }

    public void init() {
        System.out.println("SimplyBean initialization");
    }
    public void destroy() {
        System.out.println("SimplyBean destroing");
    }




    public void sayHello(){
        System.out.println("Hello, i am bean!");
        }
    public void sayname(){
        innerBean.getName();
    }
}
