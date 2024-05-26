package org.grupo_e.proyec2_grupoebackend.data.dto;

import lombok.Data;

@Data
public class LoginDto {
    private long id;
    private String username;
    private String email;
    private String password;
}
