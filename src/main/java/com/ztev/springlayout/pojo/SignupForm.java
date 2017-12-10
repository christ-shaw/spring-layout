package com.ztev.springlayout.pojo;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupForm {
    private static final String NOT_BLANK_MESSAGE = "#{notBlank.message}";
    private static final String EMAIL_MESSAGE = "email.message";

    @Getter
    @Setter
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    private String email;

    @Getter
    @Setter
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;


    public Account createAccount() {
        return new Account(getEmail(), getPassword(), "ROLE_USER");
    }

}
