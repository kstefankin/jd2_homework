package it.academy.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor

@Entity
public class Worker {

    @Id
    @GenericGenerator(name = "My_generator",strategy = "enhanced-sequence",parameters =  { @Parameter(name = "initial_value",value = "2000")})
    @GeneratedValue(generator = "My_generator") // add new table for sequence
    @Column
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;


    @Column
    private String ceh;
    @Column
    private String razryad;

    public Worker (String name, String surname, String ceh, String razryad) {
        this.name=name;
        this.surname=surname;
        this.ceh=ceh;
        this.razryad=razryad;

    }

}
