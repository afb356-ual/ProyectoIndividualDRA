package com.example.WizardsWands_sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.WizardsWands_sb.entity.Usuario;
import com.example.WizardsWands_sb.services.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UsuarioController {

    // Inyección del servicio de Usuario
    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{idUsuario}")
    public Usuario getUserById(@PathVariable long idUsuario) {
        return usuarioService.getUserById(idUsuario);
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        return usuarioService.saveUser(user);
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/{idUsuario}")
    public Usuario updateUser(@PathVariable long idUsuario, @RequestBody Usuario userDetails) {
        return usuarioService.updateUser(idUsuario, userDetails);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{idUsuario}")
    public void deleteUser(@PathVariable long idUsuario) {
        usuarioService.deleteUser(idUsuario);
    }

    // Endpoint para realizar login de usuarios
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario user) {
        Usuario existingUser = usuarioService.findByEmail(user.getEmail());
        Map<String, Object> response = new HashMap<>();
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            response.put("message", "Login successful");
            response.put("id", existingUser.getIdUsuario());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    
    // Endpoint para registrar nuevos usuarios
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Usuario user) {
        Map<String, String> response = new HashMap<>();
        if (usuarioService.findByEmail(user.getEmail()) != null) {
            response.put("message", "Email already exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        usuarioService.saveUser(user);
        response.put("message", "Registration successful");
        return ResponseEntity.ok(response);
    }
}
