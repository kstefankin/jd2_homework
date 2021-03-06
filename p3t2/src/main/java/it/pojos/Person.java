package it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity

public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer age;

    @Column
    private String name;
    @Column
    private String surname;



}
