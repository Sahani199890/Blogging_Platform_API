package com.example.bloggingPlatformAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @ManyToOne
    @NotNull(message = "sender missing")
    private UserModel sender;
    @NotNull(message = "comments missing")
    private String comments;
    @ManyToOne
    @NotNull(message = "receiver missing")
    private UserModel receiver;
}
