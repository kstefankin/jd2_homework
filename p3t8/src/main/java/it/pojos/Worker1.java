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
@DiscriminatorValue("W")
public class Worker1 extends Empl1{

    @Column
    private String ceh;
    @Column
    private String razryad;


    public Worker1(String name, String surname, String ceh, String razryad) {
        super(name,surname);
        this.ceh=ceh;
        this.razryad=razryad;

    }
}
