package it.pojos;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor


@Entity
@Table(name = "MANAGER3")
public class Manager3 extends Empl3{

    @Column
    private String  otdel;
    @Column
    private String dolzhnost;


    public Manager3(String name, String surname, String otdel, String dolzhnost) {
        super(name,surname);
        this.otdel=otdel;
        this.dolzhnost=dolzhnost;

    }
}