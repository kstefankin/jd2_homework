package it.academy.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor

@Entity
public class Manager {

    @Id
    @GenericGenerator(name = "uuid_generator",strategy = "uuid")  // add uuid generator
    @GeneratedValue(generator = "uuid_generator")
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String department;

    @Column
    private String dolzn;

    public Manager (String name, String surname, String department, String dolzn) {
        this.name=name;
        this.surname=surname;
        this.department=department;
        this.dolzn=dolzn;

    }
}
