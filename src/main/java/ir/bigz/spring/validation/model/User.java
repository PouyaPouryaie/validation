package ir.bigz.spring.validation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    protected String email;

    protected String gender;


    public User(String userName,
                String name,
                String nationalCode,
                String mobile,
                String accountNumber,
                String email,
                String gender) {
        this.userName = userName;
        this.name = name;
        this.nationalCode = nationalCode;
        this.mobile = mobile;
        this.accountNumber = accountNumber;
        this.email = email;
        this.gender = gender;
    }
}
