package ir.bigz.spring.validation.model;

import ir.bigz.spring.validation.annotation.AccountCode;
import ir.bigz.spring.validation.annotation.NationalCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @Pattern(regexp = "^(09|989)\\d{9}$", message = "mobile is not correct")
    protected String mobile;

//    @Pattern(regexp = "^\\d{4}-\\d{3}-\\d{6}-\\d$", message = "accountNUmber is not correct")
    @AccountCode
    protected String accountNumber;


    public User(@NotBlank(message = "name not blank") String name,
                @NotBlank(message = "lastName not blank") String lastName,
                @NationalCode @NotNull(message = "national code not null") String nationalCode,
                @Pattern(regexp = "^(09|989)\\d{9}$", message = "mobile is not correct") String mobile,
                @AccountCode String accountNumber) {
        this.name = name;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.mobile = mobile;
        this.accountNumber = accountNumber;
    }
}
