package ru.mochalin.laba31.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String surname;
    private String otchestvo;
    private String gender;
    private String nationality;
    private String height;
    private String weight;
    private String yearBirth;
    private String monthBirth;
    private String birthday;
    private String phoneNumber;
    private String creditCardNumber;
    private String bankAccount;
}
