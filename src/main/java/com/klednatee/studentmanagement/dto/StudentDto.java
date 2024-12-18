package com.klednatee.studentmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;

    @NotEmpty(message="กรุณากรอกชื่อให้เรียบร้อย")
    private String firstName;

    @NotEmpty(message="กรุณากรอกนามสกุลให้เรียบร้อย")
    private String lastName;

    @NotEmpty(message="กรุณากรอก Email")
    @Email
    private String email;
}
