package com.bora.emws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EmployeeName",nullable = false)
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Column(name = "EmployeeLastName",nullable = false)
    @NotEmpty(message = "Last Name cannot be empty")
    private String lastName;
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "EmployeeEmail",nullable = false,unique = true)
    private String email;
    @Column(name = "EncodedPassword")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
