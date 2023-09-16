package com.valpoSystems.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Username is Required.")
    private String username;

 
    @NotNull(message = "Password is Required.")
    private String password;
}