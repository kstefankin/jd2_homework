package it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Data
@NoArgsConstructor


@Entity
@DiscriminatorValue("M")
public class Manager1 extends Empl1{

    @Column
    private String otdel;
    @Column
    private String dolzhnoct;

    public Manager1(String name, String surname, String otdel, String dolzhnoct) {
        super(name,surname);
        this.otdel=otdel;
        this.dolzhnoct=dolzhnoct;

    }

}
