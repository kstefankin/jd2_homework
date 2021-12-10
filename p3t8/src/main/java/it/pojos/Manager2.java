package it.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity @Table(name = "MANAGER2")
@PrimaryKeyJoinColumn(name = "EMPLOYEE2_ID")
public class Manager2 extends Empl2{

    @Column
    private String otdel;
    @Column
    private String dolzhnoct;

    public Manager2(String name, String surname, String otdel, String dolzhnoct) {
        super(name,surname);
        this.otdel=otdel;
        this.dolzhnoct=dolzhnoct;

    }

}
