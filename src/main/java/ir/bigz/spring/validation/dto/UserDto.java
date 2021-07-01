package ir.bigz.spring.validation.dto;

import ir.bigz.spring.validation.annotation.AccountCode;
import ir.bigz.spring.validation.annotation.GenderType;
import ir.bigz.spring.validation.annotation.NationalCode;
import ir.bigz.spring.validation.annotation.Validator;
import ir.bigz.spring.validation.utility.Validations;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    protected long id;

    @NotBlank(message = "name not blank")
    protected String userName;

    @NotBlank(message = "lastName not blank")
    protected String name;

    @NotNull(message = "national code not null")
    @NationalCode
    protected String nationalCode;

    @Pattern(regexp = "^(09|989)\\d{9}$", message = "mobile is not correct")
    protected String mobile;

    //    @Pattern(regexp = "^\\d{4}-\\d{3}-\\d{6}-\\d$", message = "accountNUmber is not correct")
    @AccountCode
    protected String accountNumber;

    @Validator(Validations.EMAIL)
    protected String email;

    @GenderType(allowed = {"man", "woman", "transgender"})
    protected String gender;


    public UserDto(@NotBlank(message = "name not blank") String userName,
                   @NotBlank(message = "lastName not blank") String name,
                   @NationalCode @NotNull(message = "national code not null") String nationalCode,
                   @Pattern(regexp = "^(09|989)\\d{9}$", message = "mobile is not correct") String mobile,
                   @AccountCode String accountNumber,
                   @Validator(Validations.EMAIL) String email,
                   @GenderType String gender) {
        this.userName = userName;
        this.name = name;
        this.nationalCode = nationalCode;
        this.mobile = mobile;
        this.accountNumber = accountNumber;
        this.email = email;
        this.gender = gender;
    }
}
