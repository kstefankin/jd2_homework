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
public class Worker1 {


    @Id
    @GeneratedValue
    private Integer id;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCeh(String ceh) {
        this.ceh = ceh;
    }

    public void setRazryad(String razryad) {
        this.razryad = razryad;
    }

    @Column
    private String name;
    @Column
    private String surname;




    @Column
    private String ceh;
    @Column
    private String razryad;


    public Worker1(String name, String surname, String ceh, String razryad) {
        this.name=name;
        this.surname=surname;
        this.ceh=ceh;
        this.razryad=razryad;

    }
}