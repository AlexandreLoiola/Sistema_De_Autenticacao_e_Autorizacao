package com.AlexandreLoiola.AccessManagement.rest.form;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationUpdateForm {
    @NotNull(message = "The description field cannot be empty")
    @NotBlank(message = "The description field cannot be blank.")
    @Size(min = 3, max = 100, message = "The user role description must be between 3 and 100 characters.")
    private String description;

    @NotNull(message = "The path field cannot be empty")
    @NotBlank(message = "The path field cannot be blank.")
    @Size(min = 3, max = 100, message = "The path must be between 3 and 100 characters.")
    private String path;

    private Set<MethodForm> methods;
}