package ir.bigz.spring.validation.model;

import ir.bigz.spring.validation.annotation.NationalCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "name not blank")
    String name;

    @NotBlank(message = "lastName not blank")
    String lastName;

    @NotNull(message = "national code not null")
    @NationalCode
    String nationalCode;


    public User(@NotBlank(message = "name not blank") String name,
                @NotBlank(message = "lastName not blank") String lastName,
                @NationalCode @NotNull(message = "national code not null") String nationalCode) {
        this.name = name;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }
}
