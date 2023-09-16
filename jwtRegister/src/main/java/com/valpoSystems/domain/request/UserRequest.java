package com.valpoSystems.domain.request;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.valpoSystems.domain.dto.PhoneDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @NotEmpty(message = "Name is required.")
    @JsonProperty("name")
    private String name;

    
    @NotNull(message = "Email required.")
    @Email(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "Email is not valid.")
    @JsonProperty("email")
    private String email;

   
    @NotEmpty(message = "Password is required.")
    @JsonProperty("password")
    private String password;

    
    @NotNull(message = "You must provide at least one phone number.")
    @Size(min = 1, message = "You must provide at least one phone number.")
    @JsonProperty("phones")
    private @Valid Set<PhoneDto> phones;

}
