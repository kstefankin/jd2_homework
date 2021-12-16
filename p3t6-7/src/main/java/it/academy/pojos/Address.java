package it.academy.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    String city;
    String street;
    String building;
    String apart;
    String zipcode;

}
