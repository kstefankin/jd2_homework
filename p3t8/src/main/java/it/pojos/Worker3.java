package it.pojos;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor


@Entity
@Table(name = "WORKER3")
public class Worker3 extends Empl3{

    @Column
    private String ceh;
    @Column
    private String razryad;


    public Worker3(String name, String surname, String ceh, String razryad) {
        super(name,surname);
        this.ceh=ceh;
        this.razryad=razryad;

    }
}