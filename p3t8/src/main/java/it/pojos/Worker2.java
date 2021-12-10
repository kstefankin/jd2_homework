package it.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Data
@NoArgsConstructor


@Entity @Table(name = "WORKER2")
@PrimaryKeyJoinColumn(name = "EMPLOYEE2_ID")
public class Worker2 extends Empl2{

    @Column
    private String ceh;
    @Column
    private String razryad;


    public Worker2(String name, String surname, String ceh, String razryad) {
        super(name,surname);
        this.ceh=ceh;
        this.razryad=razryad;

    }
}
