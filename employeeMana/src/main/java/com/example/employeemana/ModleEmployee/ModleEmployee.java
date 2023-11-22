package com.example.employeemana.ModleEmployee;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ModleEmployee {
    @NotNull(message = "please enter id ")
    @Size(min = 2)
    private String id;
    @NotNull(message = "please enter UserName  ")
    @Pattern(regexp = "^[a-zA-Z]*$+",message = "please enter string")
    @Size(min = 4)
    private String name;
    @Email(message = "please enter email ")
    private String email;
    @Size(min = 10, max = 10 , message = "please enter phone number total 10 numbers")
    @Pattern(regexp = ("^05\\d{8}$"))
    private String phoneNumber;
    @NotNull(message = "please enter Age ")
    @Positive(message = "please enter number age positive ")
    @Min(value = 25,message =  "please enter age min 25  ")
    private int age;
    @NotNull(message = "please enter position supervisor|coordinator ")
    @Pattern(regexp = "(supervisor|coordinator)")
    private String position;
    @AssertFalse
    private boolean onLeave;
    @NotNull(message = "please enter Past Or Present not null")
    @PastOrPresent(message = "please enter date of Past Or Present ")
    private LocalDate hireDate;
    @NotNull(message = "please enter number of annualLeave")
    @Positive(message = "please enter annualLeave positive")
    private int annualLeave;

}
