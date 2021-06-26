package ir.bigz.spring.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.bigz.spring.validation.annotation.AccountCode;
import ir.bigz.spring.validation.annotation.NationalCode;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(unique = true)
    protected String userName;

    protected String name;

    protected String nationalCode;

    protected String mobile;

    protected String accountNumber;


    public User(String userName,
                String name,
                String nationalCode,
                String mobile,
                String accountNumber) {
        this.userName = userName;
        this.name = name;
        this.nationalCode = nationalCode;
        this.mobile = mobile;
        this.accountNumber = accountNumber;
    }
}
