package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class User {
    public String name;

    @Max(value = 90)
    public int age;

    @Email
    public String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
    public String phoneNumber;

    @YearMonth
    private String reqYearMonth;

    @AssertTrue(message="yyyyMMdd 형식에 맞지 않습니다.")
    public boolean reqYearMonthValidation() {
        System.out.println("assert true call");
        this.reqYearMonth = getReqYearMonth() + "01";
        try {
            LocalDate localDate = LocalDate.parse(this.reqYearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
        } catch (Exception e) {
            return false;

        }

        return true;


    }
}
