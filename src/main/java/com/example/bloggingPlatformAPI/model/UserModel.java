package com.example.bloggingPlatformAPI.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_model")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotNull(message = "userName cannot be null")
    @Column(name = "user_name")
    private String userName;
    @NotNull(message = "userName cannot be null")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "userName cannot be null")
    @Column(name = "last_name")
    private String lastName;
    @Email(message = "please enter valid email")
    @Column(name = "email")
    private String email;
    @NotNull(message = "please enter your number")
    @Length(min = 10,max = 12,message = "number should be in [10,12] only")
    @Column(name = "number")
    private String number;
}
