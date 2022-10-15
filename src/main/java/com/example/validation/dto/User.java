package com.example.validation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class User {
    public String name;

    @Max(value=90)
    public int age;

    @Email
    public String email;

    @Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}$", message="핸드폰 번호의 양식과 맞지 않습니다.")
    public String phoneNumber;
}
