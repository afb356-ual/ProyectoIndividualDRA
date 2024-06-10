package com.example.WizardsWands_sb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * La clase Usuario representa a un usuario en la aplicación. 
 * @Data genera todos los getters, setters, toString, equals y hashCode.
 * @NoArgsConstructor genera un constructor sin argumentos.
 * @AllArgsConstructor genera un constructor con todos los argumentos.
 */
@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUsuario;

    /**
     * Contraseña del usuario.
     */
    @NotBlank
    private String password;

    /**
     * Correo electrónico del usuario.
     */
    @NotBlank
    @Email
    private String email;

    /**
     * Nombre del usuario.
     */
    @NotBlank
    private String nombre;


    
}
