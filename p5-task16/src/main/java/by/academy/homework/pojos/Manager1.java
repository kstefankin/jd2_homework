package by.academy.homework.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@NoArgsConstructor

@Component
@Scope("prototype")
@Entity
public class Manager1 {

    @Id
    @GeneratedValue
    private Integer id;



    @Column
    private String name;
    @Column
    private String surname;

    @Column
    private String otdel;
    @Column
    private String dolzhnoct;

    public Manager1(String name, String surname, String otdel, String dolzhnoct) {

        this.name=name;
        this.surname=surname;
        this.otdel=otdel;
        this.dolzhnoct=dolzhnoct;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public void setDolzhnoct(String dolzhnoct) {
        this.dolzhnoct = dolzhnoct;
    }


}