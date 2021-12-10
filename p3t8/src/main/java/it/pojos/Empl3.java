package it.pojos;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor



@Entity
@Table(name = "EMPLOYEE3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Empl3 {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    @Column
    private String surname;

    public Empl3(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }
}