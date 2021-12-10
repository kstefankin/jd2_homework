package it.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor



@Entity
@Table(name = "EMPLOYEE2")
@Inheritance(strategy = InheritanceType.JOINED)

public class Empl2 {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    @Column
    private String surname;

    public Empl2(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }
}