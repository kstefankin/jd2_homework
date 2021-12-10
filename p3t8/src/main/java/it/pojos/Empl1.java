package it.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor



@Entity @Table(name = "EMPLOYEE1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMP_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")
public class Empl1 {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    @Column
    private String surname;

    public Empl1(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }
}
