package it.academy.pojos;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue  // AUTO sequence
    @Column
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;


    @Column
    private String vuz;
    @Column
    private String specialnoct;

    @Embedded
    private Address address;

    private Details details;

    public Student (String name, String surname, String vuz, String specialnoct, Address address, Details details) {
        this.name=name;
        this.surname=surname;
        this.vuz=vuz;
        this.specialnoct=specialnoct;
        this.address=address;
        this.details=details;

    }


}





