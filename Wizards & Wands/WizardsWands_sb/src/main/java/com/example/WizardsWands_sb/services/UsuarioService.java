package com.example.WizardsWands_sb.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.WizardsWands_sb.entity.Usuario;
import com.example.WizardsWands_sb.repository.UsuarioRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario getUserById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUser(Usuario user) {
        return usuarioRepository.save(user);
    }

    public Usuario updateUser(long id, Usuario userDetails) {
        Usuario existingUser = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        existingUser.setNombre(userDetails.getNombre());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPassword(userDetails.getPassword());

        return usuarioRepository.save(existingUser);
    } 
    
    public void deleteUser(long id) {
        usuarioRepository.deleteById(id);
    }

}
